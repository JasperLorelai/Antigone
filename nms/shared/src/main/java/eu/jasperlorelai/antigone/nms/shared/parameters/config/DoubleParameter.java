package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.jetbrains.annotations.NotNull;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class DoubleParameter extends PrimitiveConfigParameter<Double> {

	public DoubleParameter(@NotNull String name) {
		this(name, 0);
	}

	public DoubleParameter(@NotNull String name, double def) {
		this(name, new Default<>(def, String.valueOf(def)));
	}

	private DoubleParameter(String name, Default<Double> def) {
		super(name, double.class, ConfigDataUtil::getDouble, def);
	}

}
