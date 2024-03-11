package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.List;
import java.util.EnumSet;
import java.lang.reflect.Modifier;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.ai.goal.Goal;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;
import com.nisovin.magicspells.util.ai.CustomGoal;

import com.destroystokyo.paper.entity.ai.GoalType;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.entity.Mob;
import org.bukkit.configuration.ConfigurationSection;

import eu.jasperlorelai.antigone.nms.shared.parameters.*;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.BooleanSupplierParameter;

/**
 * Conventions:
 * <ul>
 *     <li>Annotate this class with {@link Name} which will hold the configuration name of the goal. Start it with "antigone_".</li>
 *     <li>Annotate it with {@link WrapVanillaGoal} to specify what goal this goal should wrap.</li>
 *     <li>Implement {@link AntigoneGoal#getParameters()} by returning a {@code private static final} field of the {@link AntigoneParameter} List.</li>
 * </ul>
 */
public abstract class AntigoneGoal extends CustomGoal {

	private com.destroystokyo.paper.entity.ai.Goal<Mob> handle;

	public AntigoneGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public final boolean initialize(ConfigurationSection config) {
		Class<? extends Goal> vanillaGoal;
		WrapVanillaGoal.Exact wrapVanillaGoalExact = getClass().getAnnotation(WrapVanillaGoal.Exact.class);
		WrapVanillaGoal.Inner wrapVanillaGoalInner = getClass().getAnnotation(WrapVanillaGoal.Inner.class);
		if (wrapVanillaGoalInner == null) {
			if (wrapVanillaGoalExact == null) {
				severe("Goal is missing WrapVanillaGoal annotation. Report this as a bug!");
				return false;
			}
			vanillaGoal = wrapVanillaGoalExact.value();
		}
		else {
			try {
				//noinspection unchecked
				vanillaGoal = (Class<? extends Goal>) Class.forName(wrapVanillaGoalInner.entity().getName() + "$" + wrapVanillaGoalInner.className());
			} catch (ClassNotFoundException | ClassCastException ignored) {
				severe("Goal could not be created. Report this as a bug!");
				return false;
			}
		}

		// Non-static inner class constructors require first parameter to also be an enclosing class instance.
		boolean addEnclosing = wrapVanillaGoalInner != null && !Modifier.isStatic(vanillaGoal.getModifiers());
		int offset = addEnclosing ? 1 : 0;

		List<AntigoneParameter<?, ?>> parameters = getParameters();
		int newSize = parameters.size() + offset;
		Class<?>[] types = new Class[newSize];
		Object[] args = new Object[newSize];

		if (addEnclosing) {
			types[0] = wrapVanillaGoalInner.entity();
			args[0] = wrapVanillaGoalInner.entity();
		}

		for (int i = 0; i < parameters.size(); i++) {
			AntigoneParameter<?, ?> baseParameter = parameters.get(i);
			int storeIndex = i + offset;

			if (baseParameter.getType() instanceof Class<?> type) types[storeIndex] = type;
			else types[storeIndex] = baseParameter.getType().getClass();

			if (baseParameter instanceof MobParameter<?> parameter) {
				Object convertedMob = parameter.fromBukkit(mob);
				if (convertedMob == null) {
					severe("Mob must be of type: " + parameter.getDescription());
					return false;
				}
				args[storeIndex] = convertedMob;
				continue;
			}

			if (baseParameter instanceof SameLevelParameter parameter) {
				//noinspection resource
				args[storeIndex] = parameter.of(mob);
				continue;
			}

			if (baseParameter instanceof PredicateParameter<?> parameter) {
				args[storeIndex] = parameter.getPredicate(config, mob);
				continue;
			}

			if (baseParameter instanceof BooleanSupplierParameter parameter) {
				args[storeIndex] = parameter.getSupplier(config, mob);
				continue;
			}

			if (baseParameter instanceof ConfigParameter<?, ?> parameter) {
				if (config == null) return false;

				String name = parameter.getName();
				args[storeIndex] = parameter.getSupplier().apply(config, name).get(data);
				Object def = parameter.getDefault();
				if (args[storeIndex] != null) continue;
				if (def == null) {
					severe("Required parameter '%s' not passed.", name);
					return false;
				}
				args[storeIndex] = def;
				continue;
			}

			args[storeIndex] = baseParameter.getDefault();
		}

		try {
			handle = vanillaGoal.getDeclaredConstructor(types).newInstance(args).asPaperVanillaGoal();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			StringBuilder builder = new StringBuilder();
			for (StackTraceElement el : e.getStackTrace()) {
				builder.append(el).append("\n");
			}
			severe("Report this as a bug!\n" + e + "\n" + builder);
		}
		return true;
	}

	private void severe(String message, Object... args) {
		AntigoneLogger.severe(getClass().getAnnotation(Name.class).value() + ": " + message.formatted(args));
	}

	public abstract List<AntigoneParameter<?, ?>> getParameters();

	@Override
	public final boolean shouldActivate() {
		return handle.shouldActivate();
	}

	@Override
	public final boolean shouldStayActive() {
		return handle.shouldStayActive();
	}

	@Override
	public final void start() {
		handle.start();
	}

	@Override
	public final void stop() {
		handle.stop();
	}

	@Override
	public final void tick() {
		handle.tick();
	}

	@NotNull
	@Override
	public final EnumSet<GoalType> getTypes() {
		return handle.getTypes();
	}

}
