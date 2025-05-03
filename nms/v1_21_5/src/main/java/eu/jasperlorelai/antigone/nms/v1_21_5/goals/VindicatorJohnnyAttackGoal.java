package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Vindicator;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;

@Name("antigone_vindicator_johnny_attack")
@ExtendsGoal("antigone_nearest_attackable_target")
@WrapVanillaGoal.Inner(
		entity = Vindicator.class,
		className = "VindicatorJohnnyAttackGoal"
)
public class VindicatorJohnnyAttackGoal extends AntigoneGoal {

	// Vindicator vindicator
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_5.Vindicator);

	public VindicatorJohnnyAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
