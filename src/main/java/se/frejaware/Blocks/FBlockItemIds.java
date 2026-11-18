package se.frejaware.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import se.frejaware.F;

public class FBlockItemIds {
	// ----------------------
	// BLOCKS
	// ----------------------

	// MOLLY
	public static final BlockItemId IRON_BELL = create("iron_bell");
	public static final BlockItemId PEACH_SEASHELL = create("peach_seashell");
	public static final BlockItemId PEARL_SEASHELL = create("pearl_seashell");
	public static final BlockItemId ORCHID_SEASHELL = create("orchid_seashell");

	// VANILLA BLOCK VARIANTS
	public static final BlockItemId SNOW_STAIRS = create("snow_stairs");
	public static final BlockItemId SNOW_SLAB = create("snow_slab");
	public static final BlockItemId ICE_STAIRS = create("ice_stairs");
	public static final BlockItemId ICE_SLAB = create("ice_slab");
	public static final BlockItemId PACKED_ICE_STAIRS = create("packed_ice_stairs");
	public static final BlockItemId PACKED_ICE_SLAB = create("packed_ice_slab");
	public static final BlockItemId BLUE_ICE_STAIRS = create("blue_ice_stairs");
	public static final BlockItemId BLUE_ICE_SLAB = create("blue_ice_slab");

	// BLOM
	public static final BlockItemId WHITE_ORCHID = create("white_orchid");
	public static final BlockItemId YELLOW_TULIP = create("yellow_tulip");
	public static final BlockItemId WHITE_HIBISCUS = create("white_hibiscus");
	public static final BlockItemId YELLOW_HIBISCUS = create("yellow_hibiscus");

	public static final BlockItemId WHITE_CROCUS = create("white_crocus");
	public static final BlockItemId LILAC_CROCUS = create("lilac_crocus");
	public static final BlockItemId PURPLE_CROCUS = create("purple_crocus");
	public static final BlockItemId LILY_OF_THE_GLADE = create("lily_of_the_glade");

	public static final BlockItemId WHITE_CACTUS_FLOWER = create("white_cactus_flower");
	public static final BlockItemId YELLOW_CACTUS_FLOWER = create("yellow_cactus_flower");
	public static final BlockItemId WHITE_ALLIUM = create("white_allium");

	public static final BlockItemId BLUE_SUCCULENT = create("blue_succulent");
	public static final BlockItemId RED_SUCCULENT = create("red_succulent");
	public static final BlockItemId GREEN_SUCCULENT = create("green_succulent");
	public static final BlockItemId TEAL_SUCCULENT = create("teal_succulent");
	public static final BlockItemId PURPLE_SUCCULENT = create("purple_succulent");
	public static final BlockItemId BROWN_SUCCULENT = create("brown_succulent");
	public static final BlockItemId YELLOW_SUCCULENT = create("yellow_succulent");

	public static final BlockItemId WHITE_PETALS = create("white_petals");
	public static final BlockItemId PURPLE_PETALS = create("purple_petals");
	public static final BlockItemId LIGHT_BLUE_PETALS = create("light_blue_petals");

	public static final BlockItemId ROUND_BUSH = create("round_bush");
	public static final BlockItemId DRY_CACTUS = create("dry_cactus");

	// FOOD
	public static final BlockItemId PINEAPPLE_CROP = create("pineapple", "pineapple_seeds");
	public static final BlockItemId BLUEBERRY_CROP = create("blueberry_crop");
	public static final BlockItemId BLACKBERRY_CROP = create("blackberry_crop");
	public static final BlockItemId PINKBERRY_CROP = create("pinkberry_crop");
	public static final BlockItemId BLOWBERRY_CROP = create("blowberry_crop");

	// BLUE SPRUCE WOOD
	public static final BlockItemId BLUE_SPRUCE_LOG = create("blue_spruce_log");
	public static final BlockItemId STRIPPED_BLUE_SPRUCE_LOG = create("stripped_blue_spruce_log");
	public static final BlockItemId BLUE_SPRUCE_WOOD = create("blue_spruce_wood");
	public static final BlockItemId STRIPPED_BLUE_SPRUCE_WOOD = create("stripped_blue_spruce_wood");

	public static final BlockItemId BLUE_SPRUCE_LEAVES = create("blue_spruce_leaves");
	public static final BlockItemId BLUE_SPRUCE_SAPLING = create("blue_spruce_sapling");

