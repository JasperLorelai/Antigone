package eu.jasperlorelai.antigone.nms.shared.versioned.types;

import net.kyori.adventure.key.Key;

import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;

import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsRegistryParameter.VanillaResolver;

public abstract class RegistryResolver<I> {

	protected abstract I identifier(Key key);

	public abstract VanillaResolver<SoundEvent> soundEvent();
	public abstract VanillaResolver<Item> item();
	public abstract VanillaResolver<Block> block();

}
