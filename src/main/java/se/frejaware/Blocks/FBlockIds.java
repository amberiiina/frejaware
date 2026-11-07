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
	public static final ResourceKey<Block> POTTED_WHITE_ORCHID =
			create("potted_white_orchid");
	public static final ResourceKey<Block> POTTED_YELLOW_TULIP =
			create("potted_yellow_tulip");
	public static final ResourceKey<Block> POTTED_ROUND_BUSH =
			create("potted_round_bush");
	public static final ResourceKey<Block> POTTED_WHITE_HIBISCUS =
			create("potted_white_hibiscus");
	public static final ResourceKey<Block> POTTED_YELLOW_HIBISCUS =
			create("potted_yellow_hibiscus");
	public static final ResourceKey<Block> POTTED_WHITE_CROCUS =
			create("potted_white_crocus");
	public static final ResourceKey<Block> POTTED_LILAC_CROCUS =
			create("potted_lilac_crocus");
	public static final ResourceKey<Block> POTTED_PURPLE_CROCUS =
			create("potted_purple_crocus");
	public static final ResourceKey<Block> POTTED_LILY_OF_THE_GLADE =
			create("potted_lily_of_the_glade");

	// PEAR
	public static final ResourceKey<Block> POTTED_PEAR_SAPLING =
			create("potted_pear_sapling");
	public static final ResourceKey<Block> PEAR_WALL_SIGN =
			create("pear_wall_sign");
	public static final ResourceKey<Block> PEAR_WALL_HANGING_SIGN =
			create("pear_wall_hanging_sign");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static ResourceKey<Block> create(String name) {
		Identifier id = F.id(name);
		return ResourceKey.create(Registries.BLOCK, id);
	}
}