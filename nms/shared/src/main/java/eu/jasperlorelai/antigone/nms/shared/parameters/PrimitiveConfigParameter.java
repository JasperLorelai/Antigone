package eu.jasperlorelai.antigone.nms.shared.parameters;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;

public abstract class PrimitiveConfigParameter<T> extends ExactConfigParameter<T> {

	public PrimitiveConfigParameter(String name, Class<T> type, ConfigSupplier<T> supplier) {
		this(name, type, supplier, null);
	}

	public PrimitiveConfigParameter(String name, Class<T> type, ConfigSupplier<T> supplier, T def) {
		super(name, type, supplier, def);
	}

	@Override
	public String documentType() {
		return getType().getName();
	}

}
