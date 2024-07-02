package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.*;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.modifiers.BooleanSupplierParameter;

@Name("antigone_move_through_village")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal.class)
public class MoveThroughVillageGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob entity
			MobParameters.PathfinderMob,
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
