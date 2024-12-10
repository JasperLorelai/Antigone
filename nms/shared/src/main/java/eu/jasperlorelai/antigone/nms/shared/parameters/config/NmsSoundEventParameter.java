package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Sound;

import net.minecraft.sounds.SoundEvent;

import org.jetbrains.annotations.NotNull;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.versioned.holders.RegistryResolverHolder;

public class NmsSoundEventParameter extends NmsRegistryParameter<Class<SoundEvent>, SoundEvent, SoundEvent> {

	public NmsSoundEventParameter(@ConfigKey @NotNull String name) {
		super(name, SoundEvent.class);
	}

	@Override
	public ConfigSupplier<SoundEvent> getSupplier() {
		return ConfigSupplier.fromString(string -> getVanillaResolver().apply(getBukkitResolver().apply(string)));
	}

	@NotNull
	@Override
	public BukkitResolver getBukkitResolver() {
		return string -> {
			try {
				return Sound.valueOf(string.toUpperCase()).key();
			} catch (IllegalArgumentException ignored) {
				return null;
			}
		};
	}

	@NotNull
	@Override
	public VanillaResolver<SoundEvent> getVanillaResolver() {
		return RegistryResolverHolder.getInstance().soundEvent();
	}

	@Override
	public String documentType() {
		return Description.ofEnum(Sound.class);
	}

}
