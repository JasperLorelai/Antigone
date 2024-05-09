package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.List;
import java.util.EnumSet;
import java.lang.reflect.Constructor;

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
	@SuppressWarnings("unchecked")
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
				vanillaGoal = (Class<? extends Goal>) Class.forName(wrapVanillaGoalInner.entity().getName() + "$" + wrapVanillaGoalInner.className());
			} catch (ClassNotFoundException | ClassCastException ignored) {
				severe("Goal could not be created. Report this as a bug!");
				return false;
			}
		}

		List<AntigoneParameter<?, ?>> parameters = getParameters();
		Class<?>[] types = new Class[parameters.size()];
		Object[] args = new Object[parameters.size()];
		for (int i = 0; i < parameters.size(); i++) {
			AntigoneParameter<?, ?> baseParameter = parameters.get(i);
			if (baseParameter.getType() instanceof Class<?> type) types[i] = type;
			else types[i] = baseParameter.getType().getClass();

			switch (baseParameter) {
				case MobParameter<?> parameter -> {
					Object convertedMob = parameter.fromBukkit(mob);
					if (convertedMob == null) {
						severe("Mob must be of type: " + parameter.getDescription());
						return false;
					}
					args[i] = convertedMob;
					continue;
				}
				case SameLevelParameter parameter -> {
					//noinspection resource
					args[i] = parameter.of(mob);
					continue;
				}
				case PredicateParameter<?> parameter -> {
					args[i] = parameter.getPredicate(config, mob);
					continue;
				}
				case BooleanSupplierParameter parameter -> {
					args[i] = parameter.getSupplier(config, mob);
					continue;
				}
				case ConfigParameter<?, ?> parameter -> {
					if (config == null) return false;

					String name = parameter.getName();
					args[i] = parameter.getSupplier().apply(config, name).get(data);
					Object def = parameter.getDefault() == null ? null : parameter.getDefault().value();
					if (args[i] != null) continue;
					if (def == null) {
						severe("Required parameter '%s' not passed.", name);
						return false;
					}
					args[i] = def;
					continue;
				}
				default -> {}
			}

			args[i] = baseParameter.getDefault() == null ? null : baseParameter.getDefault().value();
		}

		try {
			Constructor<? extends Goal> constructor = vanillaGoal.getDeclaredConstructor(types);
			constructor.setAccessible(true);
			handle = constructor.newInstance(args).asPaperVanillaGoal();
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
