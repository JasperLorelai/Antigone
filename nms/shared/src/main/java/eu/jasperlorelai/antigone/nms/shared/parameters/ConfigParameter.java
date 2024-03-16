package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class ConfigParameter<T, D> extends DocumentedParameter<T, D> {

	private final String name;
	private final ConfigSupplier<D> supplier;

	public ConfigParameter(@NotNull String name, @NotNull T type, @Nullable ConfigSupplier<D> supplier, @Nullable Default<D> def) {
		super(type, def);
		this.name = name;
		this.supplier = supplier;
	}

	public ConfigParameter(@NotNull String name, @NotNull T type, @Nullable ConfigSupplier<D> supplier) {
		this(name, type, supplier, null);
	}

	public String getName() {
		return name;
	}

	public ConfigSupplier<D> getSupplier() {
		return supplier;
	}

	@Override
	public void documentFurther(JsonObject doc) {
		doc.addProperty("name", getName());
	}

}
