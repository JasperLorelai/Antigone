package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.EntityTypeParameter_v1_20_4;

@Name("antigone_ocelot_avoid_entity")
@WrapVanillaGoal.Inner(
		entity = Ocelot.class,
		className = "OcelotAvoidEntityGoal"
)
@ExtendsGoal("antigone_avoid_entity")
public class OcelotAvoidEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Ocelot ocelot
			MobParameters_v1_20_4.getInstance().Ocelot,
			// Class<? extends LivingEntity> fleeFromType
			new EntityTypeParameter_v1_20_4("flee-from-type", Player.class),
			// float distance
			new FloatParameter("distance", 16),
			// double slowSpeed
			new DoubleParameter("slow-speed", 0.8),
			// double fastSpeed
			new DoubleParameter("fast-speed", 1.33)
	);

	public OcelotAvoidEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
