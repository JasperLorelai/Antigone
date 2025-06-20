package eu.jasperlorelai.antigone.nms.v1_21_6.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_6.parameters.mob.MobParameters_v1_21_6;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;

@Name("antigone_cat_sit_on_block")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.CatSitOnBlockGoal.class)
public class CatSitOnBlockGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Cat cat
			MobParameters_v1_21_6.Cat,
			// double speed
			new DoubleParameter("speed", 0.8)
	);

	public CatSitOnBlockGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
