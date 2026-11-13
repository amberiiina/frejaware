package se.frejaware.WorldGen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FlowerBedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import se.frejaware.Blocks.Custom.FSeashellBlock;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.WorldGen.Custom.FRoseQuartzOreFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FFeatures {
	public static final ResourceKey<Feature> ROSE_QUARTZ_ORE_VEIN =
			create("rose_quartz_ore_vein_feature");

	public static final ResourceKey<Feature> PEAR_TREE =
			create("pear_tree_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_PETALS =
			create("pear_meadow_petals_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_WILDFLOWERS =
			create("pear_meadow_wildflowers_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_FLOWERS =
			create("pear_meadow_flowers_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_BUSHES =
			create("pear_meadow_bushes_feature");

	public static final ResourceKey<Feature> JACARANDA_TREE =
			create("jacaranda_tree_feature");
	public static final ResourceKey<Feature> JACARANDA_GLADE_PETALS =
			create("jacaranda_glade_petals_feature");
	public static final ResourceKey<Feature> JACARANDA_GLADE_FLOWERS =
			create("jacaranda_glade_flowers_feature");

	public static final ResourceKey<Feature> ORANGE_TREE =
			create("orange_tree_feature");
	public static final ResourceKey<Feature> ORANGE_FLOWERS =
			create("orange_flowers_feature");
	public static final ResourceKey<Feature> ORANGE_DIRT_VEGETATION =
			create("orange_dirt_vegetation_feature");
	public static final ResourceKey<Feature> ORANGE_DIRT =
			create("orange_dirt_feature");

	public static final ResourceKey<Feature> DESERT_CACTUS_FLOWERS =
			create("desert_cactus_flowers_feature");
	public static final ResourceKey<Feature> DESERT_ROCKS =
			create("desert_rocks_feature");
	public static final ResourceKey<Feature> BEACH_SEASHELLS =
			create("beach_seashells");

	public static void configure(BootstrapContext<Feature> context) {
		HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
		HolderGetter<Feature> features = context.lookup(Registries.FEATURE);

		HolderGetter<BlockStateProvider> blockStateProviders =
				context.lookup(Registries.BLOCK_STATE_PROVIDER);
		Holder<BlockStateProvider> belowTrunkProvider =
				blockStateProviders.getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);

		// ROSE QUARTZ
		RuleTest onlyEndStoneRule = new BlockMatchTest(Blocks.END_STONE);
		List<BlockReplacement> roseQuartzOre = List.of(BlockReplacement.replace(
				onlyEndStoneRule, FBlocks.ROSE_QUARTZ_ORE.defaultBlockState()
		));
		context.register(ROSE_QUARTZ_ORE_VEIN,
				new FRoseQuartzOreFeature(
						roseQuartzOre,
						4,
						0.0f
				)
		);

		// PETALS
		PlaceOnGroundDecorator whitePetals = new PlaceOnGroundDecorator(
				150, 2, 2, Holder.direct(new WeightedStateProvider(
						whitePetalsPatchBuilder(1, 4)
				)
		));
		PlaceOnGroundDecorator purplePetals = new PlaceOnGroundDecorator(
				150, 2, 2, Holder.direct(new WeightedStateProvider(
						purplePetalsPatchBuilder(1, 4)
				)
		));
		PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(
				96, 4, 2, Holder.direct(new WeightedStateProvider(
						VegetationFeatures.leafLitterPatchBuilder(1, 3)
				)
		));
		PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(
				150, 2, 2, Holder.direct(new WeightedStateProvider(
						VegetationFeatures.leafLitterPatchBuilder(1, 4)
				)
		));

		// PEAR
		context.register(PEAR_TREE,
				pearTree(belowTrunkProvider)
						.decorators(List.of(
								new BeehiveDecorator(0.02F),
								whitePetals
						))
						.build()
		);
		context.register(PEAR_MEADOW_PETALS,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(FBlocks.WHITE_PETALS))
				)
		);
		context.register(PEAR_MEADOW_WILDFLOWERS,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(Blocks.WILDFLOWERS))
				)
		);
		context.register(PEAR_MEADOW_FLOWERS,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								weightedPatch(
										FBlocks.WHITE_ORCHID.defaultBlockState(), 2,
										FBlocks.YELLOW_TULIP.defaultBlockState(), 2,
										FBlocks.WHITE_HIBISCUS.defaultBlockState(), 1,
										FBlocks.YELLOW_HIBISCUS.defaultBlockState(), 1,
										Blocks.WHITE_TULIP.defaultBlockState(), 1
								)
						)
				)
		);
		context.register(PEAR_MEADOW_BUSHES,
				new SimpleBlockFeature(
						new WeightedStateProvider(
								WeightedList.<BlockState>builder()
										.add(FBlocks.BLACKBERRY_BUSH.defaultBlockState(), 1)
										.add(FBlocks.BLOWBERRY_BUSH.defaultBlockState(), 1)
										.add(FBlocks.BLUEBERRY_BUSH.defaultBlockState(), 1)
										.add(FBlocks.PINKBERRY_BUSH.defaultBlockState(), 1)
										.add(FBlocks.ROUND_BUSH.defaultBlockState(), 1)
										.add(Blocks.AZALEA.defaultBlockState(), 1)
										.build()
						)
				)
		);

		// JACARANDA
		context.register(JACARANDA_TREE,
				jacarandaTree(belowTrunkProvider)
						.decorators(List.of(
								new BeehiveDecorator(0.02F),
								purplePetals
						))
						.build()
		);
		context.register(JACARANDA_GLADE_PETALS,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(FBlocks.PURPLE_PETALS))
				)
		);
		context.register(JACARANDA_GLADE_FLOWERS,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								weightedPatch(
										FBlocks.WHITE_CROCUS.defaultBlockState(), 2,
										FBlocks.LILAC_CROCUS.defaultBlockState(), 2,
										FBlocks.PURPLE_CROCUS.defaultBlockState(), 2,
										FBlocks.LILY_OF_THE_GLADE.defaultBlockState(), 2,
										Blocks.ALLIUM.defaultBlockState(), 2,
										Blocks.LILAC.defaultBlockState(), 1,
										Blocks.PEONY.defaultBlockState(), 1
								)
						)
				)
		);

		// ORCHARD
		context.register(ORANGE_TREE,
				orangeTree(belowTrunkProvider)
						.decorators(List.of(
								new BeehiveDecorator(0.02F),
								sparseLeafLitter,
								thickLeafLitter
						))
						.build()
		);
		context.register(ORANGE_FLOWERS,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								weightedPatch(
										FBlocks.WHITE_ALLIUM.defaultBlockState(), 2,
										Blocks.ORANGE_TULIP.defaultBlockState(), 2,
										FBlocks.YELLOW_TULIP.defaultBlockState(), 1,
										Blocks.WHITE_TULIP.defaultBlockState(), 1,
										Blocks.AZURE_BLUET.defaultBlockState(), 1,
										Blocks.DANDELION.defaultBlockState(), 2,
										FBlocks.BLOWBERRY_BUSH.defaultBlockState(), 1,
										Blocks.SUNFLOWER.defaultBlockState(), 1
								)
						)
				)
		);
		context.register(ORANGE_DIRT_VEGETATION,
				new SimpleBlockFeature(
						new WeightedStateProvider(
								WeightedList.<BlockState>builder()
										.add(FBlocks.ORANGE_SAPLING.defaultBlockState(), 11)
										.add(Blocks.MOSS_CARPET.defaultBlockState(), 25)
										.add(Blocks.SHORT_GRASS.defaultBlockState(), 50)
										.add(Blocks.DEAD_BUSH.defaultBlockState(), 10)
										.add(Blocks.AZURE_BLUET.defaultBlockState(), 10)
										.add(Blocks.OAK_LOG.defaultBlockState(), 10)
										.build()
						)
				)
		);
		context.register(ORANGE_DIRT,
				new VegetationPatchFeature(
						blocks.getOrThrow(BlockTags.MOSS_REPLACEABLE),
						BlockStateProvider.holderOf(Blocks.MOSS_BLOCK),
						PlacementUtils.inlinePlaced(
								features.getOrThrow(ORANGE_DIRT_VEGETATION)
						),
						CaveSurface.FLOOR,
						ConstantInt.of(1),
						0.0F,
						5,
						0.2F,
						UniformInt.of(4, 7),
						0.3F
				)
		);

		// VANILLA
		context.register(DESERT_CACTUS_FLOWERS,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								weightedPatch(
										Blocks.CACTUS_FLOWER.defaultBlockState(), 1,
										FBlocks.WHITE_CACTUS_FLOWER.defaultBlockState(), 1,
										FBlocks.YELLOW_CACTUS_FLOWER.defaultBlockState(), 1
								)
						)
				)
		);
		context.register(DESERT_ROCKS,
				new SimpleBlockFeature(
						new WeightedStateProvider(
								WeightedList.<BlockState>builder()
										.add(Blocks.STONE_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR),
												1)
										.add(Blocks.STONE_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR)
														.setValue(ButtonBlock.FACING, Direction.EAST),
												1)
										.add(Blocks.BIRCH_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR),
												1)
										.add(Blocks.BIRCH_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR)
														.setValue(ButtonBlock.FACING, Direction.EAST),
												1)
										.add(Blocks.ACACIA_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR),
												1)
										.add(Blocks.ACACIA_BUTTON.defaultBlockState()
														.setValue(ButtonBlock.FACE, AttachFace.FLOOR)
														.setValue(ButtonBlock.FACING, Direction.EAST),
												1)
										.build()
						)
				)
		);
		context.register(BEACH_SEASHELLS,
				new SimpleBlockFeature(
						new WeightedStateProvider(
								WeightedList.<BlockState>builder()
										.add(FBlocks.PEACH_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.NORTH),
												1)
										.add(FBlocks.PEACH_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.EAST),
												1)
										.add(FBlocks.PEACH_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.SOUTH),
												1)
										.add(FBlocks.PEACH_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.WEST),
												1)
										.add(FBlocks.PEARL_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.NORTH),
												1)
										.add(FBlocks.PEARL_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.EAST),
												1)
										.add(FBlocks.PEARL_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.SOUTH),
												1)
										.add(FBlocks.PEARL_SEASHELL.defaultBlockState()
														.setValue(FSeashellBlock.FACING, Direction.WEST),
												1)
										.build()
						)
				)
		);
	}

	private static ResourceKey<Feature> create(final String name) {
		return ResourceKey.create(
				Registries.FEATURE,
				F.id(name)
		);
	}

	private static Weighted w(BlockState state, int w) {
		return new Weighted(state, w);
	}

	private static List<BlockState> weightedPatch(Object... pairs) {
		List<BlockState> out = new ArrayList<>();
		for (int i = 0; i < pairs.length; i += 2) {
			BlockState state = (BlockState) pairs[i];
			int weight = (Integer) pairs[i + 1];
			for (int w = 0; w < weight; w++) out.add(state);
		}
		return out;
	}

	private static WeightedList.Builder<BlockState> flowerBedPatchBuilder(final Block flowerBedBlock) {
		return segmentedBlockPatchBuilder(flowerBedBlock, 1, 4, FlowerBedBlock.AMOUNT, FlowerBedBlock.FACING);
	}

	public static WeightedList.Builder<BlockState> whitePetalsPatchBuilder(
			final int minState, final int maxState) {
		return segmentedBlockPatchBuilder(
				FBlocks.WHITE_PETALS,
				minState,
				maxState,
				FlowerBedBlock.AMOUNT,
				FlowerBedBlock.FACING
		);
	}

	public static WeightedList.Builder<BlockState> purplePetalsPatchBuilder(
			final int minState, final int maxState) {
		return segmentedBlockPatchBuilder(
				FBlocks.PURPLE_PETALS,
				minState,
				maxState,
				FlowerBedBlock.AMOUNT,
				FlowerBedBlock.FACING
		);
	}

	private static WeightedList.Builder<BlockState> segmentedBlockPatchBuilder(
			final Block block, final int minState, final int maxState, final IntegerProperty amountProperty, final EnumProperty<Direction> directionProperty
	) {
		WeightedList.Builder<BlockState> segmentedBlockBuild = WeightedList.builder();

		for (int amount = minState; amount <= maxState; amount++) {
			for (Direction direction : Direction.Plane.HORIZONTAL) {
				segmentedBlockBuild.add(block.defaultBlockState().setValue(amountProperty, amount).setValue(directionProperty, direction), 1);
			}
		}

		return segmentedBlockBuild;
	}

	private static TreeFeature.Builder pearTree(
			final Holder<BlockStateProvider> belowTrunkProvider) {
		return new TreeFeature.Builder(
				BlockStateProvider.of(FBlocks.PEAR_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						new WeightedListInt(WeightedList.<IntProvider>builder()
								.add(ConstantInt.of(1), 1)
								.add(ConstantInt.of(2), 1)
								.add(ConstantInt.of(3), 1)
								.build()),
						UniformInt.of(2, 4),
						UniformInt.of(-4, -3),
						UniformInt.of(-1, 0)
				),
				BlockStateProvider.of(FBlocks.PEAR_LEAVES),
				new CherryFoliagePlacer(
						ConstantInt.of(4),
						ConstantInt.of(0),
						ConstantInt.of(5),
						0.25F,
						0.5F,
						0.16666667F,
						0.33333334F
				),
				new TwoLayersFeatureSize(1, 0, 2),
				belowTrunkProvider
		).ignoreVines();
	}

	private static TreeFeature.Builder jacarandaTree(
			final Holder<BlockStateProvider> belowTrunkProvider) {
		return new TreeFeature.Builder(
				BlockStateProvider.of(FBlocks.JACARANDA_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						new WeightedListInt(WeightedList.<IntProvider>builder()
								.add(ConstantInt.of(1), 1)
								.add(ConstantInt.of(2), 1)
								.add(ConstantInt.of(3), 1)
								.build()),
						UniformInt.of(2, 4),
						UniformInt.of(-4, -3),
						UniformInt.of(-1, 0)
				),
				BlockStateProvider.of(FBlocks.JACARANDA_LEAVES),
				new CherryFoliagePlacer(
						ConstantInt.of(4),
						ConstantInt.of(0),
						ConstantInt.of(5),
						0.25F,
						0.5F,
						0.16666667F,
						0.33333334F
				),
				new TwoLayersFeatureSize(1, 0, 2),
				belowTrunkProvider
		).ignoreVines();
	}

	private static TreeFeature.Builder orangeTree(
			final Holder<BlockStateProvider> belowTrunkProvider) {
		return new TreeFeature.Builder(
				BlockStateProvider.of(Blocks.OAK_LOG),
				new StraightTrunkPlacer(
						4,
						2,
						0
				),
				new WeightedStateProvider(
						WeightedList.<BlockState>builder()
								.add(FBlocks.ORANGE_LEAVES.defaultBlockState(), 2)
								.add(Blocks.AZALEA_LEAVES.defaultBlockState(), 1)
								.build()
				),
				new BlobFoliagePlacer(
						ConstantInt.of(2),
						ConstantInt.of(0),
						3
				),
				new TwoLayersFeatureSize(1, 0, 1),
				belowTrunkProvider
		).ignoreVines();
	}
}