package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.DocumentedParameter;

public abstract class ModifierParameter<T, D> extends DocumentedParameter<Class<T>, D> {

	private final String name;

	public ModifierParameter(@NotNull @ConfigKey String name, @NotNull Class<T> type) {
		this(name, type, null);
	}

	public ModifierParameter(@NotNull @ConfigKey String name, @NotNull Class<T> type, @Nullable Default<D> def) {
		super(type, def);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public final T getModifiers(ConfigurationSection config, org.bukkit.entity.Mob mob) {
		ModifierSet modifiers = new ModifierSet(config.getStringList(getName()));
		return check(modifiers, mob);
	}

	protected abstract T check(ModifierSet modifiers, org.bukkit.entity.Mob mob);

	@Override
	public void documentFurther(JsonObject doc) {
		doc.addProperty("name", getName());
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Modifiers", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Modifiers");
	}

}
