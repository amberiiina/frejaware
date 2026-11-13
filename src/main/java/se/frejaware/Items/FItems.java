package se.frejaware.Items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.equipment.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import se.frejaware.Blocks.FBlockItemIds;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.F;
import se.frejaware.Items.Custom.*;
import se.frejaware.Shared.FItemTags;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FItems {
	// ----------------------
	// ITEMS
	// ----------------------

	// MOLLY
	public static final Item MOOBLOOM_SPAWN_EGG = registerSpawnEgg(
			FItemIds.MOOBLOOM_SPAWN_EGG, FEntityTypes.MOOBLOOM
	);
	public static final ResourceKey<JukeboxSong> RYM =
			ResourceKey.create(
					Registries.JUKEBOX_SONG,
					F.id("read_your_mind")
			);
	public static final Item MUSIC_DISC_RYM = registerItem(
			FItemIds.MUSIC_DISC_RYM,
			Item::new,
			new Item.Properties()
					.stacksTo(1)
					.rarity(Rarity.EPIC)
					.jukeboxPlayable(RYM)
	);
	public static final ResourceKey<DecoratedPotPattern> BUTTERFLY_PATTERN =
			ResourceKey.create(
					Registries.DECORATED_POT_PATTERN,
					F.id("butterfly")
			);
	public static final Item BUTTERFLY_POTTERY_SHERD = registerItem(
			FItemIds.BUTTERFLY_POTTERY_SHERD,
			Item::new,
			new Item.Properties()
					.rarity(Rarity.UNCOMMON)
					.potPattern(BUTTERFLY_PATTERN)
	);

	// BERRIES
	public static final Item BLUEBERRIES = registerItem(
			FBlockItemIds.BLUEBERRY_CROP,
			createBlockItemWithCustomItemName(FBlocks.BLUEBERRY_BUSH),
			new Item.Properties()
					.food(FFood.BLUEBERRIES)
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item BLACKBERRIES = registerItem(
			FBlockItemIds.BLACKBERRY_CROP,
			createBlockItemWithCustomItemName(FBlocks.BLACKBERRY_BUSH),
			new Item.Properties()
					.food(FFood.BLACKBERRIES)
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item PINKBERRIES = registerItem(
			FBlockItemIds.PINKBERRY_CROP,
			createBlockItemWithCustomItemName(FBlocks.PINKBERRY_BUSH),
			new Item.Properties()
					.food(FFood.PINKBERRIES)
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item BLOWBERRIES = registerItem(
			FBlockItemIds.BLOWBERRY_CROP,
			createBlockItemWithCustomItemName(FBlocks.BLOWBERRY_BUSH),
			new Item.Properties()
					.food(FFood.BLOWBERRIES, FFood.BLOWBERRIES_CONSUMABLE)
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item BERRY_JUICE_BOTTLE = registerItem(
			FItemIds.BERRY_JUICE_BOTTLE,
			Item::new,
			new Item.Properties()
					.food(FFood.BERRY_JUICE_BOTTLE, FFood.BERRY_JUICE_BOTTLE_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item JAM = registerItem(
			FItemIds.JAM,
			Item::new,
			new Item.Properties()
					.food(FFood.JAM, FFood.JAM_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item JAM_BLEND = registerItem(
			FItemIds.JAM_BLEND,
			Item::new,
			new Item.Properties()
	);

	// FRUITS
	public static final Item PEAR = registerItem(
			FItemIds.PEAR,
			Item::new,
			new Item.Properties()
					.food(FFood.PEAR)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)
	);
	public static final Item GOLDEN_PEAR = registerItem(
			FItemIds.GOLDEN_PEAR,
			Item::new,
			new Item.Properties()
					.food(FFood.GOLDEN_PEAR, FFood.GOLDEN_PEAR_CONSUMABLE)
					.rarity(Rarity.UNCOMMON)
	);
	public static final Item ENCHANTED_GOLDEN_PEAR = registerItem(
			FItemIds.ENCHANTED_GOLDEN_PEAR,
			Item::new,
			new Item.Properties()
					.food(FFood.ENCHANTED_GOLDEN_PEAR, FFood.ENCHANTED_GOLDEN_PEAR_CONSUMABLE)
					.rarity(Rarity.RARE)
					.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
	);
	public static final Item CHERRY = registerItem(
			FItemIds.CHERRY,
			Item::new,
			new Item.Properties()
					.food(FFood.CHERRY)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)
	);
	public static final Item ORANGE = registerItem(
			FItemIds.ORANGE,
			Item::new,
			new Item.Properties()
					.food(FFood.ORANGE)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)
	);
	public static final Item BANANA = registerItem(
			FItemIds.BANANA,
			Item::new,
			new Item.Properties()
					.food(FFood.BANANA)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)
	);
	public static final Item SAFFRON = registerItem(
			FItemIds.SAFFRON,
			Item::new,
			new Item.Properties()
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item SAFFRON_MILK_BOTTLE = registerItem(
			FItemIds.SAFFRON_MILK_BOTTLE,
			Item::new,
			new Item.Properties()
					.food(FFood.SAFFRON_MILK_BOTTLE, FFood.SAFFRON_MILK_BOTTLE_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item POPPY_SEEDS = registerItem(
			FItemIds.POPPY_SEEDS,
			createBlockItemWithCustomItemName(Blocks.POPPY),
			new Item.Properties()
					.food(FFood.POPPY_SEEDS, FFood.POPPY_SEEDS_CONSUMABLE)
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);
	public static final Item PINEAPPLE = registerItem(
			FItemIds.PINEAPPLE,
			Item::new,
			new Item.Properties()
					.food(FFood.PINEAPPLE)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)
	);
	public static final Item PINEAPPLE_SEEDS = registerItem(
			FBlockItemIds.PINEAPPLE_CROP,
			createBlockItemWithCustomItemName(FBlocks.PINEAPPLE),
			new Item.Properties()
					.compostable(ContextIntProviders.COMPOSTABLE_LOW)
	);

	// MILK
	public static final Item MILK_BOTTLE = registerItem(
			FItemIds.MILK_BOTTLE,
			Item::new,
			new Item.Properties()
					.food(FFood.MILK_BOTTLE, FFood.MILK_BOTTLE_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item MILKSHAKE_BOTTLE = registerItem(
			FItemIds.MILKSHAKE_BOTTLE,
			Item::new,
			new Item.Properties()
					.food(FFood.MILKSHAKE_BOTTLE, FFood.MILKSHAKE_BOTTLE_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item ICE_CREAM = registerItem(
			FItemIds.ICE_CREAM,
			Item::new,
			new Item.Properties()
					.food(FFood.ICE_CREAM)
					.craftRemainder(Items.BOWL)
					.usingConvertsTo(Items.BOWL)
	);

	// CHOCOLATE
	public static final Item COCOA_BUTTER = registerItem(
			FItemIds.COCOA_BUTTER,
			Item::new,
			new Item.Properties()
					.food(FFood.COCOA_BUTTER, FFood.COCOA_BUTTER_CONSUMABLE)
	);
	public static final Item CHOCOLATE = registerItem(
			FItemIds.CHOCOLATE,
			Item::new,
			new Item.Properties()
					.food(FFood.CHOCOLATE, FFood.CHOCOLATE_CONSUMABLE)
	);
	public static final Item CHOCOLATE_BAR = registerItem(
			FItemIds.CHOCOLATE_BAR,
			Item::new,
			new Item.Properties()
					.food(FFood.CHOCOLATE_BAR, FFood.CHOCOLATE_BAR_CONSUMABLE)
	);
	public static final Item CHOCOLATE_DIPPED_PEAR = registerItem(
			FItemIds.CHOCOLATE_DIPPED_PEAR,
			Item::new,
			new Item.Properties()
					.food(FFood.CHOCOLATE_DIPPED_PEAR)
	);
	public static final Item CHOCOLATE_BOTTLE = registerItem(
			FItemIds.CHOCOLATE_BOTTLE,
			Item::new,
			new Item.Properties()
					.food(FFood.CHOCOLATE_BOTTLE, FFood.CHOCOLATE_BOTTLE_CONSUMABLE)
					.craftRemainder(Items.GLASS_BOTTLE)
					.usingConvertsTo(Items.GLASS_BOTTLE)
	);
	public static final Item CHOCOLATE_ICE_CREAM = registerItem(
			FItemIds.CHOCOLATE_ICE_CREAM,
			Item::new,
			new Item.Properties()
					.food(FFood.CHOCOLATE_ICE_CREAM)
					.craftRemainder(Items.BOWL)
					.usingConvertsTo(Items.BOWL)
	);

	// FINISHED FOOD
	public static final Item FRUIT_SALAD = registerItem(
			FItemIds.FRUIT_SALAD,
			Item::new,
			new Item.Properties()
					.food(FFood.FRUIT_SALAD, FFood.FRUIT_SALAD_CONSUMABLE)
					.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH)
					.craftRemainder(Items.BOWL)
					.usingConvertsTo(Items.BOWL)
	);
	public static final Item PANCAKE = registerItem(
			FItemIds.PANCAKE,
			Item::new,
			new Item.Properties()
					.food(FFood.PANCAKE)
	);
	public static final Item SWEDISH_PANCAKE = registerItem(
			FItemIds.SWEDISH_PANCAKE,
			Item::new,
			new Item.Properties()
					.food(FFood.SWEDISH_PANCAKE)
	);

	// JACARANDA
	public static final Item JACARANDA_SIGN = registerBlock(
			FBlockItemIds.JACARANDA_SIGN,
			FBlocks.JACARANDA_SIGN,
			(b, p) -> new StandingAndWallBlockItem(b, FBlocks.JACARANDA_WALL_SIGN, Direction.DOWN, p),			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE)
					.stacksTo(16)
					.signText()
	);
	public static final Item JACARANDA_HANGING_SIGN = registerBlock(
			FBlockItemIds.JACARANDA_HANGING_SIGN,
			FBlocks.JACARANDA_HANGING_SIGN,
			(b, p) -> new HangingSignItem(b, FBlocks.JACARANDA_WALL_HANGING_SIGN, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_HANGING_SIGNS)
					.stacksTo(16)
					.signText()
	);
	public static final Item JACARANDA_BOAT = registerItem(
			FItemIds.JACARANDA_BOAT,
			p -> new BoatItem(FEntityTypes.JACARANDA_BOAT, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_BOATS)
					.stacksTo(1)
	);
	public static final Item JACARANDA_CHEST_BOAT = registerItem(
			FItemIds.JACARANDA_CHEST_BOAT,
			p -> new BoatItem(FEntityTypes.JACARANDA_CHEST_BOAT, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_BOATS)
					.stacksTo(1)
	);

	// PEAR
	public static final Item PEAR_SIGN = registerBlock(
			FBlockItemIds.PEAR_SIGN,
			FBlocks.PEAR_SIGN,
			(b, p) -> new StandingAndWallBlockItem(b, FBlocks.PEAR_WALL_SIGN, Direction.DOWN, p),			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE)
					.stacksTo(16)
					.signText()
	);
	public static final Item PEAR_HANGING_SIGN = registerBlock(
			FBlockItemIds.PEAR_HANGING_SIGN,
			FBlocks.PEAR_HANGING_SIGN,
			(b, p) -> new HangingSignItem(b, FBlocks.PEAR_WALL_HANGING_SIGN, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_HANGING_SIGNS)
					.stacksTo(16)
					.signText()
	);
	public static final Item PEAR_BOAT = registerItem(
			FItemIds.PEAR_BOAT,
			p -> new BoatItem(FEntityTypes.PEAR_BOAT, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_BOATS)
					.stacksTo(1)
	);
	public static final Item PEAR_CHEST_BOAT = registerItem(
			FItemIds.PEAR_CHEST_BOAT,
			p -> new BoatItem(FEntityTypes.PEAR_CHEST_BOAT, p),
			new Item.Properties()
					.cookingFuel(ContextIntProviders.COOKING_TIME_BOATS)
					.stacksTo(1)
	);

	// TRANSIUM
	public static final Item TRANSIUM = registerItem(
			FItemIds.TRANSIUM,
			Item::new,
			new Item.Properties()
					.rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_DYE = registerItem(
			FItemIds.TRANSIUM_DYE,
			Item::new,
			new Item.Properties()
					.rarity(Rarity.EPIC)
	);

	// TRANSIUM TOOLS
	public static final Item TRANSIUM_PICKAXE = registerPickaxe(
			FItemIds.TRANSIUM_PICKAXE,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_SHOVEL = registerShovel(
			FItemIds.TRANSIUM_SHOVEL,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_AXE = registerAxe(
			FItemIds.TRANSIUM_AXE,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_HOE = registerHoe(
			FItemIds.TRANSIUM_HOE,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_SWORD = registerSword(
			FItemIds.TRANSIUM_SWORD,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_SPEAR = registerSpear(
			FItemIds.TRANSIUM_SPEAR,
			FMaterials.TRANSIUM_TOOL_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);

	// TRANSIUM ARMOR
	public static final Item TRANSIUM_HELMET = registerHelmet(
			FItemIds.TRANSIUM_HELMET,
			FMaterials.TRANSIUM_ARMOR_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_CHESTPLATE = registerChestplate(
			FItemIds.TRANSIUM_CHESTPLATE,
			FMaterials.TRANSIUM_ARMOR_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_LEGGINGS = registerLeggings(
			FItemIds.TRANSIUM_LEGGINGS,
			FMaterials.TRANSIUM_ARMOR_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);
	public static final Item TRANSIUM_BOOTS = registerBoots(
			FItemIds.TRANSIUM_BOOTS,
			FMaterials.TRANSIUM_ARMOR_MATERIAL,
			new Item.Properties().rarity(Rarity.EPIC)
	);

	// ROSE QUARTZ
	public static final Item ROSE_QUARTZ = registerItem(
			FItemIds.ROSE_QUARTZ,
			Item::new,
			new Item.Properties()
					.rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_SHARD = registerItem(
			FItemIds.ROSE_QUARTZ_SHARD,
			Item::new,
			new Item.Properties()
					.trimMaterial(FTrimMaterials.ROSE_QUARTZ)
					.rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_FRAGMENT = registerItem(
			FItemIds.ROSE_QUARTZ_FRAGMENT,
			Item::new,
			new Item.Properties()
					.rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE = registerItem(
			FItemIds.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE,
			FSmithingTemplateItem::createRoseQuartzUpgradeTemplate,
			new Item.Properties()
					.rarity(Rarity.EPIC)
	);

	// ROSE QUARTZ TOOLS
	public static final Item ROSE_QUARTZ_PICKAXE = registerPickaxe(
			FItemIds.ROSE_QUARTZ_PICKAXE,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_SHOVEL = registerShovel(
			FItemIds.ROSE_QUARTZ_SHOVEL,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_AXE = registerAxe(
			FItemIds.ROSE_QUARTZ_AXE,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_HOE = registerHoe(
			FItemIds.ROSE_QUARTZ_HOE,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_SWORD = registerSword(
			FItemIds.ROSE_QUARTZ_SWORD,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_SPEAR = registerSpear(
			FItemIds.ROSE_QUARTZ_SPEAR,
			FMaterials.ROSE_QUARTZ_TOOL_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_SHIELD = registerShield(
			FItemIds.ROSE_QUARTZ_SHIELD,
			FItemTags.REPAIRS_ROSE_QUARTZ,
			1008,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);

	// ROSE QUARTZ ARMOR
	public static final Item ROSE_QUARTZ_HELMET = registerHelmet(
			FItemIds.ROSE_QUARTZ_HELMET,
			FMaterials.ROSE_QUARTZ_ARMOR_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_CHESTPLATE = registerChestplate(
			FItemIds.ROSE_QUARTZ_CHESTPLATE,
			FMaterials.ROSE_QUARTZ_ARMOR_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_LEGGINGS = registerLeggings(
			FItemIds.ROSE_QUARTZ_LEGGINGS,
			FMaterials.ROSE_QUARTZ_ARMOR_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);
	public static final Item ROSE_QUARTZ_BOOTS = registerBoots(
			FItemIds.ROSE_QUARTZ_BOOTS,
			FMaterials.ROSE_QUARTZ_ARMOR_MATERIAL,
			new Item.Properties().fireResistant().rarity(Rarity.EPIC)
	);

	// GOLEM SPAWN EGGS
	public static final Item GOLEM_SPAWN_EGG_AMETHYST = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_AMETHYST,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_AMETHYST)
	);
	public static final Item GOLEM_SPAWN_EGG_COAL = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_COAL,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_COAL)
	);
	public static final Item GOLEM_SPAWN_EGG_DIAMOND = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_DIAMOND,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_DIAMOND)
	);
	public static final Item GOLEM_SPAWN_EGG_EMERALD = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_EMERALD,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_EMERALD)
	);
	public static final Item GOLEM_SPAWN_EGG_GOLD = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_GOLD,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_GOLD)
	);
	public static final Item GOLEM_SPAWN_EGG_LAPIS = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_LAPIS,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_LAPIS)
	);
	public static final Item GOLEM_SPAWN_EGG_NETHERITE = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_NETHERITE,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_NETHERITE)
	);
	public static final Item GOLEM_SPAWN_EGG_REDSTONE = registerItem(
			FItemIds.GOLEM_SPAWN_EGG_REDSTONE,
			SpawnEggItem::new,
			new Item.Properties().spawnEgg(FEntityTypes.GOLEM_REDSTONE)
	);

	// ----------------------
	// FUNCTIONS
	// ----------------------

	// TOOLS
	public static Item registerPickaxe(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.pickaxe(
						toolMaterial,
						1.0F,
						-2.8F
				)
		);
	}
	public static Item registerShovel(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.shovel(
						toolMaterial,
						1.5F,
						-3.0F
				)
		);
	}
	public static Item registerAxe(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.axe(
						toolMaterial,
						5.0F,
						-3.0F
				)
		);
	}
	public static Item registerHoe(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.hoe(
						toolMaterial,
						-3.0F,
						0.0F
				)
		);
	}
	public static Item registerSword(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.sword(
						toolMaterial,
						3.0F,
						-2.4F
				)
		);
	}
	public static Item registerSpear(
			ResourceKey<Item> itemKey,
			ToolMaterial toolMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.spear(
						toolMaterial,
						1.15F,
						1.2F,
						0.4F,
						2.5F,
						9.0F,
						5.5F,
						5.1F,
						8.75F,
						4.6F
				)
		);
	}
	public static Item registerShield(
			ResourceKey<Item> itemKey,
			TagKey<Item> repairableTag,
			int durability,
			Item.Properties settings) {
		return registerItem(
				itemKey, ShieldItem::new, settings
						.durability(durability)
						.component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
						.repairable(repairableTag)
						.equippableUnswappable(EquipmentSlot.OFFHAND)
						.delayedComponent(
								DataComponents.BLOCKS_ATTACKS,
								(context) -> new BlocksAttacks(
										0.25F,
										1.0F,
										List.of(new BlocksAttacks.DamageReduction(
												90.0F,
												Optional.empty(),
												0.0F,
												1.0F
										)),
										new BlocksAttacks.ItemDamageFunction(
												3.0F,
												1.0F,
												1.0F
										),
										Optional.of(
												context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)
										),
										Optional.of(SoundEvents.SHIELD_BLOCK),
										Optional.of(SoundEvents.SHIELD_BREAK)
								)
						)
						.component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK)
		);
	}

	// ARMOR
	public static Item registerHelmet(
			ResourceKey<Item> itemKey,
			ArmorMaterial armorMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.humanoidArmor(
						armorMaterial,
						ArmorType.HELMET
				)
		);
	}
	public static Item registerChestplate(
			ResourceKey<Item> itemKey,
			ArmorMaterial armorMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.humanoidArmor(
						armorMaterial,
						ArmorType.CHESTPLATE
				)
		);
	}
	public static Item registerLeggings(
			ResourceKey<Item> itemKey,
			ArmorMaterial armorMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.humanoidArmor(
						armorMaterial,
						ArmorType.LEGGINGS
				)
		);
	}
	public static Item registerBoots(
			ResourceKey<Item> itemKey,
			ArmorMaterial armorMaterial,
			Item.Properties settings) {
		return registerItem(
				itemKey, Item::new, settings.humanoidArmor(
						armorMaterial,
						ArmorType.BOOTS
				)
		);
	}

	// ----------------------
	// REGISTER
	// ----------------------

	public static Item registerItem(
			ResourceKey<Item> itemKey,
			Function<Item.Properties, Item> itemFactory,
			Item.Properties settings) {
		Item item = itemFactory.apply(settings.setId(itemKey));

		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}

		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

	private static Item registerItem(
			final BlockItemId id,
			final Function<Item.Properties, Item> itemFactory,
			final Item.Properties properties) {
		return registerItem(id.item(), itemFactory, properties);
	}

	private static Item registerBlock(
			final BlockItemId id,
			final Block block,
			final BiFunction<Block, Item.Properties, Item> itemFactory,
			final Item.Properties properties) {
		return registerItem(id.item(),
				(p) -> itemFactory.apply(block, p),
				properties.useBlockDescriptionPrefix()
						.requiredFeatures(block.requiredFeatures())
		);
	}

	private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(
			final Block block) {
		return (p) -> new BlockItem(block, p.useItemDescriptionPrefix());
	}

	private static Item registerSpawnEgg(final ResourceKey<Item> id, final EntityType<?> type) {
		return registerItem(id, SpawnEggItem::new, (new Item.Properties()).spawnEgg(type));
	}

	public static void init() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
				.register(creativeTab ->
						creativeTab.accept(MUSIC_DISC_RYM)
				);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS)
				.register(creativeTab -> {
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_AMETHYST);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_COAL);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_DIAMOND);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_EMERALD);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_GOLD);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_LAPIS);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_NETHERITE);
					creativeTab.accept(FItems.GOLEM_SPAWN_EGG_REDSTONE);

					creativeTab.accept(MOOBLOOM_SPAWN_EGG);
				});
	}
}