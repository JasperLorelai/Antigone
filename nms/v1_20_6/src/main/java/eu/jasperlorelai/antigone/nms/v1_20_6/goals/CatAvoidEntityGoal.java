package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_20_6.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;

@Name("antigone_cat_avoid_entity")
@WrapVanillaGoal.Inner(
		outer = Cat.class,
		className = "CatAvoidEntityGoal"
)
@ExtendsGoal("antigone_avoid_entity")
public class CatAvoidEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Cat cat
			MobParameters.Cat,
			// Class<? extends LivingEntity> fleeFromType
			new EntityTypeParameter(LivingEntityMap::fromString, "flee-from-type", Player.class),
			// float distance
			new FloatParameter("distance", 16),
			// double slowSpeed
			new DoubleParameter("slow-speed", 0.8),
			// double fastSpeed
			new DoubleParameter("fast-speed", 1.33)
	);

	public CatAvoidEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
