package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.config.EntityTypeParameter_v1_20_2;

@Name("antigone_panda_avoid")
@WrapVanillaGoal.Inner(
		entity = Panda.class,
		className = "PandaAvoidGoal"
)
@ExtendsGoal("antigone_avoid_entity")
public class PandaAvoidGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters_v1_20_2.getInstance().Panda,
			// Class<? extends LivingEntity> fleeFromType
			new EntityTypeParameter_v1_20_2("flee-from-type", Player.class),
			// float distance
			new FloatParameter("distance", 8),
			// double slowSpeed
			new DoubleParameter("slow-speed", 2),
			// double fastSpeed
			new DoubleParameter("fast-speed", 2)
	);

	public PandaAvoidGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
