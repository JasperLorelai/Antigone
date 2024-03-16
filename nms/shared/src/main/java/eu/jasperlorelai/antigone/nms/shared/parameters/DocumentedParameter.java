package eu.jasperlorelai.antigone.nms.shared.parameters;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;

public abstract class DocumentedParameter<T, D> extends AntigoneParameter<T, D> {

	public DocumentedParameter(@NotNull T type) {
		this(type, null);
	}

	public DocumentedParameter(@NotNull T type, @Nullable Default<D> def) {
		super(type, def);
	}

	@Override
	public final void documentExtra(JsonObject doc) {
		Default<D> def = getDefault();
		if (def != null) doc.addProperty("default", def.description());
		documentFurther(doc);
	}

	public abstract void documentFurther(JsonObject doc);

}
