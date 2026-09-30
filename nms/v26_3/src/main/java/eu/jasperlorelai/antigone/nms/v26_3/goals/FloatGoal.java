package eu.jasperlorelai.antigone.nms.v26_3.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import net.minecraft.tags.FluidTags;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_3.parameters.MobParameters_v26_3;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsFluidTagParameter;

@Name("antigone_float")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.FloatGoal.class)
public class FloatGoal extends AntigoneGoal {

	// Mob mob
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// Mob mob
		MobParameters_v26_3.Mob,
		// TagKey<Fluid> fluid
		new NmsFluidTagParameter("fluid", new Default<>(FluidTags.ENTITY_FLOATABLE, "entity_floatable"))
	);

	public FloatGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
