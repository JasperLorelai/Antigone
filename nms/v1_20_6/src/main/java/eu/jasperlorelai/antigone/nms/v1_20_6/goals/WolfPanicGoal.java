package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Wolf;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_wolf_panic")
@ExtendsGoal("antigone_panic")
@WrapVanillaGoal.Inner(
		outer = Wolf.class,
		className = "WolfPanicGoal"
)
public class WolfPanicGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters.Wolf,
			// Wolf wolf
			MobParameters.Wolf,
			// double speed
			new DoubleParameter("speed", 1.5)
	);

	public WolfPanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
