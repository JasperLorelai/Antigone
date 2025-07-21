package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_21_8.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_look_at_player")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.LookAtPlayerGoal.class)
public class LookAtPlayerGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters_v1_21_8.Mob,
			// Class<? extends LivingEntity> targetType
			new EntityTypeParameter(LivingEntityMap::fromString, "target-type", Player.class),
			// float range
			new FloatParameter("range"),
			// float chance
			new FloatParameter("chance", 0.02f),
			// boolean lookForward
			new BooleanParameter("look-forward", false)
	);

	public LookAtPlayerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
