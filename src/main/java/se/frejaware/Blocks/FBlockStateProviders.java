package se.frejaware.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import se.frejaware.F;

public interface FBlockStateProviders {
	ResourceKey<BlockStateProvider> SNOW_BENEATH_TREE = create("snow_beneath_tree");
	ResourceKey<BlockStateProvider> SNOW_BENEATH_TREE_LARGE = create("snow_beneath_tree_large");

	static void bootstrap(final BootstrapContext<BlockStateProvider> context) {
		context.register(SNOW_BENEATH_TREE, RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.not(BlockPredicate.matchesTag(BlockTags.CANNOT_REPLACE_BELOW_TREE_TRUNK)), Blocks.SNOW_BLOCK));
		context.register(SNOW_BENEATH_TREE_LARGE, RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE), Blocks.SNOW_BLOCK));
	}

	private static ResourceKey<BlockStateProvider> create(final String id) {
		return ResourceKey.create(Registries.BLOCK_STATE_PROVIDER, F.id(id));
	}
}