package eu.jasperlorelai.antigone.nms.v1_20_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_random_stand")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RandomStandGoal.class)
public class RandomStandGoal extends AntigoneGoal {

	// AbstractHorse entity
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.AbstractHorse);

	public RandomStandGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
