package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Cat;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_cat_relax_on_owner")
@WrapVanillaGoal.Inner(
		outer = Cat.class,
		className = "CatRelaxOnOwnerGoal"
)
public class CatRelaxOnOwnerGoal extends AntigoneGoal {

	// Cat cat
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_8.Cat);

	public CatRelaxOnOwnerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
