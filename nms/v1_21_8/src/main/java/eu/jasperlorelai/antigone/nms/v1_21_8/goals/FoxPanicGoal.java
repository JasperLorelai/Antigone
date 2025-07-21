package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Fox;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_fox_panic")
@WrapVanillaGoal.Inner(
		outer = Fox.class,
		className = "FoxPanicGoal"
)
@ExtendsGoal("antigone_panic")
public class FoxPanicGoal extends AntigoneGoal {

	// double speed
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_8.Fox,
			new DoubleParameter("speed", 2.2)
	);

	public FoxPanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
