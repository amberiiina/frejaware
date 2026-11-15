
package se.frejaware.WorldGen.Structures;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class FPools {
	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		Holder<StructureProcessorList> noProcessors = processors.getOrThrow(ProcessorLists.EMPTY);
		Holder<StructureTemplatePool> fallback = pools.getOrThrow(Pools.EMPTY);

		// ----------------------
		// PEAR
		// ----------------------

		context.register(FStructureKeys.PEAR_BERRY_FARM_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:pear_berry_farm", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.PEAR_ARCH_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:pear_arch", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.PEAR_STONE_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(
						StructurePoolElement.single(
								"frejaware:pear_stone_sulfur", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// JACARANDA
		// ----------------------

		context.register(FStructureKeys.JACARANDA_WELL_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_well", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_POT_POOL, new StructureTemplatePool(fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_pot_copper", noProcessors), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_pot_stone", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_ARCH_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_arch", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_AMETHYST_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_amethyst", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_STONE_POOL, new StructureTemplatePool(fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_stone_andesite", noProcessors), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_stone_diorite", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// ORCHARD
		// ----------------------

		context.register(FStructureKeys.ORCHARD_POT_POOL, new StructureTemplatePool(fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_pot_orange", noProcessors), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_pot_pear", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_BIG_POT_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:orchard_big_pot", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_FARM_POOL, new StructureTemplatePool(
				fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_farm", noProcessors), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_farm_pineapple", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// DESERT
		// ----------------------

		context.register(FStructureKeys.DESERT_PALM_POOL, new StructureTemplatePool(fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:desert_palm", noProcessors), 1
				)), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_STONE_POOL, new StructureTemplatePool(fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:desert_stone_granite", noProcessors), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:desert_stone_red_sandstone", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_MUD_PYRAMID_POOL, new StructureTemplatePool(fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:desert_mud_pyramid", noProcessors), 1)
				), StructureTemplatePool.Projection.RIGID));
	}
}