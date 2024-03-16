package eu.jasperlorelai.antigone.nms.shared.parameters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;

public abstract class ClassParameter<T> extends AntigoneParameter<Class<T>, T> {

	public ClassParameter(@NotNull Class<T> type, @Nullable Default<T> def) {
		super(type, def);
	}

	public ClassParameter(@NotNull Class<T> type) {
		this(type, null);
	}

}
