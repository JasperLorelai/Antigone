package eu.jasperlorelai.antigone.nms.v1_21_8.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import net.minecraft.tags.TagKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.v1_21_8.parameters.mob.MobParameters_v1_21_8;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsDamageTypeTagParameter;

@Name("antigone_panic")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.PanicGoal.class)
public class PanicGoal extends AntigoneGoal {

	public static final Default<TagKey<DamageType>> PANIC_CAUSES_DEFAULT = new Default<>(DamageTypeTags.PANIC_CAUSES, "panic_causes");

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// PathfinderMob mob
			MobParameters_v1_21_8.PathfinderMob,
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
