package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Material;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ExactConfigParameter;

public class NmsBlockParameter extends ExactConfigParameter<Block> {

	private static final ConfigSupplier<Block> supplier = ConfigSupplier.fromString(string -> {
		Material material = Material.matchMaterial(string);
		if (material == null || !material.isBlock()) return null;
		return BuiltInRegistries.BLOCK.get(new ResourceLocation(material.getKey().getKey()));
	});

	public NmsBlockParameter(@NotNull @ConfigKey String name) {
		super(name, Block.class, supplier);
		// If a constructor with a default value is needed, remember to check "Util#isNotBootstrapped"
	}

	@Override
	public String documentType() {
		return Description.ofEnum(Material.class);
	}

}
