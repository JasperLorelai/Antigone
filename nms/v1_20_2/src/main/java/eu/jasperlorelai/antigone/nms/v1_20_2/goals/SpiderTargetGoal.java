package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.config.EntityTypeParameter_v1_20_2;

@Name("antigone_spider_target")
@WrapVanillaGoal.Inner(
		entity = Spider.class,
		className = "SpiderTargetGoal"
)
@ExtendsGoal("antigone_nearest_attackable_target")
public class SpiderTargetGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Spider spider
			MobParameters_v1_20_2.getInstance().Spider,
			// Class<? extends LivingEntity> targetEntityClass
			new EntityTypeParameter_v1_20_2("target-entity-class", Player.class)
	);

	public SpiderTargetGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
