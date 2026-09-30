package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Field;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.tags.TagKey;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NmsFluidTagParameter extends ConfigParameter<Class<TagKey>, TagKey<Fluid>> {

	private static final Map<String, TagKey<Fluid>> TAGS = new HashMap<>();
	static {
		try {
			for (Field field : FluidTags.class.getDeclaredFields()) {
				if (!(field.get(null) instanceof TagKey tag)) continue;
				TAGS.put(field.getName(), tag);
			}
		} catch (ExceptionInInitializerError | IllegalAccessException ignored) {}
	}

	private static final ConfigSupplier<TagKey<Fluid>> supplier = ConfigSupplier.fromString(string ->
		TAGS.get(string.toUpperCase())
	);

	public NmsFluidTagParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public NmsFluidTagParameter(@NotNull @ConfigKey String name, @Nullable Default<TagKey<Fluid>> def) {
		super(name, TagKey.class, supplier, def);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Fluid Tag", "https://minecraft.wiki/w/Fluid_tag_(Java_Edition)");
	}

}
