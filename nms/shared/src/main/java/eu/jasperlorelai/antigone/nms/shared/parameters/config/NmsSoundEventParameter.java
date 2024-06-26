package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Sound;

import org.jetbrains.annotations.NotNull;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ExactConfigParameter;

public class NmsSoundEventParameter extends ExactConfigParameter<SoundEvent> {

	private static final ConfigSupplier<SoundEvent> supplier = ConfigSupplier.fromString(string -> {
		try {
			return BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation(Sound.valueOf(string.toUpperCase()).getKey().getKey()));
		} catch (IllegalArgumentException ignored) {
			return null;
		}
	});

	public NmsSoundEventParameter(@NotNull @ConfigKey String name) {
		super(name, SoundEvent.class, supplier);
		// If a constructor with a default value is needed, remember to check "Util#isNotBootstrapped"
	}

	@Override
	public String documentType() {
		return Description.ofEnum(Sound.class);
	}

}
