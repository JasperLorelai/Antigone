package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.EntityTypesParameter_v1_20_4;

@Name("antigone_hurt_by_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal.class)
public class HurtByTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters_v1_20_4.getInstance().PathfinderMob,
			// Class<?>... noRevengeTypes
			new EntityTypesParameter_v1_20_4("no-revenge-types", EntityTypesParameter_v1_20_4.EMPTY)
	);

	public HurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
