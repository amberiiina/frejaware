package se.frejaware.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import se.frejaware.Blocks.Custom.FIronBellBlockEntity;
import se.frejaware.F;

public class FBlockEntityTypes {
	public static final BlockEntityType<FIronBellBlockEntity> IRON_BELL =
			register("iron_bell", FIronBellBlockEntity::new, FBlocks.IRON_BELL);

	private static <T extends BlockEntity> BlockEntityType<T> register(
			String name,
			FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
			Block... blocks
	) {
		return Registry.register(
				BuiltInRegistries.BLOCK_ENTITY_TYPE,
				F.id(name),
				FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build()
		);
	}
}