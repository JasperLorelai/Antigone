package eu.jasperlorelai.antigone.nms.v1_21_4.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Evoker;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_evoker_casting_spell")
@WrapVanillaGoal.Inner(
		outer = Evoker.class,
		className = "EvokerCastingSpellGoal"
)
@ExtendsGoal("antigone_spellcaster_casting_spell")
public class EvokerCastingSpellGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.Evoker);

	public EvokerCastingSpellGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
