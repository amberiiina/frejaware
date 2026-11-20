package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import se.frejaware.Blocks.FBlocks;

public class FBuddingAquamarineBlock extends FAquamarineBlock {
	private static final Direction[] DIRECTIONS = Direction.values();

	public FBuddingAquamarineBlock(final BlockBehaviour.Properties properties) {
		super(properties);
	}

	protected void randomTick(final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {
		if (random.nextInt(5) == 0) {
			Direction growDirection = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos growPos = pos.relative(growDirection);
			BlockState relativeState = level.getBlockState(growPos);
			Block nextStage = null;
			if (canClusterGrowAtState(relativeState)) {
				nextStage = FBlocks.SMALL_AQUAMARINE_BUD;
			} else if (relativeState.is(FBlocks.SMALL_AQUAMARINE_BUD) && relativeState.getValue(FAquamarineClusterBlock.FACING) == growDirection) {
				nextStage = FBlocks.MEDIUM_AQUAMARINE_BUD;
			} else if (relativeState.is(FBlocks.MEDIUM_AQUAMARINE_BUD) && relativeState.getValue(FAquamarineClusterBlock.FACING) == growDirection) {
				nextStage = FBlocks.LARGE_AQUAMARINE_BUD;
			} else if (relativeState.is(FBlocks.LARGE_AQUAMARINE_BUD) && relativeState.getValue(FAquamarineClusterBlock.FACING) == growDirection) {
				nextStage = FBlocks.AQUAMARINE_CLUSTER;
			}

			if (nextStage != null) {
				BlockState targetState = nextStage.defaultBlockState()
						.setValue(FAquamarineClusterBlock.FACING, growDirection)
						.setValue(FAquamarineClusterBlock.WATERLOGGED, relativeState.getFluidState().is(Fluids.WATER));
				level.setBlockAndUpdate(growPos, targetState);
			}
		}
	}

	public static boolean canClusterGrowAtState(final BlockState state) {
		return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().isFull();
	}
}
