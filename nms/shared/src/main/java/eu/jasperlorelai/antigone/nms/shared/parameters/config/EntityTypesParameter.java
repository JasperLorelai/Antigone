package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.common.base.CaseFormat;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

public abstract class EntityTypesParameter extends ConfigParameter<Class<?>, Class<? extends LivingEntity>[]> {

	/**
	 * Note: {@link HurtByTargetGoal#setAlertOthers(Class[])} is sometimes unnecessarily passed an empty array when not calling it at all and leaving the field null will do.
	 */
	@SuppressWarnings("unchecked")
	public static final Class<? extends LivingEntity>[] EMPTY = new Class[0];

	public EntityTypesParameter(String name) {
		this(name, null);
	}

	public EntityTypesParameter(String name, Class<? extends LivingEntity>[] def) {
		super(name, Class[].class, null, def);
	}

	@Override
	public ConfigSupplier<Class<? extends LivingEntity>[]> getSupplier() {
		return ConfigSupplier.fromList(list -> {
			List<Class<? extends LivingEntity>> newList = new ArrayList<>();
			for (String s : list) newList.add(fromString(s.toUpperCase()));
			//noinspection unchecked
			return newList.toArray(new Class[0]);
		});
	}

	public abstract Class<? extends LivingEntity> fromString(String string);

	@Override
	public String documentType() {
		return Description.hyperlink("LivingEntityClass", "#LivingEntityClass") + " List";
	}

	@Override
	public String documentDefault() {
		Class<? extends LivingEntity>[] def = getDefault();
		if (def == null) return null;
		if (def == EMPTY) return "Empty";
		return Arrays.stream(def)
				.map(clazz -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, clazz.getSimpleName()))
				.collect(Collectors.joining(", "));
	}

}
