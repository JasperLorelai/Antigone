package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.EntityTypeParameter_v1_20_4;

@Name("antigone_nearest_attackable_witch_target")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.target.NearestAttackableWitchTargetGoal.class)
public class NearestAttackableWitchTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Raider actor
			MobParameters_v1_20_4.getInstance().Raider,
			// Class<T extends LivingEntity> targetEntityClass
			new EntityTypeParameter_v1_20_4("target-entity-class", Player.class),
			// int reciprocalChance
			new IntegerParameter("reciprocal-chance", 10),
			// boolean checkVisibility
			new BooleanParameter("check-visibility", true),
			// boolean checkCanNavigate
			new BooleanParameter("check-can-navigate", false),
			// @Nullable Predicate<LivingEntity> targetPredicate
			new PredicateParameter<>("target-predicate")
	);

	public NearestAttackableWitchTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
