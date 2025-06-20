package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Ghast;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_ghast_shoot_fireball")
@WrapVanillaGoal.Inner(
		outer = Ghast.class,
		className = "GhastShootFireballGoal"
)
public class GhastShootFireballGoal extends AntigoneGoal {

	// Ghast ghast
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Ghast);

	public GhastShootFireballGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
