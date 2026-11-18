package se.frejaware.Entities.Custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import se.frejaware.Entities.FDamageTypes;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Items.FItems;

public class FGlazeShard extends ThrowableItemProjectile {
	public FGlazeShard(final EntityType<? extends FGlazeShard> type, final Level level) {
		super(type, level);
	}

	public FGlazeShard(final Level level, final LivingEntity mob, final ItemStack itemStack) {
		super(FEntityTypes.GLAZE_SHARD, mob, level, itemStack);
	}

	public FGlazeShard(final Level level, final double x, final double y, final double z, final ItemStack itemStack) {
		super(FEntityTypes.GLAZE_SHARD, x, y, z, level, itemStack);
	}

	protected Item getDefaultItem() {
		return FItems.GLAZE_SHARD;
	}

	private ParticleOptions getParticle() {
		ItemStack item = this.getItem();
		return item.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, ItemStackTemplate.fromNonEmptyStack(item));
	}

	public void handleEntityEvent(final @EntityEvent.Value byte id) {
		if (id == 3) {
			ParticleOptions particle = this.getParticle();
			for(int i = 0; i < 8; ++i) {
				this.level().addParticle(particle, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
			}
		}
	}

	protected void onHitEntity(final EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			Entity entity = hitResult.getEntity();
			DamageSource damageSource = FDamageTypes.glaze_shard(serverLevel, this, getOwner());
			int damage = entity instanceof Blaze ? 6 : 3;
			if (entity.hurtServer(serverLevel, damageSource, damage)) {
				EnchantmentHelper.doPostAttackEffects(serverLevel, entity, damageSource);
			}
		}
	}

	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level().isClientSide()) {
			this.level().broadcastEntityEvent(this, (byte)3);
			this.discard();
		}
	}
}
