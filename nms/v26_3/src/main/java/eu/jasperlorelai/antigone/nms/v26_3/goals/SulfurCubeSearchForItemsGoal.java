package eu.jasperlorelai.antigone.nms.v26_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.cubemob.SulfurCube;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_3.parameters.MobParameters_v26_3;

@Name("antigone_sulfur_cube_search_for_items")
@WrapVanillaGoal.Inner(
		outer = SulfurCube.class,
		className = "SulfurCubeSearchForItemsGoal"
)
public class SulfurCubeSearchForItemsGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// SulfurCube sulfurCube
		MobParameters_v26_3.SulfurCube,
		MobParameters_v26_3.SulfurCube
	);

	public SulfurCubeSearchForItemsGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
