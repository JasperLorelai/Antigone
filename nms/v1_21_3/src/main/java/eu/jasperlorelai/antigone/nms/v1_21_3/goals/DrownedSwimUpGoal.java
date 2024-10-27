package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Drowned;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;

@Name("antigone_drowned_swim_up")
@WrapVanillaGoal.Inner(
		entity = Drowned.class,
		className = "DrownedSwimUpGoal"
)
public class DrownedSwimUpGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Drowned drowned
			MobParameters.Drowned,
			// double speed
			new DoubleParameter("speed", 1),
			// int minY
			new IntegerParameter("min-y")
	);

	public DrownedSwimUpGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
