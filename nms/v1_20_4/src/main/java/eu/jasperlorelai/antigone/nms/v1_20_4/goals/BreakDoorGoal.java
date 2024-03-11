package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DifficultyPredicateParameter;

@Name("antigone_break_door")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.BreakDoorGoal.class)
public class BreakDoorGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters_v1_20_4.getInstance().Mob,
			// int maxProgress
			new IntegerParameter("max-progress", 240),
			// Predicate<Difficulty> difficultySufficientPredicate
			new DifficultyPredicateParameter("difficulty-sufficient-predicate", difficulty -> true)
	);

	public BreakDoorGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
