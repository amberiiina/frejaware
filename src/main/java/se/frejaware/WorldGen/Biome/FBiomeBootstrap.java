package se.frejaware.WorldGen.Biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.util.ARGB;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
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