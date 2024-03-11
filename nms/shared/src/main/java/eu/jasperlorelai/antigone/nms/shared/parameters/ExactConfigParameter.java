package eu.jasperlorelai.antigone.nms.shared.parameters;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class ExactConfigParameter<T> extends ConfigParameter<Class<T>, T> {

	public ExactConfigParameter(String name, Class<T> type, ConfigSupplier<T> supplier, T def) {
		super(name, type, supplier, def);
	}

	public ExactConfigParameter(String name, Class<T> type, ConfigSupplier<T> supplier) {
		super(name, type, supplier, null);
	}

}
