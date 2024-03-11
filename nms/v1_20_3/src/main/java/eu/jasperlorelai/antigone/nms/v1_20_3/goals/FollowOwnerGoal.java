package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;

@Name("antigone_follow_owner")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.FollowOwnerGoal.class)
public class FollowOwnerGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// TamableAnimal tameable
			MobParameters_v1_20_3.getInstance().TamableAnimal,
			// double speed
			new DoubleParameter("speed", 1),
			// float minDistance
			new FloatParameter("min-distance"),
			// float maxDistance
			new FloatParameter("max-distance"),
			// boolean leavesAllowed
			new BooleanParameter("leaves-allowed")
	);

	public FollowOwnerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
