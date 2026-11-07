package se.frejaware.Shared;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.Items.FItems;

public class FCreativeTabs {
	// ----------------------
	// TABS
	// ----------------------

	public static final ResourceKey<CreativeModeTab> FREJAWARE_TAB_KEY =
			ResourceKey.create(
					Registries.CREATIVE_MODE_TAB,
					F.id("frejaware")
			);
	public static final ResourceKey<CreativeModeTab> EQUIPMENT_TAB_KEY =
			ResourceKey.create(
					Registries.CREATIVE_MODE_TAB,
					F.id("equipment")
			);
	public static final ResourceKey<CreativeModeTab> FOOD_TAB_KEY =
			ResourceKey.create(
					Registries.CREATIVE_MODE_TAB,
					F.id("food")
			);
	public static final ResourceKey<CreativeModeTab> FLOWERS_TAB_KEY =
			ResourceKey.create(
					Registries.CREATIVE_MODE_TAB,
					F.id("flowers")
			);
	public static final ResourceKey<CreativeModeTab> PEAR_MEADOW_TAB_KEY =
			ResourceKey.create(
					Registries.CREATIVE_MODE_TAB,
					F.id("pear_meadow")
			);

	// ----------------------
	// FREJAWARE
	// ----------------------

	public static final CreativeModeTab FREJAWARE_TAB =
			FabricCreativeModeTab.builder()
					.icon(() -> new ItemStack(FBlocks.GOLEM_HEAD_DIAMOND))
					.title(Component.translatable("creativetab.frejaware"))
					.displayItems((params, output) -> {
						// METAL BLOCKS
						output.accept(FBlocks.TRANSIUM_BLOCK);

						output.accept(FBlocks.ROSE_QUARTZ_ORE);
						output.accept(FBlocks.ROSE_QUARTZ_BLOCK);

						output.accept(FBlocks.ROSE_QUARTZ_BRICKS);
						output.accept(FBlocks.ROSE_QUARTZ_BRICK_STAIRS);
						output.accept(FBlocks.ROSE_QUARTZ_BRICK_SLAB);
						output.accept(FBlocks.ROSE_QUARTZ_BRICK_WALL);
						output.accept(FBlocks.CHISELED_ROSE_QUARTZ_BRICKS);

						output.accept(FBlocks.ROSE_QUARTZ_DOOR);
						output.accept(FBlocks.ROSE_QUARTZ_TRAPDOOR);
						output.accept(FBlocks.ROSE_QUARTZ_BUTTON);
						output.accept(FBlocks.ROSE_QUARTZ_PRESSURE_PLATE);
						output.accept(FBlocks.ROSE_QUARTZ_LADDER);
						output.accept(FBlocks.ROSE_QUARTZ_BARS);
						output.accept(FBlocks.ROSE_QUARTZ_CHAIN);
						output.accept(FBlocks.ROSE_QUARTZ_LANTERN);

						// GOLEM HEADS
						output.accept(FBlocks.GOLEM_HEAD_AMETHYST);
						output.accept(FBlocks.GOLEM_HEAD_COAL);
						output.accept(FBlocks.GOLEM_HEAD_GOLD);
						output.accept(FBlocks.GOLEM_HEAD_IRON);
						output.accept(FBlocks.GOLEM_HEAD_LAPIS);
						output.accept(FBlocks.GOLEM_HEAD_DIAMOND);
						output.accept(FBlocks.GOLEM_HEAD_EMERALD);
						output.accept(FBlocks.GOLEM_HEAD_NETHERITE);
						output.accept(FBlocks.GOLEM_HEAD_REDSTONE);

						// GOLEM SPAWN EGGS
						output.accept(FItems.GOLEM_SPAWN_EGG_AMETHYST);
						output.accept(FItems.GOLEM_SPAWN_EGG_COAL);
						output.accept(FItems.GOLEM_SPAWN_EGG_DIAMOND);
						output.accept(FItems.GOLEM_SPAWN_EGG_EMERALD);
						output.accept(FItems.GOLEM_SPAWN_EGG_GOLD);
						output.accept(FItems.GOLEM_SPAWN_EGG_LAPIS);
						output.accept(FItems.GOLEM_SPAWN_EGG_NETHERITE);
						output.accept(FItems.GOLEM_SPAWN_EGG_REDSTONE);
					})
					.build();

	// ----------------------
	// EQUIPMENT
	// ----------------------

	public static final CreativeModeTab EQUIPMENT_TAB =
			FabricCreativeModeTab.builder()
					.icon(() -> new ItemStack(FItems.ROSE_QUARTZ_CHESTPLATE))
					.title(Component.translatable("creativetab.equipment"))
					.displayItems((params, output) -> {
						// TRANSIUM
						output.accept(FItems.TRANSIUM);
						output.accept(FItems.TRANSIUM_DYE);

						output.accept(FItems.TRANSIUM_PICKAXE);
						output.accept(FItems.TRANSIUM_SHOVEL);
						output.accept(FItems.TRANSIUM_AXE);
						output.accept(FItems.TRANSIUM_HOE);
						output.accept(FItems.TRANSIUM_SWORD);
						output.accept(FItems.TRANSIUM_SPEAR);

						output.accept(FItems.TRANSIUM_HELMET);
						output.accept(FItems.TRANSIUM_CHESTPLATE);
						output.accept(FItems.TRANSIUM_LEGGINGS);
						output.accept(FItems.TRANSIUM_BOOTS);

						// ROSE QUARTZ
						output.accept(FItems.ROSE_QUARTZ);
						output.accept(FItems.ROSE_QUARTZ_SHARD);
						output.accept(FItems.ROSE_QUARTZ_FRAGMENT);
						output.accept(FItems.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE);

						output.accept(FItems.ROSE_QUARTZ_PICKAXE);
						output.accept(FItems.ROSE_QUARTZ_SHOVEL);
						output.accept(FItems.ROSE_QUARTZ_AXE);
						output.accept(FItems.ROSE_QUARTZ_HOE);
						output.accept(FItems.ROSE_QUARTZ_SWORD);
						output.accept(FItems.ROSE_QUARTZ_SPEAR);

						output.accept(FItems.ROSE_QUARTZ_SHIELD);

						output.accept(FItems.ROSE_QUARTZ_HELMET);
						output.accept(FItems.ROSE_QUARTZ_CHESTPLATE);
						output.accept(FItems.ROSE_QUARTZ_LEGGINGS);
						output.accept(FItems.ROSE_QUARTZ_BOOTS);
					})
					.build();

