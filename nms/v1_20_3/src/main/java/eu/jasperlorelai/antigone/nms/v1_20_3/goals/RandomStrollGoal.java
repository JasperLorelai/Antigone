package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;

@Name("antigone_random_stroll")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RandomStrollGoal.class)
public class RandomStrollGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob entity
			MobParameters_v1_20_3.getInstance().PathfinderMob,
			// double speed
			new DoubleParameter("speed"),
			// int chance
			new IntegerParameter("chance", 120),
			// boolean canDespawn
			new BooleanParameter("can-despawn", true)
	);

	public RandomStrollGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
