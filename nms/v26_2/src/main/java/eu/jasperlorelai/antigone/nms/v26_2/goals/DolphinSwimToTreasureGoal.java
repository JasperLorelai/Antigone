package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.dolphin.Dolphin;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_dolphin_swim_to_treasure")
@WrapVanillaGoal.Inner(
		outer = Dolphin.class,
		className = "DolphinSwimToTreasureGoal"
)
public class DolphinSwimToTreasureGoal extends AntigoneGoal {

	// Dolphin dolphin
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v26_2.Dolphin);

	public DolphinSwimToTreasureGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
