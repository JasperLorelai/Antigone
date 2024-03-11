package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;

@Name("antigone_ranged_crossbow_attack")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal.class)
public class RangedCrossbowAttackGoal extends AntigoneGoal {

	// T extends Monster & RangedAttackMob & CrossbowAttackMob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T actor
			MobParameters_v1_20_2.getInstance().RangedCrossbowAttackMob,
			// double speed
			new DoubleParameter("speed", 1),
			// float range
			new FloatParameter("range", 8)
	);

	public RangedCrossbowAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
