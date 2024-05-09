package eu.jasperlorelai.antigone.generator;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import io.github.classgraph.ClassInfoList;

import com.nisovin.magicspells.util.Name;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * These tests ensure that implementations of goals hold up to certain Antigone conventions.
 * <ul>
 *    <li>Goals must be annotated with {@link Name}.</li>
 *    <li>Goals must be annotated with {@link WrapVanillaGoal}.</li>
 *    <li>{@link Name} must start with "antigone_".</li>
 *    <li>Goals must have a static field List of "parameters". This is so we can test if a constructor exists
 *    with those parameters with tests without needing to make a new instance of the goal, which is impossible
 *    without production (a running server) due to the arguments required..</li>
 * </ul>
 */
public class AntigoneTests {

	private static final File WORKING_DIR = new File("").getAbsoluteFile();
	private static final File NMS_DIR = new File(WORKING_DIR.getParent(), "nms");

	@TestFactory
	List<DynamicTest> test() {
		List<DynamicTest> tests = new ArrayList<>();

		File[] dirs = NMS_DIR.listFiles();
		if (dirs == null) throw new IllegalStateException("no nms dirs?");
		for (File file : dirs) {
			String version = file.getName();
			if (!version.startsWith("v")) continue;

			ClassGraph classGraph = new ClassGraph()
					.enableAllInfo()
					.acceptPackages("eu.jasperlorelai.antigone.nms." + version + ".goals");
			try (ScanResult result = classGraph.scan()) {
				ClassInfoList list = result.getSubclasses(AntigoneGoal.class);
				if (list.isEmpty()) {
					throw new RuntimeException("Submodule '" + version + "' does not provide access to its goals.");
				}

				for (ClassInfo goalInfo : list) {
					Class<? extends AntigoneGoal> goalClass = goalInfo.loadClass().asSubclass(AntigoneGoal.class);
					String testName = version + ":" + goalClass.getSimpleName();
					tests.add(DynamicTest.dynamicTest(testName, () -> runTest(goalClass)));
				}
			}
		}

		if (tests.isEmpty()) throw new IllegalStateException("no nms dirs?");
		return tests;
	}

	@SuppressWarnings("unchecked")
	private static void runTest(Class<? extends AntigoneGoal> goalClass) {
		// Test for annotations present.
		Name nameAnnotation = goalClass.getAnnotation(Name.class);
		assertNotNull(nameAnnotation, "Goal class '%s' not annotated with Name annotation.".formatted(goalClass.getSimpleName()));
		String goalName = nameAnnotation.value();

		WrapVanillaGoal.Exact wrapVanillaGoalExact = goalClass.getAnnotation(WrapVanillaGoal.Exact.class);
		WrapVanillaGoal.Inner wrapVanillaGoalInner = goalClass.getAnnotation(WrapVanillaGoal.Inner.class);
		boolean hasWrapVanillaGoal = wrapVanillaGoalExact != null || wrapVanillaGoalInner != null;
		assertTrue(hasWrapVanillaGoal, "Goal '%s' not annotated with WrapVanillaGoal annotation.".formatted(goalName));

		// Verify that Name starts with "antigone_".
		assertTrue(goalClass.getAnnotation(Name.class).value().startsWith("antigone_"), "Goal '%s' has a Name annotation with a value that does not start with 'antigone_'.".formatted(goalName));

		// Verify that the goal has a static "parameters" field.
		Field parameterField = null;
		try {
			parameterField = goalClass.getDeclaredField("parameters");
			parameterField.setAccessible(true);
		} catch (NoSuchFieldException ignored) {}
		assertNotNull(parameterField, "Goal '%s' does not hold its parameters in a static 'parameters' field.".formatted(goalName));

		// Verify type of "parameters".
		List<AntigoneParameter<?, ?>> parameters;
		try {
			parameters = (List<AntigoneParameter<?, ?>>) parameterField.get(null);
		} catch (IllegalAccessException | ClassCastException ignored) {
			fail("Goal '%s' has a 'parameters' static field which is not a List of AntigoneParameter.".formatted(goalName));
			return;
		}

		// Verify that the wrapping goal exists.
		Class<?> vanillaGoalClass = null;
		if (wrapVanillaGoalInner == null) vanillaGoalClass = wrapVanillaGoalExact.value();
		else {
			String innerClassName = wrapVanillaGoalInner.entity().getName() + "$" + wrapVanillaGoalInner.className();
			try {
				vanillaGoalClass = Class.forName(innerClassName);
			} catch (ClassNotFoundException ignored) {}
		}
		assertNotNull(vanillaGoalClass, "Goal '%s' does not wrap an existing goal.".formatted(goalName));

		// Collect parameter types.
		// Non-static inner class constructors require first parameter to also be an enclosing class instance.
		Class<?>[] types = new Class[parameters.size()];
		for (int i = 0; i < parameters.size(); i++) {
			AntigoneParameter<?, ?> parameter = parameters.get(i);
			if (parameter.getType() instanceof Class<?> type) types[i] = type;
			else types[i] = parameter.getType().getClass();
		}

		// Verify that a constructor with the given types exists.
		try {
			vanillaGoalClass.getDeclaredConstructor(types);
		} catch (NoSuchMethodException ignored) {
			fail("Goal '%s' does not have a constructor with the set parameters.".formatted(goalName));
		}
	}

}

