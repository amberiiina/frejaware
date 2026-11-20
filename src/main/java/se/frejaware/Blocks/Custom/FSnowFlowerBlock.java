package se.frejaware.Blocks.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;
import se.frejaware.Shared.FBlockTags;

import java.util.List;

public class FSnowFlowerBlock extends VegetationBlock implements SuspiciousEffectHolder {
	private static final VoxelShape SHAPE = Block.column(6.0F, 0.0F, 10.0F);
	private final SuspiciousStewEffects suspiciousStewEffects;

	public FSnowFlowerBlock(final Holder<MobEffect> suspiciousStewEffect, final float effectSeconds, final BlockBehaviour.Properties properties) {
		this(makeEffectList(suspiciousStewEffect, effectSeconds), properties);
	}

	public FSnowFlowerBlock(final SuspiciousStewEffects suspiciousStewEffects, final BlockBehaviour.Properties properties) {
		super(properties);
		this.suspiciousStewEffects = suspiciousStewEffects;
	}

	protected boolean mayPlaceOn(final BlockState state, final BlockGetter level, final BlockPos pos) {
		return state.is(FBlockTags.SUPPORTS_SNOW_VEGETATION);
	}

	protected static SuspiciousStewEffects makeEffectList(final Holder<MobEffect> suspiciousStewEffect, final float effectSeconds) {
		return new SuspiciousStewEffects(List.of(new SuspiciousStewEffects.Entry(suspiciousStewEffect, Mth.floor(effectSeconds * 20.0F))));
	}

	protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
		return SHAPE.move(state.getOffset(pos));
	}

	public SuspiciousStewEffects getSuspiciousEffects() {
		return this.suspiciousStewEffects;
	}

	public @Nullable MobEffectInstance getBeeInteractionEffect() {
		return null;
	}
}