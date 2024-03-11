package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.npc.WanderingTrader;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;

@Name("antigone_wander_to_position")
@WrapVanillaGoal.Inner(
		entity = WanderingTrader.class,
		className = "WanderToPositionGoal"
)
public class WanderToPositionGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// WanderingTrader entityvillagertrader
			MobParameters_v1_20_3.getInstance().WanderingTrader,
			// double stopDistance
			new DoubleParameter("stop-distance", 2),
			// double speedModifier
			new DoubleParameter("speed-modifier", 0.35)
	);

	public WanderToPositionGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
