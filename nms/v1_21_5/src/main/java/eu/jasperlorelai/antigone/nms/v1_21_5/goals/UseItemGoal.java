package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsItemStackParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsSoundEventParameter;

@Name("antigone_use_item")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.UseItemGoal.class)
public class UseItemGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T extends Mob actor
			MobParameters_v1_21_5.Mob,
			// ItemStack item
			new NmsItemStackParameter("item"),
			// @Nullable SoundEvent sound
			new NmsSoundEventParameter("sound"),
			// Predicate<? super T> condition
			new PredicateParameter<net.minecraft.world.entity.Mob>("condition", PredicateParameter.always())
	);

	public UseItemGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
