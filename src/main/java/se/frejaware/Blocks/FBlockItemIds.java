package se.frejaware.Blocks;

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
	public static final BlockItemId WHITE_CACTUS_FLOWER = create("white_cactus_flower");
	public static final BlockItemId YELLOW_CACTUS_FLOWER = create("yellow_cactus_flower");
	public static final BlockItemId WHITE_ORCHID = create("white_orchid");
	public static final BlockItemId YELLOW_TULIP = create("yellow_tulip");
	public static final BlockItemId ROUND_BUSH = create("round_bush");
	public static final BlockItemId WHITE_HIBISCUS = create("white_hibiscus");
	public static final BlockItemId YELLOW_HIBISCUS = create("yellow_hibiscus");
	public static final BlockItemId WHITE_CROCUS = create("white_crocus");
	public static final BlockItemId LILAC_CROCUS = create("lilac_crocus");
	public static final BlockItemId PURPLE_CROCUS = create("purple_crocus");
	public static final BlockItemId LILY_OF_THE_GLADE = create("lily_of_the_glade");

	public static final BlockItemId BLUEBERRY_CROP = create("blueberry_crop");
	public static final BlockItemId BLACKBERRY_CROP = create("blackberry_crop");
	public static final BlockItemId PINKBERRY_CROP = create("pinkberry_crop");
	public static final BlockItemId BLOWBERRY_CROP = create("blowberry_crop");

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

	public static final BlockItemId WHITE_PETALS = create("white_petals");

	// TRANSIUM
	public static final BlockItemId TRANSIUM_BLOCK =
			create("transium_block");

	// ROSE QUARTZ
	public static final BlockItemId ROSE_QUARTZ_ORE =
			create("rose_quartz_ore");

	public static final BlockItemId ROSE_QUARTZ_BLOCK =
			create("rose_quartz_block");
	public static final BlockItemId ROSE_QUARTZ_BRICKS =
			create("rose_quartz_bricks");
	public static final BlockItemId ROSE_QUARTZ_BRICK_STAIRS =
			create("rose_quartz_brick_stairs");
	public static final BlockItemId ROSE_QUARTZ_BRICK_SLAB =
			create("rose_quartz_brick_slab");
	public static final BlockItemId ROSE_QUARTZ_BRICK_WALL =
			create("rose_quartz_brick_wall");
	public static final BlockItemId CHISELED_ROSE_QUARTZ_BRICKS =
			create("chiseled_rose_quartz_bricks");
	public static final BlockItemId ROSE_QUARTZ_DOOR =
			create("rose_quartz_door");
	public static final BlockItemId ROSE_QUARTZ_TRAPDOOR =
			create("rose_quartz_trapdoor");
	public static final BlockItemId ROSE_QUARTZ_LADDER =
			create("rose_quartz_ladder");
	public static final BlockItemId ROSE_QUARTZ_BARS =
			create("rose_quartz_bars");
	public static final BlockItemId ROSE_QUARTZ_CHAIN =
			create("rose_quartz_chain");
	public static final BlockItemId ROSE_QUARTZ_LANTERN =
			create("rose_quartz_lantern");
	public static final BlockItemId ROSE_QUARTZ_PRESSURE_PLATE =
			create("rose_quartz_pressure_plate");
	public static final BlockItemId ROSE_QUARTZ_BUTTON =
			create("rose_quartz_button");

	// GOLEM HEADS
	public static final BlockItemId GOLEM_HEAD_AMETHYST =
			create("golem_head_amethyst");
	public static final BlockItemId GOLEM_WALL_HEAD_AMETHYST =
			create("golem_wall_head_amethyst");
	public static final BlockItemId GOLEM_HEAD_COAL =
			create("golem_head_coal");
	public static final BlockItemId GOLEM_WALL_HEAD_COAL =
			create("golem_wall_head_coal");
	public static final BlockItemId GOLEM_HEAD_DIAMOND =
			create("golem_head_diamond");
	public static final BlockItemId GOLEM_WALL_HEAD_DIAMOND =
			create("golem_wall_head_diamond");
	public static final BlockItemId GOLEM_HEAD_EMERALD =
			create("golem_head_emerald");
	public static final BlockItemId GOLEM_WALL_HEAD_EMERALD =
			create("golem_wall_head_emerald");
	public static final BlockItemId GOLEM_HEAD_GOLD =
			create("golem_head_gold");
	public static final BlockItemId GOLEM_WALL_HEAD_GOLD =
			create("golem_wall_head_gold");
	public static final BlockItemId GOLEM_HEAD_IRON =
			create("golem_head_iron");
	public static final BlockItemId GOLEM_WALL_HEAD_IRON =
			create("golem_wall_head_iron");
	public static final BlockItemId GOLEM_HEAD_LAPIS =
			create("golem_head_lapis");
	public static final BlockItemId GOLEM_WALL_HEAD_LAPIS =
			create("golem_wall_head_lapis");
	public static final BlockItemId GOLEM_HEAD_NETHERITE =
			create("golem_head_netherite");
	public static final BlockItemId GOLEM_WALL_HEAD_NETHERITE =
			create("golem_wall_head_netherite");
	public static final BlockItemId GOLEM_HEAD_REDSTONE =
			create("golem_head_redstone");
	public static final BlockItemId GOLEM_WALL_HEAD_REDSTONE =
			create("golem_wall_head_redstone");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static BlockItemId create(String name) {
		Identifier id = F.id(name);
		return BlockItemId.create(id, id);
	}
}