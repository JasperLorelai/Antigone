package eu.jasperlorelai.antigone.nms.v1_21_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;

@Name("antigone_ranged_bow_attack")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RangedBowAttackGoal.class)
public class RangedBowAttackGoal extends AntigoneGoal {

	// T extends Monster & RangedAttackMob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T actor
			MobParameters.RangedAttackMonster,
			// double speed
			new DoubleParameter("speed", 1),
			// int attackInterval
			new IntegerParameter("attack-interval", 20),
			// float range
			new FloatParameter("range", 15)
	);

	public RangedBowAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
