package antigone;

import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;

import org.bukkit.craftbukkit.entity.CraftMob;

import net.minecraft.world.level.pathfinder.PathType;

import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.util.SpellData;
import com.nisovin.magicspells.util.CastResult;
import com.nisovin.magicspells.util.TargetInfo;
import com.nisovin.magicspells.util.MagicConfig;
import com.nisovin.magicspells.variables.Variable;
import com.nisovin.magicspells.spells.TargetedSpell;
import com.nisovin.magicspells.util.config.ConfigData;
import com.nisovin.magicspells.util.config.ConfigDataUtil;
import com.nisovin.magicspells.spells.TargetedEntitySpell;
import com.nisovin.magicspells.variables.variabletypes.GlobalVariable;
import com.nisovin.magicspells.variables.variabletypes.GlobalStringVariable;

public class PathfindingMalusSpell extends TargetedSpell implements TargetedEntitySpell {

	private Variable storeCurrent;

	private final ConfigData<Float> malus;
	private final ConfigData<PathType> pathType;

	public PathfindingMalusSpell(MagicConfig config, String spellName) {
		super(config, spellName);

		pathType = getConfigDataEnum("path-type", PathType.class, null);
		malus = ConfigDataUtil.getFloat(config.getMainConfig(), internalKey + "malus");
	}

	@Override
	protected void initializeVariables() {
		super.initializeVariables();

		storeCurrent = MagicSpells.getVariableManager().getVariable(config.getString("store-current", null));
	}

	@Override
	public CastResult cast(SpellData data) {
		TargetInfo<LivingEntity> info = getTargetedEntity(data);
		if (info.noTarget()) return noTarget(data);

		return castAtEntity(info.spellData());
	}

	@Override
	public CastResult castAtEntity(SpellData data) {
		if (!(data.target() instanceof Mob mobBukkit)) return noTarget(data);
		net.minecraft.world.entity.Mob mob = ((CraftMob) mobBukkit).getHandle();

		PathType pathType = PathfindingMalusSpell.this.pathType.get(data);
		if (pathType == null) return new CastResult(PostCastAction.ALREADY_HANDLED, data);

		float pathfindingMalus = mob.getPathfindingMalus(pathType);

		if (storeCurrent != null) {
			Player caster = data.caster() instanceof Player player ? player : null;
			if (caster == null && !(storeCurrent instanceof GlobalVariable) && !(storeCurrent instanceof GlobalStringVariable)) {
				return new CastResult(PostCastAction.ALREADY_HANDLED, data);
			}
			MagicSpells.getVariableManager().set(storeCurrent, caster == null ? null : caster.getName(), pathfindingMalus);
		}

		if (!malus.isConstant() || malus.get() != null) {
			mob.setPathfindingMalus(pathType, malus.get(data));
		}

		playSpellEffects(data);
		return new CastResult(PostCastAction.HANDLE_NORMALLY, data);
	}

}
