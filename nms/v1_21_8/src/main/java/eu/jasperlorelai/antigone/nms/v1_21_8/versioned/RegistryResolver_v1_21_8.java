package eu.jasperlorelai.antigone.nms.v1_21_8.versioned;

import net.kyori.adventure.key.Key;

import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.versioned.types.RegistryResolver;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsRegistryParameter.VanillaResolver;

public class RegistryResolver_v1_21_8 extends RegistryResolver {

	@Override
	protected ResourceLocation resourceLocation(Key key) {
		return ResourceLocation.parse(key.asString());
	}

	@Override
	public VanillaResolver<SoundEvent> soundEvent() {
		return key -> BuiltInRegistries.SOUND_EVENT.getValue(resourceLocation(key));
	}

	@Override
	public VanillaResolver<Item> item() {
		return key -> BuiltInRegistries.ITEM.getValue(resourceLocation(key));
	}

	@Override
	public VanillaResolver<Block> block() {
		return key -> BuiltInRegistries.BLOCK.getValue(resourceLocation(key));
	}

}
