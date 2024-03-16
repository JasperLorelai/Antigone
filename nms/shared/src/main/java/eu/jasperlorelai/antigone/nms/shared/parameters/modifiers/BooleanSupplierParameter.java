package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BooleanSupplier;

import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.DocumentedParameter;

/**
 * Uses {@link ModifierSet} checks.
 * @see PredicateParameter
 */
public class BooleanSupplierParameter extends DocumentedParameter<Class<BooleanSupplier>, BooleanSupplier> {

	private final String name;

	public BooleanSupplierParameter(@NotNull String name) {
		this(name, null);
	}

	public BooleanSupplierParameter(@NotNull String name, @Nullable Default<BooleanSupplier> def) {
		super(BooleanSupplier.class, def);
		this.name = name;
	}

	public BooleanSupplier getSupplier(ConfigurationSection config, org.bukkit.entity.Mob mob) {
		ModifierSet modifiers = new ModifierSet(config.getStringList(name));
		return () -> modifiers.check(mob);
	}

	@Override
	public void documentFurther(JsonObject doc) {
		doc.addProperty("name", name);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Modifiers", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Modifiers");
	}

}
