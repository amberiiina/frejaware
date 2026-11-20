
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

		context.register(FStructureKeys.PEAR_ARCH_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:pear/arch", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.PEAR_BENCH_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:pear/bench", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.PEAR_BERRY_FARM_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:pear/berry_farm", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.PEAR_STONE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:pear/stone_sulfur", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// JACARANDA
		// ----------------------

		context.register(FStructureKeys.JACARANDA_AMETHYST_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/amethyst", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_ARCH_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/arch", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_POT_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/pot_copper", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/pot_stone", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_STONE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/stone_andesite", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/stone_diorite", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.JACARANDA_WELL_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:jacaranda/well", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// ORCHARD
		// ----------------------

		context.register(FStructureKeys.ORCHARD_ARCH_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/arch", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/arch_lantern", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/arch_lantern_low", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_BIG_POT_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/big_pot_orange", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/big_pot_pear", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_FARM_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/farm", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/farm_pineapple", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_GARDEN_SHED_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/garden_shed/top", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_GREENHOUSE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/greenhouse", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/greenhouse_abandoned", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_PERGOLA_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/pergola", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ORCHARD_POT_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:orchard/pot_orange", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:orchard/pot_pear", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// ARCTIC
		// ----------------------

		context.register(FStructureKeys.ARCTIC_FLOWER_FARM_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:arctic/flower_farm", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ARCTIC_LAMP_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_ice_candle", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_ice_lantern", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_ice_soul_lantern", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_snow_candle", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_snow_lantern", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:arctic/lamp_snow_soul_lantern", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ARCTIC_SNOWCASTLE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:arctic/snowcastle", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ARCTIC_SNOWMAN_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:arctic/snowman", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.ARCTIC_WELL_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:arctic/well", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// DESERT
		// ----------------------

		context.register(FStructureKeys.DESERT_ARCH_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/arch", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_DEAD_TREE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/dead_tree", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_DRY_POND_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/dry_pond/top", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_FOSSIL_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/fossil", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_LAMP_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/lamp", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:desert/lamp_red", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_MUD_PYRAMID_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/mud_pyramid/top", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_PALM_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/palm", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_SANDCASTLE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/sandcastle", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_SHRINE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/shrine", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
		context.register(FStructureKeys.DESERT_STONE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:desert/stone_granite", noProcessors), 1),
				Pair.of(StructurePoolElement.single("frejaware:desert/stone_red_sandstone", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));

		// ----------------------
		// BEACH
		// ----------------------

		context.register(FStructureKeys.BEACH_SANDCASTLE_POOL, new StructureTemplatePool(fallback, List.of(
				Pair.of(StructurePoolElement.single("frejaware:beach/sandcastle", noProcessors), 1)
		), StructureTemplatePool.Projection.RIGID));
	}
}