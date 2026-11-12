package se.frejaware.Entities.Custom;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SpellParticleOption;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.cow.AbstractCow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import org.jspecify.annotations.Nullable;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Shared.FDataComponents;

import java.util.Optional;
import java.util.UUID;
import java.util.function.IntFunction;

public class FMoobloom extends AbstractCow implements Shearable {
	private static final EntityDataAccessor<Integer> DATA_TYPE;
	private static final EntityDimensions BABY_DIMENSIONS;
	private @Nullable SuspiciousStewEffects stewEffects;
	private @Nullable UUID lastLightningBoltUUID;

	public static AttributeSupplier.Builder createAttributes() {
		return Animal.createAnimalAttributes()
				.add(Attributes.MAX_HEALTH, 10.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.2F);
	}

	public FMoobloom(final EntityType<? extends FMoobloom> type, final Level level) {
		super(type, level);
	}

	public float getWalkTargetValue(final BlockPos pos, final LevelReader level) {
		return level.getBlockState(pos.below())
				.is(BlockTags.FLOWERS) ? 10.0F : level.getPathfindingCostFromLightLevels(pos);
	}

	public void thunderHit(final ServerLevel level, final LightningBolt lightningBolt) {
		UUID lightningBoltUUID = lightningBolt.getUUID();
		if (!lightningBoltUUID.equals(lastLightningBoltUUID)) {
			setVariant(switch (getVariant()) {
				case YELLOW -> Variant.YELLOW;
				case PINK -> Variant.PINK;
				case BLUE -> Variant.BLUE;
				case PURPLE -> Variant.PURPLE;
				case BLACK -> Variant.BLACK;
				case RED -> Variant.RED;
				case WHITE -> Variant.WHITE;
			});
			lastLightningBoltUUID = lightningBoltUUID;
			playSound(SoundEvents.MOOSHROOM_CONVERT, 2.0F, 1.0F);
		}
	}

	protected void defineSynchedData(final SynchedEntityData.Builder entityData) {
		super.defineSynchedData(entityData);
		entityData.define(DATA_TYPE, Variant.DEFAULT.id);
	}

	public InteractionResult mobInteract(final Player player, final InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		// bone mealing drops the corresponding flower
		if (itemStack.is(Items.BONE_MEAL)) {
			Level level = level();
			if (level instanceof ServerLevel serverLevel) {
				serverLevel.playSound(
						null, this,
						SoundEvents.BONE_MEAL_USE, SoundSource.NEUTRAL,
						1.0F, 1.0F
				);
				spawnAtLocation(serverLevel, getVariant().getFlowerStack(1));
				itemStack.shrink(1);
			}
			return InteractionResult.SUCCESS;

			// shearing turns moobloom into regular cow
		} else if (itemStack.is(Items.SHEARS) && readyForShearing()) {
			Level level = level();
			if (level instanceof ServerLevel serverLevel) {
				shear(serverLevel, SoundSource.PLAYERS, itemStack);
				gameEvent(GameEvent.SHEAR, player);
				itemStack.hurtAndBreak(1, player, hand.asEquipmentSlot());
			}
			return InteractionResult.SUCCESS;

			// default
		} else {
			return super.mobInteract(player, hand);
		}
	}

	public void shear(
			final ServerLevel level,
			final SoundSource soundSource,
			final ItemStack tool) {
		level.playSound(
				null, this,
				SoundEvents.MOOSHROOM_SHEAR, soundSource,
				1.0F, 1.0F
		);
		this.convertTo(EntityTypes.COW, ConversionParams.single(
				this, false, false
		), (cow) -> {
			level.sendParticles(ParticleTypes.EXPLOSION,
					this.getX(), this.getY(0.5F), this.getZ(),
					1, 0.0F, 0.0F, 0.0F, 0.0F
			);
			spawnAtLocation(level, getVariant().getFlowerStack(3));
		});
	}

	@Override
	public boolean readyForShearing() {
		return !isBaby();
	}

	@Override
	protected void addAdditionalSaveData(final ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.store("variant", Variant.CODEC, getVariant());
	}

	@Override
	protected void readAdditionalSaveData(final ValueInput input) {
		super.readAdditionalSaveData(input);
		input.read("variant", Variant.CODEC).ifPresent(this::setVariant);
	}

