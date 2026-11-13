package se.frejaware.WorldGen.Structures;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import se.frejaware.F;

import java.util.List;

public class FPools {
	public static final ResourceKey<StructureTemplatePool> PEAR_BERRY_FARM =
			create("pear_berry_farm");
	public static final ResourceKey<StructureTemplatePool> PEAR_ARCH =
			create("pear_arch");
	public static final ResourceKey<StructureTemplatePool> PEAR_STONE =
			create("pear_stone");

	public static final ResourceKey<StructureTemplatePool> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_STONE =
			create("jacaranda_stone");

	public static final ResourceKey<StructureTemplatePool> ORCHARD_POT =
			create("orchard_pot");
	public static final ResourceKey<StructureTemplatePool> ORCHARD_BIG_POT =
			create("orchard_big_pot");
	public static final ResourceKey<StructureTemplatePool> ORCHARD_FARM =
			create("orchard_farm");

	public static final ResourceKey<StructureTemplatePool> DESERT_PALM =
			create("desert_palm");
	public static final ResourceKey<StructureTemplatePool> DESERT_STONE =
			create("desert_stone");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		Holder<StructureProcessorList> noProcessors = processors.getOrThrow(ProcessorLists.EMPTY);
		Holder<StructureTemplatePool> fallback = pools.getOrThrow(Pools.EMPTY);

		// PEAR
		context.register(PEAR_BERRY_FARM, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:pear_berry_farm", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(PEAR_ARCH, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:pear_arch", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(PEAR_STONE, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(
						StructurePoolElement.single(
								"frejaware:pear_stone_sulfur", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));

		// JACARANDA
		context.register(JACARANDA_WELL, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_well", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(JACARANDA_POT, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(
						StructurePoolElement.single(
								"frejaware:jacaranda_pot_copper", noProcessors), 1
						),
						Pair.of(
						StructurePoolElement.single(
								"frejaware:jacaranda_pot_stone", noProcessors), 1
						)
				),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(JACARANDA_ARCH, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_arch", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(JACARANDA_AMETHYST, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:jacaranda_amethyst", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(JACARANDA_STONE, new StructureTemplatePool(
				fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_stone_andesite", noProcessors
						), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_stone_diorite", noProcessors
						), 1)
				),
				StructureTemplatePool.Projection.RIGID
		));

		// ORCHARD
		context.register(ORCHARD_POT, new StructureTemplatePool(
				fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_pot_orange", noProcessors
						), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_pot_pear", noProcessors
						), 1)
				),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(ORCHARD_BIG_POT, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:orchard_big_pot", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(ORCHARD_FARM, new StructureTemplatePool(
				fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_farm", noProcessors
						), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:orchard_farm_pineapple", noProcessors
						), 1)
				),
				StructureTemplatePool.Projection.RIGID
		));

		// VANILLA
		context.register(DESERT_PALM, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:desert_palm", noProcessors), 1
				)),
				StructureTemplatePool.Projection.RIGID
		));
		context.register(DESERT_STONE, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
								"frejaware:desert_stone_granite", noProcessors
						), 1),
						Pair.of(StructurePoolElement.single(
								"frejaware:desert_stone_red_sandstone", noProcessors
						), 1)
				),
				StructureTemplatePool.Projection.RIGID
		));
	}

	private static ResourceKey<StructureTemplatePool> create(final String name) {
		return ResourceKey.create(
				Registries.TEMPLATE_POOL,
				F.id(name)
		);
	}
}