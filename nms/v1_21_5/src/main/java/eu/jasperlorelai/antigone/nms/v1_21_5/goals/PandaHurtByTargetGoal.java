package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v1_21_5.entities.LivingEntityMap;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypesParameter;

@Name("antigone_panda_hurt_by_target")
@WrapVanillaGoal.Inner(
		outer = Panda.class,
		className = "PandaHurtByTargetGoal"
)
@ExtendsGoal("antigone_hurt_by_target")
public class PandaHurtByTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters_v1_21_5.Panda,
			// Class<?>... noRevengeTypes
			new EntityTypesParameter(LivingEntityMap::fromString, "no-revenge-types", EntityTypesParameter.EMPTY)
	);

	public PandaHurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
