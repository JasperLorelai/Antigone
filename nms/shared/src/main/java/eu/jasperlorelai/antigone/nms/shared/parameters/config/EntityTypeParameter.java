package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier.FromString;

public class EntityTypeParameter extends ConfigParameter<Class<?>, Class<? extends LivingEntity>> {

	public EntityTypeParameter(@NotNull FromString<Class<? extends LivingEntity>> fromString, @NotNull @ConfigKey String name) {
		this(fromString, name, (Class<? extends LivingEntity>) null);
	}

	public EntityTypeParameter(@NotNull FromString<Class<? extends LivingEntity>> fromString, @NotNull @ConfigKey String name, @Nullable Class<? extends LivingEntity> def) {
		this(fromString, name, def == null ? null : new Default<>(def, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, def.getSimpleName())));
	}

	private EntityTypeParameter(FromString<Class<? extends LivingEntity>> fromString, @ConfigKey String name, Default<Class<? extends LivingEntity>> def) {
		super(name, Class.class, ConfigSupplier.fromString(fromString), def);
	}

	@Override
	public String documentType() {
		return Description.hyperlink("LivingEntityClass", "#LivingEntityClass");
	}

}
