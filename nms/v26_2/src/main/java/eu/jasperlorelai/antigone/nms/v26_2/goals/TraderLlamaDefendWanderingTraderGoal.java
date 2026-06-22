package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.equine.TraderLlama;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_trader_llama_defend_wandering_trader")
@WrapVanillaGoal.Inner(
		outer = TraderLlama.class,
		className = "TraderLlamaDefendWanderingTraderGoal"
)
public class TraderLlamaDefendWanderingTraderGoal extends AntigoneGoal {

	// Llama llama
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v26_2.Llama);

	public TraderLlamaDefendWanderingTraderGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
