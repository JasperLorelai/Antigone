package eu.jasperlorelai.antigone;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import com.nisovin.magicspells.Spell;
import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.variables.Variable;
import com.nisovin.magicspells.castmodifiers.Condition;
import com.nisovin.magicspells.spelleffects.SpellEffect;
import com.nisovin.magicspells.events.VariablesLoadingEvent;
import com.nisovin.magicspells.events.ConditionsLoadingEvent;
import com.nisovin.magicspells.events.SpellEffectsLoadingEvent;
import com.nisovin.magicspells.spells.passive.util.PassiveListener;
import com.nisovin.magicspells.events.PassiveListenersLoadingEvent;

// From: https://gist.github.com/JasperLorelai/4ea62ae3fb6f648c5108cfacbbe193a8
public class Cerberus implements Listener {

	private static final Map<String, Variable> VARIABLES = new HashMap<>();
	private static final Map<String, Variable> META_VARIABLES = new HashMap<>();
	private static final Set<Class<? extends Condition>> CONDITIONS = new HashSet<>();
	private static final Set<Class<? extends SpellEffect>> EFFECTS = new HashSet<>();
	private static final Set<Class<? extends PassiveListener>> LISTENERS = new HashSet<>();

	/**
	 * Register's this class's events to your plugin.
	 * @param plugin Your plugin.
	 */
	public static void register(Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(new Cerberus(), plugin);
	}

	/**
	 * Adds the class extending Spell into MagicSpell's classpath so that it may be loaded by a spell's "spell-class".
	 * @param spell The spell class to add.
	 */
	public static void addSpell(Class<? extends Spell> spell) {
		MagicSpells.getClassLoaders().add(spell.getClassLoader());
	}

	/**
	 * Adds the condition into a buffer which adds your conditions to MagicSpells whenever MagicSpells is reloaded.
	 * @param condition The condition class annotated with {@link Name}.
	 */
	public static void addCondition(Class<? extends Condition> condition) {
		CONDITIONS.add(condition);
	}

	/**
	 * Adds the passive listener into a buffer which adds your listeners to MagicSpells whenever MagicSpells is reloaded.
	 * @param listener The passive listener class annotated with {@link Name}.
	 */
	public static void addListener(Class<? extends PassiveListener> listener) {
		LISTENERS.add(listener);
	}

	/**
	 * Adds the spell effects into a buffer which adds your effects to MagicSpells whenever MagicSpells is reloaded.
	 * @param effect The spell effect class annotated with {@link Name}.
	 */
	public static void addEffect(Class<? extends SpellEffect> effect) {
		EFFECTS.add(effect);
	}

	/**
	 * Adds the MS variable into a buffer which adds your variables to MagicSpells whenever MagicSpells is reloaded.
	 * @param variable The MS variable.
	 */
	public static void addVariable(String name, Variable variable) {
		VARIABLES.put(name, variable);
	}

	/**
	 * Adds the MS meta variable into a buffer which adds your meta variables to MagicSpells whenever MagicSpells is reloaded.
	 * @param variable The MS meta variable.
	 */
	public static void addMetaVariable(String name, Variable variable) {
		META_VARIABLES.put(name, variable);
	}

	@EventHandler
	public void onConditionLoad(ConditionsLoadingEvent event) {
		CONDITIONS.forEach(event.getConditionManager()::addCondition);
	}

	@EventHandler
	public void onPassiveListenerLoad(PassiveListenersLoadingEvent event) {
		LISTENERS.forEach(event.getPassiveManager()::addListener);
	}

	@EventHandler
	public void onVariableLoad(VariablesLoadingEvent event) {
		VARIABLES.forEach(event.getVariableManager()::addVariable);
		META_VARIABLES.forEach(event.getVariableManager()::addMetaVariableType);
	}

	@EventHandler
	public void onSpellEffectLoad(SpellEffectsLoadingEvent event) {
		EFFECTS.forEach(event.getSpellEffectManager()::addSpellEffect);
	}

}
