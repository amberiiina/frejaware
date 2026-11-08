package se.frejaware.WorldGen.Structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
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
	public static final ResourceKey<Structure> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<Structure> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<Structure> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<Structure> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");

	public static final ResourceKey<Structure> PEAR_BERRY_FARM =
			create("pear_berry_farm");

	public static void bootstrap(BootstrapContext<Structure> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

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
		), 64));
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
		), 64));
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
		), 64));
		context.register(JACARANDA_AMETHYST, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.JACARANDA_GLADE)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.JACARANDA_AMETHYST),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(-2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64));

		context.register(PEAR_BERRY_FARM, new FJigsawStructure(new JigsawStructure(
				new Structure.StructureSettings(
						HolderSet.direct(biomes.getOrThrow(FBiomes.PEAR_MEADOW)),
						Map.of(),
						GenerationStep.Decoration.SURFACE_STRUCTURES,
						TerrainAdjustment.NONE),
				pools.getOrThrow(FPools.PEAR_BERRY_FARM),
				1,
				ConstantHeight.of(VerticalAnchor.absolute(2)),
				false,
				Heightmap.Types.WORLD_SURFACE_WG
		), 64));
	}

	private static ResourceKey<Structure> create(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE,
				F.id(name)
		);
	}
}