package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.BooleanSupplierParameter;

@Name("antigone_move_through_village")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal.class)
public class MoveThroughVillageGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob entity
			MobParameters_v1_20_2.getInstance().PathfinderMob,
			// double speed
			new DoubleParameter("speed", 1),
			// boolean requiresNighttime
			new BooleanParameter("requires-night-time", true),
			// int distance
			new IntegerParameter("distance", 4),
			// BooleanSupplier doorPassingThroughGetter
			new BooleanSupplierParameter("door-passing-through-getter")
	);

	public MoveThroughVillageGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
