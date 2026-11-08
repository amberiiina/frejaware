package se.frejaware.WorldGen.Structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import se.frejaware.F;

import java.util.List;

public class FStructureSets {
	public static final ResourceKey<StructureSet> JACARANDA_WELL =
			create("jacaranda_well");

	public static void bootstrap(BootstrapContext<StructureSet> ctx) {
		HolderGetter<Structure> structures = ctx.lookup(Registries.STRUCTURE);

		ctx.register(JACARANDA_WELL, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_WELL
				))),
				new RandomSpreadStructurePlacement(
						8,
						4,
						RandomSpreadType.LINEAR,
						473214
				)
		));
	}

	private static ResourceKey<StructureSet> create(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE_SET,
				F.id(name)
		);
	}
}