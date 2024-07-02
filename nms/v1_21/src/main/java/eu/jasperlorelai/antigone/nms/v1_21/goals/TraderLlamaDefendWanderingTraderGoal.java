package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.horse.TraderLlama;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_trader_llama_defend_wandering_trader")
@WrapVanillaGoal.Inner(
		entity = TraderLlama.class,
		className = "TraderLlamaDefendWanderingTraderGoal"
)
public class TraderLlamaDefendWanderingTraderGoal extends AntigoneGoal {

	// Llama llama
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Llama);

	public TraderLlamaDefendWanderingTraderGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
