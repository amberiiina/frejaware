package se.frejaware.Shared;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import se.frejaware.F;

public class FBlockTags {
	// MOLLY
	public static final TagKey<Block> POT_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("pot_flowers")
	);
	public static final TagKey<Block> OTHER_FLOWERS = TagKey.create(
			Registries.BLOCK,
			F.id("other_flowers")
	);

	// PEAR
	public static final TagKey<Block> PEAR_LOGS = TagKey.create(
			Registries.BLOCK,
			F.id("pear_logs")
	);

	// TRANSIUM
	public static final TagKey<Block> INCORRECT_FOR_TRANSIUM_TOOL = TagKey.create(
			Registries.BLOCK,
			F.id("incorrect_for_transium_tool")
	);

	// ROSE QUARTZ
	public static final TagKey<Block> INCORRECT_FOR_ROSE_QUARTZ_TOOL = TagKey.create(
			Registries.BLOCK,
			F.id("incorrect_for_rose_quartz_tool")
	);
}