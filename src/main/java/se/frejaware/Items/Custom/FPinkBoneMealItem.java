package se.frejaware.Items.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import se.frejaware.Shared.FBlockTags;

import java.util.ArrayList;
import java.util.List;

public class FPinkBoneMealItem extends Item {
	private static final int RADIUS = 3;
	private static final int ATTEMPTS = 48;

	public FPinkBoneMealItem(final Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(final UseOnContext context) {
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		ItemStack stack = context.getItemInHand();

		if (!(level instanceof ServerLevel serverLevel)) {
			return InteractionResult.SUCCESS;
		}

		if (spawnFromTag(serverLevel, pos)) {
			stack.shrink(1);
			stack.causeUseVibration(context.getPlayer(), GameEvent.ITEM_INTERACT_FINISH);
			level.levelEvent(1505, pos, 15);
			return InteractionResult.SUCCESS_SERVER;
		}
		return InteractionResult.PASS;
	}

	public static boolean spawnFromTag(final ServerLevel level, final BlockPos origin) {
		List<Block> candidates = new ArrayList<>();
		for (Holder<Block> holder : BuiltInRegistries.BLOCK.getTagOrEmpty(FBlockTags.PINK_BONE_MEAL)) {
			candidates.add(holder.value());
		}
		if (candidates.isEmpty()) return false;

		RandomSource random = level.getRandom();
		boolean placedAny = false;

		for (int i = 0; i < ATTEMPTS; i++) {
			BlockPos target = origin.offset(
					random.nextInt(RADIUS * 2 + 1) - RADIUS,
					random.nextInt(3) - 1 + 1,
					random.nextInt(RADIUS * 2 + 1) - RADIUS);

			if (!level.getBlockState(target).isAir()) continue;

			Block block = candidates.get(random.nextInt(candidates.size()));
			BlockState state = block.defaultBlockState();
			if (!state.canSurvive(level, target)) continue;

			if (block instanceof DoublePlantBlock) {
				if (!level.getBlockState(target.above()).isAir()) continue;
				DoublePlantBlock.placeAt(level, state, target, Block.UPDATE_ALL);
			} else {
				level.setBlock(target, state, Block.UPDATE_ALL);
			}
			placedAny = true;
		}
		return placedAny;
	}
}