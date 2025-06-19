package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_panda_lie_on_back")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaLieOnBackGoal"
)
public class PandaLieOnBackGoal extends AntigoneGoal {

	// Panda panda
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Panda);

	public PandaLieOnBackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
