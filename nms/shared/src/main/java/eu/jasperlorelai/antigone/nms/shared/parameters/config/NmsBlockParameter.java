package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Material;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.level.block.Block;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.versioned.holders.RegistryResolverHolder;

public class NmsBlockParameter extends NmsRegistryParameter<Class<Block>, Block, Block> {

	public NmsBlockParameter(@NotNull @ConfigKey String name) {
		super(name, Block.class);
	}

	@Override
	public ConfigSupplier<Block> getSupplier() {
		return ConfigSupplier.fromString(string -> getVanillaResolver().apply(getBukkitResolver().apply(string)));
	}

	@NotNull
	@Override
	public BukkitResolver getBukkitResolver() {
		return string -> {
			Material material = Material.matchMaterial(string);
			return material == null || !material.isBlock() ? null : material.key();
		};
	}

	@NotNull
	@Override
	public VanillaResolver<Block> getVanillaResolver() {
		return RegistryResolverHolder.getInstance().block();
	}

	@Override
	public String documentType() {
		return Description.ofEnum(Material.class);
	}

}
