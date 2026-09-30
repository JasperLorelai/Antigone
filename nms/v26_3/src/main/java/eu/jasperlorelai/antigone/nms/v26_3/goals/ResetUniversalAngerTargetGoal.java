package eu.jasperlorelai.antigone.nms.v26_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_3.parameters.MobParameters_v26_3;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;

@Name("antigone_reset_universal_anger_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal.class)
public class ResetUniversalAngerTargetGoal extends AntigoneGoal {

	// T extends Mob & NeutralMob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T mob
			MobParameters_v26_3.NeutralMob,
			// boolean triggerOthers
			new BooleanParameter("trigger-others", false)
	);

	public ResetUniversalAngerTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
