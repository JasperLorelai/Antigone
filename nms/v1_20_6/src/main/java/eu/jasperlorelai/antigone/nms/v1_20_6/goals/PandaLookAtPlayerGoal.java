package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.player.Player;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_20_6.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;

@Name("antigone_panda_look_at_player")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaLookAtPlayerGoal"
)
@ExtendsGoal("antigone_look_at_player")
public class PandaLookAtPlayerGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters.Panda,
			// Class<? extends LivingEntity> targetType
			new EntityTypeParameter(LivingEntityMap::fromString, "target-type", Player.class),
			// float range
			new FloatParameter("range", 6)
	);

	public PandaLookAtPlayerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
