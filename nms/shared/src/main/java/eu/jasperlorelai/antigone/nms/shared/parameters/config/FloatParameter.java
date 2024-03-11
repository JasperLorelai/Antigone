package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class FloatParameter extends PrimitiveConfigParameter<Float> {

	public FloatParameter(String name) {
		this(name, 0);
	}

	public FloatParameter(String name, float def) {
		super(name, float.class, ConfigDataUtil::getFloat, def);
	}

	@Override
	public String documentDefault() {
		Float def = getDefault();
		return def != null && def > 0 ? def.toString() : null;
	}

}

