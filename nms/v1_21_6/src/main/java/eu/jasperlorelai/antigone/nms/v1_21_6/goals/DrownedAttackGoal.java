package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Drowned;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;

@Name("antigone_drowned_attack")
@WrapVanillaGoal.Inner(
		outer = Drowned.class,
		className = "DrownedAttackGoal"
)
@ExtendsGoal("antigone_zombie_attack")
public class DrownedAttackGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Drowned drowned
			MobParameters_v1_21_6.Drowned,
			// double speed
			new DoubleParameter("speed", 1),
			// boolean pauseWhenMobIdle
			new BooleanParameter("pause-when-mob-idle", false)
	);

	public DrownedAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
