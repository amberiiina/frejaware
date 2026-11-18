package se.frejaware.Shared;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import se.frejaware.F;

public class FBlockTags {
	// MOLLY
	public static final TagKey<Block> POTTED_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("potted_flowers")
	);
	public static final TagKey<Block> SMALL_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("small_flowers")
	);
	public static final TagKey<Block> NON_POT_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("non_pot_flowers")
	);

	// BLUE SPRUCE
	public static final TagKey<Block> BLUE_SPRUCE_LOGS = TagKey.create(
			Registries.BLOCK,
			F.id("blue_spruce_logs")
	);
	public static final TagKey<Block> SUPPORTS_BLUE_SPRUCE = TagKey.create(
			Registries.BLOCK,
			F.id("supports_blue_spruce")
	);

	// JACARANDA
	public static final TagKey<Block> JACARANDA_LOGS = TagKey.create(
			Registries.BLOCK,
			F.id("jacaranda_logs")
	);

	// PEAR
	public static final TagKey<Block> PEAR_LOGS = TagKey.create(
			Registries.BLOCK,
			F.id("pear_logs")
	);

	// ROSE QUARTZ
	public static final TagKey<Block> INCORRECT_FOR_ROSE_QUARTZ_TOOL = TagKey.create(
			Registries.BLOCK,
			F.id("incorrect_for_rose_quartz_tool")
	);
}