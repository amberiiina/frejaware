package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import se.frejaware.Blocks.FTrees;

public class FOrangeSaplingBlock extends VegetationBlock implements BonemealableBlock {
	private static final VoxelShape SHAPE = Shapes.or(
			Block.column(16.0F, 8.0F, 16.0F),
			Block.column(4.0F, 0.0F, 8.0F)
	);

	public FOrangeSaplingBlock(final BlockBehaviour.Properties properties) {
		super(properties);
	}

	protected VoxelShape getShape(
			final BlockState state, final BlockGetter level,
			final BlockPos pos, final CollisionContext context) {
		return SHAPE;
	}

	protected boolean mayPlaceOn(
			final BlockState state,
			final BlockGetter level,
			final BlockPos pos) {
		return state.is(BlockTags.SUPPORTS_VEGETATION);
	}

	public boolean isValidBonemealTarget(
			final LevelReader level, final BlockPos pos,
			final BlockState state, final BonemealSource source) {
		if (!(level instanceof ServerLevel serverLevel)) {
			return false;
		} else {
			int minHeight = FTrees.ORANGE_GROWER.getMinimumHeight(serverLevel).orElse(0);
			return level.isInsideBuildHeight(
					pos.above(minHeight + 2)
			) && level.getFluidState(pos.above()).isEmpty();
		}
	}

	public boolean isBonemealSuccess(
			final Level level, final RandomSource random,
			final BlockPos pos, final BlockState state,
			final BonemealSource source) {
		return (double)level.getRandom().nextFloat() < 0.45;
	}

	public void performBonemeal(
			final ServerLevel level, final RandomSource random,
			final BlockPos pos, final BlockState state,
			final BonemealSource source) {
		FTrees.ORANGE_GROWER.growTree(
				level, level.getChunkSource().getGenerator(), pos, state, random
		);
	}

	protected boolean isPathfindable(
			final BlockState state, final PathComputationType type) {
		return false;
	}
}