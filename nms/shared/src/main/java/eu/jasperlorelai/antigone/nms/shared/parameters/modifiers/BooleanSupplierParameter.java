package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import com.google.gson.JsonObject;

import java.util.function.BooleanSupplier;

import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

/**
 * Uses {@link ModifierSet} checks.
 * @see PredicateParameter
 */
public class BooleanSupplierParameter extends AntigoneParameter<Class<BooleanSupplier>, BooleanSupplier> {

	private final String name;

	public BooleanSupplierParameter(String name) {
		this(name, null);
	}

	public BooleanSupplierParameter(String name, BooleanSupplier def) {
		super(BooleanSupplier.class, def);
		this.name = name;
	}

	public BooleanSupplier getSupplier(ConfigurationSection config, org.bukkit.entity.Mob mob) {
		ModifierSet modifiers = new ModifierSet(config.getStringList(name));
		return () -> modifiers.check(mob);
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
