package eu.jasperlorelai.antigone.nms.shared.versioned.types;

import net.kyori.adventure.key.Key;

import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;

import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsRegistryParameter.VanillaResolver;

public abstract class RegistryResolver {

	protected abstract ResourceLocation resourceLocation(Key key);

	public abstract VanillaResolver<SoundEvent> soundEvent();
	public abstract VanillaResolver<Item> item();
	public abstract VanillaResolver<Block> block();

}
