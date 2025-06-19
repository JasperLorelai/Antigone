package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.raid.Raider;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;

@Name("antigone_raider_move_through_village")
@WrapVanillaGoal.Inner(
		outer = Raider.class,
		className = "RaiderMoveThroughVillageGoal"
)
public class RaiderMoveThroughVillageGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Raider raider
			MobParameters.Raider,
			// double speed
			new DoubleParameter("speed", 1.0499999523162842),
			// int distance
			new IntegerParameter("distance", 1)
	);

	public RaiderMoveThroughVillageGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
