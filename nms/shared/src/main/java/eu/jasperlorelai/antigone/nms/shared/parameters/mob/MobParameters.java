package eu.jasperlorelai.antigone.nms.shared.parameters.mob;

import org.bukkit.entity.*;
import org.bukkit.entity.Parrot;

import io.papermc.paper.entity.SchoolableFish;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

import eu.jasperlorelai.antigone.nms.shared.util.Description;

public abstract class MobParameters {

	public final MobParameter<Mob> Mob = with(Mob.class, Description.ofEntityInterface(org.bukkit.entity.Mob.class));
	public final MobParameter<PathfinderMob> PathfinderMob = with(PathfinderMob.class, Description.ofEntityInterface(Creature.class));
	public final MobParameter<Animal> Animal = with(Animal.class, Description.ofEntityInterface(Animals.class));
	public final MobParameter<Wolf> Wolf = with(Wolf.class, Description.ofClassName(org.bukkit.entity.Wolf.class));
	public final MobParameter<Cat> Cat = with(Cat.class, Description.ofClassName(org.bukkit.entity.Cat.class));
	public final MobParameter<Dolphin> Dolphin = with(Dolphin.class, Description.ofClassName(org.bukkit.entity.Dolphin.class));
	public final MobParameter<TamableAnimal> TamableAnimal = with(TamableAnimal.class, Description.ofEntityInterface(Tameable.class));
	public final MobParameter<Llama> Llama = with(Llama.class, Description.ofClassName(org.bukkit.entity.Llama.class));
	public final MobParameter<AbstractVillager> AbstractVillager = with(AbstractVillager.class, Description.ofEntityInterface(org.bukkit.entity.AbstractVillager.class));
	public final MobParameter<AbstractIllager> AbstractIllager = with(AbstractIllager.class, Description.ofEntityInterface(Illager.class));
	public final MobParameter<IronGolem> IronGolem = with(IronGolem.class, Description.ofClassName(org.bukkit.entity.IronGolem.class));
	public final MobParameter<Raider> Raider = with(Raider.class, Description.ofEntityInterface(org.bukkit.entity.Raider.class));
	public final MobParameter<AbstractHorse> AbstractHorse = with(AbstractHorse.class, Description.ofEntityInterface(org.bukkit.entity.AbstractHorse.class));
	public final MobParameter<Creeper> Creeper = with(Creeper.class, Description.ofClassName(org.bukkit.entity.Creeper.class));
	public final MobParameter<Zombie> Zombie = with(Zombie.class, Description.ofClassName(org.bukkit.entity.Zombie.class));
	public final MobParameter<SkeletonHorse> SkeletonHorse = with(SkeletonHorse.class, Description.ofClassName(org.bukkit.entity.SkeletonHorse.class));
	public final MobParameter<Vindicator> Vindicator = with(Vindicator.class, Description.ofClassName(org.bukkit.entity.Vindicator.class));
	public final MobParameter<WanderingTrader> WanderingTrader = with(WanderingTrader.class, Description.ofClassName(org.bukkit.entity.WanderingTrader.class));
	public final MobParameter<Turtle> Turtle = with(Turtle.class, Description.ofClassName(org.bukkit.entity.Turtle.class));
	public final MobParameter<Strider> Strider = with(Strider.class, Description.ofClassName(org.bukkit.entity.Strider.class));
	public final MobParameter<Squid> Squid = with(Squid.class, Description.ofClassName(org.bukkit.entity.Squid.class));
	public final MobParameter<Spider> Spider = with(Spider.class, Description.ofClassName(org.bukkit.entity.Spider.class));
	public final MobParameter<Fox> Fox = with(Fox.class, Description.ofClassName(org.bukkit.entity.Fox.class));
	public final MobParameter<Slime> Slime = with(Slime.class, Description.ofClassName(org.bukkit.entity.Slime.class));
	public final MobParameter<Silverfish> Silverfish = with(Silverfish.class, Description.ofClassName(org.bukkit.entity.Silverfish.class));
	public final MobParameter<Shulker> Shulker = with(Shulker.class, Description.ofClassName(org.bukkit.entity.Shulker.class));
	public final MobParameter<Ghast> Ghast = with(Ghast.class, Description.ofClassName(org.bukkit.entity.Ghast.class));
	public final MobParameter<Rabbit> Rabbit = with(Rabbit.class, Description.ofClassName(org.bukkit.entity.Rabbit.class));
	public final MobParameter<Pufferfish> Pufferfish = with(Pufferfish.class, Description.ofClassName(PufferFish.class));
	public final MobParameter<Panda> Panda = with(Panda.class, Description.ofClassName(org.bukkit.entity.Panda.class));
	public final MobParameter<Ocelot> Ocelot = with(Ocelot.class, Description.ofClassName(org.bukkit.entity.Ocelot.class));
	public final MobParameter<PatrollingMonster> PatrollingMonster = with(PatrollingMonster.class, Description.ofEntityInterface("Patrolling ", org.bukkit.entity.Raider.class));
	public final MobParameter<Guardian> Guardian = with(Guardian.class, Description.ofClassName(org.bukkit.entity.Guardian.class));
	public final MobParameter<AbstractFish> AbstractFish = with(AbstractFish.class, Description.ofEntityInterface(Fish.class));
	public final MobParameter<ShoulderRidingEntity> ShoulderRidingEntity = with(ShoulderRidingEntity.class, Description.ofClassName(Parrot.class));
	public final MobParameter<AbstractSchoolingFish> AbstractSchoolingFish = with(AbstractSchoolingFish.class, Description.ofEntityInterface(SchoolableFish.class));
	public final MobParameter<EnderMan> EnderMan = with(EnderMan.class, Description.ofClassName(Enderman.class));
	public final MobParameter<Drowned> Drowned = with(Drowned.class, Description.ofClassName(org.bukkit.entity.Drowned.class));
	public final MobParameter<Blaze> Blaze = with(Blaze.class, Description.ofClassName(org.bukkit.entity.Blaze.class));
	public final MobParameter<Bee> Bee = with(Bee.class, Description.ofClassName(org.bukkit.entity.Bee.class));
	public final MobParameter<Mob> NeutralMob = with(Mob.class, Description.ofEntityInterface("Neutral ", org.bukkit.entity.Mob.class));
	public final MobParameter<RangedAttackMob> RangedAttackMob = with(RangedAttackMob.class, Description.ofEntityInterface(Parrot.class));
	public final MobParameter<Monster> RangedAttackMonster = with(Monster.class, Description.ofEntityInterface("Ranged attack ", org.bukkit.entity.Monster.class), RangedAttackMob.class);
	public final MobParameter<Monster> RangedCrossbowAttackMob = with(Monster.class, Description.ofEntityInterface("Ranged crossbow attack ", org.bukkit.entity.Monster.class), RangedAttackMob.class, CrossbowAttackMob.class);

	public abstract MobConverter<Mob> toMob();

	private <M> MobParameter<M> with(Class<M> nmsClass, String description, Class<?> ...withInterfaces) {
		return new MobParameter<>(nmsClass, description, mob -> {
			try {
				M entity = nmsClass.cast(((MobConverter<?>) toMob()).fromBukkit(mob));
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
