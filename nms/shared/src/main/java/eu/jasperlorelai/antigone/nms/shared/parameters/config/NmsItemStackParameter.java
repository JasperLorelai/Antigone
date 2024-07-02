package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.bukkit.craftbukkit.inventory.CraftItemStack;

import com.nisovin.magicspells.util.magicitems.MagicItem;
import com.nisovin.magicspells.util.magicitems.MagicItems;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ExactConfigParameter;

public class NmsItemStackParameter extends ExactConfigParameter<ItemStack> {

	public NmsItemStackParameter(@NotNull @ConfigKey String name) {
		this(name, (ItemStack) null);
	}

	public NmsItemStackParameter(@NotNull @ConfigKey String name, @Nullable ItemStack def) {
		this(name, def == null ? null : new Default<>(def, def.toString()));
	}

	private NmsItemStackParameter(@ConfigKey String name, Default<ItemStack> def) {
		super(name, ItemStack.class, null, def);
	}

	@Override
	public ConfigSupplier<ItemStack> getSupplier() {
		return ConfigSupplier.fromString(string -> {
			MagicItem magicItem = MagicItems.getMagicItemFromString(string);
			if (magicItem == null) return null;
			return CraftItemStack.asNMSCopy(magicItem.getItemStack());
		});
	}

	@Override
	public String documentType() {
		return Description.hyperlink("Magic Item String", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Magic-Item-String");
	}

}
