package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Cat;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;

@Name("antigone_cat_relax_on_owner")
@WrapVanillaGoal.Inner(
		entity = Cat.class,
		className = "CatRelaxOnOwnerGoal"
)
public class CatRelaxOnOwnerGoal extends AntigoneGoal {

	// Cat cat
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_20_4.getInstance().Cat);

	public CatRelaxOnOwnerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
