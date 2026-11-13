package se.frejaware.Shared;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import se.frejaware.F;

public class FBlockTags {
	// MOLLY
	public static final TagKey<Block> POT_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("pot_flowers")
	);
	public static final TagKey<Block> NON_POT_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("non_pot_flowers")
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