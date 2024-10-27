package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.horse.Llama;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_llama_hurt_by_target")
@WrapVanillaGoal.Inner(
		entity = Llama.class,
		className = "LlamaHurtByTargetGoal"
)
@ExtendsGoal("antigone_hurt_by_target")
public class LlamaHurtByTargetGoal extends AntigoneGoal {

	// Llama llama
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Llama);

	public LlamaHurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
