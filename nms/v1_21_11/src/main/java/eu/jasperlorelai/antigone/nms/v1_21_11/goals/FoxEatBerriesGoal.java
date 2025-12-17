package eu.jasperlorelai.antigone.nms.v1_21_11.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.fox.Fox;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_11.parameters.mob.MobParameters_v1_21_11;

@Name("antigone_fox_eat_berries")
@WrapVanillaGoal.Inner(
		outer = Fox.class,
		className = "FoxEatBerriesGoal"
)
public class FoxEatBerriesGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_11.Fox,
			// double speed
			new DoubleParameter("speed", 1.2000000476837158),
			// int range
			new IntegerParameter("range", 12),
			// int maxYDifference
			new IntegerParameter("max-y-difference", 1)
	);

	public FoxEatBerriesGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
