package eu.jasperlorelai.antigone.nms.v1_21_4.entities;

import java.lang.Class;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.AgeableWaterCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Bogged;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.PatrollingMonster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.creaking.Creaking;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import org.jetbrains.annotations.Nullable;

public class LivingEntityMap {
	private static final Map<String, Class<? extends LivingEntity>> map = new LinkedHashMap<>();

	static {
		map.put("abstract_chested_horse", AbstractChestedHorse.class);
		map.put("abstract_fish", AbstractFish.class);
		map.put("abstract_golem", AbstractGolem.class);
		map.put("abstract_horse", AbstractHorse.class);
		map.put("abstract_illager", AbstractIllager.class);
		map.put("abstract_piglin", AbstractPiglin.class);
		map.put("abstract_schooling_fish", AbstractSchoolingFish.class);
		map.put("abstract_skeleton", AbstractSkeleton.class);
		map.put("abstract_villager", AbstractVillager.class);
		map.put("ageable_mob", AgeableMob.class);
		map.put("ageable_water_creature", AgeableWaterCreature.class);
		map.put("allay", Allay.class);
		map.put("ambient_creature", AmbientCreature.class);
		map.put("animal", Animal.class);
		map.put("armadillo", Armadillo.class);
		map.put("armor_stand", ArmorStand.class);
		map.put("axolotl", Axolotl.class);
		map.put("bat", Bat.class);
		map.put("bee", Bee.class);
		map.put("blaze", Blaze.class);
		map.put("bogged", Bogged.class);
		map.put("breeze", Breeze.class);
		map.put("camel", Camel.class);
		map.put("cat", Cat.class);
		map.put("cave_spider", CaveSpider.class);
		map.put("chicken", Chicken.class);
		map.put("cod", Cod.class);
		map.put("cow", Cow.class);
		map.put("creaking", Creaking.class);
		map.put("creeper", Creeper.class);
		map.put("dolphin", Dolphin.class);
		map.put("donkey", Donkey.class);
		map.put("drowned", Drowned.class);
		map.put("elder_guardian", ElderGuardian.class);
		map.put("ender_dragon", EnderDragon.class);
		map.put("ender_man", EnderMan.class);
		map.put("endermite", Endermite.class);
		map.put("evoker", Evoker.class);
		map.put("flying_mob", FlyingMob.class);
		map.put("fox", Fox.class);
		map.put("frog", Frog.class);
		map.put("ghast", Ghast.class);
		map.put("giant", Giant.class);
		map.put("glow_squid", GlowSquid.class);
		map.put("goat", Goat.class);
		map.put("guardian", Guardian.class);
		map.put("hoglin", Hoglin.class);
		map.put("horse", Horse.class);
		map.put("husk", Husk.class);
		map.put("illusioner", Illusioner.class);
		map.put("iron_golem", IronGolem.class);
		map.put("llama", Llama.class);
		map.put("magma_cube", MagmaCube.class);
		map.put("mob", Mob.class);
		map.put("monster", Monster.class);
		map.put("mule", Mule.class);
		map.put("mushroom_cow", MushroomCow.class);
		map.put("ocelot", Ocelot.class);
		map.put("panda", Panda.class);
		map.put("parrot", Parrot.class);
		map.put("pathfinder_mob", PathfinderMob.class);
		map.put("patrolling_monster", PatrollingMonster.class);
		map.put("phantom", Phantom.class);
		map.put("pig", Pig.class);
		map.put("piglin", Piglin.class);
		map.put("piglin_brute", PiglinBrute.class);
		map.put("pillager", Pillager.class);
		map.put("player", Player.class);
		map.put("polar_bear", PolarBear.class);
		map.put("pufferfish", Pufferfish.class);
		map.put("rabbit", Rabbit.class);
		map.put("raider", Raider.class);
		map.put("ravager", Ravager.class);
		map.put("salmon", Salmon.class);
		map.put("sheep", Sheep.class);
		map.put("shoulder_riding_entity", ShoulderRidingEntity.class);
		map.put("shulker", Shulker.class);
		map.put("silverfish", Silverfish.class);
		map.put("skeleton", Skeleton.class);
		map.put("skeleton_horse", SkeletonHorse.class);
		map.put("slime", Slime.class);
		map.put("sniffer", Sniffer.class);
		map.put("snow_golem", SnowGolem.class);
		map.put("spellcaster_illager", SpellcasterIllager.class);
		map.put("spider", Spider.class);
		map.put("squid", Squid.class);
		map.put("stray", Stray.class);
		map.put("strider", Strider.class);
		map.put("tadpole", Tadpole.class);
		map.put("tamable_animal", TamableAnimal.class);
		map.put("trader_llama", TraderLlama.class);
		map.put("tropical_fish", TropicalFish.class);
		map.put("turtle", Turtle.class);
		map.put("vex", Vex.class);
		map.put("villager", Villager.class);
		map.put("vindicator", Vindicator.class);
		map.put("wandering_trader", WanderingTrader.class);
		map.put("warden", Warden.class);
		map.put("water_animal", WaterAnimal.class);
		map.put("witch", Witch.class);
		map.put("wither_boss", WitherBoss.class);
		map.put("wither_skeleton", WitherSkeleton.class);
		map.put("wolf", Wolf.class);
		map.put("zoglin", Zoglin.class);
		map.put("zombie", Zombie.class);
		map.put("zombie_horse", ZombieHorse.class);
		map.put("zombie_villager", ZombieVillager.class);
		map.put("zombified_piglin", ZombifiedPiglin.class);
	}

	@Nullable
	public static Class<? extends LivingEntity> fromString(String name) {
		return map.get(name.toLowerCase());
	}
}
