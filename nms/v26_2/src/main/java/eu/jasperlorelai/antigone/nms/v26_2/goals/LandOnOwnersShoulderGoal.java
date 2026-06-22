package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_land_on_owners_shoulder")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.LandOnOwnersShoulderGoal.class)
public class LandOnOwnersShoulderGoal extends AntigoneGoal {

	// ShoulderRidingEntity tameable
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v26_2.ShoulderRidingEntity);

	public LandOnOwnersShoulderGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
