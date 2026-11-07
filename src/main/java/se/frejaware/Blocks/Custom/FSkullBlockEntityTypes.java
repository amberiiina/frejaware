package se.frejaware.Blocks.Custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.mixin.BlockEntityTypeAccessor;

import java.util.HashSet;
import java.util.Set;

public class FSkullBlockEntityTypes {
	public static void register() {
		BlockEntityType<?> skullType =
				BuiltInRegistries.BLOCK_ENTITY_TYPE
						.get(Identifier.withDefaultNamespace("skull"))
						.orElseThrow()
						.value();

		BlockEntityTypeAccessor accessor = (BlockEntityTypeAccessor) (Object) skullType;
		Set<Block> blocks = new HashSet<>(accessor.frejaware$getValidBlocks());

		blocks.add(FBlocks.GOLEM_HEAD_AMETHYST);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_AMETHYST);
		blocks.add(FBlocks.GOLEM_HEAD_COAL);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_COAL);
		blocks.add(FBlocks.GOLEM_HEAD_DIAMOND);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_DIAMOND);
		blocks.add(FBlocks.GOLEM_HEAD_EMERALD);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_EMERALD);
		blocks.add(FBlocks.GOLEM_HEAD_GOLD);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_GOLD);
		blocks.add(FBlocks.GOLEM_HEAD_IRON);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_IRON);
		blocks.add(FBlocks.GOLEM_HEAD_LAPIS);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_LAPIS);
		blocks.add(FBlocks.GOLEM_HEAD_NETHERITE);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_NETHERITE);
		blocks.add(FBlocks.GOLEM_HEAD_REDSTONE);
		blocks.add(FBlocks.GOLEM_WALL_HEAD_REDSTONE);

		accessor.frejaware$setValidBlocks(Set.copyOf(blocks));
	}
}