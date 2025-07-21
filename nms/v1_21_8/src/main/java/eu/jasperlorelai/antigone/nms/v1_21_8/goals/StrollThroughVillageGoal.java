package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_stroll_through_village")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.StrollThroughVillageGoal.class)
public class StrollThroughVillageGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters_v1_21_8.PathfinderMob,
			// int searchRange
			new IntegerParameter("search-range", 200)
	);

	public StrollThroughVillageGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
