package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_panda_sneeze")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaSneezeGoal"
)
public class PandaSneezeGoal extends AntigoneGoal {

	// Panda panda
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_8.Panda);

	public PandaSneezeGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
