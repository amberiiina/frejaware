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
	public static final ResourceKey<StructureTemplatePool> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");

	public static final ResourceKey<StructureTemplatePool> PEAR_BERRY_FARM =
			create("pear_berry_farm");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		Holder<StructureProcessorList> noProcessors = processors.getOrThrow(ProcessorLists.EMPTY);
		Holder<StructureTemplatePool> fallback = pools.getOrThrow(Pools.EMPTY);

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

		context.register(PEAR_BERRY_FARM, new StructureTemplatePool(
				fallback,
				List.of(Pair.of(StructurePoolElement.single(
						"frejaware:pear_berry_farm", noProcessors), 1
				)),
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