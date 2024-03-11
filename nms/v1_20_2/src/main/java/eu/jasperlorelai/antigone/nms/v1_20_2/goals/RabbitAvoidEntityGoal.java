package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Rabbit;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.config.EntityTypeParameter_v1_20_2;

@Name("antigone_rabbit_avoid_entity")
@WrapVanillaGoal.Inner(
		entity = Rabbit.class,
		className = "RabbitAvoidEntityGoal"
)
@ExtendsGoal("antigone_avoid_entity")
public class RabbitAvoidEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Rabbit rabbit
			MobParameters_v1_20_2.getInstance().Rabbit,
			// Class<? extends LivingEntity> fleeFromType
			new EntityTypeParameter_v1_20_2("flee-from-type", Wolf.class),
			// float distance
			new FloatParameter("distance", 10),
			// double slowSpeed
			new DoubleParameter("slow-speed", 2.2),
			// double fastSpeed
			new DoubleParameter("fast-speed", 2.2)
	);

	public RabbitAvoidEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
