package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.EnderMan;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_enderman_freeze_when_looked_at")
@WrapVanillaGoal.Inner(
		entity = EnderMan.class,
		className = "EndermanFreezeWhenLookedAt"
)
public class EndermanFreezeWhenLookedAt extends AntigoneGoal {

	// EnderMan enderman
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters.EnderMan);

	public EndermanFreezeWhenLookedAt(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
