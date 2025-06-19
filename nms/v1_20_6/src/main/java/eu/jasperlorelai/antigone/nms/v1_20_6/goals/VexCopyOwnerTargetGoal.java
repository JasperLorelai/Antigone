package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Vex;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_vex_copy_owner_target")
@WrapVanillaGoal.Inner(
		outer = Vex.class,
		className = "VexCopyOwnerTargetGoal"
)
public class VexCopyOwnerTargetGoal extends AntigoneGoal {

	// PathfinderMob entitycreature
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Vex, MobParameters.PathfinderMob);

	public VexCopyOwnerTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
