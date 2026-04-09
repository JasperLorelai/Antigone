package eu.jasperlorelai.antigone.nms.v26_1_1.entities;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.bee.Bee;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.camel.CamelHusk;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.cow.AbstractCow;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.cow.MushroomCow;
import net.minecraft.world.entity.animal.equine.AbstractChestedHorse;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.equine.Donkey;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.animal.equine.Mule;
import net.minecraft.world.entity.animal.equine.SkeletonHorse;
import net.minecraft.world.entity.animal.equine.TraderLlama;
import net.minecraft.world.entity.animal.equine.ZombieHorse;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.feline.Ocelot;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.entity.animal.nautilus.AbstractNautilus;
import net.minecraft.world.entity.animal.nautilus.Nautilus;
import net.minecraft.world.entity.animal.nautilus.ZombieNautilus;
import net.minecraft.world.entity.animal.panda.Panda;
import net.minecraft.world.entity.animal.parrot.Parrot;
import net.minecraft.world.entity.animal.parrot.ShoulderRidingEntity;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.polarbear.PolarBear;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.animal.turtle.Turtle;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import org.jetbrains.annotations.Nullable;

public class AnimalMap {
	private static final Map<String, Class<? extends Animal>> map = new LinkedHashMap<>();

	static {
		map.put("abstract_chested_horse", AbstractChestedHorse.class);
		map.put("abstract_cow", AbstractCow.class);
		map.put("abstract_horse", AbstractHorse.class);
		map.put("abstract_nautilus", AbstractNautilus.class);
		map.put("armadillo", Armadillo.class);
		map.put("axolotl", Axolotl.class);
		map.put("bee", Bee.class);
		map.put("camel", Camel.class);
		map.put("camel_husk", CamelHusk.class);
		map.put("cat", Cat.class);
		map.put("chicken", Chicken.class);
		map.put("cow", Cow.class);
		map.put("donkey", Donkey.class);
		map.put("fox", Fox.class);
		map.put("frog", Frog.class);
		map.put("goat", Goat.class);
		map.put("happy_ghast", HappyGhast.class);
		map.put("hoglin", Hoglin.class);
		map.put("horse", Horse.class);
		map.put("llama", Llama.class);
		map.put("mule", Mule.class);
		map.put("mushroom_cow", MushroomCow.class);
		map.put("nautilus", Nautilus.class);
		map.put("ocelot", Ocelot.class);
		map.put("panda", Panda.class);
		map.put("parrot", Parrot.class);
		map.put("pig", Pig.class);
		map.put("polar_bear", PolarBear.class);
		map.put("rabbit", Rabbit.class);
		map.put("sheep", Sheep.class);
		map.put("shoulder_riding_entity", ShoulderRidingEntity.class);
		map.put("skeleton_horse", SkeletonHorse.class);
		map.put("sniffer", Sniffer.class);
		map.put("strider", Strider.class);
		map.put("tamable_animal", TamableAnimal.class);
		map.put("trader_llama", TraderLlama.class);
		map.put("turtle", Turtle.class);
		map.put("wolf", Wolf.class);
		map.put("zombie_horse", ZombieHorse.class);
		map.put("zombie_nautilus", ZombieNautilus.class);
	}

	@Nullable
	public static Class<? extends Animal> fromString(String name) {
		return map.get(name.toLowerCase());
	}
}
