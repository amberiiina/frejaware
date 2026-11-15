package se.frejaware.Blocks.Custom;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FHalfTransparentBlockStairBlock extends StairBlock {
	public FHalfTransparentBlockStairBlock(BlockState baseState, Properties properties) {
		super(baseState, properties);
	}

	// from HalfTransparentBlock
	protected boolean skipRendering(final BlockState state, final BlockState neighborState, final Direction direction) {
		return neighborState.is(this) ? true : super.skipRendering(state, neighborState, direction);
	}
}