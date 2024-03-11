package eu.jasperlorelai.antigone.nms.shared.parameters;

public abstract class ClassParameter<T> extends AntigoneParameter<Class<T>, T> {

	public ClassParameter(Class<T> type, T def) {
		super(type, def);
	}

	public ClassParameter(Class<T> type) {
		this(type, null);
	}

}
