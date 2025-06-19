package eu.jasperlorelai.antigone.nms.v1_21_5.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Drowned;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.FloatParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.IntegerParameter;
import eu.jasperlorelai.antigone.nms.v1_21_5.parameters.mob.MobParameters_v1_21_5;

@Name("antigone_drowned_trident_attack")
@WrapVanillaGoal.Inner(
		outer = Drowned.class,
		className = "DrownedTridentAttackGoal"
)
@ExtendsGoal("antigone_ranged_attack")
public class DrownedTridentAttackGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// RangedAttackMob mob
			MobParameters_v1_21_5.RangedAttackMob,
			// double mobSpeed
			new DoubleParameter("mob-speed", 1),
			// int intervalTicks
			new IntegerParameter("interval-ticks", 40),
			// float maxShootRange
			new FloatParameter("max-shoot-range", 10)
	);

	public DrownedTridentAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
