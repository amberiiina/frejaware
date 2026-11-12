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
	public static final ResourceKey<PlacedFeature> ROSE_QUARTZ_ORE_VEIN =
			create("rose_quartz_ore_vein_placed");

	public static final ResourceKey<PlacedFeature> PEAR_TREE_CHERRY =
			create("pear_tree_cherry_placed");

	public static final ResourceKey<PlacedFeature> PEAR_TREE =
			create("pear_tree_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_PETALS =
			create("pear_meadow_petals_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_WILDFLOWERS =
			create("pear_meadow_wildflowers_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_FLOWERS =
			create("pear_meadow_flowers_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_BUSH =
			create("pear_meadow_bush_placed");
	public static final ResourceKey<PlacedFeature> PEAR_MEADOW_BUSHES =
			create("pear_meadow_bushes_placed");

	public static final ResourceKey<PlacedFeature> JACARANDA_TREE =
			create("jacaranda_tree_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_PETALS =
			create("jacaranda_glade_petals_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_FLOWERS =
			create("jacaranda_glade_flowers_placed");
	public static final ResourceKey<PlacedFeature> JACARANDA_GLADE_MOSS =
			create("jacaranda_glade_moss_placed");

	public static final ResourceKey<PlacedFeature> DESERT_CACTUS_FLOWERS =
			create("desert_cactus_flowers_feature");
	public static final ResourceKey<PlacedFeature> DESERT_ROCKS =
			create("desert_rocks_feature");

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

		// VANILLA
		List<PlacementModifier> desertCactusFlowersModifiers = List.of(
				CountPlacement.of(3),
				RarityFilter.onAverageOnceEvery(10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				CountPlacement.of(16),
				BiomeFilter.biome(),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);
		List<PlacementModifier> desertCactusRocksModifiers = List.of(
				CountPlacement.of(3),
				RarityFilter.onAverageOnceEvery(2),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				CountPlacement.of(4),
				BiomeFilter.biome(),
				OffsetPlacement.ofTriangle(6, 2),
				BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
		);

		// ROSE QUARTZ
		context.register(
				ROSE_QUARTZ_ORE_VEIN,
				new PlacedFeature(
						features.getOrThrow(FFeatures.ROSE_QUARTZ_ORE_VEIN),
						roseQuartzOreVeinPlacedModifiers
				)
		);

		// PEAR
		context.register(PEAR_TREE_CHERRY,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE),
						pearTreeCherryModifiers
				)
		);
		context.register(PEAR_TREE,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_TREE),
						pearTreeModifiers
				)
		);
		context.register(PEAR_MEADOW_PETALS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_PETALS),
						pearMeadowPetalsModifiers
				)
		);
		context.register(PEAR_MEADOW_WILDFLOWERS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_WILDFLOWERS),
						pearMeadowWildflowersModifiers
				)
		);
		context.register(PEAR_MEADOW_FLOWERS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_FLOWERS),
						pearMeadowFlowersModifiers
				)
		);
		context.register(PEAR_MEADOW_BUSH,
				new PlacedFeature(
						features.getOrThrow(VegetationFeatures.BUSH),
						pearMeadowBushModifiers
				)
		);
		context.register(PEAR_MEADOW_BUSHES,
				new PlacedFeature(
						features.getOrThrow(FFeatures.PEAR_MEADOW_BUSHES),
						pearMeadowBushesModifiers
				)
		);

		// JACARANDA
		context.register(JACARANDA_TREE,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_TREE),
						jacarandaTreeModifiers
				)
		);
		context.register(JACARANDA_GLADE_PETALS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_GLADE_PETALS),
						jacarandaMeadowPetalsModifiers
				)
		);
		context.register(JACARANDA_GLADE_FLOWERS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.JACARANDA_GLADE_FLOWERS),
						jacarandaGladeFlowersModifiers
				)
		);
		context.register(JACARANDA_GLADE_MOSS,
				new PlacedFeature(
						features.getOrThrow(CaveFeatures.MOSS_PATCH),
						jacarandaGladeMossModifiers
				)
		);

		// VANILLA
		context.register(DESERT_CACTUS_FLOWERS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.DESERT_CACTUS_FLOWERS),
						desertCactusFlowersModifiers
				)
		);
		context.register(DESERT_ROCKS,
				new PlacedFeature(
						features.getOrThrow(FFeatures.DESERT_ROCKS),
						desertCactusRocksModifiers
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