package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import com.google.gson.JsonObject;

import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySelector;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.DocumentedParameter;

/**
 * Uses {@link ModifierSet} checks.
 * @see BooleanSupplierParameter
 */
@SuppressWarnings("rawtypes")
public class PredicateParameter<E extends LivingEntity> extends DocumentedParameter<Class<Predicate>, Predicate<E>> {

	private final String name;

	public PredicateParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public PredicateParameter(@NotNull @ConfigKey String name, @Nullable Default<Predicate<E>> def) {
		super(Predicate.class, def);
		this.name = name;
	}

	public Predicate<E> getPredicate(ConfigurationSection config, org.bukkit.entity.Mob mob) {
		ModifierSet modifiers = new ModifierSet(config.getStringList(name));
		return nmsEntity -> {
			if (Bukkit.getEntity(nmsEntity.getUUID()) instanceof org.bukkit.entity.LivingEntity entity)
				return modifiers.check(mob, entity);
			return false;
		};
	}

	@Override
	public void documentFurther(JsonObject doc) {
		doc.addProperty("name", name);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Modifiers", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Modifiers");
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
