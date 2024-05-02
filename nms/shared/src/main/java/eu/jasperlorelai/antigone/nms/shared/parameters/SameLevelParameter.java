package eu.jasperlorelai.antigone.nms.shared.parameters;

import org.bukkit.entity.Mob;

import com.google.gson.JsonObject;

import net.minecraft.world.level.Level;

import org.bukkit.craftbukkit.CraftWorld;

public class SameLevelParameter extends ClassParameter<Level> {

	private static SameLevelParameter instance;

	private SameLevelParameter() {
		super(Level.class);
	}

	public static SameLevelParameter getInstance() {
		if (instance == null) instance = new SameLevelParameter();
		return instance;
	}

	public Level of(Mob mob) {
		return ((CraftWorld) mob.getWorld()).getHandle();
	}

	@Override
	public void documentExtra(JsonObject doc) {
		// Unused
	}

	@Override
	public String documentType() {
		return null; // Unused
	}

}
