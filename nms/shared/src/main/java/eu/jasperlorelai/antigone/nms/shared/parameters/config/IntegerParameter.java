package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.jetbrains.annotations.NotNull;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class IntegerParameter extends PrimitiveConfigParameter<Integer> {

	public IntegerParameter(@NotNull @ConfigKey String name) {
		this(name, 0);
	}

	public IntegerParameter(@NotNull @ConfigKey String name, int def) {
		this(name, new Default<>(def, String.valueOf(def)));
	}

	private IntegerParameter(@ConfigKey String name, Default<Integer> def) {
		super(name, int.class, ConfigDataUtil::getInteger, def);
	}

}
