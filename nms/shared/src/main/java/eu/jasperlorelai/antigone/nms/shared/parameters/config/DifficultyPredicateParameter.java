package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Difficulty;

import java.util.EnumSet;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

@SuppressWarnings("rawtypes")
public class DifficultyPredicateParameter extends ConfigParameter<Class<Predicate>, Predicate<Difficulty>> {

	public static final Default<Predicate<Difficulty>> DEFAULT_ALL = new Default<>(d -> true, "All");

	private static final ConfigSupplier<Predicate<Difficulty>> supplier = ConfigSupplier.fromList(list -> {
		EnumSet<Difficulty> difficulties = EnumSet.noneOf(Difficulty.class);
		for (String string : list) {
			try {
				difficulties.add(Difficulty.valueOf(string));
			} catch (IllegalArgumentException ignored) {}
		}
		return difficulties::contains;
	});

	public DifficultyPredicateParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public DifficultyPredicateParameter(@NotNull @ConfigKey String name, @Nullable Default<Predicate<Difficulty>> def) {
		super(name, Predicate.class, supplier, def);
	}

	@Override
	public String documentType() {
		return Description.ofEnum("List of ", Difficulty.class);
	}

}
