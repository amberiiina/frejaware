package se.frejaware.Blocks.Custom;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FHalfTransparentBlockSlabBlock extends SlabBlock {
	public FHalfTransparentBlockSlabBlock(Properties properties) {
		super(properties);
	}

	// from HalfTransparentBlock
	protected boolean skipRendering(final BlockState state, final BlockState neighborState, final Direction direction) {
		return neighborState.is(this) ? true : super.skipRendering(state, neighborState, direction);
	}
}