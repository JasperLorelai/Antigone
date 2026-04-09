package eu.jasperlorelai.antigone.nms.v26_1_1.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_spear_use")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.SpearUseGoal.class)
public class SpearUseGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// <T extends Monster> mob
		MobParameters.Monster,
		// double speedModifierWhenCharging
		new DoubleParameter("speed-charging", 1),
		// double speedModifierWhenRepositioning
		new DoubleParameter("speed-repositioning", 1),
		// float approachDistance
		new FloatParameter("approach-distance", 10),
		// float targetInRangeRadius
		new FloatParameter("target-range", 2)
	);

	public SpearUseGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
