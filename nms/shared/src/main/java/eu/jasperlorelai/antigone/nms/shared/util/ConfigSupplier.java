package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

import org.jetbrains.annotations.NotNull;

import org.bukkit.configuration.ConfigurationSection;

import com.nisovin.magicspells.util.SpellData;
import com.nisovin.magicspells.util.config.ConfigData;
import com.nisovin.magicspells.util.config.ConfigDataUtil;

@FunctionalInterface
public interface ConfigSupplier<T> {

	ConfigData<T> apply(ConfigurationSection config, String name);

	static <R> ConfigSupplier<R> fromString(Function<String, R> fromFunction) {
		return (config, path) -> {
			String value = config.getString(path);
			if (value == null) return data -> null;

			R ret = fromFunction.apply(value);
			if (ret != null) return data -> ret;

			ConfigData<String> supplier = ConfigDataUtil.getString(value);
			if (supplier.isConstant()) return data -> null;

			return new ConfigData<>() {

				@Override
				public R get(@NotNull SpellData data) {
					String val = supplier.get(data);
					if (val == null) return null;
					return fromFunction.apply(value);
				}

				@Override
				public boolean isConstant() {
					return false;
				}

			};
		};
	}

	static <R> ConfigSupplier<R> fromList(Function<List<String>, R> fromFunction) {
		return (config, path) -> {
			if (config.isString(path)) return fromString(string -> fromFunction.apply(List.of(string))).apply(config, path);

			List<String> list = config.getStringList(path);
			if (list.isEmpty()) return data -> null;

			return data -> {
				List<String> newList = new ArrayList<>();
				for (String string : list) {
					newList.add(ConfigDataUtil.getString(string).get(data));
				}
				return fromFunction.apply(newList);
			};
		};
	}

}
