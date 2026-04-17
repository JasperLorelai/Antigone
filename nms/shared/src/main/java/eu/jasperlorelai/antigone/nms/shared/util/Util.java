package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.*;

import net.minecraft.server.Bootstrap;

public class Util {

	private static final Map<String, String> VERSION_REMAP = new LinkedHashMap<>() {{
		put("26.1.2", "26.1.1");
	}};

	private static final Map<String, List<String>> REVERSE_VERSION_MAP = new HashMap<>();
	static {
		for (Map.Entry<String, String> entry : VERSION_REMAP.entrySet()) {
			String from = entry.getKey();
			String to = entry.getValue();
			REVERSE_VERSION_MAP.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
		}
	}

	public static List<String> getReverseVersions(String mcVersion) {
		return REVERSE_VERSION_MAP.getOrDefault(mcVersion, List.of());
	}

	public static boolean isNotBootstrapped() {
		try {
			Bootstrap.checkBootstrapCalled(() -> "antigone");
			return false;
		} catch (IllegalArgumentException ignored) {
			return true;
		}
	}

	public static String getNMSVersion(String mcVersion) {
		if (mcVersion.startsWith("v") && !mcVersion.contains(".")) return mcVersion;
		return "v" + VERSION_REMAP.getOrDefault(mcVersion, mcVersion).replace(".", "_");
	}

	public static String getNMSPackage(String mcVersion) {
		return "eu.jasperlorelai.antigone.nms." + getNMSVersion(mcVersion);
	}

}
