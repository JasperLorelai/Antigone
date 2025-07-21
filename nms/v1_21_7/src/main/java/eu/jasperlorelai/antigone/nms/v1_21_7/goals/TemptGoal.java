package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_tempt")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.TemptGoal.class)
public class TemptGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob entity
			MobParameters_v1_21_7.PathfinderMob,
			// double speed
			new DoubleParameter("speed"),
			// Ingredient food
			new NmsIngredientParameter("food"),
			// boolean canBeScared
			new BooleanParameter("can-be-scared"),
			// double canBeScared
			new DoubleParameter("stop-distance", 2.5)
	);

	public TemptGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