	public static final BlockItemId BLUE_SPRUCE_PLANKS = create("blue_spruce_planks");
	public static final BlockItemId BLUE_SPRUCE_STAIRS = create("blue_spruce_stairs");
	public static final BlockItemId BLUE_SPRUCE_SLAB = create("blue_spruce_slab");
	public static final BlockItemId BLUE_SPRUCE_FENCE = create("blue_spruce_fence");
	public static final BlockItemId BLUE_SPRUCE_FENCE_GATE = create("blue_spruce_fence_gate");
	public static final BlockItemId BLUE_SPRUCE_DOOR = create("blue_spruce_door");
	public static final BlockItemId BLUE_SPRUCE_TRAPDOOR = create("blue_spruce_trapdoor");
	public static final BlockItemId BLUE_SPRUCE_BUTTON = create("blue_spruce_button");
	public static final BlockItemId BLUE_SPRUCE_PRESSURE_PLATE = create("blue_spruce_pressure_plate");
	public static final BlockItemId BLUE_SPRUCE_SIGN = create("blue_spruce_sign");
	public static final BlockItemId BLUE_SPRUCE_HANGING_SIGN = create("blue_spruce_hanging_sign");
	public static final BlockItemId BLUE_SPRUCE_SHELF = create("blue_spruce_shelf");

	// ORANGE
	public static final BlockItemId ORANGE_LEAVES = create("orange_leaves");
	public static final BlockItemId ORANGE_SAPLING = create("orange_sapling");

	// JACARANDA WOOD
	public static final BlockItemId JACARANDA_LOG = create("jacaranda_log");
	public static final BlockItemId STRIPPED_JACARANDA_LOG = create("stripped_jacaranda_log");
	public static final BlockItemId JACARANDA_WOOD = create("jacaranda_wood");
	public static final BlockItemId STRIPPED_JACARANDA_WOOD = create("stripped_jacaranda_wood");

	public static final BlockItemId JACARANDA_LEAVES = create("jacaranda_leaves");
	public static final BlockItemId JACARANDA_SAPLING = create("jacaranda_sapling");

	public static final BlockItemId JACARANDA_PLANKS = create("jacaranda_planks");
	public static final BlockItemId JACARANDA_STAIRS = create("jacaranda_stairs");
	public static final BlockItemId JACARANDA_SLAB = create("jacaranda_slab");
	public static final BlockItemId JACARANDA_FENCE = create("jacaranda_fence");
	public static final BlockItemId JACARANDA_FENCE_GATE = create("jacaranda_fence_gate");
	public static final BlockItemId JACARANDA_DOOR = create("jacaranda_door");
	public static final BlockItemId JACARANDA_TRAPDOOR = create("jacaranda_trapdoor");
	public static final BlockItemId JACARANDA_BUTTON = create("jacaranda_button");
	public static final BlockItemId JACARANDA_PRESSURE_PLATE = create("jacaranda_pressure_plate");
	public static final BlockItemId JACARANDA_SIGN = create("jacaranda_sign");
	public static final BlockItemId JACARANDA_HANGING_SIGN = create("jacaranda_hanging_sign");
	public static final BlockItemId JACARANDA_SHELF = create("jacaranda_shelf");

	// PEAR WOOD
	public static final BlockItemId PEAR_LOG = create("pear_log");
	public static final BlockItemId STRIPPED_PEAR_LOG = create("stripped_pear_log");
	public static final BlockItemId PEAR_WOOD = create("pear_wood");
	public static final BlockItemId STRIPPED_PEAR_WOOD = create("stripped_pear_wood");

	public static final BlockItemId PEAR_LEAVES = create("pear_leaves");
	public static final BlockItemId PEAR_SAPLING = create("pear_sapling");

	public static final BlockItemId PEAR_PLANKS = create("pear_planks");
	public static final BlockItemId PEAR_STAIRS = create("pear_stairs");
	public static final BlockItemId PEAR_SLAB = create("pear_slab");
	public static final BlockItemId PEAR_FENCE = create("pear_fence");
	public static final BlockItemId PEAR_FENCE_GATE = create("pear_fence_gate");
	public static final BlockItemId PEAR_DOOR = create("pear_door");
	public static final BlockItemId PEAR_TRAPDOOR = create("pear_trapdoor");
	public static final BlockItemId PEAR_BUTTON = create("pear_button");
	public static final BlockItemId PEAR_PRESSURE_PLATE = create("pear_pressure_plate");
	public static final BlockItemId PEAR_SIGN = create("pear_sign");
	public static final BlockItemId PEAR_HANGING_SIGN = create("pear_hanging_sign");
	public static final BlockItemId PEAR_SHELF = create("pear_shelf");

