package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.PatrollingMonster;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_long_distance_patrol")
@WrapVanillaGoal.Inner(
		outer = PatrollingMonster.class,
		className = "LongDistancePatrolGoal"
)
public class LongDistancePatrolGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// <T extends PatrollingMonster> entity
			MobParameters.PatrollingMonster,
			// double leaderSpeed
			new DoubleParameter("leader-speed", 0.7),
			// double followSpeed
			new DoubleParameter("follow-speed", 0.595)
	);

	public LongDistancePatrolGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
