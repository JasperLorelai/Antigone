package eu.jasperlorelai.antigone.nms.shared.parameters;

import org.bukkit.entity.Mob;

import com.google.gson.JsonObject;

import net.minecraft.world.level.Level;

public abstract class SameLevelParameter extends ClassParameter<Level> {

	public SameLevelParameter() {
		super(Level.class);
	}

	public abstract Level of(Mob mob);

	@Override
	public void documentExtra(JsonObject doc) {
		// Unused
	}

	@Override
	public String documentType() {
		return null; // Unused
	}

}
