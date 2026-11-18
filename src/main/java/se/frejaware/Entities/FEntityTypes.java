package se.frejaware.Entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Enderman;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.entity.projectile.throwableitemprojectile.Snowball;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import se.frejaware.Entities.Custom.*;
import se.frejaware.Items.FItems;

import java.util.function.Supplier;

public class FEntityTypes {
	// ----------------------
	// ENTITY TYPES
	// ----------------------

	// MOLLY
	public static final EntityType<FMoobloom> MOOBLOOM = register(
			FEntityTypeIds.MOOBLOOM,
			EntityType.Builder.of(FMoobloom::new, MobCategory.CREATURE)
					.sized(0.9F, 1.4F)
					.eyeHeight(1.3F)
					.passengerAttachments(1.36875F)
					.clientTrackingRange(10),
			FMoobloom.createAttributes()
	);
	public static final EntityType<FGlaze> GLAZE = register(
			FEntityTypeIds.GLAZE,
			EntityType.Builder.of(FGlaze::new, MobCategory.MONSTER)
					.sized(0.9F, 1.4F)
					.eyeHeight(1.3F)
					.passengerAttachments(1.36875F)
					.clientTrackingRange(10),
			FGlaze.createAttributes()
	);
	public static final EntityType<FGlazeball> GLAZEBALL = register(
			FEntityTypeIds.GLAZEBALL,
			EntityType.Builder.<FGlazeball>of(FGlazeball::new, MobCategory.MISC)
				.noLootTable()
				.sized(0.3125F, 0.3125F)
				.clientTrackingRange(4)
				.updateInterval(10)
	);
	public static final EntityType<FGlazeShard> GLAZE_SHARD = register(
			FEntityTypeIds.GLAZE_SHARD,
			EntityType.Builder.<FGlazeShard>of(FGlazeShard::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.25F, 0.25F)
					.clientTrackingRange(4)
					.updateInterval(10)
	);
	public static final EntityType<FGlacierman> GLACIERMAN = register(
			FEntityTypeIds.GLACIERMAN,
			EntityType.Builder.of(FGlacierman::new, MobCategory.MONSTER)
					.sized(0.6F, 2.9F)
					.eyeHeight(2.55F)
					.passengerAttachments(2.80625F)
					.clientTrackingRange(8)
					.notInPeaceful(),
			FGlacierman.createAttributes()
	);
	public static final EntityType<FFrostbiteCrawler> FROSTBITE_CRAWLER = register(
			FEntityTypeIds.FROSTBITE_CRAWLER,
			EntityType.Builder.of(FFrostbiteCrawler::new, MobCategory.MONSTER)
					.sized(1.4F, 0.9F)
					.eyeHeight(0.65F)
					.passengerAttachments(0.765F)
					.clientTrackingRange(8)
					.notInPeaceful(),
			FFrostbiteCrawler.createAttributes()
	);

	// BLUE SPRUCE
	public static final EntityType<Boat> BLUE_SPRUCE_BOAT = register(
			FEntityTypeIds.BLUE_SPRUCE_BOAT,
			EntityType.Builder.of(boatFactory(() -> FItems.BLUE_SPRUCE_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);
	public static final EntityType<ChestBoat> BLUE_SPRUCE_CHEST_BOAT = register(
			FEntityTypeIds.BLUE_SPRUCE_CHEST_BOAT,
			EntityType.Builder.of(chestBoatFactory(() -> FItems.BLUE_SPRUCE_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);

	// JACARANDA
	public static final EntityType<Boat> JACARANDA_BOAT = register(
			FEntityTypeIds.JACARANDA_BOAT,
			EntityType.Builder.of(boatFactory(() -> FItems.JACARANDA_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);
	public static final EntityType<ChestBoat> JACARANDA_CHEST_BOAT = register(
			FEntityTypeIds.JACARANDA_CHEST_BOAT,
			EntityType.Builder.of(chestBoatFactory(() -> FItems.JACARANDA_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);

	// PEAR
	public static final EntityType<Boat> PEAR_BOAT = register(
			FEntityTypeIds.PEAR_BOAT,
			EntityType.Builder.of(boatFactory(() -> FItems.PEAR_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);
	public static final EntityType<ChestBoat> PEAR_CHEST_BOAT = register(
			FEntityTypeIds.PEAR_CHEST_BOAT,
			EntityType.Builder.of(chestBoatFactory(() -> FItems.PEAR_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
	);

	// GOLEMS
	public static final EntityType<FGolem> GOLEM_AMETHYST = register(
			FEntityTypeIds.GOLEM_AMETHYST,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.AMETHYST)
	);
	public static final EntityType<FGolem> GOLEM_COAL = register(
			FEntityTypeIds.GOLEM_COAL,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.COAL)
	);
	public static final EntityType<FGolem> GOLEM_DIAMOND = register(
			FEntityTypeIds.GOLEM_DIAMOND,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.DIAMOND)
	);
	public static final EntityType<FGolem> GOLEM_EMERALD = register(
			FEntityTypeIds.GOLEM_EMERALD,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.EMERALD)
	);
	public static final EntityType<FGolem> GOLEM_GOLD = register(
			FEntityTypeIds.GOLEM_GOLD,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.GOLD)
	);
	public static final EntityType<FGolem> GOLEM_LAPIS = register(
			FEntityTypeIds.GOLEM_LAPIS,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.LAPIS)
	);
	public static final EntityType<FGolem> GOLEM_NETHERITE = register(
			FEntityTypeIds.GOLEM_NETHERITE,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.NETHERITE)
	);
	public static final EntityType<FGolem> GOLEM_REDSTONE = register(
			FEntityTypeIds.GOLEM_REDSTONE,
			EntityType.Builder.of(FGolem::new, MobCategory.MISC)
					.sized(1.4f, 2.7f)
					.clientTrackingRange(10),
			FGolem.createGolemAttributes(GolemStats.REDSTONE)
	);

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
	}

	private static <T extends LivingEntity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder, AttributeSupplier.Builder attributes) {
		EntityType<T> type = register(key, builder);
		FabricDefaultAttributeRegistry.register(type, attributes);
		return type;
	}

	private static EntityType.EntityFactory<Boat> boatFactory(final Supplier<Item> boatItem) {
		return (entityType, level) -> new Boat(entityType, level, boatItem);
	}

	private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(final Supplier<Item> dropItem) {
		return (entityType, level) -> new ChestBoat(entityType, level, dropItem);
	}

	public enum GolemStats {
		COAL(70.0, 0.23, 11.0),
		GOLD(80.0, 0.28, 13.0),
		REDSTONE(90.0, 0.30, 14.0),
		LAPIS(95.0, 0.25, 14.0),
		AMETHYST(105.0, 0.26, 16.0),
		EMERALD(120.0, 0.26, 17.0),
		DIAMOND(150.0, 0.26, 20.0),
		NETHERITE(200.0, 0.23, 25.0);

		public final double health, speed, damage;

		GolemStats(double health, double speed, double damage) {
			this.health = health;
			this.speed = speed;
			this.damage = damage;
		}
	}

	public static void init() {}
}
