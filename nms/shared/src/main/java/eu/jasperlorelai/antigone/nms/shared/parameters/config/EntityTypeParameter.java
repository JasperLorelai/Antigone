package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.google.common.base.CaseFormat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier.FromString;

public class EntityTypeParameter<T> extends ConfigParameter<Class<?>, Class<? extends T>> {

	private final Class<? extends T> type;

	public EntityTypeParameter(@NotNull Class<? extends T> type, @NotNull FromString<Class<? extends T>> fromString, @NotNull @ConfigKey String name) {
		this(type, fromString, name, (Class<? extends T>) null);
	}

	public EntityTypeParameter(@NotNull Class<? extends T> type, @NotNull FromString<Class<? extends T>> fromString, @NotNull @ConfigKey String name, @Nullable Class<? extends T> def) {
		this(type, fromString, name, def == null ? null : new Default<>(def, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, def.getSimpleName())));
	}

	private EntityTypeParameter(Class<? extends T> type, FromString<Class<? extends T>> fromString, @ConfigKey String name, Default<Class<? extends T>> def) {
		super(name, Class.class, ConfigSupplier.fromString(fromString), def);
		this.type = type;
	}

	@Override
	public String documentType() {
		return Description.hyperlink(type.getSimpleName() + "Class", "#" + type.getSimpleName() + "Class");
	}

}
