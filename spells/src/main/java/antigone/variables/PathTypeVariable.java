package antigone.variables;

import antigone.AddonInfo;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.world.level.pathfinder.PathType;

import com.nisovin.magicspells.variables.variabletypes.MetaVariable;

public class PathTypeVariable extends MetaVariable {

	private final PathType type;

	public static List<AddonInfo<MetaVariable>> getTypes() {
		List<AddonInfo<MetaVariable>> addons = new ArrayList<>();
		for (PathType type : PathType.values()) {
			addons.add(new AddonInfo<>("path_malus_" + type.name().toLowerCase(), new PathTypeVariable(type)));
		}
		return addons;
	}

	public PathTypeVariable(PathType type) {
		this.type = type;
	}

	@Override
	public double getValue(String s) {
		return type.getMalus();
	}

}
