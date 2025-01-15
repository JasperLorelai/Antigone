package eu.jasperlorelai.antigone.nms.v1_21_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Bee;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_bee_grow_crop")
@WrapVanillaGoal.Inner(
		entity = Bee.class,
		className = "BeeGrowCropGoal"
)
public class BeeGrowCropGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Bee);

	public BeeGrowCropGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
