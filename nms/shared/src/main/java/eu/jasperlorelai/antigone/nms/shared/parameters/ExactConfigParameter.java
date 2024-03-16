package eu.jasperlorelai.antigone.nms.shared.parameters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class ExactConfigParameter<T> extends ConfigParameter<Class<T>, T> {

	public ExactConfigParameter(@NotNull String name, @NotNull Class<T> type, @Nullable ConfigSupplier<T> supplier, @Nullable Default<T> def) {
		super(name, type, supplier, def);
	}

	public ExactConfigParameter(@NotNull String name, @NotNull Class<T> type, @Nullable ConfigSupplier<T> supplier) {
		super(name, type, supplier, null);
	}

}
