package eu.jasperlorelai.antigone;

import java.util.Set;
import java.util.HashSet;

import org.bstats.bukkit.Metrics;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.event.HandlerList;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;

import com.nisovin.magicspells.util.ai.CustomGoal;
import com.nisovin.magicspells.util.ai.CustomGoals;
import com.nisovin.magicspells.events.MagicSpellsLoadingEvent;

public final class Antigone extends JavaPlugin implements Listener {

	private static Set<Class<? extends CustomGoal>> antigoneGoals = new HashSet<>();

	@Override
	public void onEnable() {
		new Metrics(this, 21705);
		Bukkit.getPluginManager().registerEvents(this, this);

		String mcVersion = Bukkit.getMinecraftVersion();
		String version = "v" + mcVersion.replaceAll("\\.", "_");
		ClassGraph classGraph = new ClassGraph()
				.enableAllInfo()
				.acceptPackages("eu.jasperlorelai.antigone.nms." + version + ".goals");
		try (ScanResult result = classGraph.scan()) {
			ClassInfoList list = result.getSubclasses(CustomGoal.class);
			if (list.isEmpty()) {
				getLogger().severe("This version of Antigone does not support version: " + mcVersion);
				return;
			}
			for (ClassInfo goal : list) {
				if (goal.isAbstract() || goal.isInterface() || goal.isInnerClass()) continue;
				antigoneGoals.add(goal.loadClass().asSubclass(CustomGoal.class));
			}
		}
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll((Plugin) this);

		antigoneGoals = null;
	}

	@EventHandler
	public void onMSLoading(MagicSpellsLoadingEvent event) {
		if (antigoneGoals == null) return;
		antigoneGoals.forEach(CustomGoals::addGoal);
	}

}
