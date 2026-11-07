package se.frejaware.WorldGen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;

import java.util.List;

public class FPlacedFeatures {
	public static final ResourceKey<PlacedFeature> ROSE_QUARTZ_ORE_VEIN_PLACED_KEY =
			create("rose_quartz_ore_vein_placed");

	public static final ResourceKey<PlacedFeature> PEAR_TREE_CHERRY_PLACED_KEY =
			create("pear_tree_cherry_placed");

	public static final ResourceKey<PlacedFeature> PEAR_TREE_PLACED_KEY =
			create("pear_tree_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_PETALS_PLACED_KEY =
			create("pear_meadow_petals_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_WILDFLOWERS_PLACED_KEY =
			create("pear_meadow_wildflowers_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_FLOWERS_PLACED_KEY =
			create("pear_meadow_flowers_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_BUSH_PLACED_KEY =
			create("pear_meadow_bush_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_BUSHES_PLACED_KEY =
			create("pear_meadow_bushes_placed");

	public static void configure(BootstrapContext<PlacedFeature> context) {
		HolderGetter<Feature> features = context.lookup(Registries.FEATURE);

		// ROSE QUARTZ
		List<PlacementModifier> roseQuartzOreVeinPlacedModifiers = List.of(
				CountPlacement.of(4),
				BiomeFilter.biome(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(10),
						VerticalAnchor.absolute(65)
				),
				InSquarePlacement.spread()
		);

		// PEAR TREE
		List<PlacementModifier> pearTreeModifiers = List.of(
				CountPlacement.of(2),
				InSquarePlacement.spread(),
				SurfaceWaterDepthFilter.forMaxDepth(0),
				PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
				BiomeFilter.biome(),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.wouldSurvive(FBlocks.PEAR_SAPLING)
				)
		);
		List<PlacementModifier> pearTreeCherryModifiers = List.of(
				RarityFilter.onAverageOnceEvery(2),
				InSquarePlacement.spread(),
				SurfaceWaterDepthFilter.forMaxDepth(0),
				PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
				BiomeFilter.biome(),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.wouldSurvive(FBlocks.PEAR_SAPLING)
				)
		);
		List<PlacementModifier> pearMeadowPetalsModifiers = List.of(
				NoiseThresholdCountPlacement.of(-0.8, 5, 10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(72),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> pearMeadowWildflowersModifiers = List.of(
				NoiseThresholdCountPlacement.of(-0.8, 5, 10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(24),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> pearMeadowFlowersModifiers = List.of(
				CountPlacement.of(3),
				RarityFilter.onAverageOnceEvery(2),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(96),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> pearMeadowBushModifiers = List.of(
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(24),
				OffsetPlacement.ofTriangle(5, 3),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> pearMeadowBushesModifiers = List.of(
				RarityFilter.onAverageOnceEvery(4),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(8),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);

		// REGISTER
		context.register(
				ROSE_QUARTZ_ORE_VEIN_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.ROSE_QUARTZ_ORE_VEIN_FEATURE_KEY),
						roseQuartzOreVeinPlacedModifiers
				)
		);

		context.register(
				PEAR_TREE_CHERRY_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE_FEATURE_KEY),
						pearTreeCherryModifiers
				)
		);

		context.register(
				PEAR_TREE_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE_FEATURE_KEY),
						pearTreeModifiers
				)
		);
		context.register(
				PEAR_MEADOW_PETALS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_PETALS_FEATURE_KEY),
						pearMeadowPetalsModifiers
				)
		);
		context.register(
				PEAR_MEADOW_WILDFLOWERS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_WILDFLOWERS_FEATURE_KEY),
						pearMeadowWildflowersModifiers
				)
		);
		context.register(
				PEAR_MEADOW_FLOWERS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_FLOWERS_FEATURE_KEY),
						pearMeadowFlowersModifiers
				)
		);
		context.register(
				PEAR_MEADOW_BUSH_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(VegetationFeatures.BUSH),
						pearMeadowBushModifiers
				)
		);
		context.register(
				PEAR_MEADOW_BUSHES_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_BUSHES_FEATURE_KEY),
						pearMeadowBushesModifiers
				)
		);
	}

	private static ResourceKey<PlacedFeature> create(final String name) {
		return ResourceKey.create(
				Registries.PLACED_FEATURE,
				F.id(name)
		);
	}
}