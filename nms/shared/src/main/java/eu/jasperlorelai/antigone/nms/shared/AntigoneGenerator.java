package eu.jasperlorelai.antigone.nms.shared;

import org.bukkit.entity.Mob;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import java.lang.reflect.Constructor;

import com.squareup.javapoet.*;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import io.github.classgraph.ClassInfoList;

import javax.lang.model.element.Modifier;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.Nullable;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

public class AntigoneGenerator {

	private static final File SOURCE_DIR = new File("src/main/java");
	private static final String VERSION = new File("").getAbsoluteFile().getName();
	private static final String PACKAGE_NAME = AntigoneGenerator.class.getPackageName().replace("shared", VERSION);

	public static void main(String... args) {
		try {
			setupGoals();
			setupLivingEntityStore();
		} catch (Exception e) {
			//noinspection CallToPrintStackTrace
			e.printStackTrace();
		}
	}

	private static void write(String packageSuffix, TypeSpec typeSpec) throws IOException {
		File file = JavaFile.builder(PACKAGE_NAME + packageSuffix, typeSpec)
				.indent("\t")
				.build()
                .writeToFile(SOURCE_DIR);

		try (Stream<String> stream = Files.lines(file.toPath())) {
			List<String> lines = stream.map(line -> line.replaceFirst("\n$", "\r\n")).toList();
			Files.write(file.toPath(), lines);
		}
	}

	private static String getAntigoneAnnotationName(String annotation) {
		annotation = annotation.replaceFirst("Goal$", "");
		annotation = "antigone_" + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, annotation);
		return annotation;
	}

	private static void setupGoals() throws IOException {
		TypeName simpleWildcard = WildcardTypeName.subtypeOf(Object.class);
		MethodSpec constructor = MethodSpec.constructorBuilder()
				.addModifiers(Modifier.PUBLIC)
				.addParameter(Mob.class, "mob")
				.addParameter(SpellData.class, "data")
				.addStatement("super(mob, data)")
				.build();
		TypeName antigoneParameterType = ParameterizedTypeName.get(ClassName.get(AntigoneParameter.class), simpleWildcard, simpleWildcard);
		TypeName parameterListType = ParameterizedTypeName.get(ClassName.get(List.class), antigoneParameterType);
		MethodSpec parametersMethod = MethodSpec.methodBuilder("getParameters")
				.addAnnotation(Override.class)
				.addModifiers(Modifier.PUBLIC)
				.returns(parameterListType)
				.addStatement("return parameters")
				.build();

		ClassGraph classGraph = new ClassGraph().enableAllInfo().acceptPackages("net.minecraft.");
		try (ScanResult result = classGraph.scan()) {
			for (ClassInfo info : result.getSubclasses(Goal.class)) {
				if (info.isAbstract() || info.isInterface() || info.isAnonymousInnerClass()) continue;
				Class<?> goalClass = info.loadClass();
				if (goalClass == WrappedGoal.class) continue;

				try {
					Class<?> existingGoal = Class.forName(PACKAGE_NAME + ".goals." + goalClass.getSimpleName());
					String goalName = existingGoal.getAnnotation(Name.class).value();

					Field parameterField = existingGoal.getDeclaredField("parameters");
					parameterField.setAccessible(true);
					@SuppressWarnings("unchecked")
					List<AntigoneParameter<?, ?>> parameters = (List<AntigoneParameter<?, ?>>) parameterField.get(null);

					int maxPossible = 0;
					for (Constructor<?> constr : goalClass.getDeclaredConstructors()) {
						int count = constr.getParameterCount();
						if (goalName.equals("antigone_breed")) count--;

						if (count <= maxPossible) continue;
						maxPossible = count;
					}

					if (maxPossible > parameters.size()) {
						System.out.println("Goal '" + goalName + "' may be more configurable than it currently is. (" + parameters.size() + "/" + maxPossible + ")");
					}

					// Let's not override existing goals.
					continue;
				} catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException ignored) {}

				TypeSpec.Builder goalBuilder = TypeSpec.classBuilder(goalClass.getSimpleName())
						.addModifiers(Modifier.PUBLIC)
						.superclass(AntigoneGoal.class)
						.addAnnotation(AnnotationSpec.builder(Name.class)
								.addMember("value", "$S", getAntigoneAnnotationName(goalClass.getSimpleName()))
								.build()
						)
						.addField(FieldSpec.builder(parameterListType, "parameters")
								.addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
								.initializer(CodeBlock.builder()
										.add("$T.of(\n)", List.class)
										.build()
								)
								.build()
						)
						.addMethod(constructor)
						.addMethod(parametersMethod);

				if (info.isInnerClass()) goalBuilder.addAnnotation(AnnotationSpec.builder(WrapVanillaGoal.Inner.class)
						.addMember("entity", "$T.class", info.getOuterClasses().getFirst().loadClass())
						.addMember("className", "$S", goalClass.getSimpleName())
						.build()
				);
				else goalBuilder.addAnnotation(AnnotationSpec.builder(WrapVanillaGoal.Exact.class)
						.addMember("value", "$T.class", goalClass)
						.build()
				);

				ClassInfo superClass = info.getSuperclass();
				if (!superClass.isAbstract() && !superClass.isInterface()) goalBuilder.addAnnotation(AnnotationSpec.builder(ExtendsGoal.class)
						.addMember("value", "$S", getAntigoneAnnotationName(superClass.getSimpleName()))
						.build()
				);

				write(".goals", goalBuilder.build());
			}
		}
	}

	private static void setupLivingEntityStore() throws IOException {
		TypeName livingEntity = ParameterizedTypeName.get(ClassName.get(Class.class), WildcardTypeName.subtypeOf(LivingEntity.class));
		TypeName map = ParameterizedTypeName.get(ClassName.get(Map.class), ClassName.get(String.class), livingEntity);

		TypeSpec.Builder livingEntityBuilder = TypeSpec.classBuilder("LivingEntityMap")
				.addModifiers(Modifier.PUBLIC)
				.addField(FieldSpec.builder(map, "map", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
						.initializer("new $T<>()", LinkedHashMap.class)
						.build()
				)
				.addMethod(MethodSpec.methodBuilder("fromString")
						.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
						.addParameter(ClassName.get(String.class), "name")
						.addAnnotation(Nullable.class)
						.addStatement("return map.get(name.toLowerCase())")
						.returns(livingEntity)
						.build()
				);

		CodeBlock.Builder initialise = CodeBlock.builder();
		ClassGraph classGraph = new ClassGraph()
				.enableAllInfo()
				.acceptPackages("net.minecraft.world.entity.");
		try (ScanResult result = classGraph.scan()) {
			ClassInfoList list = result.getSubclasses(LivingEntity.class);
			list.sort((a, b) -> a.getSimpleName().compareToIgnoreCase(b.getSimpleName()));
			for (ClassInfo info : list) {
				String key = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, info.getSimpleName());
				initialise.addStatement("map.put($S, $T.class)", key, ClassName.get(info.loadClass()));
			}
		}

		write(".entities", livingEntityBuilder.addStaticBlock(initialise.build()).build());
	}

}
