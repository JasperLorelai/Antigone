package eu.jasperlorelai.antigone;

import java.io.*;
import java.util.List;
import java.lang.reflect.Field;

import io.github.classgraph.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.common.base.Charsets;

import com.nisovin.magicspells.util.Name;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.DummyParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.SameLevelParameter;

public abstract class AntigoneDocs {

	private static final File PROJECT_DIR = new File("").getAbsoluteFile().getParentFile();
	private static final File NMS_DIR = new File(PROJECT_DIR, "nms");
	private static final File FILE = new File(PROJECT_DIR, "docs/docs.json");

	public static void main(String... args) {
		File[] dirs = NMS_DIR.listFiles();
		JsonObject docs = new JsonObject();
		if (dirs != null) {
			for (File file : dirs) {
				String version = file.getName();
				if (!version.startsWith("v")) continue;
				docs.add(version, documentVersion(version));
			}
		}
		if (docs.isEmpty()) throw new IllegalStateException("no nms dirs?");

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

		// Collect "LivingEntityClass" values.
		JsonArray livingEntityClasses = new JsonArray();

		ClassGraph classGraph = new ClassGraph()
				.enableAllInfo()
				.acceptClasses(packagePrefix + ".parameters.mob.LivingEntityClass");
		try (ScanResult result = classGraph.scan()) {
			for (FieldInfo value : result.getAllEnums().get(0).getEnumConstants()) {
				livingEntityClasses.add(value.getName().toLowerCase());
			}
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Submodule '" + version + "' does not provide access.");
		}
		docs.add("LivingEntityClass", livingEntityClasses);

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
				String goalName = goalClass.getAnnotation(Name.class).value();

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
					if (baseParameter instanceof MobParameter<?> parameter && !goalDoc.has("target")) {
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
					goalDoc.addProperty("target", wrapGoalInner.entity().getSimpleName());
				}

				goalDoc.add("parameters", parameterDocs);
				goalDocs.add(goalName, goalDoc);
			}
		}

		docs.add("goals", goalDocs);
		return docs;
	}

}
