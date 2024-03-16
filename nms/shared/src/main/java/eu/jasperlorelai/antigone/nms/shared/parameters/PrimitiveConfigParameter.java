package eu.jasperlorelai.antigone.nms.shared.parameters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class PrimitiveConfigParameter<T> extends ExactConfigParameter<T> {

	public PrimitiveConfigParameter(@NotNull String name, @NotNull Class<T> type, @Nullable ConfigSupplier<T> supplier) {
		this(name, type, supplier, null);
	}

	public PrimitiveConfigParameter(@NotNull String name, @NotNull Class<T> type, @Nullable ConfigSupplier<T> supplier, @Nullable Default<T> def) {
		super(name, type, supplier, def);
	}

	@Override
	public String documentType() {
		return getType().getName();
	}

}
