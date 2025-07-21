package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_defend_village_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal.class)
public class DefendVillageTargetGoal extends AntigoneGoal {

	// IronGolem golem
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_8.IronGolem);

	public DefendVillageTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
