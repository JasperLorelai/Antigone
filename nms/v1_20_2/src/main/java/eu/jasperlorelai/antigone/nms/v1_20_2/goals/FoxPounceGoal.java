package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Fox;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

@Name("antigone_fox_pounce")
@WrapVanillaGoal.Inner(
		entity = Fox.class,
		className = "FoxPounceGoal"
)
public class FoxPounceGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of();

	public FoxPounceGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
