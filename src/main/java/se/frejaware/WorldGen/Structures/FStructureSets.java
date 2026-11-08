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
	public static final ResourceKey<StructureSet> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<StructureSet> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<StructureSet> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");

	public static final ResourceKey<StructureSet> PEAR_BERRY_FARM =
			create("pear_berry_farm");

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

		context.register(JACARANDA_WELL, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_WELL
				))),
				new RandomSpreadStructurePlacement(
						16,
						6,
						RandomSpreadType.LINEAR,
						5974324
				)
		));
		context.register(JACARANDA_POT, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_POT
				))),
				new RandomSpreadStructurePlacement(
						9,
						3,
						RandomSpreadType.LINEAR,
						8423812
				)
		));
		context.register(JACARANDA_ARCH, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_ARCH
				))),
				new RandomSpreadStructurePlacement(
						18,
						6,
						RandomSpreadType.LINEAR,
						157813
				)
		));
		context.register(JACARANDA_AMETHYST, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_AMETHYST
				))),
				new RandomSpreadStructurePlacement(
						12,
						4,
						RandomSpreadType.LINEAR,
						423784
				)
		));

		context.register(PEAR_BERRY_FARM, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.PEAR_BERRY_FARM
				))),
				new RandomSpreadStructurePlacement(
						18,
						6,
						RandomSpreadType.LINEAR,
						438218
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