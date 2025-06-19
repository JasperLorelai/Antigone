package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Squid;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_squid_random_movement")
@WrapVanillaGoal.Inner(
		outer = Squid.class,
		className = "SquidRandomMovementGoal"
)
public class SquidRandomMovementGoal extends AntigoneGoal {

	// Squid squid
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Squid, MobParameters.Squid);

	public SquidRandomMovementGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
