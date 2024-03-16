package eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob;

import java.lang.Override;

import net.minecraft.world.entity.Mob;

import org.bukkit.craftbukkit.v1_20_R3.entity.CraftMob;

import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobConverter;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameters;

public class MobParameters_v1_20_4 extends MobParameters {

	private static MobParameters_v1_20_4 instance;

	private MobParameters_v1_20_4() {}

	public static MobParameters_v1_20_4 getInstance() {
		if (instance == null) instance = new MobParameters_v1_20_4();
		return instance;
	}

	@Override
	public MobConverter<Mob> toMob() {
		return mob -> ((CraftMob) mob).getHandle();
	}

}
