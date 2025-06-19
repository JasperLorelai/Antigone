package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Vex;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;

@Name("antigone_vex_copy_owner_target")
@WrapVanillaGoal.Inner(
		outer = Vex.class,
		className = "VexCopyOwnerTargetGoal"
)
public class VexCopyOwnerTargetGoal extends AntigoneGoal {

	// PathfinderMob entitycreature
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_5.Vex,
			MobParameters_v1_21_5.PathfinderMob
	);

	public VexCopyOwnerTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