	// ----------------------
	// FOOD
	// ----------------------

	public static final CreativeModeTab FOOD_TAB =
			FabricCreativeModeTab.builder()
					.icon(() -> new ItemStack(FItems.PEAR))
					.title(Component.translatable("creativetab.food"))
					.displayItems((params, output) -> {
						output.accept(FItems.PEAR);
						output.accept(FItems.GOLDEN_PEAR);
						output.accept(FItems.ENCHANTED_GOLDEN_PEAR);
						output.accept(FItems.CHERRY);
						output.accept(FItems.BANANA);
						output.accept(FItems.ORANGE);

						output.accept(FItems.CHOCOLATE_BOTTLE);
						output.accept(FItems.MILK_BOTTLE);
						output.accept(FItems.BERRY_JUICE_BOTTLE);
						output.accept(FItems.MILKSHAKE_BOTTLE);

						output.accept(FItems.COCOA_BUTTER);
						output.accept(FItems.CHOCOLATE);
						output.accept(FItems.CHOCOLATE_BAR);
						output.accept(FItems.CHOCOLATE_DIPPED_PEAR);

						output.accept(FItems.BLACKBERRIES);
						output.accept(FItems.BLOWBERRIES);
						output.accept(FItems.BLUEBERRIES);
						output.accept(FItems.PINKBERRIES);

						output.accept(FItems.FRUIT_SALAD);
						output.accept(FItems.ICE_CREAM);
						output.accept(FItems.CHOCOLATE_ICE_CREAM);
					})
					.build();

	// ----------------------
	// FLOWERS
	// ----------------------

	public static final CreativeModeTab FLOWERS_TAB =
			FabricCreativeModeTab.builder()
					.icon(() -> new ItemStack(FBlocks.WHITE_ORCHID))
					.title(Component.translatable("creativetab.flowers"))
					.displayItems((params, output) -> {
						output.accept(FBlocks.WHITE_CACTUS_FLOWER);
						output.accept(FBlocks.YELLOW_CACTUS_FLOWER);
						output.accept(FBlocks.WHITE_ORCHID);
						output.accept(FBlocks.YELLOW_TULIP);
						output.accept(FBlocks.ROUND_BUSH);
						output.accept(FBlocks.WHITE_HIBISCUS);
						output.accept(FBlocks.YELLOW_HIBISCUS);
						output.accept(FBlocks.WHITE_CROCUS);
						output.accept(FBlocks.LILAC_CROCUS);
						output.accept(FBlocks.PURPLE_CROCUS);
						output.accept(FBlocks.LILY_OF_THE_GLADE);
					})
					.build();

	// ----------------------
	// PEAR MEADOW
	// ----------------------

	public static final CreativeModeTab PEAR_MEADOW_TAB =
			FabricCreativeModeTab.builder()
					.icon(() -> new ItemStack(FBlocks.PEAR_SAPLING))
					.title(Component.translatable("creativetab.pear_meadow"))
					.displayItems((params, output) -> {
						output.accept(FBlocks.PEAR_LOG);
						output.accept(FBlocks.STRIPPED_PEAR_LOG);
						output.accept(FBlocks.PEAR_WOOD);
						output.accept(FBlocks.STRIPPED_PEAR_WOOD);

						output.accept(FBlocks.PEAR_LEAVES);
						output.accept(FBlocks.WHITE_PETALS);
						output.accept(FBlocks.PEAR_SAPLING);

						output.accept(FBlocks.PEAR_PLANKS);
						output.accept(FBlocks.PEAR_STAIRS);
						output.accept(FBlocks.PEAR_SLAB);
						output.accept(FBlocks.PEAR_FENCE);
						output.accept(FBlocks.PEAR_FENCE_GATE);
						output.accept(FBlocks.PEAR_DOOR);
						output.accept(FBlocks.PEAR_TRAPDOOR);
						output.accept(FBlocks.PEAR_BUTTON);
						output.accept(FBlocks.PEAR_PRESSURE_PLATE);
						output.accept(FBlocks.PEAR_SHELF);

						output.accept(FItems.PEAR_SIGN);
						output.accept(FItems.PEAR_HANGING_SIGN);
						output.accept(FItems.PEAR_BOAT);
						output.accept(FItems.PEAR_CHEST_BOAT);
					})
					.build();

	// ----------------------
	// FUNCTIONS
	// ----------------------

	public static void initialize() {
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				FREJAWARE_TAB_KEY,
				FREJAWARE_TAB
		);
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				EQUIPMENT_TAB_KEY,
				EQUIPMENT_TAB
		);
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				FOOD_TAB_KEY,
				FOOD_TAB
		);
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				FLOWERS_TAB_KEY,
				FLOWERS_TAB
		);
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				PEAR_MEADOW_TAB_KEY,
				PEAR_MEADOW_TAB
		);
	}
}