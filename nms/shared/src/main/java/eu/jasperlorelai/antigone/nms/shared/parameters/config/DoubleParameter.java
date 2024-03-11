package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class DoubleParameter extends PrimitiveConfigParameter<Double> {

	public DoubleParameter(String name) {
		this(name, 0);
	}

	public DoubleParameter(String name, double def) {
		super(name, double.class, ConfigDataUtil::getDouble, def);
	}

	@Override
	public String documentDefault() {
		Double def = getDefault();
		return def != null && def > 0 ? def.toString() : null;
	}

}
