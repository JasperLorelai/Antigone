package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.AbstractFish;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;

@Name("antigone_fish_swim")
@WrapVanillaGoal.Inner(
		entity = AbstractFish.class,
		className = "FishSwimGoal"
)
@ExtendsGoal("antigone_random_swimming")
public class FishSwimGoal extends AntigoneGoal {

	// AbstractFish fish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_20_3.getInstance().AbstractFish);

	public FishSwimGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
