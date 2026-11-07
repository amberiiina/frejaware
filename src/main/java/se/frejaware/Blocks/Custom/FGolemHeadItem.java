package se.frejaware.Blocks.Custom;

import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import se.frejaware.Blocks.FBlocks;

public class FGolemHeadItem extends BlockItem {
	private final Block standingBlock;
	private final Block wallBlock;

	public FGolemHeadItem(
			Block standingBlock,
			Block wallBlock,
			Properties properties
	) {
		super(standingBlock, properties);
		this.standingBlock = standingBlock;
		this.wallBlock = wallBlock;
	}

	@Override
	protected BlockState getPlacementState(BlockPlaceContext context) {
		Direction direction = context.getClickedFace();

		if (direction.getAxis() == Direction.Axis.Y) {
			return standingBlock.defaultBlockState()
					.setValue(
							SkullBlock.ROTATION,
							RotationSegment.convertToSegment(context.getRotation())
					);
		}

		return wallBlock.defaultBlockState().setValue(WallSkullBlock.FACING, direction);
	}
}