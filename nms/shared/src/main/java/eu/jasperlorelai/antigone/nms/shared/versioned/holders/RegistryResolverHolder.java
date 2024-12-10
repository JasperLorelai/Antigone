package eu.jasperlorelai.antigone.nms.shared.versioned.holders;

import org.bukkit.Bukkit;

import eu.jasperlorelai.antigone.nms.shared.versioned.VersionedHolder;
import eu.jasperlorelai.antigone.nms.shared.versioned.types.RegistryResolver;

public class RegistryResolverHolder extends VersionedHolder<RegistryResolver> {

	private static RegistryResolver INSTANCE;

	private RegistryResolverHolder(String mcVersion) {
		super(RegistryResolver.class, mcVersion);
	}

	public static RegistryResolver getInstance() {
		if (INSTANCE == null) INSTANCE = new RegistryResolverHolder(Bukkit.getMinecraftVersion()).create();
		return INSTANCE;
	}

}
