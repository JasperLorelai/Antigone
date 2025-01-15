package eu.jasperlorelai.antigone.nms.v1_21_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_breed")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.BreedGoal.class)
public class BreedGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Animal animal
			MobParameters.Animal,
			// double speed
			new DoubleParameter("speed", 1)
			// Class<? extends Animal> entityClass //HARDCODED
	);

	public BreedGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
