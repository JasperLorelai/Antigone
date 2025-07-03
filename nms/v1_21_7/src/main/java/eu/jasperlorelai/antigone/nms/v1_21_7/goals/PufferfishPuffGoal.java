package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Pufferfish;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_pufferfish_puff")
@WrapVanillaGoal.Inner(
		outer = Pufferfish.class,
		className = "PufferfishPuffGoal"
)
public class PufferfishPuffGoal extends AntigoneGoal {

	// Pufferfish pufferfish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_7.Pufferfish);

	public PufferfishPuffGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
