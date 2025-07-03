package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

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
import eu.jasperlorelai.antigone.nms.v1_21_7.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_panda_avoid")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaAvoidGoal"
)
@ExtendsGoal("antigone_avoid_entity")
public class PandaAvoidGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters_v1_21_7.Panda,
			// Class<? extends LivingEntity> fleeFromType
			new EntityTypeParameter(LivingEntityMap::fromString, "flee-from-type", Player.class),
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
