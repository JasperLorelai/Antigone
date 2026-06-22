package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.fox.Fox;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_seek_shelter")
@WrapVanillaGoal.Inner(
		outer = Fox.class,
		className = "SeekShelterGoal"
)
@ExtendsGoal("antigone_flee_sun")
public class SeekShelterGoal extends AntigoneGoal {

	// double speed
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v26_2.Fox,
			new DoubleParameter("speed", 1.25)
	);

	public SeekShelterGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
