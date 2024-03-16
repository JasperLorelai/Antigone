package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import eu.jasperlorelai.antigone.nms.shared.util.Default;

public class DummyParameter<T> extends ClassParameter<T> {

	public DummyParameter(@NotNull Class<T> type, @NotNull T def) {
		this(type, new Default<>(def));
	}

	private DummyParameter(Class<T> type, Default<T> def) {
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
