package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Field;

import net.minecraft.tags.DamageTypeTags;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NmsDamageTypeTagParameter extends ConfigParameter<Class<TagKey>, TagKey<DamageType>> {

	private static final Map<String, TagKey<DamageType>> TAGS = new HashMap<>();
	static {
		try {
			for (Field field : DamageTypeTags.class.getDeclaredFields()) {
				if (!(field.get(null) instanceof TagKey tag)) continue;
				TAGS.put(field.getName(), tag);
			}
		} catch (ExceptionInInitializerError | IllegalAccessException ignored) {}
	}

	private static final ConfigSupplier<TagKey<DamageType>> supplier = ConfigSupplier.fromString(string ->
			TAGS.get(string.toUpperCase())
	);

	public NmsDamageTypeTagParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public NmsDamageTypeTagParameter(@NotNull @ConfigKey String name, @Nullable Default<TagKey<DamageType>> def) {
		super(name, TagKey.class, supplier, def);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Item tag", "https://minecraft.wiki/w/Damage_type_tag_(Java_Edition)");
	}

}
