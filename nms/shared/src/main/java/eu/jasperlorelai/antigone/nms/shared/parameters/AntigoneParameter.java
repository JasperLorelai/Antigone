package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

public abstract class AntigoneParameter<T, D> {

	private final T type;
	private final D def;

	public AntigoneParameter(T type) {
		this(type, null);
	}

	public AntigoneParameter(T type, D def) {
		this.type = type;
		this.def = def;
	}

	public T getType() {
		return type;
	}

	public D getDefault() {
		return def;
	}

	public JsonObject document() {
		JsonObject doc = new JsonObject();
		doc.addProperty("type", documentType());
		documentExtra(doc);
		return doc;
	}

	public abstract void documentExtra(JsonObject doc);

	public abstract String documentType();

}
