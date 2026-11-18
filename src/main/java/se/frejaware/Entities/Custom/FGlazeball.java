package se.frejaware.Entities.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import se.frejaware.Entities.FDamageTypes;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Items.FItems;

public class FGlazeball extends Fireball {
	public FGlazeball(final EntityType<? extends FGlazeball> type, final Level level) {
		super(type, level);
		this.setItem(new ItemStack(FItems.GLAZE_SHARD));
	}

	public FGlazeball(final Level level, final LivingEntity mob, final Vec3 direction) {
		super(FEntityTypes.GLAZEBALL, mob, direction, level);
		this.setItem(new ItemStack(FItems.GLAZE_SHARD));
	}

	public FGlazeball(final Level level, final double x, final double y, final double z, final Vec3 direction) {
		super(FEntityTypes.GLAZEBALL, x, y, z, direction, level);
		this.setItem(new ItemStack(FItems.GLAZE_SHARD));
	}

	@Override
	protected boolean shouldBurn() {
		return false;
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.SNOWFLAKE;
	}

	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level().isClientSide()) {
			this.discard();
		}
	}

	protected void onHitEntity(final EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			Entity target = hitResult.getEntity();
			Entity owner = this.getOwner();
			DamageSource damageSource = FDamageTypes.glazeball(serverLevel, this, owner);

			if (target.hurtServer(serverLevel, damageSource, 8.0F)) {
				EnchantmentHelper.doPostAttackEffects(serverLevel, target, damageSource);

				if (target.canFreeze()) {
					target.setTicksFrozen(target.getTicksRequiredToFreeze() + 100);
				}
				if (target instanceof LivingEntity living) {
					living.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200, 2), owner);
					// add freezing once 26.4 is out
				}
			}
		}
	}
}