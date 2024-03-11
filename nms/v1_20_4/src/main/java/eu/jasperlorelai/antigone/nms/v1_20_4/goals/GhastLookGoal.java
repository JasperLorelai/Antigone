package eu.jasperlorelai.antigone.nms.v1_20_4.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Ghast;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob.MobParameters_v1_20_4;

@Name("antigone_ghast_look")
@WrapVanillaGoal.Inner(
		entity = Ghast.class,
		className = "GhastLookGoal"
)
public class GhastLookGoal extends AntigoneGoal {

	// Ghast ghast
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_20_4.getInstance().Ghast);

	public GhastLookGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}