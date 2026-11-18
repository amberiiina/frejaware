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
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import se.frejaware.WorldGen.Biome.FBiomes;

import java.util.Map;

public class FStructures {
	public static void bootstrap(BootstrapContext<Structure> context) {
		// don't use terrain adjustment if the height is anything but 0

		// ----------------------
		// PEAR
		// ----------------------

		// generates perfectly, although i did see a stone spawn on a thinbeard island so maybe raise minY by 1?
		thinBeard(context, FStructureKeys.PEAR_ARCH, FStructureKeys.PEAR_ARCH_POOL, FBiomes.PEAR_MEADOW);
		thinBeard(context, FStructureKeys.PEAR_BERRY_FARM, FStructureKeys.PEAR_BERRY_FARM_POOL, FBiomes.PEAR_MEADOW);
		thinBeard(context, FStructureKeys.PEAR_STONE, FStructureKeys.PEAR_STONE_POOL, FBiomes.PEAR_MEADOW);

		// ----------------------
		// JACARANDA
		// ----------------------

		// generates perfectly
		thinBeard(context, FStructureKeys.JACARANDA_AMETHYST, FStructureKeys.JACARANDA_AMETHYST_POOL, FBiomes.JACARANDA_GLADE);
		thinBeard(context, FStructureKeys.JACARANDA_ARCH, FStructureKeys.JACARANDA_ARCH_POOL, FBiomes.JACARANDA_GLADE);
		thinBeard(context, FStructureKeys.JACARANDA_POT, FStructureKeys.JACARANDA_POT_POOL, FBiomes.JACARANDA_GLADE);
		thinBeard(context, FStructureKeys.JACARANDA_STONE, FStructureKeys.JACARANDA_STONE_POOL, FBiomes.JACARANDA_GLADE);
		noBeard(context, FStructureKeys.JACARANDA_WELL, FStructureKeys.JACARANDA_WELL_POOL, FBiomes.JACARANDA_GLADE, -2);

		// ----------------------
		// ORCHARD
		// ----------------------

		// generates perfectly
		thinBeard(context, FStructureKeys.ORCHARD_BIG_POT, FStructureKeys.ORCHARD_BIG_POT_POOL, FBiomes.ORCHARD);
		thinBeard(context, FStructureKeys.ORCHARD_FARM, FStructureKeys.ORCHARD_FARM_POOL, FBiomes.ORCHARD);
		thinBeard(context, FStructureKeys.ORCHARD_GREENHOUSE, FStructureKeys.ORCHARD_GREENHOUSE_POOL, FBiomes.ORCHARD);
		thinBeard(context, FStructureKeys.ORCHARD_PERGOLA, FStructureKeys.ORCHARD_PERGOLA_POOL, FBiomes.ORCHARD);
		thinBeard(context, FStructureKeys.ORCHARD_POT, FStructureKeys.ORCHARD_POT_POOL, FBiomes.ORCHARD);

		// ----------------------
		// ARCTIC
		// ----------------------

		// generates perfectly
		thinBeard(context, FStructureKeys.ARCTIC_FLOWER_FARM, FStructureKeys.ARCTIC_FLOWER_FARM_POOL, FBiomes.ARCTIC);
		thinBeard(context, FStructureKeys.ARCTIC_LAMP, FStructureKeys.ARCTIC_LAMP_POOL, FBiomes.ARCTIC);
		noBeard(context, FStructureKeys.ARCTIC_WELL, FStructureKeys.ARCTIC_WELL_POOL, FBiomes.ARCTIC, -2);

		// ----------------------
		// DESERT
		// ----------------------

		// generates perfectly
		thinBeard(context, FStructureKeys.DESERT_ARCH, FStructureKeys.DESERT_ARCH_POOL, Biomes.DESERT);
		thinBeard(context, FStructureKeys.DESERT_DEAD_TREE, FStructureKeys.DESERT_DEAD_TREE_POOL, Biomes.DESERT);
		thinBeardJigsaw(context, FStructureKeys.DESERT_DRY_POND, FStructureKeys.DESERT_DRY_POND_POOL, Biomes.DESERT, 2);
		thinBeard(context, FStructureKeys.DESERT_FOSSIL, FStructureKeys.DESERT_FOSSIL_POOL, Biomes.DESERT);
		thinBeardJigsaw(context, FStructureKeys.DESERT_MUD_PYRAMID, FStructureKeys.DESERT_MUD_PYRAMID_POOL, Biomes.DESERT, 2);
		thinBeard(context, FStructureKeys.DESERT_PALM, FStructureKeys.DESERT_PALM_POOL, Biomes.DESERT);
		thinBeard(context, FStructureKeys.DESERT_SHRINE, FStructureKeys.DESERT_SHRINE_POOL, Biomes.DESERT);
		thinBeard(context, FStructureKeys.DESERT_STONE, FStructureKeys.DESERT_STONE_POOL, Biomes.DESERT);

		// ----------------------
		// BEACH
		// ----------------------

		thinBeard(context, FStructureKeys.BEACH_SANDCASTLE, FStructureKeys.BEACH_SANDCASTLE_POOL, Biomes.BEACH);
	}

	private static void noBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void noBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int height) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void noBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int height, int minY) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), minY, 384));
	}

	private static void thinBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void thinBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int height) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void thinBeard(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int height, int minY) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), 1, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), minY, 384));
	}

	private static void thinBeardJigsaw(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int depth) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), depth, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void thinBeardJigsaw(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int depth, int height) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), depth, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static void thinBeardJigsaw(
			BootstrapContext<Structure> context, ResourceKey<Structure> key, ResourceKey<StructureTemplatePool> pool, ResourceKey<Biome> biome, int depth, int height, int minY) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		context.register(key, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(biome)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(pool), depth, ConstantHeight.of(VerticalAnchor.absolute(height)), false, Heightmap.Types.WORLD_SURFACE_WG
		), minY, 384));
	}
}