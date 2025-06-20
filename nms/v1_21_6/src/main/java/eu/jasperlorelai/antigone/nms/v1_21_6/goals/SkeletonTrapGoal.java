package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;

@Name("antigone_skeleton_trap")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.animal.horse.SkeletonTrapGoal.class)
public class SkeletonTrapGoal extends AntigoneGoal {

	// SkeletonHorse skeletonHorse
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_6.SkeletonHorse);

	public SkeletonTrapGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
