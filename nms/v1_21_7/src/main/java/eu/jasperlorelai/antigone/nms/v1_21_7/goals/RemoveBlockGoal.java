package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_remove_block")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RemoveBlockGoal.class)
public class RemoveBlockGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Block targetBlock
			new NmsBlockParameter("target-block"),
			// PathfinderMob mob
			MobParameters_v1_21_7.PathfinderMob,
			// double speed
			new DoubleParameter("speed"),
			// int maxYDifference
			new IntegerParameter("max-y-difference")
	);

	public RemoveBlockGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
