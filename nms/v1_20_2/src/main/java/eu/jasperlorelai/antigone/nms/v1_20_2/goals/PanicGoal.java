package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;

@Name("antigone_panic")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.PanicGoal.class)
public class PanicGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters_v1_20_2.getInstance().PathfinderMob,
			// double speed
			new DoubleParameter("speed")
	);

	public PanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
