package eu.jasperlorelai.antigone.nms.v1_20_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_owner_hurt_by_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal.class)
public class OwnerHurtByTargetGoal extends AntigoneGoal {

	// TamableAnimal tameable
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.TamableAnimal);

	public OwnerHurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
