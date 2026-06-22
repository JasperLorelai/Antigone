package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.animal.feline.Cat;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsIngredientParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsIngredientParameter.ItemLike;

@Name("antigone_cat_tempt")
@WrapVanillaGoal.Inner(
	outer = Cat.class,
	className = "CatTemptGoal"
)
@ExtendsGoal("antigone_tempt")
public class CatTemptGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// Cat cat
		MobParameters_v26_2.Cat,
		// double speed
		new DoubleParameter("speed", 0.6),
		// Ingredient food
		new NmsIngredientParameter("food", List.of(new ItemLike(ItemTags.CAT_FOOD, "cat_food"))),
		// boolean canBeScared
		new BooleanParameter("can-be-scared", true)
	);

	public CatTemptGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
