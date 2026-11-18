package se.frejaware.Entities.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.skeleton.Stray;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class FFrostbiteCrawler extends Monster {
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;

	public FFrostbiteCrawler(final EntityType<? extends FFrostbiteCrawler> type, final Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Armadillo.class, 6.0F, 1.0F, 1.2, (entity) -> !((Armadillo)entity).isScared()));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(4, new CrawlerAttackGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new CrawlerTargetGoal<>(this, Player.class));
		this.targetSelector.addGoal(3, new CrawlerTargetGoal<>(this, IronGolem.class));
	}

	protected PathNavigation createNavigation(final Level level) {
		return new WallClimberNavigation(this, level);
	}

	protected void defineSynchedData(final SynchedEntityData.Builder entityData) {
		super.defineSynchedData(entityData);
		entityData.define(DATA_FLAGS_ID, (byte)0);
	}

	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 20.0F)
				.add(Attributes.ATTACK_DAMAGE, 4.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.3F);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.SPIDER_AMBIENT;
	}

	protected SoundEvent getHurtSound(final DamageSource source) {
		return SoundEvents.SPIDER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.SPIDER_DEATH;
	}

	protected void playStepSound(final BlockPos pos, final BlockState blockState) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	public boolean onClimbable() {
		return this.isClimbing();
	}

	public void makeStuckInBlock(final BlockState state, final Vec3 speedMultiplier) {
		if (!state.is(Blocks.COBWEB)) {
			super.makeStuckInBlock(state, speedMultiplier);
		}
	}

	public boolean canBeAffected(final MobEffectInstance newEffect) {
		return !newEffect.is(MobEffects.POISON) && super.canBeAffected(newEffect);
	}

	public boolean isClimbing() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	public void setClimbing(final boolean value) {
		byte flags = this.entityData.get(DATA_FLAGS_ID);
		if (value) {
			flags = (byte)(flags | 1);
		} else {
			flags = (byte)(flags & -2);
		}

		this.entityData.set(DATA_FLAGS_ID, flags);
	}

	public @Nullable SpawnGroupData finalizeSpawn(final ServerLevelAccessor level, final DifficultyInstance difficulty, final EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
		groupData = super.finalizeSpawn(level, difficulty, spawnReason, groupData);
		RandomSource random = level.getRandom();
		if (random.nextInt(100) == 0) {
			Stray stray = EntityTypes.STRAY.create(this.level(), EntitySpawnReason.JOCKEY);
			if (stray != null) {
				stray.snapTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
				stray.finalizeSpawn(level, difficulty, spawnReason, null);
				stray.startRiding(this, false, false);
			}
		}

		if (groupData == null) {
			groupData = new CrawlerEffectsGroupData();
			if (level.getDifficulty() == Difficulty.HARD && random.nextFloat() < 0.1F * difficulty.getSpecialMultiplier()) {
				((CrawlerEffectsGroupData)groupData).setRandomEffect(random);
			}
		}

		if (groupData instanceof CrawlerEffectsGroupData crawlerEffectsGroupData) {
			Holder<MobEffect> effect = crawlerEffectsGroupData.effect;
			if (effect != null) {
				this.addEffect(new MobEffectInstance(effect, -1));
			}
		}

		return groupData;
	}

	public Vec3 getVehicleAttachmentPoint(final Entity vehicle) {
		return vehicle.getBbWidth() <= this.getBbWidth() ? new Vec3(0.0F, (double)0.3125F * (double)this.getScale(), 0.0F) : super.getVehicleAttachmentPoint(vehicle);
	}

	static {
		DATA_FLAGS_ID = SynchedEntityData.defineId(FFrostbiteCrawler.class, EntityDataSerializers.BYTE);
	}

	public static class CrawlerEffectsGroupData implements SpawnGroupData {
		public @Nullable Holder<MobEffect> effect;

		public void setRandomEffect(final RandomSource random) {
			int selection = random.nextInt(5);
			if (selection <= 1) {
				this.effect = MobEffects.SPEED;
			} else if (selection <= 2) {
				this.effect = MobEffects.STRENGTH;
			} else if (selection <= 3) {
				this.effect = MobEffects.REGENERATION;
			} else if (selection <= 4) {
				this.effect = MobEffects.INVISIBILITY;
			}
		}
	}

	private static class CrawlerAttackGoal extends MeleeAttackGoal {
		public CrawlerAttackGoal(final FFrostbiteCrawler mob) {
			super(mob, 1.25F, true);
		}

		public boolean canUse() {
			return super.canUse() && !this.mob.isVehicle();
		}

		public boolean canContinueToUse() {
			float br = this.mob.getLightLevelDependentMagicValue();
			if (br >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
				this.mob.setTarget(null);
				return false;
			} else {
				return super.canContinueToUse();
			}
		}
	}

	private static class CrawlerTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
		public CrawlerTargetGoal(final FFrostbiteCrawler mob, final Class<T> targetType) {
			super(mob, targetType, true);
		}

		public boolean canUse() {
			float br = this.mob.getLightLevelDependentMagicValue();
			return !(br >= 0.5F) && super.canUse();
		}
	}
}