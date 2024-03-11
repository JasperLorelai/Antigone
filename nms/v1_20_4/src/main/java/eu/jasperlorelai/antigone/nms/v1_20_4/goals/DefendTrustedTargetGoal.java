package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.LivingEntity;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.EntityTypeParameter_v1_20_4;

@Name("antigone_defend_trusted_target")
@WrapVanillaGoal.Inner(
		entity = Fox.class,
		className = "DefendTrustedTargetGoal"
)
@ExtendsGoal("antigone_nearest_attackable_target")
public class DefendTrustedTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Class targetClass
			new EntityTypeParameter_v1_20_4("target-class", LivingEntity.class),
			// boolean checkVisibility
			new BooleanParameter("check-visibility", false),
			// boolean checkCanNavigate
			new BooleanParameter("check-can-navigate", false),
			// @Nullable Predicate<LivingEntity> targetPredicate
			new PredicateParameter<>("target-predicate")
	);

	public DefendTrustedTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
