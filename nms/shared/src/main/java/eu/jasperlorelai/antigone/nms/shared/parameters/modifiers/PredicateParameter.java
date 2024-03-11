package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import com.google.gson.JsonObject;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

/**
 * Uses {@link ModifierSet} checks.
 * @see BooleanSupplierParameter
 */
@SuppressWarnings("rawtypes")
public class PredicateParameter<E extends LivingEntity> extends AntigoneParameter<Class<Predicate>, Predicate<E>> {

	private final String name;

	public PredicateParameter(String name) {
		this(name, null);
	}

	public PredicateParameter(String name, Predicate<E> def) {
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
	public void documentExtra(JsonObject doc) {
		doc.addProperty("name", name);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Modifiers", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Modifiers");
	}

}
