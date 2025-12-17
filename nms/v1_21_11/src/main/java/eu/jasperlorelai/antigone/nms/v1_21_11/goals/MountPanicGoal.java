package eu.jasperlorelai.antigone.nms.v1_21_11.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.equine.AbstractHorse;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_11.parameters.mob.MobParameters_v1_21_11;

@Name("antigone_mount_panic")
@WrapVanillaGoal.Inner(
		outer = AbstractHorse.class,
		className = "MountPanicGoal"
)
@ExtendsGoal("antigone_panic")
public class MountPanicGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		MobParameters_v1_21_11.AbstractHorse,
		// double speed
		new DoubleParameter("speed", 1.2)
	);

	public MountPanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
