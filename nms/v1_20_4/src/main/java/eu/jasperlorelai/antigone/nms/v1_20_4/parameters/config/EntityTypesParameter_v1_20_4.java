package eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config;

import java.lang.Class;
import java.lang.String;
import java.lang.Override;
import java.lang.IllegalArgumentException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;

import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.LivingEntityClass;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypesParameter;

public class EntityTypesParameter_v1_20_4 extends EntityTypesParameter {

	public EntityTypesParameter_v1_20_4(@NotNull String name) {
		this(name, null);
	}

	public EntityTypesParameter_v1_20_4(@NotNull String name, @Nullable Class<? extends LivingEntity>[] def) {
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
