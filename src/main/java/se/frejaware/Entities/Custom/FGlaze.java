package se.frejaware.Entities.Custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class FGlaze extends Monster {
	private float allowedHeightOffset = 0.5F;
	private int nextHeightOffsetChangeTick;
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;

	public FGlaze(final EntityType<? extends FGlaze> glaze, final Level level) {
		super(glaze, level);
		this.setPathfindingMalus(PathType.WATER, 8.0F);
		this.setPathfindingMalus(PathType.LAVA, -1.0F);
		this.setPathfindingMalus(PathType.FIRE_IN_NEIGHBOR, -1.0F);
		this.setPathfindingMalus(PathType.FIRE, -1.0F);
		this.xpReward = 10;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(4, new FGlaze.GlazeAttackGoal(this));
		this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0F));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0F, 0.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 24.0F)
				.add(Attributes.ATTACK_DAMAGE, 8.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.23F)
				.add(Attributes.FOLLOW_RANGE, 48.0F);
	}

	protected void defineSynchedData(final SynchedEntityData.Builder entityData) {
		super.defineSynchedData(entityData);
		entityData.define(DATA_FLAGS_ID, (byte)0);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.BLAZE_AMBIENT;
	}

	protected SoundEvent getHurtSound(final DamageSource source) {
		return SoundEvents.BLAZE_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.BLAZE_DEATH;
	}

	public float getLightLevelDependentMagicValue() {
		return 1.0F;
	}

	public void aiStep() {
		if (!this.onGround() && this.getDeltaMovement().y < (double)0.0F) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0F, 0.6, 1.0F));
		}
		if (this.level().isClientSide()) {
			if (this.random.nextInt(24) == 0 && !this.isSilent()) {
				this.level().playLocalSound(this.getX() + (double)0.5F, this.getY() + (double)0.5F, this.getZ() + (double)0.5F, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
			}
			this.level().addParticle(ParticleTypes.SNOWFLAKE,
					this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5),
					0.0, 0.0, 0.0);
			if (this.isCharged()) {
				for (int i = 0; i < 4; ++i) {
					this.level().addParticle(ParticleTypes.SNOWFLAKE,
							this.getRandomX(0.8), this.getRandomY(), this.getRandomZ(0.8),
							(this.random.nextDouble() - 0.5) * 0.1,
							0.05,
							(this.random.nextDouble() - 0.5) * 0.1);
				}
			}
		}
		super.aiStep();
	}

	public boolean isSensitiveToWater() {
		return false;
	}

	@Override
	public boolean canFreeze() {
		return false;
	}

	protected void customServerAiStep(final ServerLevel level) {
		--this.nextHeightOffsetChangeTick;
		if (this.nextHeightOffsetChangeTick <= 0) {
			this.nextHeightOffsetChangeTick = 100;
			this.allowedHeightOffset = (float)this.random.triangle(0.5F, 6.891);
		}
		LivingEntity target = this.getTarget();
		if (target != null && target.getEyeY() > this.getEyeY() + (double)this.allowedHeightOffset && this.canAttack(target)) {
			Vec3 movement = this.getDeltaMovement();
			this.setDeltaMovement(this.getDeltaMovement().add(0.0F, ((double)0.3F - movement.y) * (double)0.3F, 0.0F));
			this.needsSync = true;
		}
		super.customServerAiStep(level);
	}

	public boolean isCharged() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	private void setCharged(final boolean value) {
		byte flags = this.entityData.get(DATA_FLAGS_ID);
		if (value) {
			flags = (byte)(flags | 1);
		} else {
			flags = (byte)(flags & -2);
		}
		this.entityData.set(DATA_FLAGS_ID, flags);
	}

	static {
		DATA_FLAGS_ID = SynchedEntityData.defineId(FGlaze.class, EntityDataSerializers.BYTE);
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		if (source.is(DamageTypeTags.IS_FIRE)) {
			damage *= 2.0F;
		}
		return super.hurtServer(level, source, damage);
	}

	private static class GlazeAttackGoal extends Goal {
		private final FGlaze glaze;
		private int attackStep;
		private int attackTime;
		private int lastSeen;

		public GlazeAttackGoal(final FGlaze glaze) {
			this.glaze = glaze;
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		public boolean canUse() {
			LivingEntity target = this.glaze.getTarget();
			return target != null && target.isAlive() && this.glaze.canAttack(target);
		}

		public void start() {
			this.attackStep = 0;
		}

		public void stop() {
			this.glaze.setCharged(false);
			this.lastSeen = 0;
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			--this.attackTime;
			LivingEntity target = this.glaze.getTarget();
			if (target != null) {
				boolean hasLineOfSight = this.glaze.getSensing().hasLineOfSight(target);
				if (hasLineOfSight) {
					this.lastSeen = 0;
				} else {
					++this.lastSeen;
				}
				double distance = this.glaze.distanceToSqr(target);
				if (distance < (double)4.0F) {
					if (!hasLineOfSight) {
						return;
					}
					if (this.attackTime <= 0) {
						this.attackTime = 20;
						this.glaze.doHurtTarget(getServerLevel(this.glaze), target);
					}
					this.glaze.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0F);
				} else if (distance < this.getFollowDistance() * this.getFollowDistance() && hasLineOfSight) {
					double xd = target.getX() - this.glaze.getX();
					double yd = target.getY(0.5F) - this.glaze.getY(0.5F);
					double zd = target.getZ() - this.glaze.getZ();
					if (this.attackTime <= 0) {
						++this.attackStep;
						if (this.attackStep == 1) {
							this.attackTime = 60;
							this.glaze.setCharged(true);
						} else if (this.attackStep <= 4) {
							this.attackTime = 6;
						} else {
							this.attackTime = 100;
							this.attackStep = 0;
							this.glaze.setCharged(false);
						}
						if (this.attackStep > 1) {
							double sqd = Math.sqrt(Math.sqrt(distance)) * (double)0.5F;
							if (!this.glaze.isSilent()) {
								this.glaze.level().levelEvent(null, 1018, this.glaze.blockPosition(), 0);
							}
							for(int i = 0; i < 1; ++i) {
								Vec3 direction = new Vec3(this.glaze.getRandom().triangle(xd, 2.297 * sqd), yd, this.glaze.getRandom().triangle(zd, 2.297 * sqd));
								FGlazeball entity = new FGlazeball(this.glaze.level(), this.glaze, direction.normalize());
								entity.setPos(entity.getX(), this.glaze.getY(0.5F) + (double)0.5F, entity.getZ());
								this.glaze.level().addFreshEntity(entity);
							}
						}
					}
					this.glaze.getLookControl().setLookAt(target, 10.0F, 10.0F);
				} else if (this.lastSeen < 5) {
					this.glaze.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0F);
				}
				super.tick();
			}
		}

		private double getFollowDistance() {
			return this.glaze.getAttributeValue(Attributes.FOLLOW_RANGE);
		}
	}
}