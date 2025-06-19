package eu.jasperlorelai.antigone.nms.v1_21_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.horse.Llama;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_llama_attack_wolf")
@WrapVanillaGoal.Inner(
		outer = Llama.class,
		className = "LlamaAttackWolfGoal"
)
@ExtendsGoal("antigone_nearest_attackable_target")
public class LlamaAttackWolfGoal extends AntigoneGoal {

	// Llama llama
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Llama);

	public LlamaAttackWolfGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
