package eu.jasperlorelai.antigone.nms.v1_20_4.parameters.config;

import java.lang.String;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack;

import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsItemStackParameter;

public class NmsItemStackParameter_v1_20_4 extends NmsItemStackParameter {

	public NmsItemStackParameter_v1_20_4(@NotNull String name) {
		this(name, null);
	}

	public NmsItemStackParameter_v1_20_4(@NotNull String name, @Nullable ItemStack def) {
		super(name, def);
	}

	public ItemStack asNMSCopy(org.bukkit.inventory.ItemStack itemStack) {
		return CraftItemStack.asNMSCopy(itemStack);
	}

}
