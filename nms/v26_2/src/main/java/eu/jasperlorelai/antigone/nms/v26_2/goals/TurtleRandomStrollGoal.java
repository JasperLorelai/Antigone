package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.turtle.Turtle;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;

@Name("antigone_turtle_random_stroll")
@WrapVanillaGoal.Inner(
		outer = Turtle.class,
		className = "TurtleRandomStrollGoal"
)
@ExtendsGoal("antigone_random_stroll")
public class TurtleRandomStrollGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Turtle turtle
			MobParameters_v26_2.Turtle,
			// double speed
			new DoubleParameter("speed", 1),
			// int chance
			new IntegerParameter("chance", 100)
	);

	public TurtleRandomStrollGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
