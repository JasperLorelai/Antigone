package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Mob;

import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySelector;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;

@SuppressWarnings("rawtypes")
public class PredicateParameter<E extends LivingEntity> extends ModifierParameter<Predicate, Predicate<E>> {

	public PredicateParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public PredicateParameter(@NotNull @ConfigKey String name, @Nullable Default<Predicate<E>> def) {
		super(name, Predicate.class, def);
	}

	@Override
	protected Predicate<E> check(ModifierSet modifiers, Mob mob) {
		return nmsEntity -> {
			if (Bukkit.getEntity(nmsEntity.getUUID()) instanceof org.bukkit.entity.LivingEntity entity)
				return modifiers.check(mob, entity);
			return false;
		};
	}

	public static <T extends LivingEntity> Default<Predicate<T>> always() {
		return new Default<>(e -> true, "[always require]");
	}

	public static <T extends LivingEntity> Default<Predicate<T>> noCreativeOrSpectator() {
		return new Default<>(
				EntitySelector.NO_CREATIVE_OR_SPECTATOR::test,
				"[gamemode creative deny, gamemode spectator deny]"
		);
	}

}
