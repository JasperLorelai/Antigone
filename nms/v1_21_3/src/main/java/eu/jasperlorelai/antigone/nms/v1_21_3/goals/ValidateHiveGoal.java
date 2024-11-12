package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import org.bukkit.entity.Mob;

import net.minecraft.world.entity.animal.Bee;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

@Name("antigone_validate_hive")
@WrapVanillaGoal.Inner(
		entity = Bee.class,
		className = "ValidateHiveGoal"
)
public class ValidateHiveGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Bee);

	public ValidateHiveGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}