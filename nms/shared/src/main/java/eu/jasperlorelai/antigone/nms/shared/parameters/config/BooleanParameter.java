package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.jetbrains.annotations.NotNull;

import com.nisovin.magicspells.util.config.ConfigDataUtil;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.parameters.PrimitiveConfigParameter;

public class BooleanParameter extends PrimitiveConfigParameter<Boolean> {

	public BooleanParameter(@NotNull String name) {
		this(name, false);
	}

	public BooleanParameter(@NotNull String name, boolean def) {
		this(name, new Default<>(def, String.valueOf(def)));
	}

	private BooleanParameter(String name, Default<Boolean> def) {
		super(name, boolean.class, ConfigDataUtil::getBoolean, def);
	}

}
