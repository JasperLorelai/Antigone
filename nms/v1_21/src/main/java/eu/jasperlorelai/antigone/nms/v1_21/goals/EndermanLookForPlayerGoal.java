package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.EnderMan;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;

@Name("antigone_enderman_look_for_player")
@WrapVanillaGoal.Inner(
		outer = EnderMan.class,
		className = "EndermanLookForPlayerGoal"
)
@ExtendsGoal("antigone_nearest_attackable_target")
public class EndermanLookForPlayerGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// EnderMan enderman
			MobParameters.EnderMan,
			// @Nullable Predicate<LivingEntity> targetPredicate
			new PredicateParameter<>("target-predicate")
	);

	public EndermanLookForPlayerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
