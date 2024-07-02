package eu.jasperlorelai.antigone.nms.v1_21.goals;

import java.util.List;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsDamageTypeTagParameter;

@Name("antigone_panic")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.PanicGoal.class)
public class PanicGoal extends AntigoneGoal {

	public static final Default<TagKey<DamageType>> PANIC_CAUSES_DEFAULT = new Default<>(DamageTypeTags.PANIC_CAUSES, "panic_causes");

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters.PathfinderMob,
			// double speed
			new DoubleParameter("speed"),
			// TagKey panicDamageTypes
			new NmsDamageTypeTagParameter("panic-damage-types", PANIC_CAUSES_DEFAULT)
	);

	public PanicGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
