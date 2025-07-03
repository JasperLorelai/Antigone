package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_random_look_around")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.RandomLookAroundGoal.class)
public class RandomLookAroundGoal extends AntigoneGoal {

	// Mob mob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_7.Mob);

	public RandomLookAroundGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
