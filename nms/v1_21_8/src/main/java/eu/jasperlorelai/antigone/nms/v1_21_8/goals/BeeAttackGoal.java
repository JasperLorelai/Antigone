package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Bee;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;

@Name("antigone_bee_attack")
@WrapVanillaGoal.Inner(
		outer = Bee.class,
		className = "BeeAttackGoal"
)
@ExtendsGoal("antigone_melee_attack")
public class BeeAttackGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_8.Bee,
			// PathfinderMob mob
			MobParameters_v1_21_8.PathfinderMob,
			// double speed
			new DoubleParameter("speed", 1.399999976158142),
			// boolean pauseWhenMobIdle
			new BooleanParameter("pause-when-mob-idle", true)
	);

	public BeeAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
