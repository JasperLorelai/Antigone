package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Silverfish;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;

@Name("antigone_silverfish_merge_with_stone")
@WrapVanillaGoal.Inner(
		outer = Silverfish.class,
		className = "SilverfishMergeWithStoneGoal"
)
@ExtendsGoal("antigone_random_stroll")
public class SilverfishMergeWithStoneGoal extends AntigoneGoal {

	// Silverfish silverfish
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(MobParameters_v1_21_8.Silverfish);

	public SilverfishMergeWithStoneGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
