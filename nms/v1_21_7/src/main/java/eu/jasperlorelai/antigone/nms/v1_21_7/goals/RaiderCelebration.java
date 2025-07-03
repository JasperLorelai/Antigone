package eu.jasperlorelai.antigone.nms.v1_21_7.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.raid.Raider;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_7.parameters.mob.MobParameters_v1_21_7;

@Name("antigone_raider_celebration")
@WrapVanillaGoal.Inner(
		outer = Raider.class,
		className = "RaiderCelebration"
)
public class RaiderCelebration extends AntigoneGoal {

	// Raider entityraider
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v1_21_7.Raider,
			MobParameters_v1_21_7.Raider
	);

	public RaiderCelebration(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
