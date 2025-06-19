package eu.jasperlorelai.antigone.nms.shared;

import java.io.*;
import java.util.List;
import java.lang.reflect.Field;

import io.github.classgraph.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.common.base.Charsets;

import com.nisovin.magicspells.util.Name;

import com.google.gson.JsonPrimitive;
import com.google.common.base.CaseFormat;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.pathfinder.PathType;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.DummyParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.SameLevelParameter;

public abstract class AntigoneDocs {

	private static final File WORKING_DIR = new File("").getAbsoluteFile();
	private static final File PROJECT_DIR = WORKING_DIR.getParentFile().getParentFile();
	private static final File FILE = new File(PROJECT_DIR, "docs/docs.json");

	public static void main(String... args) {
		String version = WORKING_DIR.getName();
		if (!version.startsWith("v") || version.equals("shared")) return;

		JsonObject docs;
		try {
			docs = JsonParser.parseReader(new FileReader(FILE)).getAsJsonObject();
		} catch (FileNotFoundException e) {
			docs = new JsonObject();
		}
		docs.add(version, documentVersion(version));

		//noinspection ResultOfMethodCallIgnored
		FILE.getParentFile().mkdir();
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(FILE), Charsets.UTF_8)) {
			writer.write(docs.toString());
		} catch (IOException e) {
			//noinspection CallToPrintStackTrace
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static JsonObject documentVersion(String version) {
		String packagePrefix = "eu.jasperlorelai.antigone.nms." + version;
		JsonObject docs = new JsonObject();
		ClassGraph classGraph;

		// Collect "LivingEntityMap" keys.
		JsonArray entities = new JsonArray();
		classGraph = new ClassGraph().acceptPackages("net.minecraft.world.entity.");
		try (ScanResult result = classGraph.scan()) {
			ClassInfoList list = result.getSubclasses(LivingEntity.class);
			list.sort((a, b) -> a.getSimpleName().compareToIgnoreCase(b.getSimpleName()));
			for (ClassInfo info : list) entities.add(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, info.getSimpleName()));
		}
		docs.add("LivingEntityClass", entities);

		// Collect "PathType" enum.
		JsonObject pathTypes = new JsonObject();
		for (PathType type : PathType.values()) {
			pathTypes.add(type.name().toLowerCase(), new JsonPrimitive(type.getMalus()));
		}
		docs.add("PathfindingMalus", pathTypes);

		// Document goals.
		JsonObject goalDocs = new JsonObject();
		classGraph = new ClassGraph()
				.enableAllInfo()
				.enableStaticFinalFieldConstantInitializerValues()
				.acceptPackages(packagePrefix + ".goals");
		try (ScanResult result = classGraph.scan()) {
			ClassInfoList list = result.getSubclasses(AntigoneGoal.class);
			if (list.isEmpty()) {
				throw new RuntimeException("Submodule '" + version + "' does not provide access.");
			}

			for (ClassInfo goalInfo : list) {
				Class<? extends AntigoneGoal> goalClass = goalInfo.loadClass().asSubclass(AntigoneGoal.class);
				Name nameAnnotation = goalClass.getAnnotation(Name.class);
				if (nameAnnotation == null) {
					System.out.println("Goal '" + goalClass.getSimpleName() + "' does not have a Name annotation.");
					continue;
				}
				String goalName = nameAnnotation.value();

				List<AntigoneParameter<?, ?>> parameters;
				try {
					Field field = goalClass.getDeclaredField("parameters");
					field.setAccessible(true);
					parameters = (List<AntigoneParameter<?, ?>>) field.get(null);
				} catch (IllegalAccessException | NoSuchFieldException ex) {
					//noinspection CallToPrintStackTrace
					ex.printStackTrace();
					return docs;
				}

				JsonObject goalDoc = new JsonObject();

				ExtendsGoal extendsGoal = goalClass.getAnnotation(ExtendsGoal.class);
				if (extendsGoal != null) goalDoc.addProperty("extends", extendsGoal.value());

				JsonArray parameterDocs = new JsonArray();
				for (AntigoneParameter<?, ?> baseParameter : parameters) {
					// Magic parameter: Value is always the same.
					if (baseParameter instanceof MobParameter<?> parameter) {
						goalDoc.addProperty("target", parameter.getDescription());
						continue;
					}
					// Magic parameter: no doc.
					if (baseParameter instanceof DummyParameter<?>) continue;
					if (baseParameter instanceof SameLevelParameter) continue;

					JsonObject data = baseParameter.document();
					if (data == null) throw new IllegalStateException("Missing documentation setup for parameter: " + baseParameter.getClass().getName());
					parameterDocs.add(data);
				}

				// Maybe MobParameter wasn't used? Target then is the outer Entity class.
				WrapVanillaGoal.Inner wrapGoalInner = goalClass.getAnnotation(WrapVanillaGoal.Inner.class);
				if (!goalDoc.has("target")) {
					if (wrapGoalInner == null) throw new RuntimeException("Not sure if target is allowed to be 'any', so I'll leave this throw here until we encounter such a case.");
					if (!wrapGoalInner.outer().isAssignableFrom(LivingEntity.class)) continue;
					goalDoc.addProperty("target", wrapGoalInner.outer().getSimpleName());
				}

				goalDoc.add("parameters", parameterDocs);
				goalDocs.add(goalName, goalDoc);
			}
		}

		docs.add("goals", goalDocs);
		return docs;
	}

}
