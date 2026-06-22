package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.cubemob.SulfurCube;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsIngredientParameter;

@Name("antigone_sulfur_cube_tempt")
@WrapVanillaGoal.Inner(
		outer = SulfurCube.class,
		className = "SulfurCubeTemptGoal"
)
@ExtendsGoal("antigone_for_non_pathfinders")
public class SulfurCubeTemptGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// Mob mob
		MobParameters_v26_2.Mob,
		// double speedModifier
		new DoubleParameter("speed-modifier", 1),
		// Predicate<ItemStack> items
		new NmsIngredientParameter("items"),
		// boolean canScare
		new BooleanParameter("can-scare", false),
		// double stopDistance
		new DoubleParameter("stop-distance", 1)
	);

	public SulfurCubeTemptGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
