package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import se.frejaware.Items.FItems;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FBlackberryBushBlock extends SweetBerryBushBlock {
	public FBlackberryBushBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected ItemStack getCloneItemStack(
			final LevelReader level,
			final BlockPos pos,
			final BlockState state,
			final boolean includeData) {
		return new ItemStack(FItems.BLACKBERRIES);
	}

	@Override
	protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		return List.of(new ItemStack(FItems.BLACKBERRIES));
	}

	@Override
	protected InteractionResult useWithoutItem(
			final BlockState state,
			final Level level,
			final BlockPos pos,
			final Player player,
			final BlockHitResult hitResult) {
		if (state.getValue(AGE) > 1) {
			if (level instanceof ServerLevel) {
				ServerLevel serverLevel = (ServerLevel)level;
				int count = ThreadLocalRandom.current().nextInt(1, 4);
				for (int i = 0; i < count; i++) {
					Block.dropResources(
							state,
							level,
							pos
					);
				}
				serverLevel.playSound(
						null,
						pos,
						SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES,
						SoundSource.BLOCKS,
						1.0F,
						0.8F + serverLevel.getRandom().nextFloat() * 0.4F
				);
				BlockState newState = state.setValue(AGE, 1);
				serverLevel.setBlock(pos, newState, 2);
				serverLevel.gameEvent(
						GameEvent.BLOCK_CHANGE,
						pos,
						GameEvent.Context.of(player, newState)
				);
			}
			return InteractionResult.SUCCESS;
		} else {
			return super.useWithoutItem(state, level, pos, player, hitResult);
		}
	}
}