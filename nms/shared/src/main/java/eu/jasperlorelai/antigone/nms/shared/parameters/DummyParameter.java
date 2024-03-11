package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

public class DummyParameter<T> extends ClassParameter<T> {

	public DummyParameter(Class<T> type, T def) {
		super(type, def);
	}

	@Override
	public void documentExtra(JsonObject doc) {
		// Unused
	}

	@Override
	public String documentType() {
		return null; // Unused
	}

}
