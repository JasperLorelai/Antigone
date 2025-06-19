package eu.jasperlorelai.antigone.nms.shared.util;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import net.minecraft.world.entity.ai.goal.Goal;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapVanillaGoal {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Exact {

		Class<? extends Goal> value();

	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Inner {

		Class<?> outer();

		String className();

	}

}
