package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Llama;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.config.EntityTypeParameter_v1_20_2;

@Name("antigone_wolf_avoid_entity")
@ExtendsGoal("antigone_avoid_entity")
@WrapVanillaGoal.Inner(
		entity = Wolf.class,
		className = "WolfAvoidEntityGoal"
)
public class WolfAvoidEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Wolf entitywolf
			MobParameters_v1_20_2.getInstance().Wolf,
			// Class fleeFromType
			new EntityTypeParameter_v1_20_2("flee-from-type", Llama.class),
			// float distance
			new FloatParameter("distance", 24),
			// double slowSpeed
			new DoubleParameter("fast-speed", 1.5),
			// double fastSpeed
			new DoubleParameter("fast-speed", 1.5)
	);

	public WolfAvoidEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
