package eu.jasperlorelai.antigone.nms.v1_20_4.parameters.mob;

import java.lang.Class;
import java.lang.Override;
import java.util.function.Supplier;
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

/**
 * Enum representing LivingEntity variants, either direct mobs (e.g. Zombie, Pig) or groups of them (e.g. Animal, Mob).
 */
public enum LivingEntityClass implements Supplier<Class<? extends LivingEntity>> {

	AGEABLE_MOB(AgeableMob.class),

	FLYING_MOB(FlyingMob.class),

	GLOW_SQUID(GlowSquid.class),

	MOB(Mob.class),

	PATHFINDER_MOB(PathfinderMob.class),

	TAMABLE_ANIMAL(TamableAnimal.class),

	AMBIENT_CREATURE(AmbientCreature.class),

	BAT(Bat.class),

	ABSTRACT_FISH(AbstractFish.class),

	ABSTRACT_GOLEM(AbstractGolem.class),

	ABSTRACT_SCHOOLING_FISH(AbstractSchoolingFish.class),

	ANIMAL(Animal.class),

	BEE(Bee.class),

	CAT(Cat.class),

	CHICKEN(Chicken.class),

	COD(Cod.class),

	COW(Cow.class),

	DOLPHIN(Dolphin.class),

	FOX(Fox.class),

	IRON_GOLEM(IronGolem.class),

	MUSHROOM_COW(MushroomCow.class),

	OCELOT(Ocelot.class),

	PANDA(Panda.class),

	PARROT(Parrot.class),

	PIG(Pig.class),

	POLAR_BEAR(PolarBear.class),

	PUFFERFISH(Pufferfish.class),

	RABBIT(Rabbit.class),

	SALMON(Salmon.class),

	SHEEP(Sheep.class),

	SHOULDER_RIDING_ENTITY(ShoulderRidingEntity.class),

	SNOW_GOLEM(SnowGolem.class),

	SQUID(Squid.class),

	TROPICAL_FISH(TropicalFish.class),

	TURTLE(Turtle.class),

	WATER_ANIMAL(WaterAnimal.class),

	WOLF(Wolf.class),

	ALLAY(Allay.class),

	AXOLOTL(Axolotl.class),

	CAMEL(Camel.class),

	FROG(Frog.class),

	TADPOLE(Tadpole.class),

	GOAT(Goat.class),

	ABSTRACT_CHESTED_HORSE(AbstractChestedHorse.class),

	ABSTRACT_HORSE(AbstractHorse.class),

	DONKEY(Donkey.class),

	HORSE(Horse.class),

	LLAMA(Llama.class),

	MULE(Mule.class),

	SKELETON_HORSE(SkeletonHorse.class),

	TRADER_LLAMA(TraderLlama.class),

	ZOMBIE_HORSE(ZombieHorse.class),

	SNIFFER(Sniffer.class),

	ENDER_DRAGON(EnderDragon.class),

	WITHER_BOSS(WitherBoss.class),

	ARMOR_STAND(ArmorStand.class),

	ABSTRACT_ILLAGER(AbstractIllager.class),

	ABSTRACT_SKELETON(AbstractSkeleton.class),

	BLAZE(Blaze.class),

	CAVE_SPIDER(CaveSpider.class),

	CREEPER(Creeper.class),

	DROWNED(Drowned.class),

	ELDER_GUARDIAN(ElderGuardian.class),

	ENDER_MAN(EnderMan.class),

	ENDERMITE(Endermite.class),

	EVOKER(Evoker.class),

	GHAST(Ghast.class),

	GIANT(Giant.class),

	GUARDIAN(Guardian.class),

	HUSK(Husk.class),

	ILLUSIONER(Illusioner.class),

	MAGMA_CUBE(MagmaCube.class),

	MONSTER(Monster.class),

	PATROLLING_MONSTER(PatrollingMonster.class),

	PHANTOM(Phantom.class),

	PILLAGER(Pillager.class),

	RAVAGER(Ravager.class),

	SHULKER(Shulker.class),

	SILVERFISH(Silverfish.class),

	SKELETON(Skeleton.class),

	SLIME(Slime.class),

	SPELLCASTER_ILLAGER(SpellcasterIllager.class),

	SPIDER(Spider.class),

	STRAY(Stray.class),

	STRIDER(Strider.class),

	VEX(Vex.class),

	VINDICATOR(Vindicator.class),

	WITCH(Witch.class),

	WITHER_SKELETON(WitherSkeleton.class),

	ZOGLIN(Zoglin.class),

	ZOMBIE(Zombie.class),

	ZOMBIE_VILLAGER(ZombieVillager.class),

	ZOMBIFIED_PIGLIN(ZombifiedPiglin.class),

	BREEZE(Breeze.class),

	HOGLIN(Hoglin.class),

	ABSTRACT_PIGLIN(AbstractPiglin.class),

	PIGLIN(Piglin.class),

	PIGLIN_BRUTE(PiglinBrute.class),

	WARDEN(Warden.class),

	ABSTRACT_VILLAGER(AbstractVillager.class),

	VILLAGER(Villager.class),

	WANDERING_TRADER(WanderingTrader.class),

	PLAYER(Player.class),

	RAIDER(Raider.class);

	private final Class<? extends LivingEntity> clazz;

	LivingEntityClass(Class<? extends LivingEntity> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Class<? extends LivingEntity> get() {
		return clazz;
	}

}
