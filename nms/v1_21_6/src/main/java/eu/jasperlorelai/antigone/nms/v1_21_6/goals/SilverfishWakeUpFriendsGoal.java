package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Silverfish;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;

@Name("antigone_silverfish_wake_up_friends")
@WrapVanillaGoal.Inner(
		outer = Silverfish.class,
		className = "SilverfishWakeUpFriendsGoal"
)
public class SilverfishWakeUpFriendsGoal extends AntigoneGoal {

	// Silverfish silverfish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_6.Silverfish);

	public SilverfishWakeUpFriendsGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
