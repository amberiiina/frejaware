package se.frejaware.WorldGen.Biome;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.util.ARGB;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import se.frejaware.WorldGen.FPlacedFeatures;

// get decimal color from https://minecraft.wiki/w/Biome_definition_(Java_Edition)
public class FBiomeBootstrap {
	public static void bootstrap(
			BootstrapContext<Biome> context
	) {
		// -------------------
		// PEAR MEADOW
		// -------------------

		Biome pearMeadow = new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.8F)		//0.0f - 1.0f,
				.temperature(0.7F)	//-0.7f - 2.0f

				.setAttribute(
						EnvironmentAttributes.SKY_COLOR,
						ARGB.vector3fFromRGB24(0x79a6ff)
				)
				.setAttribute(
						EnvironmentAttributes.BACKGROUND_MUSIC,
						BackgroundMusic.OVERWORLD
				)
				.setAttribute(
						EnvironmentAttributes.NATURAL_MOB_SPAWNS,
						MobSpawnSettings.EMPTY
				)
				.specialEffects(
						new BiomeSpecialEffects.Builder()
								.waterColor(4159204)
								.build()
				)
				.mobSpawnSettings(
						new MobSpawnSettings.Builder()
								.addAllSpawns(MobCategory.AMBIENT,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.BAT,
														ConstantInt.of(8)
												), 10)
												.build())
								.addAllSpawns(MobCategory.CREATURE,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.PIG,
														UniformInt.of(1, 2)
												), 1)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.RABBIT,
														UniformInt.of(2, 6)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SHEEP,
														UniformInt.of(2, 4)
												), 2)
												.build())
								.addAllSpawns(MobCategory.MONSTER,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SPIDER,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ZOMBIE,
														ConstantInt.of(4)
												), 95)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ZOMBIE_VILLAGER,
														ConstantInt.of(1)
												), 5)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SKELETON,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.CREEPER,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SLIME,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ENDERMAN,
														UniformInt.of(1, 4)
												), 10)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.WITCH,
														ConstantInt.of(1)
												), 5)
												.build())
								.addAllSpawns(MobCategory.UNDERGROUND_WATER_CREATURE,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.GLOW_SQUID,
														UniformInt.of(4, 6)
												), 10)
												.build())
								.build()
				)
				.generationSettings(
						new BiomeGenerationSettings.Builder(
								context.lookup(Registries.PLACED_FEATURE),
								context.lookup(Registries.CARVER)
						)
								// carvers
								.addCarver(Carvers.CAVE)
								.addCarver(Carvers.CAVE_EXTRA_UNDERGROUND)
								.addCarver(Carvers.CANYON)
								// 2
								.addFeature(
										GenerationStep.Decoration.LAKES,
										MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND
								)
								// 3
								.addFeature(
										GenerationStep.Decoration.LOCAL_MODIFICATIONS,
										CavePlacements.AMETHYST_GEODE
								)
								// 4
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.MONSTER_ROOM
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.MONSTER_ROOM_DEEP
								)
								// 7
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIRT
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRAVEL
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRANITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRANITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIORITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIORITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_ANDESITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_ANDESITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_TUFF
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COAL_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COAL_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_MIDDLE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_SMALL
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GOLD
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GOLD_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_REDSTONE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_REDSTONE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_MEDIUM
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_LARGE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_BURIED
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_LAPIS
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_LAPIS_BURIED
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.UNDERWATER_MAGMA
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_SAND
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_CLAY
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_GRAVEL
								)
								// 9
								.addFeature(
										GenerationStep.Decoration.FLUID_SPRINGS,
										MiscOverworldPlacements.SPRING_WATER
								)
								// 10
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										CavePlacements.GLOW_LICHEN
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_GRASS_FOREST
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_PUMPKIN
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_SUGAR_CANE
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_FIREFLY_BUSH_NEAR_WATER
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										CavePlacements.ROOTED_AZALEA_TREE
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_TREE_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_MEADOW_PETALS_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_MEADOW_WILDFLOWERS_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_MEADOW_FLOWERS_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_MEADOW_BUSH_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.PEAR_MEADOW_BUSHES_PLACED_KEY
								)
								.build()
				)
				.build();

		// -------------------
		// JACARANDA GLADE
		// -------------------

		Biome jacarandaGlade = new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.9F)		//0.0f - 1.0f,
				.temperature(1.4F)	//-0.7f - 2.0f
				.setAttribute(
						EnvironmentAttributes.SKY_COLOR,
						ARGB.vector3fFromRGB24(0x79a6ff)
				)
				.setAttribute(
						EnvironmentAttributes.BACKGROUND_MUSIC,
						BackgroundMusic.OVERWORLD
				)
				.specialEffects(
						new BiomeSpecialEffects.Builder()
								.waterColor(3903923)
								.grassColorOverride(5884220)
								.build()
				)
				.mobSpawnSettings(
						new MobSpawnSettings.Builder()
								.addAllSpawns(MobCategory.AMBIENT,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.BAT,
														ConstantInt.of(8)
												), 10)
												.build())
								.addAllSpawns(MobCategory.CREATURE,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.PIG,
														UniformInt.of(1, 2)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.RABBIT,
														UniformInt.of(2, 6)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SHEEP,
														UniformInt.of(2, 4)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ALLAY,
														ConstantInt.of(1)
												), 1)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.FROG,
														UniformInt.of(1, 3)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ARMADILLO,
														UniformInt.of(1, 2)
												), 2)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.PANDA,
														UniformInt.of(1, 2)
												), 1)
												.build())
								.addAllSpawns(MobCategory.MONSTER,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SPIDER,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ZOMBIE,
														ConstantInt.of(4)
												), 95)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ZOMBIE_VILLAGER,
														ConstantInt.of(1)
												), 5)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SKELETON,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.CREEPER,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.SLIME,
														ConstantInt.of(4)
												), 100)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.ENDERMAN,
														UniformInt.of(1, 4)
												), 10)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.WITCH,
														ConstantInt.of(1)
												), 5)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.BREEZE,
														UniformInt.of(1, 2)
												), 20)
												.build())
								.addAllSpawns(MobCategory.UNDERGROUND_WATER_CREATURE,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.GLOW_SQUID,
														UniformInt.of(4, 6)
												), 10)
												.build())
								.addAllSpawns(MobCategory.WATER_AMBIENT,
										WeightedList.<MobSpawnSettings.SpawnerData>builder()
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.COD,
														UniformInt.of(1, 5)
												), 5)
												.add(new MobSpawnSettings.SpawnerData(
														EntityTypes.TROPICAL_FISH,
														UniformInt.of(1, 5)
												), 3)
												.build())
								.build()
				)
				.generationSettings(
						new BiomeGenerationSettings.Builder(
								context.lookup(Registries.PLACED_FEATURE),
								context.lookup(Registries.CARVER)
						)
								// carvers
								.addCarver(Carvers.CAVE)
								.addCarver(Carvers.CAVE_EXTRA_UNDERGROUND)
								.addCarver(Carvers.CANYON)
								// 2
								.addFeature(
										GenerationStep.Decoration.LAKES,
										MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND
								)
								// 3
								.addFeature(
										GenerationStep.Decoration.LOCAL_MODIFICATIONS,
										CavePlacements.AMETHYST_GEODE
								)
								// 4
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.MONSTER_ROOM
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.MONSTER_ROOM_DEEP
								)
								// 7
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIRT
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRAVEL
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRANITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GRANITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIORITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIORITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_ANDESITE_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_ANDESITE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_TUFF
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COAL_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COAL_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_UPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_MIDDLE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_IRON_SMALL
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GOLD
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_GOLD_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_REDSTONE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_REDSTONE_LOWER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_MEDIUM
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_LARGE
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_DIAMOND_BURIED
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_LAPIS
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_LAPIS_BURIED
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										OrePlacements.ORE_COPPER
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										CavePlacements.UNDERWATER_MAGMA
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_SAND
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_CLAY
								)
								.addFeature(
										GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
										MiscOverworldPlacements.DISK_GRAVEL
								)
								// 9
								.addFeature(
										GenerationStep.Decoration.FLUID_SPRINGS,
										MiscOverworldPlacements.SPRING_WATER
								)
								// 10
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										CavePlacements.GLOW_LICHEN
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.BAMBOO_LIGHT
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_GRASS_FOREST
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_PUMPKIN
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_SUGAR_CANE
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										VegetationPlacements.PATCH_FIREFLY_BUSH_NEAR_WATER
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										CavePlacements.ROOTED_AZALEA_TREE
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.JACARANDA_TREE_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.JACARANDA_GLADE_PETALS_PLACED_KEY
								)
								.addFeature(
										GenerationStep.Decoration.VEGETAL_DECORATION,
										FPlacedFeatures.JACARANDA_GLADE_FLOWERS_PLACED_KEY
								)
								.build()
				)
				.build();

		context.register(FBiomes.PEAR_MEADOW, pearMeadow);
		context.register(FBiomes.JACARANDA_GLADE, jacarandaGlade);
	}

	private FBiomeBootstrap() {}
}