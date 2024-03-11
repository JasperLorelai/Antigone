package eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config;

import java.lang.Override;

import net.minecraft.world.level.Level;

import org.bukkit.entity.Mob;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;

import eu.jasperlorelai.antigone.nms.shared.parameters.SameLevelParameter;

public class SameLevelParameter_v1_20_4 extends SameLevelParameter {

	private static SameLevelParameter_v1_20_4 instance;

	private SameLevelParameter_v1_20_4() {
	}

	public static SameLevelParameter_v1_20_4 getInstance() {
		if (instance == null) instance = new SameLevelParameter_v1_20_4();
		return instance;
	}

	@Override
	public Level of(Mob mob) {
		return ((CraftWorld) mob.getWorld()).getHandle();
	}

}
