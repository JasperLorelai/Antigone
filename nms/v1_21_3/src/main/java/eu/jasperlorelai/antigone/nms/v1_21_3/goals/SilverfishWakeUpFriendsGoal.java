package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Silverfish;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_silverfish_wake_up_friends")
@WrapVanillaGoal.Inner(
		entity = Silverfish.class,
		className = "SilverfishWakeUpFriendsGoal"
)
public class SilverfishWakeUpFriendsGoal extends AntigoneGoal {

	// Silverfish silverfish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Silverfish);

	public SilverfishWakeUpFriendsGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
