package se.frejaware.WorldGen.Structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import se.frejaware.F;
import se.frejaware.WorldGen.Biome.FBiomes;

import java.util.Map;

public class FStructures {
	public static void bootstrap(BootstrapContext<Structure> context) {
		// ----------------------
		// PEAR
		// ----------------------

		basicStructure(context, FStructureKeys.PEAR_BERRY_FARM,
				FStructureKeys.PEAR_BERRY_FARM_POOL, FBiomes.PEAR_MEADOW, -2);
		basicStructure(context, FStructureKeys.PEAR_ARCH,
				FStructureKeys.PEAR_ARCH_POOL, FBiomes.PEAR_MEADOW, -2);
		basicStructure(context, FStructureKeys.PEAR_STONE,
				FStructureKeys.PEAR_STONE_POOL, FBiomes.PEAR_MEADOW, 0);

		// ----------------------
		// JACARANDA
		// ----------------------

		basicStructure(context, FStructureKeys.JACARANDA_WELL,
				FStructureKeys.JACARANDA_WELL_POOL, FBiomes.JACARANDA_GLADE, -2);
		basicStructure(context, FStructureKeys.JACARANDA_POT,
				FStructureKeys.JACARANDA_POT_POOL, FBiomes.JACARANDA_GLADE, 1);
		basicStructure(context, FStructureKeys.JACARANDA_ARCH,
				FStructureKeys.JACARANDA_ARCH_POOL, FBiomes.JACARANDA_GLADE, -2);
		basicStructure(context, FStructureKeys.JACARANDA_AMETHYST,
				FStructureKeys.JACARANDA_AMETHYST_POOL, FBiomes.JACARANDA_GLADE, -1);
		basicStructure(context, FStructureKeys.JACARANDA_STONE,
				FStructureKeys.JACARANDA_STONE_POOL, FBiomes.JACARANDA_GLADE, 0);

		// ----------------------
		// ORCHARD
		// ----------------------

		basicStructure(context, FStructureKeys.ORCHARD_POT,
				FStructureKeys.ORCHARD_POT_POOL, FBiomes.ORCHARD, 1);
		basicStructure(context, FStructureKeys.ORCHARD_BIG_POT,
				FStructureKeys.ORCHARD_BIG_POT_POOL, FBiomes.ORCHARD, 1);
		basicStructure(context, FStructureKeys.ORCHARD_FARM,
				FStructureKeys.ORCHARD_FARM_POOL, FBiomes.ORCHARD);

		// ----------------------
		// DESERT
		// ----------------------

		basicStructure(context, FStructureKeys.DESERT_PALM,
				FStructureKeys.DESERT_PALM_POOL, Biomes.DESERT, 2, 75);
		basicStructure(context, FStructureKeys.DESERT_STONE,
				FStructureKeys.DESERT_STONE_POOL, Biomes.DESERT, 2);
		basicStructure(context, FStructureKeys.DESERT_MUD_PYRAMID,
				FStructureKeys.DESERT_MUD_PYRAMID_POOL, Biomes.DESERT, -8);
	}

	private static void basicStructure(
			BootstrapContext<Structure> context,
			ResourceKey<Structure> key,
			ResourceKey<StructureTemplatePool> pool,
			ResourceKey<Biome> biome) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(biome)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(0)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void basicStructure(
			BootstrapContext<Structure> context,
			ResourceKey<Structure> key,
			ResourceKey<StructureTemplatePool> pool,
			ResourceKey<Biome> biome,
			final int height) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(biome)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(height)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void basicStructure(
			BootstrapContext<Structure> context,
			ResourceKey<Structure> key,
			ResourceKey<StructureTemplatePool> pool,
			ResourceKey<Biome> biome,
			final int height,
			TerrainAdjustment terrainAdjustment) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(biome)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						terrainAdjustment),
				pools.getOrThrow(pool),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(height)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void basicStructure(
			BootstrapContext<Structure> context,
			ResourceKey<Structure> key,
			ResourceKey<StructureTemplatePool> pool,
			ResourceKey<Biome> biome,
			final int height,
			final int maxY) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(biome)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(height)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, maxY));
	}

	private static void basicStructure(
			BootstrapContext<Structure> context,
			ResourceKey<Structure> key,
			ResourceKey<StructureTemplatePool> pool,
			ResourceKey<Biome> biome,
			final int height,
			final int maxY,
			TerrainAdjustment terrainAdjustment) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(biome)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						terrainAdjustment),
				pools.getOrThrow(pool),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(height)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, maxY));
	}
}