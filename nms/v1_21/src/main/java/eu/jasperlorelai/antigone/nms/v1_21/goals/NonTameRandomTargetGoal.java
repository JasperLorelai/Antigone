package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_21.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;

@Name("antigone_non_tame_random_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal.class)
public class NonTameRandomTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// TamableAnimal tameable
			MobParameters.TamableAnimal,
			// Class<T extends LivingEntity> targetClass
			new EntityTypeParameter(LivingEntityMap::fromString, "target-class"),
			// boolean checkVisibility
			new BooleanParameter("check-visibility", false),
			// @Nullable Predicate<LivingEntity> targetPredicate
			new PredicateParameter<>("target-predicate")
	);

	public NonTameRandomTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
