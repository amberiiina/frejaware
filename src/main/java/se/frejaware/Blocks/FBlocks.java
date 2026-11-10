package se.frejaware.Blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import se.frejaware.Blocks.Custom.*;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FBlocks {
	// ----------------------
	// BLOCKS
	// ----------------------

	// MOLLY
	public static final Block PINEAPPLE = register(
			FBlockItemIds.PINEAPPLE_CROP,
			FPineappleBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(state -> state.getValue(CropBlock.AGE) >= 2 ? MapColor.COLOR_YELLOW : MapColor.PLANT)
					.noCollision()
					.randomTicks()
					.instabreak()
					.sound(SoundType.CROP)
					.pushReaction(PushReaction.POPPED)
	);

	public static final Block IRON_BELL = registerBlockItem(
			FBlockItemIds.IRON_BELL,
			FIronBellBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.RAW_IRON)
					.forceSolidOn()
					.strength(5.0F)
					.sound(SoundType.ANVIL)
					.pushReaction(PushReaction.POPPED)
	);

	public static final Block WHITE_CACTUS_FLOWER = registerBlockItem(
			FBlockItemIds.WHITE_CACTUS_FLOWER,
			CactusFlowerBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.QUARTZ)
					.noCollision()
					.instabreak()
					.ignitedByLava()
					.sound(SoundType.CACTUS_FLOWER)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block YELLOW_CACTUS_FLOWER = registerBlockItem(
			FBlockItemIds.YELLOW_CACTUS_FLOWER,
			CactusFlowerBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_YELLOW)
					.noCollision()
					.instabreak()
					.ignitedByLava()
					.sound(SoundType.CACTUS_FLOWER)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block WHITE_ORCHID = registerBlockItem(
			FBlockItemIds.WHITE_ORCHID,
			p -> new FlowerBlock(MobEffects.SATURATION, 0.35F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_WHITE_ORCHID = registerBlock(
			FBlockIds.POTTED_WHITE_ORCHID,
			p -> new FlowerPotBlock(WHITE_ORCHID, p),
			Blocks.flowerPotProperties()
	);
	public static final Block YELLOW_TULIP = registerBlockItem(
			FBlockItemIds.YELLOW_TULIP,
			p -> new FlowerBlock(MobEffects.WEAKNESS, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_YELLOW_TULIP = registerBlock(
			FBlockIds.POTTED_YELLOW_TULIP,
			p -> new FlowerPotBlock(YELLOW_TULIP, p),
			Blocks.flowerPotProperties()
	);
	public static final Block ROUND_BUSH = registerBlockItem(
			FBlockItemIds.ROUND_BUSH,
			BushBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.replaceable()
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_ROUND_BUSH = registerBlock(
			FBlockIds.POTTED_ROUND_BUSH,
			p -> new FlowerPotBlock(ROUND_BUSH, p),
			Blocks.flowerPotProperties()
	);
	public static final Block WHITE_HIBISCUS = registerBlockItem(
			FBlockItemIds.WHITE_HIBISCUS,
			p -> new FlowerBlock(MobEffects.NAUSEA, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);

	public static final Block POTTED_WHITE_HIBISCUS = registerBlock(
			FBlockIds.POTTED_WHITE_HIBISCUS,
			p -> new FlowerPotBlock(WHITE_HIBISCUS, p),
			Blocks.flowerPotProperties()
	);
	public static final Block YELLOW_HIBISCUS = registerBlockItem(
			FBlockItemIds.YELLOW_HIBISCUS,
			p -> new FlowerBlock(MobEffects.NAUSEA, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_YELLOW_HIBISCUS = registerBlock(
			FBlockIds.POTTED_YELLOW_HIBISCUS,
			p -> new FlowerPotBlock(YELLOW_HIBISCUS, p),
			Blocks.flowerPotProperties()
	);
	public static final Block WHITE_CROCUS = registerBlockItem(
			FBlockItemIds.WHITE_CROCUS,
			p -> new FlowerBlock(MobEffects.REGENERATION, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_WHITE_CROCUS = registerBlock(
			FBlockIds.POTTED_WHITE_CROCUS,
			p -> new FlowerPotBlock(WHITE_CROCUS, p),
			Blocks.flowerPotProperties()
	);
	public static final Block LILAC_CROCUS = registerBlockItem(
			FBlockItemIds.LILAC_CROCUS,
			p -> new FlowerBlock(MobEffects.REGENERATION, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_LILAC_CROCUS = registerBlock(
			FBlockIds.POTTED_LILAC_CROCUS,
			p -> new FlowerPotBlock(LILAC_CROCUS, p),
			Blocks.flowerPotProperties()
	);
	public static final Block PURPLE_CROCUS = registerBlockItem(
			FBlockItemIds.PURPLE_CROCUS,
			p -> new FlowerBlock(MobEffects.REGENERATION, 7.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_PURPLE_CROCUS = registerBlock(
			FBlockIds.POTTED_PURPLE_CROCUS,
			p -> new FlowerPotBlock(PURPLE_CROCUS, p),
			Blocks.flowerPotProperties()
	);
	public static final Block LILY_OF_THE_GLADE = registerBlockItem(
			FBlockItemIds.LILY_OF_THE_GLADE,
			p -> new FlowerBlock(MobEffects.POISON, 11.0F, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.instabreak()
					.sound(SoundType.GRASS)
					.offsetType(BlockBehaviour.OffsetType.XZ)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_LILY_OF_THE_GLADE = registerBlock(
			FBlockIds.POTTED_LILY_OF_THE_GLADE,
			p -> new FlowerPotBlock(LILY_OF_THE_GLADE, p),
			Blocks.flowerPotProperties()
	);

	// FOOD
	public static final Block BLUEBERRY_BUSH = registerBlock(
			FBlockItemIds.BLUEBERRY_CROP.block(),
			FBlueberryBushBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.randomTicks()
					.noCollision()
					.sound(SoundType.SWEET_BERRY_BUSH)
					.pushReaction(PushReaction.POPPED));
	public static final Block BLACKBERRY_BUSH = registerBlock(
			FBlockItemIds.BLACKBERRY_CROP.block(),
			FBlackberryBushBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.randomTicks()
					.noCollision()
					.sound(SoundType.SWEET_BERRY_BUSH)
					.pushReaction(PushReaction.POPPED));
	public static final Block PINKBERRY_BUSH = registerBlock(
			FBlockItemIds.PINKBERRY_CROP.block(),
			FPinkberryBushBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.randomTicks()
					.noCollision()
					.sound(SoundType.SWEET_BERRY_BUSH)
					.pushReaction(PushReaction.POPPED));
	public static final Block BLOWBERRY_BUSH = registerBlock(
			FBlockItemIds.BLOWBERRY_CROP.block(),
			FBlowberryBushBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.randomTicks()
					.noCollision()
					.sound(SoundType.SWEET_BERRY_BUSH)
					.pushReaction(PushReaction.POPPED));

	// JACARANDA WOOD
	public static final Block JACARANDA_LOG = registerBlockItem(
			FBlockItemIds.JACARANDA_LOG,
			RotatedPillarBlock::new,
			Blocks.logProperties(
					MapColor.PLANT,
					MapColor.COLOR_BROWN,
					SoundType.CHERRY_WOOD
			)
	);
	public static final Block STRIPPED_JACARANDA_LOG = registerBlockItem(
			FBlockItemIds.STRIPPED_JACARANDA_LOG,
			RotatedPillarBlock::new,
			Blocks.logProperties(
					MapColor.PLANT,
					MapColor.PLANT,
					SoundType.CHERRY_WOOD
			)
	);
	public static final Block JACARANDA_WOOD = registerBlockItem(
			FBlockItemIds.JACARANDA_WOOD,
			RotatedPillarBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_BROWN)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block STRIPPED_JACARANDA_WOOD = registerBlockItem(
			FBlockItemIds.STRIPPED_JACARANDA_WOOD,
			RotatedPillarBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block JACARANDA_LEAVES = registerBlockItem(
			FBlockItemIds.JACARANDA_LEAVES,
			p -> new UntintedParticleLeavesBlock(
					0.1F,
					FParticles.JACARANDA_LEAVES,
					AmbientLeavesBlockSoundPlayer.noAmbientSound(), p
			),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.QUARTZ)
					.strength(0.2F)
					.randomTicks()
					.sound(SoundType.CHERRY_LEAVES)
					.noOcclusion()
					.isValidSpawn(Blocks::ocelotOrParrot)
					.isSuffocating(Blocks::never)
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
					.isRedstoneConductor(Blocks::never)
	);
	public static final Block JACARANDA_SAPLING = registerBlockItem(
			FBlockItemIds.JACARANDA_SAPLING,
			p -> new SaplingBlock(FTrees.JACARANDA_GROWER, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.QUARTZ)
					.noCollision()
					.randomTicks()
					.instabreak()
					.sound(SoundType.CHERRY_SAPLING)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_JACARANDA_SAPLING = registerBlock(
			FBlockIds.POTTED_JACARANDA_SAPLING,
			p -> new FlowerPotBlock(JACARANDA_SAPLING, p),
			Blocks.flowerPotProperties()
	);
	public static final Block JACARANDA_PLANKS = registerBlockItem(
			FBlockItemIds.JACARANDA_PLANKS,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block JACARANDA_STAIRS = registerStair(
			FBlockItemIds.JACARANDA_STAIRS,
			JACARANDA_PLANKS
	);
	public static final Block JACARANDA_SLAB = registerSlab(
			FBlockItemIds.JACARANDA_SLAB,
			JACARANDA_PLANKS
	);
	public static final Block JACARANDA_FENCE = registerBlockItem(
			FBlockItemIds.JACARANDA_FENCE,
			FenceBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.ignitedByLava()
					.sound(SoundType.CHERRY_WOOD)
	);
	public static final Block JACARANDA_FENCE_GATE = registerBlockItem(
			FBlockItemIds.JACARANDA_FENCE_GATE,
			p -> new FenceGateBlock(FTrees.JACARANDA_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.ignitedByLava()
	);
	public static final Block JACARANDA_DOOR = registerBlockItem(
			FBlockItemIds.JACARANDA_DOOR,
			p -> new DoorBlock(FTrees.JACARANDA_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(3.0F)
					.noOcclusion()
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block JACARANDA_TRAPDOOR = registerBlockItem(
			FBlockItemIds.JACARANDA_TRAPDOOR,
			p -> new TrapDoorBlock(FTrees.JACARANDA_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(3.0F)
					.noOcclusion()
					.isValidSpawn(Blocks::never)
					.ignitedByLava()
	);
	public static final Block JACARANDA_BUTTON = registerBlockItem(
			FBlockItemIds.JACARANDA_BUTTON,
			p -> new ButtonBlock(FTrees.JACARANDA_SET, 30, p),
			Blocks.buttonProperties()
	);
	public static final Block JACARANDA_PRESSURE_PLATE = registerBlockItem(
			FBlockItemIds.JACARANDA_PRESSURE_PLATE,
			p -> new PressurePlateBlock(FTrees.JACARANDA_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(0.5F)
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block JACARANDA_SIGN = registerBlock(
			FBlockItemIds.JACARANDA_SIGN.block(),
			p -> new StandingSignBlock(FTrees.JACARANDA_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block JACARANDA_WALL_SIGN = registerBlock(
			FBlockIds.JACARANDA_WALL_SIGN,
			p -> new WallSignBlock(FTrees.JACARANDA_WOOD, p),
			wallVariant(JACARANDA_SIGN, true)
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block JACARANDA_HANGING_SIGN = registerBlock(
			FBlockItemIds.JACARANDA_HANGING_SIGN.block(),
			p -> new CeilingHangingSignBlock(FTrees.JACARANDA_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block JACARANDA_WALL_HANGING_SIGN = registerBlock(
			FBlockIds.JACARANDA_WALL_HANGING_SIGN,
			p -> new WallHangingSignBlock(FTrees.JACARANDA_WOOD, p),
			wallVariant(JACARANDA_HANGING_SIGN, true)
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block JACARANDA_SHELF = registerBlockItem(
			FBlockItemIds.JACARANDA_SHELF,
			ShelfBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(JACARANDA_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.sound(SoundType.SHELF)
					.ignitedByLava()
					.strength(2.0F, 3.0F)
	);
	public static final Block PURPLE_PETALS = registerBlockItem(
			FBlockItemIds.PURPLE_PETALS,
			p -> new FlowerBedBlock(p, 3),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.sound(SoundType.PINK_PETALS)
					.pushReaction(PushReaction.POPPED)
	);

	// PEAR WOOD
	public static final Block PEAR_LOG = registerBlockItem(
			FBlockItemIds.PEAR_LOG,
			RotatedPillarBlock::new,
			Blocks.logProperties(
					MapColor.PLANT,
					MapColor.COLOR_BROWN,
					SoundType.CHERRY_WOOD
			)
	);
	public static final Block STRIPPED_PEAR_LOG = registerBlockItem(
			FBlockItemIds.STRIPPED_PEAR_LOG,
			RotatedPillarBlock::new,
			Blocks.logProperties(
					MapColor.PLANT,
					MapColor.PLANT,
					SoundType.CHERRY_WOOD
			)
	);
	public static final Block PEAR_WOOD = registerBlockItem(
			FBlockItemIds.PEAR_WOOD,
			RotatedPillarBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_BROWN)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block STRIPPED_PEAR_WOOD = registerBlockItem(
			FBlockItemIds.STRIPPED_PEAR_WOOD,
			RotatedPillarBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block PEAR_LEAVES = registerBlockItem(
			FBlockItemIds.PEAR_LEAVES,
			p -> new UntintedParticleLeavesBlock(
					0.1F,
					FParticles.PEAR_LEAVES,
					AmbientLeavesBlockSoundPlayer.noAmbientSound(), p
			),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.QUARTZ)
					.strength(0.2F)
					.randomTicks()
					.sound(SoundType.CHERRY_LEAVES)
					.noOcclusion()
					.isValidSpawn(Blocks::ocelotOrParrot)
					.isSuffocating(Blocks::never)
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
					.isRedstoneConductor(Blocks::never)
	);
	public static final Block PEAR_SAPLING = registerBlockItem(
			FBlockItemIds.PEAR_SAPLING,
			p -> new SaplingBlock(FTrees.PEAR_GROWER, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.QUARTZ)
					.noCollision()
					.randomTicks()
					.instabreak()
					.sound(SoundType.CHERRY_SAPLING)
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block POTTED_PEAR_SAPLING = registerBlock(
			FBlockIds.POTTED_PEAR_SAPLING,
			p -> new FlowerPotBlock(PEAR_SAPLING, p),
			Blocks.flowerPotProperties()
	);
	public static final Block PEAR_PLANKS = registerBlockItem(
			FBlockItemIds.PEAR_PLANKS,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.sound(SoundType.CHERRY_WOOD)
					.ignitedByLava()
	);
	public static final Block PEAR_STAIRS = registerStair(
			FBlockItemIds.PEAR_STAIRS,
			PEAR_PLANKS
	);
	public static final Block PEAR_SLAB = registerSlab(
			FBlockItemIds.PEAR_SLAB,
			PEAR_PLANKS
	);
	public static final Block PEAR_FENCE = registerBlockItem(
			FBlockItemIds.PEAR_FENCE,
			FenceBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.ignitedByLava()
					.sound(SoundType.CHERRY_WOOD)
	);
	public static final Block PEAR_FENCE_GATE = registerBlockItem(
			FBlockItemIds.PEAR_FENCE_GATE,
			p -> new FenceGateBlock(FTrees.PEAR_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.strength(2.0F, 3.0F)
					.ignitedByLava()
	);
	public static final Block PEAR_DOOR = registerBlockItem(
			FBlockItemIds.PEAR_DOOR,
			p -> new DoorBlock(FTrees.PEAR_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(3.0F)
					.noOcclusion()
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block PEAR_TRAPDOOR = registerBlockItem(
			FBlockItemIds.PEAR_TRAPDOOR,
			p -> new TrapDoorBlock(FTrees.PEAR_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.strength(3.0F)
					.noOcclusion()
					.isValidSpawn(Blocks::never)
					.ignitedByLava()
	);
	public static final Block PEAR_BUTTON = registerBlockItem(
			FBlockItemIds.PEAR_BUTTON,
			p -> new ButtonBlock(FTrees.PEAR_SET, 30, p),
			Blocks.buttonProperties()
	);
	public static final Block PEAR_PRESSURE_PLATE = registerBlockItem(
			FBlockItemIds.PEAR_PRESSURE_PLATE,
			p -> new PressurePlateBlock(FTrees.PEAR_SET, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(0.5F)
					.ignitedByLava()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block PEAR_SIGN = registerBlock(
			FBlockItemIds.PEAR_SIGN.block(),
			p -> new StandingSignBlock(FTrees.PEAR_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block PEAR_WALL_SIGN = registerBlock(
			FBlockIds.PEAR_WALL_SIGN,
			p -> new WallSignBlock(FTrees.PEAR_WOOD, p),
			wallVariant(PEAR_SIGN, true)
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block PEAR_HANGING_SIGN = registerBlock(
			FBlockItemIds.PEAR_HANGING_SIGN.block(),
			p -> new CeilingHangingSignBlock(FTrees.PEAR_WOOD, p),
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block PEAR_WALL_HANGING_SIGN = registerBlock(
			FBlockIds.PEAR_WALL_HANGING_SIGN,
			p -> new WallHangingSignBlock(FTrees.PEAR_WOOD, p),
			wallVariant(PEAR_HANGING_SIGN, true)
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.forceSolidOn()
					.instrument(NoteBlockInstrument.BASS)
					.noCollision()
					.strength(1.0F)
					.ignitedByLava()
	);
	public static final Block PEAR_SHELF = registerBlockItem(
			FBlockItemIds.PEAR_SHELF,
			ShelfBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(PEAR_PLANKS.defaultMapColor())
					.instrument(NoteBlockInstrument.BASS)
					.sound(SoundType.SHELF)
					.ignitedByLava()
					.strength(2.0F, 3.0F)
	);
	public static final Block WHITE_PETALS = registerBlockItem(
			FBlockItemIds.WHITE_PETALS,
			p -> new FlowerBedBlock(p, 3),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.PLANT)
					.noCollision()
					.sound(SoundType.PINK_PETALS)
					.pushReaction(PushReaction.POPPED)
	);

	// TRANSIUM
	public static final Block TRANSIUM_BLOCK = registerBlockItem(
			FBlockItemIds.TRANSIUM_BLOCK,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.instrument(NoteBlockInstrument.BELL)
					.requiresCorrectToolForDrops()
					.strength(5.0F, 6.0F)
					.sound(SoundType.AMETHYST)
	);

	// ROSE QUARTZ
	public static final BlockSetType ROSE_QUARTZ_SET_TYPE = new BlockSetType(
			"rose_quartz",
			true,
			true,
			true,
			BlockSetType.PressurePlateSensitivity.EVERYTHING,
			SoundType.AMETHYST,
			SoundEvents.IRON_DOOR_CLOSE,
			SoundEvents.IRON_DOOR_OPEN,
			SoundEvents.IRON_TRAPDOOR_CLOSE,
			SoundEvents.IRON_TRAPDOOR_OPEN,
			SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
			SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
			SoundEvents.STONE_BUTTON_CLICK_OFF,
			SoundEvents.STONE_BUTTON_CLICK_ON
	);

	public static final Block ROSE_QUARTZ_ORE = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_ORE,
			p -> new DropExperienceBlock(UniformInt.of(3, 7), p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.SAND)
					.instrument(NoteBlockInstrument.BASEDRUM)
					.requiresCorrectToolForDrops()
					.strength(3.0F, 3.0F)
					.sound(SoundType.ANCIENT_DEBRIS)
	);
	public static final Block ROSE_QUARTZ_BLOCK = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_BLOCK,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.instrument(NoteBlockInstrument.BELL)
					.requiresCorrectToolForDrops()
					.strength(5.0F, 6.0F)
					.sound(SoundType.AMETHYST)
	);
	public static final Block ROSE_QUARTZ_BRICKS = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_BRICKS,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.instrument(NoteBlockInstrument.BELL)
					.requiresCorrectToolForDrops()
					.strength(1.5F, 6.0F)
					.sound(SoundType.AMETHYST)
	);
	public static final Block ROSE_QUARTZ_BRICK_STAIRS = registerStair(
			FBlockItemIds.ROSE_QUARTZ_BRICK_STAIRS, ROSE_QUARTZ_BRICKS);
	public static final Block ROSE_QUARTZ_BRICK_SLAB = registerSlab(
			FBlockItemIds.ROSE_QUARTZ_BRICK_SLAB, ROSE_QUARTZ_BRICKS);
	public static final Block ROSE_QUARTZ_BRICK_WALL = registerWall(
			FBlockItemIds.ROSE_QUARTZ_BRICK_WALL, ROSE_QUARTZ_BRICKS);
	public static final Block CHISELED_ROSE_QUARTZ_BRICKS = registerBlockItem(
			FBlockItemIds.CHISELED_ROSE_QUARTZ_BRICKS,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.instrument(NoteBlockInstrument.BELL)
					.requiresCorrectToolForDrops()
					.strength(1.5F, 6.0f)
					.sound(SoundType.AMETHYST)
	);
	public static final Block ROSE_QUARTZ_DOOR = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_DOOR,
			p -> new DoorBlock(ROSE_QUARTZ_SET_TYPE, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(5.0F)
					.sound(SoundType.AMETHYST)
					.noOcclusion()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block ROSE_QUARTZ_TRAPDOOR = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_TRAPDOOR,
			p -> new TrapDoorBlock(ROSE_QUARTZ_SET_TYPE, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(5.0F)
					.sound(SoundType.AMETHYST)
					.noOcclusion()
					.isValidSpawn(Blocks::never)
	);
	public static final Block ROSE_QUARTZ_LADDER = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_LADDER,
			LadderBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(0.8F)
					.sound(SoundType.LADDER)
					.forceSolidOff()
					.noOcclusion()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block ROSE_QUARTZ_BARS = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_BARS,
			IronBarsBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(5.0F)
					.sound(SoundType.AMETHYST)
					.noOcclusion()
	);
	public static final Block ROSE_QUARTZ_CHAIN = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_CHAIN,
			ChainBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(5.0F)
					.sound(SoundType.CHAIN)
					.forceSolidOn()
					.noOcclusion()
	);
	public static final Block ROSE_QUARTZ_LANTERN = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_LANTERN,
			LanternBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(3.5F)
					.sound(SoundType.LANTERN)
					.lightLevel(state -> 15)
					.forceSolidOn()
					.noOcclusion()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block ROSE_QUARTZ_PRESSURE_PLATE = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_PRESSURE_PLATE,
			p -> new PressurePlateBlock(ROSE_QUARTZ_SET_TYPE, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.instrument(NoteBlockInstrument.BELL)
					.requiresCorrectToolForDrops()
					.strength(0.5F)
					.sound(SoundType.AMETHYST)
					.forceSolidOn()
					.noOcclusion()
					.pushReaction(PushReaction.POPPED)
	);
	public static final Block ROSE_QUARTZ_BUTTON = registerBlockItem(
			FBlockItemIds.ROSE_QUARTZ_BUTTON,
			p -> new ButtonBlock(ROSE_QUARTZ_SET_TYPE, 30, p),
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PINK)
					.requiresCorrectToolForDrops()
					.strength(0.5F)
					.sound(SoundType.AMETHYST)
					.noCollision()
					.pushReaction(PushReaction.POPPED)
	);

	// GOLEM HEADS
	public static final Block GOLEM_HEAD_AMETHYST = registerBlock(
			FBlockItemIds.GOLEM_HEAD_AMETHYST.block(),
			p -> new FSkullBlock(FSkullBlock.Types.AMETHYST, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_AMETHYST = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_AMETHYST.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.AMETHYST, p),
			wallVariant(GOLEM_HEAD_AMETHYST, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_COAL = registerBlock(
			FBlockItemIds.GOLEM_HEAD_COAL.block(),
			p -> new FSkullBlock(FSkullBlock.Types.COAL, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_COAL = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_COAL.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.COAL, p),
			wallVariant(GOLEM_HEAD_COAL, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_DIAMOND = registerBlock(
			FBlockItemIds.GOLEM_HEAD_DIAMOND.block(),
			p -> new FSkullBlock(FSkullBlock.Types.DIAMOND, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_DIAMOND = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_DIAMOND.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.DIAMOND, p),
			wallVariant(GOLEM_HEAD_DIAMOND, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_EMERALD = registerBlock(
			FBlockItemIds.GOLEM_HEAD_EMERALD.block(),
			p -> new FSkullBlock(FSkullBlock.Types.EMERALD, p),
			BlockBehaviour.Properties.of()
					.instrument(NoteBlockInstrument.BIT)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_EMERALD = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_EMERALD.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.EMERALD, p),
			wallVariant(GOLEM_HEAD_EMERALD, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_GOLD = registerBlock(
			FBlockItemIds.GOLEM_HEAD_GOLD.block(),
			p -> new FSkullBlock(FSkullBlock.Types.GOLD, p),
			BlockBehaviour.Properties.of()
					.instrument(NoteBlockInstrument.BELL)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_GOLD = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_GOLD.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.GOLD, p),
			wallVariant(GOLEM_HEAD_GOLD, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_IRON = registerBlock(
			FBlockItemIds.GOLEM_HEAD_IRON.block(),
			(p) -> new FSkullBlock(FSkullBlock.Types.IRON, p),
			BlockBehaviour.Properties.of()
					.instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_IRON = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_IRON.block(),
			(p) -> new FWallSkullBlock(FSkullBlock.Types.IRON, p),
			wallVariant(GOLEM_HEAD_IRON, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_LAPIS = registerBlock(
			FBlockItemIds.GOLEM_HEAD_LAPIS.block(),
			p -> new FSkullBlock(FSkullBlock.Types.LAPIS, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_LAPIS = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_LAPIS.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.LAPIS, p),
			wallVariant(GOLEM_HEAD_LAPIS, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_NETHERITE = registerBlock(
			FBlockItemIds.GOLEM_HEAD_NETHERITE.block(),
			p -> new FSkullBlock(FSkullBlock.Types.NETHERITE, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_NETHERITE = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_NETHERITE.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.NETHERITE, p),
			wallVariant(GOLEM_HEAD_NETHERITE, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_HEAD_REDSTONE = registerBlock(
			FBlockItemIds.GOLEM_HEAD_REDSTONE.block(),
			p -> new FSkullBlock(FSkullBlock.Types.REDSTONE, p),
			BlockBehaviour.Properties.of()
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.noOcclusion()
					.requiresCorrectToolForDrops()
	);
	public static final Block GOLEM_WALL_HEAD_REDSTONE = registerBlock(
			FBlockItemIds.GOLEM_WALL_HEAD_REDSTONE.block(),
			p -> new FWallSkullBlock(FSkullBlock.Types.REDSTONE, p),
			wallVariant(GOLEM_HEAD_REDSTONE, true)
					.strength(1.0F)
					.pushReaction(PushReaction.POPPED)
					.requiresCorrectToolForDrops()
	);

	// items
	static {
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_AMETHYST,
				GOLEM_HEAD_AMETHYST,
				GOLEM_WALL_HEAD_AMETHYST
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_COAL,
				GOLEM_HEAD_COAL,
				GOLEM_WALL_HEAD_COAL
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_DIAMOND,
				GOLEM_HEAD_DIAMOND,
				GOLEM_WALL_HEAD_DIAMOND
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_EMERALD,
				GOLEM_HEAD_EMERALD,
				GOLEM_WALL_HEAD_EMERALD
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_GOLD,
				GOLEM_HEAD_GOLD,
				GOLEM_WALL_HEAD_GOLD
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_IRON,
				GOLEM_HEAD_IRON,
				GOLEM_WALL_HEAD_IRON
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_LAPIS,
				GOLEM_HEAD_LAPIS,
				GOLEM_WALL_HEAD_LAPIS
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_NETHERITE,
				GOLEM_HEAD_NETHERITE,
				GOLEM_WALL_HEAD_NETHERITE
		);
		registerGolemHeadItem(
				FBlockItemIds.GOLEM_HEAD_REDSTONE,
				GOLEM_HEAD_REDSTONE,
				GOLEM_WALL_HEAD_REDSTONE
		);
	}

	// ----------------------
	// FUNCTIONS
 	// ----------------------

	private static BlockBehaviour.Properties wallVariant(final Block standingBlock, final boolean copyName) {
		BlockBehaviour.Properties wallProperties = BlockBehaviour.Properties.of().overrideLootTable(standingBlock.getLootTable());
		if (copyName) {
			wallProperties = wallProperties.overrideDescription(standingBlock.getDescriptionId());
		}
		return wallProperties;
	}

	// block
	private static Block register(
			final BlockItemId id,
			final Function<BlockBehaviour.Properties, Block> factory,
			final BlockBehaviour.Properties properties) {
		return register(id.block(), factory, properties);
	}

	public static Block register(
			final ResourceKey<Block> id,
			final Function<BlockBehaviour.Properties, Block> factory,
			final BlockBehaviour.Properties properties) {
		Block block = factory.apply(properties.setId(id));
		return Registry.register(BuiltInRegistries.BLOCK, id, block);
	}

	// block without item
	private static Block registerBlock(
			ResourceKey<Block> id,
			Function<BlockBehaviour.Properties, Block> blockFactory,
			BlockBehaviour.Properties properties
	) {
		return Registry.register(
				BuiltInRegistries.BLOCK,
				id,
				blockFactory.apply(properties.setId(id))
		);
	}

	// block with item
	private static Block registerBlockItem(
			BlockItemId id,
			Function<BlockBehaviour.Properties, Block> blockFactory,
			BlockBehaviour.Properties properties
	) {
		Block block = registerBlock(id.block(), blockFactory, properties);

		Item.Properties props = new Item.Properties()
				.useBlockDescriptionPrefix()
				.setId(id.item());

		if (id.block().identifier().getPath().contains("rose_quartz")) {
			props.rarity(Rarity.EPIC);
		}

		BlockItem blockItem = new BlockItem(block, props);

		Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

		return block;
	}

	// register stair
	private static Block registerStair(final BlockItemId id, final Block base) {
		return registerBlockItem(
				id, p -> new StairBlock(
						base.defaultBlockState(), p
				),
				BlockBehaviour.Properties.ofFullCopy(base)
						.isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE)
		);
	}

	// register slab
	private static Block registerSlab(final BlockItemId id, final Block base) {
		return registerBlockItem(
				id,
				SlabBlock::new,
				BlockBehaviour.Properties.ofFullCopy(base)
						.isViewBlocking(NEAR_PLANE_INTERSECTS_OUTLINE)
		);
	}

	// register wall
	private static Block registerWall(final BlockItemId id, final Block base) {
		return registerBlockItem(
				id,
				WallBlock::new,
				BlockBehaviour.Properties.ofFullCopy(base)
						.forceSolidOn()
		);
	}

	// register golem head item
	private static void registerGolemHeadItem(
			BlockItemId id,
			Block standingBlock,
			Block wallBlock
	) {
		Registry.register(
				BuiltInRegistries.ITEM,
				id.item(),
				new FGolemHeadItem(
						standingBlock,
						wallBlock,
						new Item.Properties()
								.useBlockDescriptionPrefix()
								.setId(id.item())
				)
		);
	}

	// helpers
	private static final BlockBehaviour.StateArgumentPredicate<AABB>
			NEAR_PLANE_INTERSECTS_OUTLINE = (
			state, level,
			blockPos, nearPlaneBox) -> {
		for (AABB outlineBox : state.getOcclusionShape().toAabbs()) {
			if (outlineBox.move(blockPos).intersects(nearPlaneBox)) {
				return true;
			}
		}
		return false;
	};

	public static void initialize() {}
}