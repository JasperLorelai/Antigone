package eu.jasperlorelai.antigone.nms.v26_2.goals;

import java.util.List;

import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.raid.Raider;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.v26_2.parameters.MobParameters_v26_2;

@Name("antigone_obtain_raid_leader_banner")
@WrapVanillaGoal.Inner(
		outer = Raider.class,
		className = "ObtainRaidLeaderBannerGoal"
)
public class ObtainRaidLeaderBannerGoal extends AntigoneGoal {

	// <T extends Raider> entityraider
	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			MobParameters_v26_2.Raider,
			MobParameters_v26_2.Raider
	);

	public ObtainRaidLeaderBannerGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
