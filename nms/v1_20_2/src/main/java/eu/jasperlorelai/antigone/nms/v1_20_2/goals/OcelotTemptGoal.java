package eu.jasperlorelai.antigone.nms.v1_20_2.goals;

import java.util.List;
import java.lang.Override;

import org.bukkit.Material;
import org.bukkit.entity.Mob;

import com.nisovin.magicspells.util.Name;
import com.nisovin.magicspells.util.SpellData;

import net.minecraft.world.entity.animal.Ocelot;

import eu.jasperlorelai.antigone.nms.shared.util.ExtendsGoal;
import eu.jasperlorelai.antigone.nms.shared.util.AntigoneGoal;
import eu.jasperlorelai.antigone.nms.shared.util.WrapVanillaGoal;
import eu.jasperlorelai.antigone.nms.shared.parameters.AntigoneParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.DoubleParameter;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.BooleanParameter;
import eu.jasperlorelai.antigone.nms.v1_20_2.parameters.mob.MobParameters_v1_20_2;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsIngredientParameter;

@Name("antigone_ocelot_tempt")
@WrapVanillaGoal.Inner(
		entity = Ocelot.class,
		className = "OcelotTemptGoal"
)
@ExtendsGoal("antigone_tempt")
public class OcelotTemptGoal extends AntigoneGoal {

	private static final List<AntigoneParameter<?, ?>> parameters = List.of(
			// Ocelot ocelot
			MobParameters_v1_20_2.getInstance().Ocelot,
			// double speed
			new DoubleParameter("speed", 0.6),
			// Ingredient food
			new NmsIngredientParameter("food", List.of(Material.COD, Material.SALMON)),
			// boolean canBeScared
			new BooleanParameter("can-be-scared", true)
	);

	public OcelotTemptGoal(Mob mob, SpellData data) {
		super(mob, data);
	}

	@Override
	public List<AntigoneParameter<?, ?>> getParameters() {
		return parameters;
	}

}
