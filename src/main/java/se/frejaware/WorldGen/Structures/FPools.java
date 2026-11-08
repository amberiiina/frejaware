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
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import se.frejaware.F;

import java.util.List;

public class FPools {
	public static final ResourceKey<StructureTemplatePool> JACARANDA_WELL =
			create("jacaranda_well");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

		Holder<StructureProcessorList> noProcessors = processors.getOrThrow(ProcessorLists.EMPTY);
		Holder<StructureTemplatePool> fallback = pools.getOrThrow(Pools.EMPTY);

		context.register(JACARANDA_WELL, new StructureTemplatePool(
				fallback,
				List.of(
						Pair.of(StructurePoolElement.single(
								"frejaware:jacaranda_well", noProcessors
						),
						1
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