package eu.jasperlorelai.antigone.nms.v1_20_6.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.AbstractIllager;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

@Name("antigone_raider_open_door")
@WrapVanillaGoal.Inner(
		entity = AbstractIllager.class,
		className = "RaiderOpenDoorGoal"
)
@ExtendsGoal("antigone_open_door")
public class RaiderOpenDoorGoal extends AntigoneGoal {

	// Raider raider
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters.AbstractIllager,
			MobParameters.Raider
	);

	public RaiderOpenDoorGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
