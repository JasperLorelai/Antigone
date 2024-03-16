package eu.jasperlorelai.antigone.nms.shared.parameters.mob;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import eu.jasperlorelai.antigone.nms.shared.parameters.ClassParameter;

public class MobParameter<T> extends ClassParameter<T> {

	private final String description;
	private final MobConverter<T> converter;

	MobParameter(@NotNull Class<T> nmsType, @NotNull String description, @NotNull MobConverter<T> converter) {
		super(nmsType);
		this.description = description;
		this.converter = converter;
	}

	public String getDescription() {
		return description;
	}

	public T fromBukkit(org.bukkit.entity.Mob mob) {
		return converter.fromBukkit(mob);
	}

	@Override
	public void documentExtra(JsonObject doc) {
		// Unused
	}

	@Override
	public String documentType() {
		return null; // Unused
	}

}
