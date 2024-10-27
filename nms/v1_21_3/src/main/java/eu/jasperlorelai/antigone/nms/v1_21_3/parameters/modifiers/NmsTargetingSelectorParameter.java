package eu.jasperlorelai.antigone.nms.v1_21_3.parameters.modifiers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Mob;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.ModifierParameter;

public class NmsTargetingSelectorParameter<E extends LivingEntity> extends ModifierParameter<TargetingConditions.Selector, TargetingConditions.Selector> {

	public NmsTargetingSelectorParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public NmsTargetingSelectorParameter(@NotNull @ConfigKey String name, @Nullable Default<TargetingConditions.Selector> def) {
		super(name, TargetingConditions.Selector.class, def);
	}

	@Override
	protected TargetingConditions.Selector check(ModifierSet modifiers, Mob mob) {
		return (nmsEntity, world) -> {
			if (Bukkit.getEntity(nmsEntity.getUUID()) instanceof org.bukkit.entity.LivingEntity entity)
				return modifiers.check(mob, entity);
			return false;
		};
	}

}
