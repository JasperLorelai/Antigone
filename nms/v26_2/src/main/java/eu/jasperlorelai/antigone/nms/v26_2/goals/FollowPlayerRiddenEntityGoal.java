package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.boat.Boat;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.v26_2.entities.EntityMap;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.EntityTypeParameter;

@Name("antigone_follow_player_ridden_entity")
@WrapVanillaGoal.Exact(net.minecraft.world.entity.ai.goal.FollowPlayerRiddenEntityGoal.class)
public class FollowPlayerRiddenEntityGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
		// PathfinderMob mob
		MobParameters_v26_2.PathfinderMob,
		// Class<? extends Entity> entityTypeToFollow
		new EntityTypeParameter<>(Entity.class, EntityMap::fromString, "entity-type-follow", Boat.class)
	);

	public FollowPlayerRiddenEntityGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
