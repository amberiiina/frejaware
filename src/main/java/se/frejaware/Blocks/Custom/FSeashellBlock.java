package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FSeashellBlock extends Block {
	public static final EnumProperty<Direction> FACING;
	private static final VoxelShape SHAPE_NORTH =
			Block.box(3, 0, 5, 12, 2, 12);
	private static final VoxelShape SHAPE_EAST =
			Block.box(4, 0, 3, 11, 2, 12);
	private static final VoxelShape SHAPE_SOUTH =
			Block.box(4, 0, 4, 13, 2, 11);
	private static final VoxelShape SHAPE_WEST =
			Block.box(5, 0, 4, 12, 2, 13);

    public FSeashellBlock(Properties properties) {
        super(properties);
		registerDefaultState(stateDefinition.any()
				.setValue(FACING, Direction.NORTH)
		);
    }

	protected VoxelShape getShape(
			final BlockState state, final BlockGetter level,
			final BlockPos pos, final CollisionContext context) {
		return switch (state.getValue(FACING)) {
			case EAST  -> SHAPE_EAST;
			case SOUTH -> SHAPE_SOUTH;
			case WEST  -> SHAPE_WEST;
			default    -> SHAPE_NORTH;
		};
	}

	@Override
	protected void createBlockStateDefinition(
			StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState()
				.setValue(FACING, context.getHorizontalDirection());
	}

	protected BlockState rotate(final BlockState state, final Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	protected BlockState mirror(final BlockState state, final Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	static {
		FACING = BlockStateProperties.HORIZONTAL_FACING;
	}
}