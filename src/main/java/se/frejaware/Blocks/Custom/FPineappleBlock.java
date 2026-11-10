package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import se.frejaware.Items.FItems;

public class FPineappleBlock extends CropBlock {
	public FPineappleBlock(final BlockBehaviour.Properties properties) {
		super(properties);
	}

	private static final VoxelShape[] SHAPES = Block.boxes(
			7, age -> Block.column(16.0F, 0.0F, 2 + age)
	);

	protected ItemLike getBaseSeedId() {
		return FItems.PINEAPPLE_SEEDS;
	}

	protected VoxelShape getShape(
			final BlockState state, final BlockGetter level,
			final BlockPos pos, final CollisionContext context) {
		return SHAPES[this.getAge(state)];
	}
}