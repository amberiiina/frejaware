package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import se.frejaware.Shared.FBlockTags;

public class FBlueSpruceSaplingBlock extends SaplingBlock {
	public FBlueSpruceSaplingBlock(TreeGrower treeGrower, Properties properties) {
		super(treeGrower, properties);
	}

	protected boolean mayPlaceOn(final BlockState state, final BlockGetter level, final BlockPos pos) {
		return state.is(FBlockTags.SUPPORTS_BLUE_SPRUCE);
	}
}