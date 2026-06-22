package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.monster.Shulker;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_shulker_nearest_attack")
@WrapVanillaGoal.Inner(
		outer = Shulker.class,
		className = "ShulkerNearestAttackGoal"
)
@ExtendsGoal("antigone_nearest_attackable_target")
public class ShulkerNearestAttackGoal extends AntigoneGoal {

	// Shulker entityshulker
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v26_2.Shulker,
			MobParameters_v26_2.Shulker
	);

	public ShulkerNearestAttackGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
