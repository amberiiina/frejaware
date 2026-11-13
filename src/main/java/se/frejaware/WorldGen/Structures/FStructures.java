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
	public static final ResourceKey<Structure> PEAR_BERRY_FARM =
			create("pear_berry_farm");
	public static final ResourceKey<Structure> PEAR_ARCH =
			create("pear_arch");
	public static final ResourceKey<Structure> PEAR_STONE =
			create("pear_stone");

	public static final ResourceKey<Structure> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<Structure> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<Structure> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<Structure> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");
	public static final ResourceKey<Structure> JACARANDA_STONE =
			create("jacaranda_stone");

	public static final ResourceKey<Structure> ORCHARD_POT =
			create("orchard_pot");
	public static final ResourceKey<Structure> ORCHARD_BIG_POT =
			create("orchard_big_pot");
	public static final ResourceKey<Structure> ORCHARD_FARM =
			create("orchard_farm");

	public static final ResourceKey<Structure> DESERT_PALM =
			create("desert_palm");
	public static final ResourceKey<Structure> DESERT_STONE =
			create("desert_stone");

	public static void bootstrap(BootstrapContext<Structure> context) {
		// PEAR
		basicStructure(context, PEAR_BERRY_FARM, FPools.PEAR_BERRY_FARM,
				FBiomes.PEAR_MEADOW, -2);
		basicStructure(context, PEAR_ARCH, FPools.PEAR_ARCH,
				FBiomes.PEAR_MEADOW, -2);
		basicStructure(context, PEAR_STONE, FPools.PEAR_STONE,
				FBiomes.PEAR_MEADOW, 0);

		// JACARANDA
		basicStructure(context, JACARANDA_WELL, FPools.JACARANDA_WELL,
				FBiomes.JACARANDA_GLADE, -2);
		basicStructure(context, JACARANDA_POT, FPools.JACARANDA_POT,
				FBiomes.JACARANDA_GLADE, 1);
		basicStructure(context, JACARANDA_ARCH, FPools.JACARANDA_ARCH,
				FBiomes.JACARANDA_GLADE, -2);
		basicStructure(context, JACARANDA_AMETHYST, FPools.JACARANDA_AMETHYST,
				FBiomes.JACARANDA_GLADE, -1);
		basicStructure(context, JACARANDA_STONE, FPools.JACARANDA_STONE,
				FBiomes.JACARANDA_GLADE, 0);

		// ORCHARD
		basicStructure(context, ORCHARD_POT, FPools.ORCHARD_POT,
				FBiomes.ORCHARD, 1);
		basicStructure(context, ORCHARD_BIG_POT, FPools.ORCHARD_BIG_POT,
				FBiomes.ORCHARD, 1);
		basicStructure(context, ORCHARD_FARM, FPools.ORCHARD_FARM,
				FBiomes.ORCHARD);

		// VANILLA
		basicStructure(context, DESERT_PALM, FPools.DESERT_PALM,
				Biomes.DESERT, 1, 75);
		basicStructure(context, DESERT_STONE, FPools.DESERT_STONE,
				Biomes.DESERT, 2);
	}

	private static ResourceKey<Structure> create(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE,
				F.id(name)
		);
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