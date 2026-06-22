package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.illager.Vindicator;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_vindicator_johnny_attack")
@ExtendsGoal("antigone_nearest_attackable_target")
@WrapVanillaGoal.Inner(
		outer = Vindicator.class,
		className = "VindicatorJohnnyAttackGoal"
)
public class VindicatorJohnnyAttackGoal extends AntigoneGoal {

	// Vindicator vindicator
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v26_2.Vindicator);

	public VindicatorJohnnyAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
