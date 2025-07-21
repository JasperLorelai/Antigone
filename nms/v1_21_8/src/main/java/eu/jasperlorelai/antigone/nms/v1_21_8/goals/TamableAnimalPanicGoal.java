package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.TamableAnimal;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsDamageTypeTagParameter;

@Name("antigone_tamable_animal_panic")
@WrapVanillaGoal.Inner(
		outer = TamableAnimal.class,
		className = "TamableAnimalPanicGoal"
)
@ExtendsGoal("antigone_panic")
public class TamableAnimalPanicGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// TamableAnimal tamableAnimal
			MobParameters_v1_21_8.TamableAnimal,
			// double speed
			new DoubleParameter("speed"),
			// TagKey panicDamageTypes
			new NmsDamageTypeTagParameter("panic-damage-types", PanicGoal.PANIC_CAUSES_DEFAULT)
	);

	public TamableAnimalPanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
