package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Slime;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_slime_keep_on_jumping")
@WrapVanillaGoal.Inner(
		entity = Slime.class,
		className = "SlimeKeepOnJumpingGoal"
)
public class SlimeKeepOnJumpingGoal extends AntigoneGoal {

	// Slime slime
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Slime);

	public SlimeKeepOnJumpingGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}