package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Bee;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_bee_hurt_by_other")
@WrapVanillaGoal.Inner(
		outer = Bee.class,
		className = "BeeHurtByOtherGoal"
)
@ExtendsGoal("antigone_hurt_by_target")
public class BeeHurtByOtherGoal extends AntigoneGoal {

	// Bee entitybee
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Bee, MobParameters.Bee);

	public BeeHurtByOtherGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
