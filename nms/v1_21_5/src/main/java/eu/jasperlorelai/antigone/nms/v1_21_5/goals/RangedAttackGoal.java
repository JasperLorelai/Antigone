package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;

@Name("antigone_ranged_attack")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RangedAttackGoal.class)
public class RangedAttackGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// RangedAttackMob mob
			MobParameters_v1_21_5.RangedAttackMob,
			// double mobSpeed
			new DoubleParameter("mob-speed"),
			// int minIntervalTicks
			new IntegerParameter("min-interval-ticks"),
			// int maxIntervalTicks
			new IntegerParameter("max-interval-ticks"),
			// float maxShootRange
			new FloatParameter("max-shoot-range")
	);

	public RangedAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
