package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_panda_attack")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaAttackGoal"
)
@ExtendsGoal("antigone_melee_attack")
public class PandaAttackGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters_v1_21_7.Panda,
			// double speed
			new DoubleParameter("speed", 1.2000000476837158),
			// boolean pauseWhenMobIdle
			new BooleanParameter("pause-when-mob-idle", true)
	);

	public PandaAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
