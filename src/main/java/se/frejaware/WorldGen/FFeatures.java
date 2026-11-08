package se.frejaware.WorldGen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.WorldGen.Custom.FRoseQuartzOreFeature;

import java.util.List;
import java.util.Set;

public class FFeatures {
	public static final ResourceKey<Feature> ROSE_QUARTZ_ORE_VEIN_FEATURE_KEY =
			create("rose_quartz_ore_vein_feature");

	public static final ResourceKey<Feature> PEAR_TREE_FEATURE_KEY =
			create("pear_tree_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_PETALS_FEATURE_KEY =
			create("pear_meadow_petals_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_WILDFLOWERS_FEATURE_KEY =
			create("pear_meadow_wildflowers_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_FLOWERS_FEATURE_KEY =
			create("pear_meadow_flowers_feature");
	public static final ResourceKey<Feature> PEAR_MEADOW_BUSHES_FEATURE_KEY =
			create("pear_meadow_bushes_feature");

	public static final ResourceKey<Feature> JACARANDA_TREE_FEATURE_KEY =
			create("jacaranda_tree_feature");
	public static final ResourceKey<Feature> JACARANDA_GLADE_PETALS_FEATURE_KEY =
			create("jacaranda_glade_petals_feature");
	public static final ResourceKey<Feature> JACARANDA_GLADE_FLOWERS_FEATURE_KEY =
			create("jacaranda_glade_flowers_feature");

	public static void configure(BootstrapContext<Feature> context) {
		// ROSE QUARTZ
		RuleTest onlyEndStoneRule = new BlockMatchTest(Blocks.END_STONE);

		List<BlockReplacement> roseQuartzOre = List.of(BlockReplacement.replace(
				onlyEndStoneRule, FBlocks.ROSE_QUARTZ_ORE.defaultBlockState()
		));

		// PEAR TREE
		HolderGetter<BlockStateProvider> blockStateProviders = context.lookup(Registries.BLOCK_STATE_PROVIDER);
		Holder<BlockStateProvider> belowTrunkProvider = blockStateProviders.getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);

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

		// ROSE QUARTZ
		context.register(ROSE_QUARTZ_ORE_VEIN_FEATURE_KEY,
				new FRoseQuartzOreFeature(
						roseQuartzOre,
						4,
						0.0f
				)
		);

		// PEAR
		context.register(PEAR_TREE_FEATURE_KEY,
				pearTree(belowTrunkProvider)
						.decorators(List.of(whitePetals))
						.build()
		);
		context.register(PEAR_MEADOW_PETALS_FEATURE_KEY,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(FBlocks.WHITE_PETALS))
				)
		);
		context.register(PEAR_MEADOW_WILDFLOWERS_FEATURE_KEY,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(Blocks.WILDFLOWERS))
				)
		);
		context.register(PEAR_MEADOW_FLOWERS_FEATURE_KEY,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								List.of(
										FBlocks.WHITE_ORCHID.defaultBlockState(),
										FBlocks.WHITE_ORCHID.defaultBlockState(),
										FBlocks.YELLOW_TULIP.defaultBlockState(),
										FBlocks.YELLOW_TULIP.defaultBlockState(),
										FBlocks.WHITE_HIBISCUS.defaultBlockState(),
										FBlocks.YELLOW_HIBISCUS.defaultBlockState(),
										Blocks.WHITE_TULIP.defaultBlockState()
								)
						)
				)
		);
		context.register(PEAR_MEADOW_BUSHES_FEATURE_KEY,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								List.of(
										FBlocks.BLUEBERRY_BUSH.defaultBlockState(),
										FBlocks.BLACKBERRY_BUSH.defaultBlockState(),
										FBlocks.PINKBERRY_BUSH.defaultBlockState(),
										FBlocks.BLOWBERRY_BUSH.defaultBlockState(),
										FBlocks.ROUND_BUSH.defaultBlockState(),
										Blocks.AZALEA.defaultBlockState(),
										Blocks.AZALEA.defaultBlockState()
								)
						)
				)
		);

		// JACARANDA
		context.register(JACARANDA_TREE_FEATURE_KEY,
				jacarandaTree(belowTrunkProvider)
						.decorators(List.of(purplePetals))
						.build()
		);
		context.register(JACARANDA_GLADE_PETALS_FEATURE_KEY,
				new SimpleBlockFeature(
						new WeightedStateProvider(flowerBedPatchBuilder(FBlocks.PURPLE_PETALS))
				)
		);
		context.register(JACARANDA_GLADE_FLOWERS_FEATURE_KEY,
				new SimpleBlockFeature(
						new NoiseProvider(
								2345L,
								NormalNoise.createParity(0, 1.0F),
								0.020833334F,
								List.of(
										FBlocks.WHITE_CROCUS.defaultBlockState(),
										FBlocks.LILAC_CROCUS.defaultBlockState(),
										FBlocks.PURPLE_CROCUS.defaultBlockState(),
										FBlocks.LILY_OF_THE_GLADE.defaultBlockState()
								)
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
}