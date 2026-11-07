package se.frejaware.Entities.Custom;

import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import se.frejaware.Blocks.Custom.FSkullBlock;
import se.frejaware.Entities.FEntityTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FGolemSpawner {
	/** A pattern that can never match; used to disable the vanilla iron golem. */
	public static final BlockPattern NEVER = BlockPatternBuilder.start()
			.aisle("#")
			.where('#', BlockInWorld.hasState(state -> false))
			.build();

	private record Spec(Block material, Supplier<EntityType<? extends IronGolem>> entity) {}

	private static final Map<SkullBlock.Type, Spec> SPECS = Map.of(
			FSkullBlock.Types.AMETHYST,  new Spec(Blocks.AMETHYST_BLOCK,  () -> FEntityTypes.GOLEM_AMETHYST),
			FSkullBlock.Types.COAL,      new Spec(Blocks.COAL_BLOCK,      () -> FEntityTypes.GOLEM_COAL),
			FSkullBlock.Types.DIAMOND,   new Spec(Blocks.DIAMOND_BLOCK,   () -> FEntityTypes.GOLEM_DIAMOND),
			FSkullBlock.Types.EMERALD,   new Spec(Blocks.EMERALD_BLOCK,   () -> FEntityTypes.GOLEM_EMERALD),
			FSkullBlock.Types.GOLD,      new Spec(Blocks.GOLD_BLOCK,      () -> FEntityTypes.GOLEM_GOLD),
			FSkullBlock.Types.IRON,      new Spec(Blocks.IRON_BLOCK,      () -> EntityTypes.IRON_GOLEM),
			FSkullBlock.Types.LAPIS,     new Spec(Blocks.LAPIS_BLOCK,     () -> FEntityTypes.GOLEM_LAPIS),
			FSkullBlock.Types.NETHERITE, new Spec(Blocks.NETHERITE_BLOCK, () -> FEntityTypes.GOLEM_NETHERITE),
			FSkullBlock.Types.REDSTONE,  new Spec(Blocks.REDSTONE_BLOCK,  () -> FEntityTypes.GOLEM_REDSTONE)
	);

	private static final Map<SkullBlock.Type, BlockPattern> PATTERNS = new HashMap<>();

	private FGolemSpawner() {}

	public static void trySpawn(Level level, BlockPos pos, BlockState state) {
		if (!(level instanceof ServerLevel serverLevel)) return;
		if (!(state.getBlock() instanceof AbstractSkullBlock skull)) return;

		Spec spec = SPECS.get(skull.getType());
		if (spec == null) return;

		BlockPattern pattern = PATTERNS.computeIfAbsent(skull.getType(), t ->
				BlockPatternBuilder.start()
						.aisle("~^~", "###", "~#~")
						.where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(state.getBlock())))
						.where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(spec.material())))
						.where('~', BlockInWorld.hasState(BlockBehaviour.BlockStateBase::isAir))
						.build());

		BlockPattern.BlockPatternMatch match = pattern.find(level, pos);
		if (match == null) return;

		IronGolem golem = spec.entity().get().create(serverLevel, EntitySpawnReason.TRIGGERED);
		if (golem == null) return;
		golem.setPlayerCreated(true);

		for (int x = 0; x < pattern.getWidth(); x++) {
			for (int y = 0; y < pattern.getHeight(); y++) {
				BlockInWorld b = match.getBlock(x, y, 0);
				level.setBlock(b.getPos(), Blocks.AIR.defaultBlockState(), 2);
				level.levelEvent(2001, b.getPos(), Block.getId(b.getState()));
			}
		}

		BlockPos spawn = match.getBlock(1, 2, 0).getPos();
		golem.snapTo(spawn.getX() + 0.5, spawn.getY() + 0.05, spawn.getZ() + 0.5, 0.0F, 0.0F);
		level.addFreshEntity(golem);

		for (ServerPlayer player : level.getEntitiesOfClass(ServerPlayer.class, golem.getBoundingBox().inflate(5.0))) {
			CriteriaTriggers.SUMMONED_ENTITY.trigger(player, golem);
		}

		for (int x = 0; x < pattern.getWidth(); x++) {
			for (int y = 0; y < pattern.getHeight(); y++) {
				level.updateNeighborsAt(match.getBlock(x, y, 0).getPos(), Blocks.AIR);
			}
		}
	}
}