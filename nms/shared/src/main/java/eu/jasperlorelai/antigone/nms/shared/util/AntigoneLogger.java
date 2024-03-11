package eu.jasperlorelai.antigone.nms.shared.util;

import org.bukkit.Bukkit;

import java.util.logging.Level;

public class AntigoneLogger {

	public static void log(Level level, String message) {
		try {
			//noinspection DataFlowIssue
			Bukkit.getPluginManager().getPlugin("Antigone").getLogger().log(level, message);
		} catch (Exception e) {
			//noinspection CallToPrintStackTrace
			e.printStackTrace();
		}
	}

	public static void severe(String message) {
		log(Level.SEVERE, message);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

}
