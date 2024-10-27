package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;

@Name("antigone_open_door")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.OpenDoorGoal.class)
public class OpenDoorGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters.Mob,
			// boolean delayedClose
			new BooleanParameter("delayed-close", false)
	);

	public OpenDoorGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
