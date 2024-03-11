package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class IntegerParameter extends PrimitiveConfigParameter<Integer> {

	public IntegerParameter(String name) {
		this(name, 0);
	}

	public IntegerParameter(String name, int def) {
		super(name, int.class, ConfigDataUtil::getInteger, def);
	}

	@Override
	public String documentDefault() {
		Integer def = getDefault();
		return def != null && def > 0 ? def.toString() : null;
	}

}
