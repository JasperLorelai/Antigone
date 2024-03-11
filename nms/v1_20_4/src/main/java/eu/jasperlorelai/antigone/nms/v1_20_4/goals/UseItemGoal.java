package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.PredicateParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsSoundEventParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config.NmsItemStackParameter_v1_20_4;

@Name("antigone_use_item")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.UseItemGoal.class)
public class UseItemGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// T extends Mob actor
			MobParameters_v1_20_4.getInstance().Mob,
			// ItemStack item
			new NmsItemStackParameter_v1_20_4("item"),
			// @Nullable SoundEvent sound
			new NmsSoundEventParameter("sound"),
			// Predicate<? super T> condition
			new PredicateParameter<net.minecraft.world.entity.Mob>("condition", entity -> true)
	);

	public UseItemGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
