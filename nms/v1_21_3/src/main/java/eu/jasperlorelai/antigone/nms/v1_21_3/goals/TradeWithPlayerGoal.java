package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_trade_with_player")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.TradeWithPlayerGoal.class)
public class TradeWithPlayerGoal extends AntigoneGoal {

	// AbstractVillager merchant
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.AbstractVillager);

	public TradeWithPlayerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