	@Override
	public @Nullable SpawnGroupData finalizeSpawn(
			final ServerLevelAccessor level,
			final DifficultyInstance difficulty,
			final EntitySpawnReason reason,
			@Nullable final SpawnGroupData groupData) {
		Variant[] all = Variant.values();
		setVariant(all[random.nextInt(all.length)]);
		return super.finalizeSpawn(level, difficulty, reason, groupData);
	}

	private void setVariant(final Variant variant) {
		entityData.set(DATA_TYPE, variant.id);
	}

	public Variant getVariant() {
		return Variant.byId(entityData.get(DATA_TYPE));
	}

	public <T> @Nullable T get(final DataComponentType<? extends T> type) {
		return type == FDataComponents.MOOBLOOM_VARIANT ?
				castComponentValue(type, getVariant()) : super.get(type);
	}

	protected void applyImplicitComponents(final DataComponentGetter components) {
		applyImplicitComponentIfPresent(components, FDataComponents.MOOBLOOM_VARIANT);
		super.applyImplicitComponents(components);
	}

	protected <T> boolean applyImplicitComponent(
			final DataComponentType<T> type, final T value) {
		if (type == FDataComponents.MOOBLOOM_VARIANT) {
			setVariant(castComponentValue(FDataComponents.MOOBLOOM_VARIANT, value));
			return true;
		} else {
			return super.applyImplicitComponent(type, value);
		}
	}

	public EntityDimensions getDefaultDimensions(final Pose pose) {
		return isBaby() ? BABY_DIMENSIONS : super.getDefaultDimensions(pose);
	}

	public @Nullable FMoobloom getBreedOffspring(
			final ServerLevel level, final AgeableMob partner) {
		FMoobloom baby = FEntityTypes.MOOBLOOM.create(level, EntitySpawnReason.BREEDING);
		if (baby != null) {
			baby.setVariant(getOffspringVariant((FMoobloom)partner));
		}

		return baby;
	}

	private Variant getOffspringVariant(final FMoobloom mate) {
		Variant variant = getVariant();
		Variant mateVariant = mate.getVariant();
		Variant babyVariant;
		if (variant == mateVariant && random.nextInt(1024) == 0) {
			babyVariant = variant.randomOther(random);
		} else {
			babyVariant = random.nextBoolean() ? variant : mateVariant;
		}
		return babyVariant;
	}

	static {
		DATA_TYPE = SynchedEntityData.defineId(FMoobloom.class, EntityDataSerializers.INT);
		BABY_DIMENSIONS = EntityDimensions.scalable(0.45F, 0.7F)
				.withEyeHeight(0.69F)
				.withAttachments(EntityAttachments.builder()
						.attach(EntityAttachment.PASSENGER, 0.0F, 0.75F, 0.0F)
				);
	}

	public enum Variant implements StringRepresentable {
		YELLOW("yellow", 0, Blocks.DANDELION.defaultBlockState()),
		PINK("pink", 1, Blocks.PINK_TULIP.defaultBlockState()),
		BLUE("blue", 2, Blocks.CORNFLOWER.defaultBlockState()),
		PURPLE("purple", 3, Blocks.ALLIUM.defaultBlockState()),
		BLACK("black", 4, Blocks.WITHER_ROSE.defaultBlockState()),
		RED("red", 5, Blocks.POPPY.defaultBlockState()),
		WHITE("white", 6, FBlocks.WHITE_ORCHID.defaultBlockState());

		public static final Variant DEFAULT = YELLOW;
		public static final Codec<Variant> CODEC =
				StringRepresentable.fromEnum(Variant::values);
		private static final IntFunction<Variant> BY_ID =
				ByIdMap.continuous(Variant::id, values(),
						ByIdMap.OutOfBoundsStrategy.CLAMP
				);
		public static final StreamCodec<ByteBuf, Variant> STREAM_CODEC =
				ByteBufCodecs.idMapper(BY_ID, Variant::id);
		private final String type;
		private final int id;
		private final BlockState blockState;

		Variant(final String type, final int id, final BlockState blockState) {
			this.type = type;
			this.id = id;
			this.blockState = blockState;
		}

		public BlockState getBlockState() {
			return blockState;
		}

		public String getSerializedName() {
			return type;
		}

		private int id() {
			return id;
		}

		private static Variant byId(final int id) {
			return BY_ID.apply(id);
		}

		public Variant randomOther(RandomSource random) {
			Variant[] all = values();
			int i = random.nextInt(all.length - 1);
			return all[i >= ordinal() ? i + 1 : i];
		}

		public ItemStack getFlowerStack(int count) {
			return new ItemStack(blockState.getBlock().asItem(), count);
		}
	}
}
