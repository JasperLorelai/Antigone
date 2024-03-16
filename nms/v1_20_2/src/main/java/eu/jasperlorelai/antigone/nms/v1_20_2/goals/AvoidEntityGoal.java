package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.config.EntityTypeParameter_v1_20_2;

@Name("antigone_avoid_entity")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.AvoidEntityGoal.class)
public class AvoidEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters_v1_20_2.getInstance().PathfinderMob,
			// Class<T extends LivingEntity> fleeFromType
			new EntityTypeParameter_v1_20_2("flee-from"),
			// Predicate<LivingEntity> extraInclusionSelector
			new PredicateParameter<>("extra-inclusion-selector", PredicateParameter.always()),
			// float distance
			new FloatParameter("distance"),
			// double slowSpeed
			new DoubleParameter("slow-speed"),
			// double fastSpeed
			new DoubleParameter("fast-speed"),
			// Predicate<LivingEntity> inclusionSelector
			new PredicateParameter<>("inclusion-selector", PredicateParameter.noCreativeOrSpectator())
	);

	public AvoidEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
