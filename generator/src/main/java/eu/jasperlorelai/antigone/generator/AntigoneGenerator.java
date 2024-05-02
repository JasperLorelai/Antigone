package eu.jasperlorelai.antigone.generator;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.bukkit.entity.Mob;

import com.squareup.javapoet.*;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import javax.lang.model.element.Modifier;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

public class AntigoneGenerator {

	private String version;
	private String packagePrefix;

	private File goalsDir;
	private File sourceDir;

	@SuppressWarnings("unused")
	private AntigoneGenerator() {}

	private AntigoneGenerator(String version) {
		this.version = version;
		packagePrefix = "eu.jasperlorelai.antigone.nms." + version;
		sourceDir = new File(new File("").getAbsoluteFile().getParentFile(), "nms/" + version + "/src/main/java");
		goalsDir = new File(sourceDir, packagePrefix.replaceAll("\\.", "/") + "/goals");

		try {
			setupGoals();
			// Parameters depends on LivingEntityClass
			setupLivingEntityClass();
			setupParameters();
		} catch (Exception e) {
			//noinspection CallToPrintStackTrace
			e.printStackTrace();
		}
	}

	public static void main(String... args) {
		if (args.length == 0) throw new IllegalStateException("No MC version passed in arguments.");
		new AntigoneGenerator(args[0]);
	}

	private void write(String packageSuffix, TypeSpec typeSpec) throws IOException {
		write(sourceDir, packageSuffix, typeSpec);
	}

	private void write(File dir, String packageSuffix, TypeSpec typeSpec) throws IOException {
		JavaFile.builder(packagePrefix + packageSuffix, typeSpec)
				.indent("\t")
				.build()
				.writeTo(dir);
	}

	private String getAntigoneAnnotationName(String annotation) {
		annotation = annotation.replaceFirst("Goal$", "");
		annotation = "antigone_" + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, annotation);
		return annotation;
	}

	private void setupGoals() throws IOException {
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

				// Let's not override existing goals.
				if (new File(goalsDir, goalClass.getSimpleName() + ".java").exists()) continue;
				if (goalClass == WrappedGoal.class) continue;

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

	private void setupLivingEntityClass() throws IOException {
		TypeName livingEntityWildcard = ParameterizedTypeName.get(ClassName.get(Class.class), WildcardTypeName.subtypeOf(LivingEntity.class));
		TypeSpec.Builder entityClassEnum = TypeSpec.enumBuilder("LivingEntityClass")
				.addJavadoc("Enum representing LivingEntity variants, either direct mobs (e.g. Zombie, Pig) or groups of them (e.g. Animal, Mob).")
				.addModifiers(Modifier.PUBLIC)
				.addField(livingEntityWildcard, "clazz", Modifier.PRIVATE, Modifier.FINAL)
				.addMethod(MethodSpec.constructorBuilder()
						.addParameter(livingEntityWildcard, "clazz")
						.addStatement("this.$N = $N", "clazz", "clazz")
						.build()
				)
				.addSuperinterface(ParameterizedTypeName.get(ClassName.get(Supplier.class), livingEntityWildcard))
				.addMethod(MethodSpec.methodBuilder("get")
						.addAnnotation(Override.class)
						.addModifiers(Modifier.PUBLIC)
						.returns(livingEntityWildcard)
						.addStatement("return clazz")
						.build()
				);

		ClassGraph classGraph = new ClassGraph()
				.enableAllInfo()
				.acceptPackages("net.minecraft.world.entity.");
		try (ScanResult result = classGraph.scan()) {
			for (ClassInfo info : result.getSubclasses(LivingEntity.class)) {
				Class<?> clazz = info.loadClass();
				entityClassEnum.addEnumConstant(
						CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, clazz.getSimpleName()),
						TypeSpec.anonymousClassBuilder("$T.class", ClassName.get(clazz)).build()
				);
			}
		}

		write(".parameters.mob", entityClassEnum.build());
	}

	private void writeInstancedConfigParameter(ClassName superClass, TypeName defType, Function<TypeSpec.Builder, TypeSpec.Builder> function) throws IOException {
		write(".parameters.config", function.apply(TypeSpec.classBuilder(superClass.simpleName() + "_" + version))
				.addModifiers(Modifier.PUBLIC)
				.superclass(superClass)
				.addMethod(MethodSpec.constructorBuilder()
						.addModifiers(Modifier.PUBLIC)
						.addParameter(ParameterSpec.builder(String.class, "name").addAnnotation(NotNull.class).build())
						.addStatement("this(name, null)")
						.build()
				)
				.addMethod(MethodSpec.constructorBuilder()
						.addModifiers(Modifier.PUBLIC)
						.addParameter(ParameterSpec.builder(String.class, "name").addAnnotation(NotNull.class).build())
						.addParameter(ParameterSpec.builder(defType, "def").addAnnotation(Nullable.class).build())
						.addStatement("super(name, def)")
						.build()
				)
				.build());
	}

	private void setupParameters() throws IOException {
		ClassName typeLivingEntityClass = ClassName.bestGuess(packagePrefix + ".parameters.mob.LivingEntityClass");
		TypeName livingEntityWildcard = ParameterizedTypeName.get(ClassName.get(Class.class), WildcardTypeName.subtypeOf(LivingEntity.class));

		writeInstancedConfigParameter(ClassName.get(EntityTypeParameter.class), livingEntityWildcard,
				builder -> builder.addMethod(MethodSpec.methodBuilder("fromString")
						.addModifiers(Modifier.PUBLIC)
						.addAnnotation(Override.class)
						.addParameter(String.class, "string")
						.returns(livingEntityWildcard)
						.addCode(CodeBlock.builder()
								.beginControlFlow("try")
								.addStatement("return $T.valueOf(string.toUpperCase()).get()", typeLivingEntityClass)
								.nextControlFlow("catch ($T ignored)", IllegalArgumentException.class)
								.endControlFlow()
								.addStatement("return null")
								.build()
						)
						.build()
				)
		);

		writeInstancedConfigParameter(ClassName.get(EntityTypesParameter.class), ArrayTypeName.of(livingEntityWildcard),
				builder -> builder.addMethod(MethodSpec.methodBuilder("fromString")
						.addModifiers(Modifier.PUBLIC)
						.addAnnotation(Override.class)
						.addParameter(String.class, "string")
						.returns(livingEntityWildcard)
						.addCode(CodeBlock.builder()
								.beginControlFlow("try")
								.addStatement("return $T.valueOf(string.toUpperCase()).get()", typeLivingEntityClass)
								.nextControlFlow("catch ($T ignored)", IllegalArgumentException.class)
								.endControlFlow()
								.addStatement("return null")
								.build()
						)
						.build()
				)
		);
	}

}
