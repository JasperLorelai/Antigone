package eu.jasperlorelai.antigone.nms.v1_20_3.parameters.config;

import java.lang.Class;
import java.lang.String;
import java.lang.Override;
import java.lang.IllegalArgumentException;

import net.minecraft.world.entity.LivingEntity;

import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.LivingEntityClass;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;

public class EntityTypeParameter_v1_20_3 extends EntityTypeParameter {

	public EntityTypeParameter_v1_20_3(String name) {
		this(name, null);
	}

	public EntityTypeParameter_v1_20_3(String name, Class<? extends LivingEntity> def) {
		super(name, def);
	}

	@Override
	public Class<? extends LivingEntity> fromString(String string) {
		try {
			return LivingEntityClass.valueOf(string.toUpperCase()).get();
		} catch (IllegalArgumentException ignored) {}
		return null;
	}

}
