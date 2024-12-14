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

import antigone.AddonInfo;
import antigone.variables.PathTypeVariable;

import eu.jasperlorelai.antigone.nms.shared.util.Util;

import com.nisovin.magicspells.Spell;
import com.nisovin.magicspells.util.ai.CustomGoal;
import com.nisovin.magicspells.util.ai.CustomGoals;
import com.nisovin.magicspells.events.MagicSpellsLoadingEvent;
import com.nisovin.magicspells.variables.variabletypes.MetaVariable;

public final class Antigone extends JavaPlugin implements Listener {

	private static final Set<Class<? extends CustomGoal>> GOALS = new HashSet<>();

	@Override
	public void onEnable() {
		new Metrics(this, 21705);
		Cerberus.register(this);
		Bukkit.getPluginManager().registerEvents(this, this);

		String mcVersion = Bukkit.getMinecraftVersion();
		ClassGraph classGraph = new ClassGraph().acceptPackages(Util.getNMSPackage(mcVersion) + ".goals", "antigone");
		try (ScanResult result = classGraph.scan()) {
			ClassInfoList goals = result.getSubclasses(CustomGoal.class);
			if (goals.isEmpty()) {
				getLogger().severe("This version of Antigone does not support version: " + mcVersion);
				return;
			}
			for (ClassInfo goal : goals) {
				if (goal.isAbstract() || goal.isInterface() || goal.isInnerClass()) continue;
				GOALS.add(goal.loadClass().asSubclass(CustomGoal.class));
			}

			for (ClassInfo spell : result.getSubclasses(Spell.class)) {
				Cerberus.addSpell(spell.loadClass().asSubclass(Spell.class));
			}
		}

		for (AddonInfo<MetaVariable> info : PathTypeVariable.getTypes()) {
			Cerberus.addMetaVariable(info.name(), info.addon());
		}
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll((Plugin) this);
		Bukkit.getScheduler().cancelTasks(this);

		GOALS.clear();
	}

	@EventHandler
	public void onMSLoading(MagicSpellsLoadingEvent event) {
		GOALS.forEach(CustomGoals::addGoal);
	}

}