	// TRANSIUM
	public static final BlockItemId TRANSIUM_BLOCK = create("transium_block");

	// ROSE QUARTZ
	public static final BlockItemId ROSE_QUARTZ_ORE = create("rose_quartz_ore");

	public static final BlockItemId ROSE_QUARTZ_BLOCK = create("rose_quartz_block");
	public static final BlockItemId ROSE_QUARTZ_BRICKS = create("rose_quartz_bricks");
	public static final BlockItemId ROSE_QUARTZ_BRICK_STAIRS = create("rose_quartz_brick_stairs");
	public static final BlockItemId ROSE_QUARTZ_BRICK_SLAB = create("rose_quartz_brick_slab");
	public static final BlockItemId ROSE_QUARTZ_BRICK_WALL = create("rose_quartz_brick_wall");
	public static final BlockItemId CHISELED_ROSE_QUARTZ_BRICKS = create("chiseled_rose_quartz_bricks");
	public static final BlockItemId ROSE_QUARTZ_DOOR = create("rose_quartz_door");
	public static final BlockItemId ROSE_QUARTZ_TRAPDOOR = create("rose_quartz_trapdoor");
	public static final BlockItemId ROSE_QUARTZ_LADDER = create("rose_quartz_ladder");
	public static final BlockItemId ROSE_QUARTZ_BARS = create("rose_quartz_bars");
	public static final BlockItemId ROSE_QUARTZ_CHAIN = create("rose_quartz_chain");
	public static final BlockItemId ROSE_QUARTZ_LANTERN = create("rose_quartz_lantern");
	public static final BlockItemId ROSE_QUARTZ_PRESSURE_PLATE = create("rose_quartz_pressure_plate");
	public static final BlockItemId ROSE_QUARTZ_BUTTON = create("rose_quartz_button");

	// GOLEM HEADS
	public static final BlockItemId GOLEM_HEAD_AMETHYST = create("golem_head_amethyst");
	public static final BlockItemId GOLEM_WALL_HEAD_AMETHYST = create("golem_wall_head_amethyst");
	public static final BlockItemId GOLEM_HEAD_COAL = create("golem_head_coal");
	public static final BlockItemId GOLEM_WALL_HEAD_COAL = create("golem_wall_head_coal");
	public static final BlockItemId GOLEM_HEAD_DIAMOND = create("golem_head_diamond");
	public static final BlockItemId GOLEM_WALL_HEAD_DIAMOND = create("golem_wall_head_diamond");
	public static final BlockItemId GOLEM_HEAD_EMERALD = create("golem_head_emerald");
	public static final BlockItemId GOLEM_WALL_HEAD_EMERALD = create("golem_wall_head_emerald");
	public static final BlockItemId GOLEM_HEAD_GOLD = create("golem_head_gold");
	public static final BlockItemId GOLEM_WALL_HEAD_GOLD = create("golem_wall_head_gold");
	public static final BlockItemId GOLEM_HEAD_IRON = create("golem_head_iron");
	public static final BlockItemId GOLEM_WALL_HEAD_IRON = create("golem_wall_head_iron");
	public static final BlockItemId GOLEM_HEAD_LAPIS = create("golem_head_lapis");
	public static final BlockItemId GOLEM_WALL_HEAD_LAPIS = create("golem_wall_head_lapis");
	public static final BlockItemId GOLEM_HEAD_NETHERITE = create("golem_head_netherite");
	public static final BlockItemId GOLEM_WALL_HEAD_NETHERITE = create("golem_wall_head_netherite");
	public static final BlockItemId GOLEM_HEAD_REDSTONE = create("golem_head_redstone");
	public static final BlockItemId GOLEM_WALL_HEAD_REDSTONE = create("golem_wall_head_redstone");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static BlockItemId create(final String name) {
		return create(F.id(name), F.id(name));
	}

	public static BlockItemId create(final String blockName, final String itemName) {
		return create(F.id(blockName), F.id(itemName));
	}

	public static BlockItemId create(final Identifier blockId, final Identifier itemId) {
		return new BlockItemId(
				ResourceKey.create(Registries.BLOCK, blockId),
				ResourceKey.create(Registries.ITEM, itemId)
		);
	}
}