package eu.jasperlorelai.antigone.nms.v1_21_11.versioned;

import net.kyori.adventure.key.Key;

import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.versioned.types.RegistryResolver;
import eu.jasperlorelai.antigone.nms.shared.parameters.config.NmsRegistryParameter.VanillaResolver;

public class RegistryResolver_v1_21_11 extends RegistryResolver<Identifier> {

	@Override
	protected Identifier identifier(Key key) {
		return Identifier.parse(key.asString());
	}

	@Override
	public VanillaResolver<SoundEvent> soundEvent() {
		return key -> BuiltInRegistries.SOUND_EVENT.getValue(identifier(key));
	}

	@Override
	public VanillaResolver<Item> item() {
		return key -> BuiltInRegistries.ITEM.getValue(identifier(key));
	}

	@Override
	public VanillaResolver<Block> block() {
		return key -> BuiltInRegistries.BLOCK.getValue(identifier(key));
	}

}
