package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

public class EntityTypesParameter extends ConfigParameter<Class<?>, Class<? extends LivingEntity>[]> {

	private final Function<String, Class<? extends LivingEntity>> fromString;

	/**
	 * Note: {@link HurtByTargetGoal#setAlertOthers(Class[])} is sometimes unnecessarily passed an empty array when not calling it at all and leaving the field null will do.
	 */
	@SuppressWarnings("unchecked")
	public static final Class<? extends LivingEntity>[] EMPTY = new Class[0];

	public EntityTypesParameter(@NotNull Function<String, Class<? extends LivingEntity>> fromString, @NotNull @ConfigKey String name) {
		this(fromString, name, (Class<? extends LivingEntity>[]) null);
	}

	public EntityTypesParameter(@NotNull Function<String, Class<? extends LivingEntity>> fromString, @NotNull @ConfigKey String name, @Nullable Class<? extends LivingEntity>[] def) {
		this(fromString, name, def == null ? null : new Default<>(def, defaultToString(def)));
	}

	private EntityTypesParameter(Function<String, Class<? extends LivingEntity>> fromString, @ConfigKey String name, Default<Class<? extends LivingEntity>[]> def) {
		super(name, Class[].class, null, def);
		this.fromString = fromString;
	}

	private static String defaultToString(Class<? extends LivingEntity>[] def) {
		if (def == EMPTY) return "Empty";
		return Arrays.stream(def)
				.map(clazz -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, clazz.getSimpleName()))
				.collect(Collectors.joining(", "));
	}

	@Override
	@SuppressWarnings("unchecked")
	public ConfigSupplier<Class<? extends LivingEntity>[]> getSupplier() {
		return ConfigSupplier.fromList(list -> {
			List<Class<? extends LivingEntity>> newList = new ArrayList<>();
			for (String s : list) newList.add(fromString.apply(s));
			return newList.toArray(new Class[0]);
		});
	}

	@Override
	public String documentType() {
		return Description.hyperlink("LivingEntityClass", "#LivingEntityClass") + " List";
	}

}
