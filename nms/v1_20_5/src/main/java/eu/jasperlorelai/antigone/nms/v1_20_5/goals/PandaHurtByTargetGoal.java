package eu.jasperlorelai.antigone.nms.v1_20_5.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Panda;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.v1_20_5.parameters.config.EntityTypesParameter_v1_20_5;

@Name("antigone_panda_hurt_by_target")
@WrapVanillaGoal.Inner(
		entity = Panda.class,
		className = "PandaHurtByTargetGoal"
)
@ExtendsGoal("antigone_hurt_by_target")
public class PandaHurtByTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters.Panda,
			// Class<?>... noRevengeTypes
			new EntityTypesParameter_v1_20_5("no-revenge-types", EntityTypesParameter_v1_20_5.EMPTY)
	);

	public PandaHurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
