package eu.jasperlorelai.antigone.nms.shared.util;

import net.minecraft.server.Bootstrap;

public class Util {

	public static boolean isNotBootstrapped() {
		try {
			Bootstrap.checkBootstrapCalled(() -> "antigone");
			return false;
		} catch (IllegalArgumentException ignored) {
			return true;
		}
	}

}
