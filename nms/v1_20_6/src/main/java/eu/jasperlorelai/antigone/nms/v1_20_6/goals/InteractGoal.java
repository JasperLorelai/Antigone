package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.v1_20_6.parameters.config.EntityTypeParameter_v1_20_6;

@Name("antigone_interact")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.InteractGoal.class)
public class InteractGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters.Mob,
			// Class<? extends LivingEntity> targetType
			new EntityTypeParameter_v1_20_6("target-type", Player.class),
			// float range
			new FloatParameter("range", 3),
			// float chance
			new FloatParameter("chance", 1)
	);

	public InteractGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
