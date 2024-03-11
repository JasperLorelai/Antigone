package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.SameLevelParameter_v1_20_4;

@Name("antigone_climb_on_top_of_powder_snow")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal.class)
public class ClimbOnTopOfPowderSnowGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob entity
			MobParameters_v1_20_4.getInstance().Mob,
			// Level world
			SameLevelParameter_v1_20_4.getInstance()
	);

	public ClimbOnTopOfPowderSnowGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
