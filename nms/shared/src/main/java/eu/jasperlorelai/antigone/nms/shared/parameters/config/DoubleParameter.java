package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.jetbrains.annotations.NotNull;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class DoubleParameter extends PrimitiveConfigParameter<Double> {

	public DoubleParameter(@NotNull @ConfigKey String name) {
		this(name, 0);
	}

	public DoubleParameter(@NotNull @ConfigKey String name, double def) {
		this(name, new Default<>(def, String.valueOf(def)));
	}

	private DoubleParameter(@ConfigKey String name, Default<Double> def) {
		super(name, double.class, ConfigDataUtil::getDouble, def);
	}

}
