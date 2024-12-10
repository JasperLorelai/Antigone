package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import net.kyori.adventure.key.Key;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

public abstract class NmsRegistryParameter<C, T, V> extends ConfigParameter<C, T> {

	public NmsRegistryParameter(@NotNull @ConfigKey String name, @NotNull C type) {
		super(name, type, null);
		// If a constructor with a default value is needed, remember to check "Util#isNotBootstrapped"
	}

	@Nullable
	public abstract BukkitResolver getBukkitResolver();

	@NotNull
	public abstract VanillaResolver<V> getVanillaResolver();

	@FunctionalInterface
	public interface BukkitResolver {

		@Nullable
		Key apply(String string);

	}

	@FunctionalInterface
	public interface VanillaResolver<T> {

		@Nullable
		T apply(Key key);

	}

}
