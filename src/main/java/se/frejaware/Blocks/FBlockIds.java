package se.frejaware.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import se.frejaware.F;

public class FBlockIds {
	// ----------------------
	// BLOCKS
	// ----------------------

	// MOLLY

	// BLOM
	public static final ResourceKey<Block> POTTED_WHITE_ORCHID = create("potted_white_orchid");
	public static final ResourceKey<Block> POTTED_YELLOW_TULIP = create("potted_yellow_tulip");
	public static final ResourceKey<Block> POTTED_WHITE_HIBISCUS = create("potted_white_hibiscus");
	public static final ResourceKey<Block> POTTED_YELLOW_HIBISCUS = create("potted_yellow_hibiscus");

	public static final ResourceKey<Block> POTTED_WHITE_CROCUS = create("potted_white_crocus");
	public static final ResourceKey<Block> POTTED_LILAC_CROCUS = create("potted_lilac_crocus");
	public static final ResourceKey<Block> POTTED_PURPLE_CROCUS = create("potted_purple_crocus");
	public static final ResourceKey<Block> POTTED_LILY_OF_THE_GLADE = create("potted_lily_of_the_glade");

	public static final ResourceKey<Block> POTTED_FROSTBLOOM = create("potted_frostbloom");
	public static final ResourceKey<Block> POTTED_SNOWBELL = create("potted_snowbell");

	public static final ResourceKey<Block> POTTED_WHITE_ALLIUM = create("potted_white_allium");
	public static final ResourceKey<Block> POTTED_PINK_CARNATION = create("potted_pink_carnation");
	public static final ResourceKey<Block> POTTED_WHITE_CARNATION = create("potted_white_carnation");
	public static final ResourceKey<Block> POTTED_CORAL_CARNATION = create("potted_coral_carnation");
	public static final ResourceKey<Block> POTTED_VIOLET_CARNATION = create("potted_violet_carnation");
	public static final ResourceKey<Block> POTTED_YELLOW_CARNATION = create("potted_yellow_carnation");

	public static final ResourceKey<Block> POTTED_BLUE_SUCCULENT = create("potted_blue_succulent");
	public static final ResourceKey<Block> POTTED_RED_SUCCULENT = create("potted_red_succulent");
	public static final ResourceKey<Block> POTTED_GREEN_SUCCULENT = create("potted_green_succulent");
	public static final ResourceKey<Block> POTTED_TEAL_SUCCULENT = create("potted_teal_succulent");
	public static final ResourceKey<Block> POTTED_PURPLE_SUCCULENT = create("potted_purple_succulent");
	public static final ResourceKey<Block> POTTED_BROWN_SUCCULENT = create("potted_brown_succulent");
	public static final ResourceKey<Block> POTTED_YELLOW_SUCCULENT = create("potted_yellow_succulent");

	public static final ResourceKey<Block> POTTED_DRY_CACTUS = create("potted_dry_cactus");

	// BLUE_SPRUCE
	public static final ResourceKey<Block> POTTED_BLUE_SPRUCE_SAPLING = create("potted_blue_spruce_sapling");
	public static final ResourceKey<Block> BLUE_SPRUCE_WALL_SIGN = create("blue_spruce_wall_sign");
	public static final ResourceKey<Block> BLUE_SPRUCE_WALL_HANGING_SIGN = create("blue_spruce_wall_hanging_sign");

	// ORANGE
	public static final ResourceKey<Block> POTTED_ORANGE_SAPLING = create("potted_orange_sapling");

	// JACARANDA
	public static final ResourceKey<Block> POTTED_JACARANDA_SAPLING = create("potted_jacaranda_sapling");
	public static final ResourceKey<Block> JACARANDA_WALL_SIGN = create("jacaranda_wall_sign");
	public static final ResourceKey<Block> JACARANDA_WALL_HANGING_SIGN = create("jacaranda_wall_hanging_sign");

	// PEAR
	public static final ResourceKey<Block> POTTED_PEAR_SAPLING = create("potted_pear_sapling");
	public static final ResourceKey<Block> PEAR_WALL_SIGN = create("pear_wall_sign");
	public static final ResourceKey<Block> PEAR_WALL_HANGING_SIGN = create("pear_wall_hanging_sign");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static ResourceKey<Block> create(String name) {
		Identifier id = F.id(name);
		return ResourceKey.create(Registries.BLOCK, id);
	}
}