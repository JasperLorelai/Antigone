package eu.jasperlorelai.antigone.nms.v1_21_11.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.fox.Fox;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_11.parameters.mob.MobParameters_v1_21_11;

@Name("antigone_fox_breed")
@WrapVanillaGoal.Inner(
		outer = Fox.class,
		className = "FoxBreedGoal"
)
@ExtendsGoal("antigone_breed")
public class FoxBreedGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Fox fox
			MobParameters_v1_21_11.Fox,
			// double speed
			new DoubleParameter("speed", 1)
	);

	public FoxBreedGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
