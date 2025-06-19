package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.PatrollingMonster;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;

@Name("antigone_long_distance_patrol")
@WrapVanillaGoal.Inner(
		outer = PatrollingMonster.class,
		className = "LongDistancePatrolGoal"
)
public class LongDistancePatrolGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// <T extends PatrollingMonster> entity
			MobParameters_v1_21_6.PatrollingMonster,
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
