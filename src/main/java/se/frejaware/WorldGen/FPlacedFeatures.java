package se.frejaware.WorldGen;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
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

	public static final ResourceKey<PlacedFeature> JACARANDA_TREE_PLACED_KEY =
			create("jacaranda_tree_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_PETALS_PLACED_KEY =
			create("jacaranda_glade_petals_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_FLOWERS_PLACED_KEY =
			create("jacaranda_glade_flowers_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_MOSS_PLACED_KEY =
			create("jacaranda_glade_moss_placed");

	public static void configure(BootstrapContext<PlacedFeature> context) {
		HolderGetter<Feature> features = context.lookup(Registries.FEATURE);

		// ROSE QUARTZ
		List<PlacementModifier> roseQuartzOreVeinPlacedModifiers = List.of(
				BiomeFilter.biome(),
				CountPlacement.of(4),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(10),
						VerticalAnchor.absolute(65)
				),
				InSquarePlacement.spread()
		);

		// PEAR TREE
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

		List<PlacementModifier> pearTreeModifiers = List.of(
				InSquarePlacement.spread(),
				SurfaceWaterDepthFilter.forMaxDepth(0),
				PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
				BiomeFilter.biome(),
				CountPlacement.of(2),
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
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(16),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);

		// JACARANDA
		List<PlacementModifier> jacarandaTreeModifiers = List.of(
				InSquarePlacement.spread(),
				SurfaceWaterDepthFilter.forMaxDepth(0),
				PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
				BiomeFilter.biome(),
				CountPlacement.of(2),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.wouldSurvive(FBlocks.JACARANDA_SAPLING)
				)
		);
		List<PlacementModifier> jacarandaMeadowPetalsModifiers = List.of(
				NoiseThresholdCountPlacement.of(-0.8, 5, 10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				CountPlacement.of(96),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> jacarandaGladeFlowersModifiers = List.of(
				CountPlacement.of(3),
				RarityFilter.onAverageOnceEvery(2),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				CountPlacement.of(128),
				BiomeFilter.biome(),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> jacarandaGladeMossModifiers = List.of(
				CountPlacement.of(36),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.aboveBottom(0),
						VerticalAnchor.absolute(256)
				),
				EnvironmentScanPlacement.scanningFor(
						Direction.DOWN,
						BlockPredicate.solid(),
						BlockPredicate.matchesTag(BlockTags.AIR),
						12
				),
				OffsetPlacement.of(0, 1, 0),
				BiomeFilter.biome()
		);

		// ROSE QUARTZ
		context.register(
				ROSE_QUARTZ_ORE_VEIN_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.ROSE_QUARTZ_ORE_VEIN_FEATURE_KEY),
						roseQuartzOreVeinPlacedModifiers
				)
		);

		// PEAR
		context.register(PEAR_TREE_CHERRY_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE_FEATURE_KEY),
						pearTreeCherryModifiers
				)
		);
		context.register(PEAR_TREE_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE_FEATURE_KEY),
						pearTreeModifiers
				)
		);
		context.register(PEAR_MEADOW_PETALS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_PETALS_FEATURE_KEY),
						pearMeadowPetalsModifiers
				)
		);
		context.register(PEAR_MEADOW_WILDFLOWERS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_WILDFLOWERS_FEATURE_KEY),
						pearMeadowWildflowersModifiers
				)
		);
		context.register(PEAR_MEADOW_FLOWERS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_FLOWERS_FEATURE_KEY),
						pearMeadowFlowersModifiers
				)
		);
		context.register(PEAR_MEADOW_BUSH_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(VegetationFeatures.BUSH),
						pearMeadowBushModifiers
				)
		);
		context.register(PEAR_MEADOW_BUSHES_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_BUSHES_FEATURE_KEY),
						pearMeadowBushesModifiers
				)
		);

		// JACARANDA
		context.register(JACARANDA_TREE_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_TREE_FEATURE_KEY),
						jacarandaTreeModifiers
				)
		);
		context.register(JACARANDA_GLADE_PETALS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_GLADE_PETALS_FEATURE_KEY),
						jacarandaMeadowPetalsModifiers
				)
		);
		context.register(JACARANDA_GLADE_FLOWERS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_GLADE_FLOWERS_FEATURE_KEY),
						jacarandaGladeFlowersModifiers
				)
		);
		context.register(JACARANDA_GLADE_MOSS_PLACED_KEY,
				new PlacedFeature(
						features.getOrThrow(CaveFeatures.MOSS_PATCH),
						jacarandaGladeMossModifiers
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