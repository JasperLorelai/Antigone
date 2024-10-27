package eu.jasperlorelai.antigone.nms.v1_21_3.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Illusioner;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_illusioner_blindness_spell")
@WrapVanillaGoal.Inner(
		entity = Illusioner.class,
		className = "IllusionerBlindnessSpellGoal"
)
public class IllusionerBlindnessSpellGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Illusioner);

	public IllusionerBlindnessSpellGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
