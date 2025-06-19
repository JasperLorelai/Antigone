package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_ranged_crossbow_attack")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal.class)
public class RangedCrossbowAttackGoal extends AntigoneGoal {

	// T extends Monster & RangedAttackMob & CrossbowAttackMob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T actor
			MobParameters.RangedCrossbowAttackMob,
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
