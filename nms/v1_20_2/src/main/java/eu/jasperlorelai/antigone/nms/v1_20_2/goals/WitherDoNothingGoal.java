package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.boss.wither.WitherBoss;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;

@Name("antigone_wither_do_nothing")
@WrapVanillaGoal.Inner(
		entity = WitherBoss.class,
		className = "WitherDoNothingGoal"
)
public class WitherDoNothingGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of();

	public WitherDoNothingGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
