package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Vindicator;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_vindicator_johnny_attack")
@ExtendsGoal("antigone_nearest_attackable_target")
@WrapVanillaGoal.Inner(
		outer = Vindicator.class,
		className = "VindicatorJohnnyAttackGoal"
)
public class VindicatorJohnnyAttackGoal extends AntigoneGoal {

	// Vindicator vindicator
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Vindicator);

	public VindicatorJohnnyAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
