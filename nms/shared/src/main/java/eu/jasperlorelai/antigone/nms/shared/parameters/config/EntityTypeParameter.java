package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

public abstract class EntityTypeParameter extends ConfigParameter<Class<?>, Class<? extends LivingEntity>> {

	public EntityTypeParameter(@NotNull String name) {
		this(name, (Class<? extends LivingEntity>) null);
	}

	public EntityTypeParameter(@NotNull String name, @Nullable Class<? extends LivingEntity> def) {
		this(name, def == null ? null : new Default<>(def, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, def.getSimpleName())));
	}

	private EntityTypeParameter(String name, Default<Class<? extends LivingEntity>> def) {
		super(name, Class.class, null, def);
	}

	@Override
	public ConfigSupplier<Class<? extends LivingEntity>> getSupplier() {
		return ConfigSupplier.fromString(this::fromString);
	}

	public abstract Class<? extends LivingEntity> fromString(String string);

	@Override
	public String documentType() {
		return Description.hyperlink("LivingEntityClass", "#LivingEntityClass");
	}

}
