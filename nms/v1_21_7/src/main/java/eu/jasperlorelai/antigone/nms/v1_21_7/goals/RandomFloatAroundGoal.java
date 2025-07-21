package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Ghast;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_random_float_around")
@WrapVanillaGoal.Inner(
		outer = Ghast.class,
		className = "RandomFloatAroundGoal"
)
public class RandomFloatAroundGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// Mob ghast,
		MobParameters_v1_21_7.Mob,
		// int distanceToBlocks
		new IntegerParameter("distance-to-blocks", 0)
	);

	public RandomFloatAroundGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
