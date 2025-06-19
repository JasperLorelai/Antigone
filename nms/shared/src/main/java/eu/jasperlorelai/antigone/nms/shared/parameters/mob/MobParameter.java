package eu.jasperlorelai.antigone.nms.shared.parameters.mob;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import org.bukkit.craftbukkit.entity.CraftMob;

import eu.jasperlorelai.antigone.nms.shared.parameters.ClassParameter;

public class MobParameter<T> extends ClassParameter<T> {

	private final String description;
	private final MobConverter<T> converter;

	public MobParameter(@NotNull Class<T> nmsType, @NotNull String description, @NotNull MobConverter<T> converter) {
		super(nmsType);
		this.description = description;
		this.converter = converter;
	}

	public static <M> MobParameter<M> of(Class<M> nmsClass, String description, Class<?> ...withInterfaces) {
		return new MobParameter<>(nmsClass, description, mob -> {
			try {
				M entity = nmsClass.cast(((CraftMob) mob).getHandle());
				if (withInterfaces == null) return entity;
				for (Class<?> withInterface : withInterfaces) {
					if (!entity.getClass().isAssignableFrom(withInterface)) return null;
				}
				return entity;
			} catch (ClassCastException e) {
				return null;
			}
		});
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
