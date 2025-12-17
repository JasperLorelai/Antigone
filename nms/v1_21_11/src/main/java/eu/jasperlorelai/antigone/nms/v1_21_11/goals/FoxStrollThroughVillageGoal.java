package eu.jasperlorelai.antigone.nms.v1_21_11.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.fox.Fox;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.DummyParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_11.parameters.mob.MobParameters_v1_21_11;

@Name("antigone_fox_stroll_through_village")
@WrapVanillaGoal.Inner(
		outer = Fox.class,
		className = "FoxStrollThroughVillageGoal"
)
@ExtendsGoal("antigone_stroll_through_village")
public class FoxStrollThroughVillageGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_11.Fox,
			// int unused
			new DummyParameter<>(int.class, 32),
			// int searchRange
			new IntegerParameter("search-range", 200)
	);

	public FoxStrollThroughVillageGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
