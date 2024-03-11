package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.google.common.base.CaseFormat;

import net.minecraft.world.entity.LivingEntity;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

public abstract class EntityTypeParameter extends ConfigParameter<Class<?>, Class<? extends LivingEntity>> {

	public EntityTypeParameter(String name) {
		this(name, null);
	}

	public EntityTypeParameter(String name, Class<? extends LivingEntity> def) {
		super(name, Class.class, null, def);
	}

	@Override
	public ConfigSupplier<Class<? extends LivingEntity>> getSupplier() {
		return ConfigSupplier.fromString(this::fromString);
	}

	public abstract Class<? extends LivingEntity> fromString(String string);

	@Override
	public String documentDefault() {
		Class<? extends LivingEntity> def = getDefault();
		if (def == null) return null;
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, def.getSimpleName());
	}

	@Override
	public String documentType() {
		return Description.hyperlink("LivingEntityClass", "#LivingEntityClass");
	}

}
