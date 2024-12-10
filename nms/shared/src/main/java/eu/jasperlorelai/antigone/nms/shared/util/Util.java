package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.Map;

import net.minecraft.server.Bootstrap;

public class Util {

	private static final Map<String, String> VERSION_REMAP = Map.of(
			"1.21.1", "1.21"
	);

	public static boolean isNotBootstrapped() {
		try {
			Bootstrap.checkBootstrapCalled(() -> "antigone");
			return false;
		} catch (IllegalArgumentException ignored) {
			return true;
		}
	}

	public static String getNMSVersion(String mcVersion) {
		if (mcVersion.startsWith("v")) return mcVersion;
		return "v" + VERSION_REMAP.getOrDefault(mcVersion, mcVersion).replace(".", "_");
	}

	public static String getNMSPackage(String mcVersion) {
		return "eu.jasperlorelai.antigone.nms." + getNMSVersion(mcVersion);
	}

}
