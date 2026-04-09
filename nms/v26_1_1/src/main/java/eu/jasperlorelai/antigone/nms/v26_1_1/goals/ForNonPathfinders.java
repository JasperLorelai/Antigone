package eu.jasperlorelai.antigone.nms.v26_1_1.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.ai.goal.TemptGoal;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsIngredientParameter;

@Name("antigone_for_non_pathfinders")
@WrapVanillaGoal.Inner(
		outer = TemptGoal.class,
		className = "ForNonPathfinders"
)
@ExtendsGoal("antigone_tempt")
public class ForNonPathfinders extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters.Mob,
			// double speedModifier
			new DoubleParameter("speed-modifier", 0.35),
			// Predicate<ItemStack> items
			new NmsIngredientParameter("items"),
			// boolean canScare
			new BooleanParameter("can-scare", true),
			// double stopDistance
			new DoubleParameter("stop-distance", 2)
	);

	public ForNonPathfinders(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
