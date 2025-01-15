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
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;

@Name("antigone_cat_lie_on_bed")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.CatLieOnBedGoal.class)
public class CatLieOnBedGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Cat cat
			MobParameters.Cat,
			// double speed
			new DoubleParameter("speed", 1),
			// int range
			new IntegerParameter("range", 8)
	);

	public CatLieOnBedGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
