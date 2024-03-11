package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Difficulty;

import java.util.EnumSet;
import java.util.function.Predicate;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

@SuppressWarnings("rawtypes")
public class DifficultyPredicateParameter extends ConfigParameter<Class<Predicate>, Predicate<Difficulty>> {

	private static final ConfigSupplier<Predicate<Difficulty>> supplier = ConfigSupplier.fromList(list -> {
		EnumSet<Difficulty> difficulties = EnumSet.noneOf(Difficulty.class);
		for (String string : list) {
			try {
				difficulties.add(Difficulty.valueOf(string));
			} catch (IllegalArgumentException ignored) {}
		}
		return difficulties::contains;
	});

	public DifficultyPredicateParameter(String name) {
		this(name, null);
	}

	public DifficultyPredicateParameter(String name, Predicate<Difficulty> def) {
		super(name, Predicate.class, supplier, def);
	}

	@Override
	public String documentType() {
		return Description.ofEnum("List of ", Difficulty.class);
	}

	@Override
	public String documentDefault() {
		return null; // Cannot document
	}

}
