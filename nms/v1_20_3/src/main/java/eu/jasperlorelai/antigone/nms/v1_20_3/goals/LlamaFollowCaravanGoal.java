package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;

@Name("antigone_llama_follow_caravan")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.LlamaFollowCaravanGoal.class)
public class LlamaFollowCaravanGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Llama llama
			MobParameters_v1_20_3.getInstance().Llama,
			// double speed
			new DoubleParameter("speed", 2.1)
	);

	public LlamaFollowCaravanGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
