package se.frejaware.Items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import se.frejaware.F;

public class FItemIds {
	// ----------------------
	// ITEMS
	// ----------------------

	// FOOD
	public static final ResourceKey<Item> PINEAPPLE = create("pineapple");
	public static final ResourceKey<Item> CHERRY = create("cherry");
	public static final ResourceKey<Item> BANANA = create("banana");
	public static final ResourceKey<Item> ORANGE = create("orange");
	public static final ResourceKey<Item> PEAR = create("pear");
	public static final ResourceKey<Item> CHOCOLATE_DIPPED_PEAR = create("chocolate_dipped_pear");
	public static final ResourceKey<Item> GOLDEN_PEAR = create("golden_pear");
	public static final ResourceKey<Item> ENCHANTED_GOLDEN_PEAR = create("enchanted_golden_pear");

	public static final ResourceKey<Item> POPPY_SEEDS = create("poppy_seeds");
	public static final ResourceKey<Item> SAFFRON = create("saffron");

	public static final ResourceKey<Item> CHOCOLATE_BOTTLE = create("chocolate_bottle");
	public static final ResourceKey<Item> MILK_BOTTLE = create("milk_bottle");
	public static final ResourceKey<Item> BERRY_JUICE_BOTTLE = create("berry_juice_bottle");
	public static final ResourceKey<Item> MILKSHAKE_BOTTLE = create("milkshake_bottle");
	public static final ResourceKey<Item> SAFFRON_MILK_BOTTLE = create("saffron_milk_bottle");

	public static final ResourceKey<Item> COCOA_BUTTER = create("cocoa_butter");
	public static final ResourceKey<Item> CHOCOLATE = create("chocolate");
	public static final ResourceKey<Item> CHOCOLATE_BAR = create("chocolate_bar");

	public static final ResourceKey<Item> FRUIT_SALAD = create("fruit_salad");
	public static final ResourceKey<Item> ICE_CREAM = create("ice_cream");
	public static final ResourceKey<Item> CHOCOLATE_ICE_CREAM = create("chocolate_ice_cream");

	// JACARANDA
	public static final ResourceKey<Item> JACARANDA_BOAT = create(
			"jacaranda_boat");
	public static final ResourceKey<Item> JACARANDA_CHEST_BOAT = create(
			"jacaranda_chest_boat");

	// PEAR
	public static final ResourceKey<Item> PEAR_BOAT = create(
			"pear_boat");
	public static final ResourceKey<Item> PEAR_CHEST_BOAT = create(
			"pear_chest_boat");

	// TRANSIUM
	public static final ResourceKey<Item> TRANSIUM = create(
			"transium");
	public static final ResourceKey<Item> TRANSIUM_DYE = create(
			"transium_dye");

	public static final ResourceKey<Item> TRANSIUM_PICKAXE = create(
			"transium_pickaxe");
	public static final ResourceKey<Item> TRANSIUM_SHOVEL = create(
			"transium_shovel");
	public static final ResourceKey<Item> TRANSIUM_AXE = create(
			"transium_axe");
	public static final ResourceKey<Item> TRANSIUM_HOE = create(
			"transium_hoe");
	public static final ResourceKey<Item> TRANSIUM_SWORD = create(
			"transium_sword");
	public static final ResourceKey<Item> TRANSIUM_SPEAR = create(
			"transium_spear");

	public static final ResourceKey<Item> TRANSIUM_HELMET = create(
			"transium_helmet");
	public static final ResourceKey<Item> TRANSIUM_CHESTPLATE = create(
			"transium_chestplate");
	public static final ResourceKey<Item> TRANSIUM_LEGGINGS = create(
			"transium_leggings");
	public static final ResourceKey<Item> TRANSIUM_BOOTS = create(
			"transium_boots");

	// ROSE QUARTZ
	public static final ResourceKey<Item> ROSE_QUARTZ =
			create("rose_quartz");
	public static final ResourceKey<Item> ROSE_QUARTZ_SHARD =
			create("rose_quartz_shard");
	public static final ResourceKey<Item> ROSE_QUARTZ_FRAGMENT =
			create("rose_quartz_fragment");
	public static final ResourceKey<Item> ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE =
			create("rose_quartz_upgrade_smithing_template");

	public static final ResourceKey<Item> ROSE_QUARTZ_PICKAXE =
			create("rose_quartz_pickaxe");
	public static final ResourceKey<Item> ROSE_QUARTZ_SHOVEL =
			create("rose_quartz_shovel");
	public static final ResourceKey<Item> ROSE_QUARTZ_AXE =
			create("rose_quartz_axe");
	public static final ResourceKey<Item> ROSE_QUARTZ_HOE =
			create("rose_quartz_hoe");
	public static final ResourceKey<Item> ROSE_QUARTZ_SWORD =
			create("rose_quartz_sword");
	public static final ResourceKey<Item> ROSE_QUARTZ_SPEAR =
			create("rose_quartz_spear");

	public static final ResourceKey<Item> ROSE_QUARTZ_SHIELD = create(
			"rose_quartz_shield");

	public static final ResourceKey<Item> ROSE_QUARTZ_HELMET = create(
			"rose_quartz_helmet");
	public static final ResourceKey<Item> ROSE_QUARTZ_CHESTPLATE = create(
			"rose_quartz_chestplate");
	public static final ResourceKey<Item> ROSE_QUARTZ_LEGGINGS = create(
			"rose_quartz_leggings");
	public static final ResourceKey<Item> ROSE_QUARTZ_BOOTS = create(
			"rose_quartz_boots");

	// GOLEM HEADS
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_AMETHYST =
			create("golem_spawn_egg_amethyst");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_COAL =
			create("golem_spawn_egg_coal");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_DIAMOND =
			create("golem_spawn_egg_diamond");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_EMERALD =
			create("golem_spawn_egg_emerald");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_GOLD =
			create("golem_spawn_egg_gold");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_LAPIS =
			create("golem_spawn_egg_lapis");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_NETHERITE =
			create("golem_spawn_egg_netherite");
	public static final ResourceKey<Item> GOLEM_SPAWN_EGG_REDSTONE =
			create("golem_spawn_egg_redstone");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	public static ResourceKey<Item> create(String name) {
		return ResourceKey.create(Registries.ITEM, F.id(name));
	}
}