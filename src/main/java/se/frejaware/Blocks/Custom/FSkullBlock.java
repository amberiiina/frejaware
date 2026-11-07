package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import se.frejaware.Entities.Custom.FGolemSpawner;

public class FSkullBlock extends SkullBlock {
	public FSkullBlock(final Type type, final BlockBehaviour.Properties properties) {
		super(type, properties);
	}

	public enum Types implements Type {
		AMETHYST("amethyst"),
		COAL("coal"),
		DIAMOND("diamond"),
		EMERALD("emerald"),
		GOLD("gold"),
		IRON("iron"),
		LAPIS("lapis"),
		NETHERITE("netherite"),
		REDSTONE("redstone");

		private final String name;

		Types(final String name) {
			this.name = name;
			TYPES.put(name, this);
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
		super.onPlace(state, level, pos, oldState, movedByPiston);
		if (!oldState.is(state.getBlock())) {
			FGolemSpawner.trySpawn(level, pos, state);
		}
	}

	private static final VoxelShape GOLEM_SHAPE =
			Block.box(4, 0, 4, 12, 10, 12);

	@Override
	protected VoxelShape getShape(
			BlockState state,
			BlockGetter level,
			BlockPos pos,
			CollisionContext context
	) {
		return GOLEM_SHAPE;
	}

	@Override
	protected VoxelShape getCollisionShape(
			BlockState state,
			BlockGetter level,
			BlockPos pos,
			CollisionContext context
	) {
		return GOLEM_SHAPE;
	}
}
