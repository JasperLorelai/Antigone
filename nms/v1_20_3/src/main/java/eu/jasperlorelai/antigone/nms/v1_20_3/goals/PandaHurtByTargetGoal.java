package eu.jasperlorelai.antigone.nms.v1_20_3.goals;

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
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.mob.MobParameters_v1_20_3;
import eu.jasperlorelai.antigone.nms.v1_20_3.parameters.config.EntityTypesParameter_v1_20_3;

@Name("antigone_panda_hurt_by_target")
@WrapVanillaGoal.Inner(
		entity = Panda.class,
		className = "PandaHurtByTargetGoal"
)
@ExtendsGoal("antigone_hurt_by_target")
public class PandaHurtByTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Panda panda
			MobParameters_v1_20_3.getInstance().Panda,
			// Class<?>... noRevengeTypes
			new EntityTypesParameter_v1_20_3("no-revenge-types", EntityTypesParameter_v1_20_3.EMPTY)
	);

	public PandaHurtByTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
