package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;

public abstract class AntigoneParameter<T, D> {

	private final T type;
	@Nullable
	private final Default<D> def;

	public AntigoneParameter(@NotNull T type) {
		this(type, null);
	}

	public AntigoneParameter(@NotNull T type, @Nullable Default<D> def) {
		this.type = type;
		this.def = def;
	}

	public T getType() {
		return type;
	}

	@Nullable
	public Default<D> getDefault() {
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
