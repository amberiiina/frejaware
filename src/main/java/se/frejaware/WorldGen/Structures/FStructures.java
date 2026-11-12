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

	public static final ResourceKey<Structure> DESERT_PALM =
			create("desert_palm");
	public static final ResourceKey<Structure> DESERT_STONE =
			create("desert_stone");

	public static void bootstrap(BootstrapContext<Structure> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		// PEAR
		context.register(PEAR_BERRY_FARM, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.PEAR_MEADOW)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(FPools.PEAR_BERRY_FARM),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(PEAR_ARCH, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.PEAR_MEADOW)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.PEAR_ARCH),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(PEAR_STONE, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.PEAR_MEADOW)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.PEAR_STONE),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(0)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));

		// JACARANDA
		context.register(JACARANDA_WELL, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.JACARANDA_GLADE)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.JACARANDA_WELL),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(JACARANDA_POT, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.JACARANDA_GLADE)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.JACARANDA_POT),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(1)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(JACARANDA_ARCH, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.JACARANDA_GLADE)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.JACARANDA_ARCH),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(JACARANDA_AMETHYST, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.JACARANDA_GLADE)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.JACARANDA_AMETHYST),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-1)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
		context.register(JACARANDA_STONE, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.PEAR_MEADOW)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(FPools.JACARANDA_STONE),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(0)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));

		// VANILLA
		context.register(DESERT_PALM, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.DESERT_PALM),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(1)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 67));
		context.register(DESERT_STONE, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.BEARD_THIN),
				pools.getOrThrow(FPools.DESERT_STONE),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(1)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64, 384));
	}

	private static ResourceKey<Structure> create(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE,
				F.id(name)
		);
	}
}