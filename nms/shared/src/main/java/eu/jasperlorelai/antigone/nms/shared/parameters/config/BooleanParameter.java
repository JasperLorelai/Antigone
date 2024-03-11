package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class BooleanParameter extends PrimitiveConfigParameter<Boolean> {

	public BooleanParameter(String name) {
		this(name, false);
	}

	public BooleanParameter(String name, boolean def) {
		super(name, boolean.class, ConfigDataUtil::getBoolean, def);
	}

	@Override
	public String documentDefault() {
		return String.valueOf(getDefault());
	}

}
