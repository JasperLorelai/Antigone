package eu.jasperlorelai.antigone.nms.v1_21_11.parameters.mob;

import org.bukkit.craftbukkit.entity.CraftMob;

import io.papermc.paper.entity.SchoolableFish;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.bee.Bee;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.monster.illager.*;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.entity.animal.panda.Panda;
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.animal.turtle.Turtle;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.entity.animal.feline.Ocelot;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.animal.fish.Pufferfish;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.dolphin.Dolphin;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.entity.animal.polarbear.PolarBear;
import net.minecraft.world.entity.animal.equine.SkeletonHorse;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.animal.fish.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.parrot.ShoulderRidingEntity;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;

import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.parameters.mob.MobParameter;

public class MobParameters_v1_21_11 {

	public static final MobParameter<Mob> Mob = with(Mob.class, Description.ofEntityInterface(org.bukkit.entity.Mob.class));
	public static final MobParameter<PathfinderMob> PathfinderMob = with(PathfinderMob.class, Description.ofEntityInterface(org.bukkit.entity.Creature.class));
	public static final MobParameter<Animal> Animal = with(Animal.class, Description.ofEntityInterface(org.bukkit.entity.Animals.class));
	public static final MobParameter<Wolf> Wolf = with(Wolf.class, Description.ofClass(org.bukkit.entity.Wolf.class));
	public static final MobParameter<Cat> Cat = with(Cat.class, Description.ofClass(org.bukkit.entity.Cat.class));
	public static final MobParameter<Dolphin> Dolphin = with(Dolphin.class, Description.ofClass(org.bukkit.entity.Dolphin.class));
	public static final MobParameter<TamableAnimal> TamableAnimal = with(TamableAnimal.class, Description.ofEntityInterface(org.bukkit.entity.Tameable.class));
	public static final MobParameter<Llama> Llama = with(Llama.class, Description.ofClass(org.bukkit.entity.Llama.class));
	public static final MobParameter<AbstractVillager> AbstractVillager = with(AbstractVillager.class, Description.ofEntityInterface(org.bukkit.entity.AbstractVillager.class));
	public static final MobParameter<AbstractIllager> AbstractIllager = with(AbstractIllager.class, Description.ofEntityInterface(org.bukkit.entity.Illager.class));
	public static final MobParameter<IronGolem> IronGolem = with(IronGolem.class, Description.ofClass(org.bukkit.entity.IronGolem.class));
	public static final MobParameter<Raider> Raider = with(Raider.class, Description.ofEntityInterface(org.bukkit.entity.Raider.class));
	public static final MobParameter<AbstractHorse> AbstractHorse = with(AbstractHorse.class, Description.ofEntityInterface(org.bukkit.entity.AbstractHorse.class));
	public static final MobParameter<Creeper> Creeper = with(Creeper.class, Description.ofClass(org.bukkit.entity.Creeper.class));
	public static final MobParameter<Zombie> Zombie = with(Zombie.class, Description.ofClass(org.bukkit.entity.Zombie.class));
	public static final MobParameter<SkeletonHorse> SkeletonHorse = with(SkeletonHorse.class, Description.ofClass(org.bukkit.entity.SkeletonHorse.class));
	public static final MobParameter<Vindicator> Vindicator = with(Vindicator.class, Description.ofClass(org.bukkit.entity.Vindicator.class));
	public static final MobParameter<WanderingTrader> WanderingTrader = with(WanderingTrader.class, Description.ofClass(org.bukkit.entity.WanderingTrader.class));
	public static final MobParameter<Turtle> Turtle = with(Turtle.class, Description.ofClass(org.bukkit.entity.Turtle.class));
	public static final MobParameter<Strider> Strider = with(Strider.class, Description.ofClass(org.bukkit.entity.Strider.class));
	public static final MobParameter<Squid> Squid = with(Squid.class, Description.ofClass(org.bukkit.entity.Squid.class));
	public static final MobParameter<Spider> Spider = with(Spider.class, Description.ofClass(org.bukkit.entity.Spider.class));
	public static final MobParameter<Fox> Fox = with(Fox.class, Description.ofClass(org.bukkit.entity.Fox.class));
	public static final MobParameter<Slime> Slime = with(Slime.class, Description.ofClass(org.bukkit.entity.Slime.class));
	public static final MobParameter<Silverfish> Silverfish = with(Silverfish.class, Description.ofClass(org.bukkit.entity.Silverfish.class));
	public static final MobParameter<Shulker> Shulker = with(Shulker.class, Description.ofClass(org.bukkit.entity.Shulker.class));
	public static final MobParameter<Ghast> Ghast = with(Ghast.class, Description.ofClass(org.bukkit.entity.Ghast.class));
	public static final MobParameter<HappyGhast> HappyGhast = with(HappyGhast.class, Description.ofClass(org.bukkit.entity.HappyGhast.class));
	public static final MobParameter<Rabbit> Rabbit = with(Rabbit.class, Description.ofClass(org.bukkit.entity.Rabbit.class));
	public static final MobParameter<Pufferfish> Pufferfish = with(Pufferfish.class, Description.ofClass(org.bukkit.entity.PufferFish.class));
	public static final MobParameter<Panda> Panda = with(Panda.class, Description.ofClass(org.bukkit.entity.Panda.class));
	public static final MobParameter<Ocelot> Ocelot = with(Ocelot.class, Description.ofClass(org.bukkit.entity.Ocelot.class));
	public static final MobParameter<PatrollingMonster> PatrollingMonster = with(PatrollingMonster.class, Description.ofEntityInterface("Patrolling ", org.bukkit.entity.Raider.class));
	public static final MobParameter<Guardian> Guardian = with(Guardian.class, Description.ofClass(org.bukkit.entity.Guardian.class));
	public static final MobParameter<AbstractFish> AbstractFish = with(AbstractFish.class, Description.ofEntityInterface(org.bukkit.entity.Fish.class));
	public static final MobParameter<ShoulderRidingEntity> ShoulderRidingEntity = with(ShoulderRidingEntity.class, Description.ofClass(org.bukkit.entity.Parrot.class));
	public static final MobParameter<AbstractSchoolingFish> AbstractSchoolingFish = with(AbstractSchoolingFish.class, Description.ofEntityInterface(SchoolableFish.class));
	public static final MobParameter<EnderMan> EnderMan = with(EnderMan.class, Description.ofClass(org.bukkit.entity.Enderman.class));
	public static final MobParameter<Drowned> Drowned = with(Drowned.class, Description.ofClass(org.bukkit.entity.Drowned.class));
	public static final MobParameter<Blaze> Blaze = with(Blaze.class, Description.ofClass(org.bukkit.entity.Blaze.class));
	public static final MobParameter<Bee> Bee = with(Bee.class, Description.ofClass(org.bukkit.entity.Bee.class));
	public static final MobParameter<Evoker> Evoker = with(Evoker.class, Description.ofClass(org.bukkit.entity.Evoker.class));
	public static final MobParameter<Phantom> Phantom = with(Phantom.class, Description.ofClass(org.bukkit.entity.Phantom.class));
	public static final MobParameter<PolarBear> PolarBear = with(PolarBear.class, Description.ofClass(org.bukkit.entity.PolarBear.class));
	public static final MobParameter<SpellcasterIllager> SpellcasterIllager = with(SpellcasterIllager.class, Description.ofClass(org.bukkit.entity.Spellcaster.class));
	public static final MobParameter<Vex> Vex = with(Vex.class, Description.ofClass(org.bukkit.entity.Vex.class));
	public static final MobParameter<WitherBoss> WitherBoss = with(WitherBoss.class, Description.ofClass(org.bukkit.entity.Wither.class));
	public static final MobParameter<Illusioner> Illusioner = with(Illusioner.class, Description.ofClass(org.bukkit.entity.Illusioner.class));
	public static final MobParameter<Mob> NeutralMob = with(Mob.class, Description.ofEntityInterface("Neutral ", org.bukkit.entity.Mob.class));
	public static final MobParameter<RangedAttackMob> RangedAttackMob = with(RangedAttackMob.class, Description.ofEntityInterface(org.bukkit.entity.Parrot.class));
	public static final MobParameter<Monster> Monster = with(Monster.class, Description.ofClass(org.bukkit.entity.Monster.class));
	public static final MobParameter<Monster> RangedAttackMonster = with(Monster.class, Description.ofEntityInterface("Ranged attack ", org.bukkit.entity.Monster.class), RangedAttackMob.class);
	public static final MobParameter<Monster> RangedCrossbowAttackMob = with(Monster.class, Description.ofEntityInterface("Ranged crossbow attack ", org.bukkit.entity.Monster.class), RangedAttackMob.class, CrossbowAttackMob.class);

	public static <M> MobParameter<M> with(Class<M> nmsClass, String description, Class<?> ...withInterfaces) {
		return new MobParameter<>(nmsClass, description, mob -> {
			try {
				M entity = nmsClass.cast(((CraftMob) mob).getHandle());
				if (withInterfaces == null) return entity;
				for (Class<?> withInterface : withInterfaces) {
					if (!entity.getClass().isAssignableFrom(withInterface)) return null;
				}
				return entity;
			} catch (ClassCastException e) {
				return null;
			}
		});
	}

}
