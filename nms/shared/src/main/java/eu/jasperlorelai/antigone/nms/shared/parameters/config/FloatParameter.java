package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.jetbrains.annotations.NotNull;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class FloatParameter extends PrimitiveConfigParameter<Float> {

	public FloatParameter(@NotNull @ConfigKey String name) {
		this(name, 0);
	}

	public FloatParameter(@NotNull @ConfigKey String name, float def) {
		this(name, new Default<>(def, String.valueOf(def)));
	}

	private FloatParameter(@ConfigKey String name, Default<Float> def) {
		super(name, float.class, ConfigDataUtil::getFloat, def);
	}

}

