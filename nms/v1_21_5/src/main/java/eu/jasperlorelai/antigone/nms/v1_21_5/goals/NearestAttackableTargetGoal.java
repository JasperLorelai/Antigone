package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_21_5.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.modifiers.NmsTargetingSelectorParameter;

@Name("antigone_nearest_attackable_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal.class)
public class NearestAttackableTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Mob mob
			MobParameters_v1_21_5.Mob,
			// Class<T extends LivingEntity> targetClass
			new EntityTypeParameter(LivingEntityMap::fromString, "target-class"),
			// int reciprocalChance
			new IntegerParameter("reciprocal-chance"),
			// boolean checkVisibility
			new BooleanParameter("check-visibility"),
			// boolean checkCanNavigate
			new BooleanParameter("check-can-navigate"),
			// @Nullable Predicate<LivingEntity> targetPredicate
			new NmsTargetingSelectorParameter("target-predicate")
	);

	public NearestAttackableTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
