package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class ConfigParameter<T, D> extends AntigoneParameter<T, D> {

	private final String name;
	private final ConfigSupplier<D> supplier;

	public ConfigParameter(String name, T type, ConfigSupplier<D> supplier, D def) {
		super(type, def);
		this.name = name;
		this.supplier = supplier;
	}

	public ConfigParameter(String name, T type, ConfigSupplier<D> supplier) {
		this(name, type, supplier, null);
	}

	public String getName() {
		return name;
	}

	public ConfigSupplier<D> getSupplier() {
		return supplier;
	}

	@Override
	public void documentExtra(JsonObject doc) {
		String def = documentDefault();
		if (def != null) doc.addProperty("default", def);
		doc.addProperty("name", getName());
	}

	public abstract String documentDefault();

}
