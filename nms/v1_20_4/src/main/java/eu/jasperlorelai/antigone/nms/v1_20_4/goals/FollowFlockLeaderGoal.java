package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;

@Name("antigone_follow_flock_leader")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal.class)
public class FollowFlockLeaderGoal extends AntigoneGoal {

	// AbstractSchoolingFish fish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_20_4.getInstance().AbstractSchoolingFish);

	public FollowFlockLeaderGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
