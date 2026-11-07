package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FWallSkullBlock extends WallSkullBlock {
	public FWallSkullBlock(final SkullBlock.Type type, final BlockBehaviour.Properties properties) {
		super(type, properties);
	}

	@Override
	protected VoxelShape getShape(
			BlockState state,
			BlockGetter level,
			BlockPos pos,
			CollisionContext context
	) {
		return getHeadShape(state.getValue(FACING));
	}

	@Override
	protected VoxelShape getCollisionShape(
			BlockState state,
			BlockGetter level,
			BlockPos pos,
			CollisionContext context
	) {
		return getHeadShape(state.getValue(FACING));
	}

	private VoxelShape getHeadShape(Direction facing) {
		return switch (facing) {
			case NORTH -> Block.box(4, 4, 8, 12, 14, 16);
			case SOUTH -> Block.box(4, 4, 0, 12, 14, 8);
			case EAST  -> Block.box(0, 4, 4, 8, 14, 12);
			case WEST  -> Block.box(8, 4, 4, 16, 14, 12);
			default -> Shapes.empty();
		};
	}
}