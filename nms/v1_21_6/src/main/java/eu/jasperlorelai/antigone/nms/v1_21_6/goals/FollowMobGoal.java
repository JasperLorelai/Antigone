package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;

@Name("antigone_follow_mob")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.FollowMobGoal.class)
public class FollowMobGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters_v1_21_6.Mob,
			// double speed
			new DoubleParameter("speed", 1),
			// float minDistance
			new FloatParameter("min-distance", 3),
			// float maxDistance
			new FloatParameter("max-distance", 7)
	);

	public FollowMobGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
