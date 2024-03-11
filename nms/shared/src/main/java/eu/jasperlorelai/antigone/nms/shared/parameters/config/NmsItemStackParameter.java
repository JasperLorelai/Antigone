package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import net.minecraft.world.item.ItemStack;

import com.nisovin.magicspells.util.magicitems.MagicItem;
import com.nisovin.magicspells.util.magicitems.MagicItems;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ExactConfigParameter;

public abstract class NmsItemStackParameter extends ExactConfigParameter<ItemStack> {

	public NmsItemStackParameter(String name) {
		this(name, null);
	}

	public NmsItemStackParameter(String name, ItemStack def) {
		super(name, ItemStack.class, null, def);
	}

	@Override
	public ConfigSupplier<ItemStack> getSupplier() {
		return ConfigSupplier.fromString(string -> {
			MagicItem magicItem = MagicItems.getMagicItemFromString(string);
			if (magicItem == null) return null;
			return asNMSCopy(magicItem.getItemStack());
		});
	}

	public abstract ItemStack asNMSCopy(org.bukkit.inventory.ItemStack itemStack);

	@Override
	public String documentDefault() {
		ItemStack def = getDefault();
		if (def == null) return null;
		return def.toString();
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Magic Item String", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Magic-Item-String");
	}

}
