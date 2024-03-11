package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Fox;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;

@Name("antigone_fox_follow_parent")
@WrapVanillaGoal.Inner(
		entity = Fox.class,
		className = "FoxFollowParentGoal"
)
@ExtendsGoal("antigone_follow_parent")
public class FoxFollowParentGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Fox entityfox
			MobParameters_v1_20_2.getInstance().Fox,
			// double speed
			new DoubleParameter("speed", 1.25)
	);

	public FoxFollowParentGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
