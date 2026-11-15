
package se.frejaware.WorldGen.Structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

public class FStructureSets {
	public static void bootstrap(BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

		// ----------------------
		// PEAR
		// ----------------------

		context.register(FStructureKeys.PEAR_BERRY_FARM_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.PEAR_BERRY_FARM
				))),
				new RandomSpreadStructurePlacement(
						18, 6, RandomSpreadType.LINEAR, 438218
				)));
		context.register(FStructureKeys.PEAR_ARCH_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.PEAR_ARCH
				))),
				new RandomSpreadStructurePlacement(
						18, 6, RandomSpreadType.LINEAR, 523783
				)));
		context.register(FStructureKeys.PEAR_STONE_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.PEAR_STONE
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 732178
				)));

		// ----------------------
		// JACARANDA
		// ----------------------

		context.register(FStructureKeys.JACARANDA_WELL_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.JACARANDA_WELL
				))),
				new RandomSpreadStructurePlacement(
						16, 6, RandomSpreadType.LINEAR, 597432
				)));
		context.register(FStructureKeys.JACARANDA_POT_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.JACARANDA_POT
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 842381
				)));
		context.register(FStructureKeys.JACARANDA_ARCH_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.JACARANDA_ARCH
				))),
				new RandomSpreadStructurePlacement(
						18, 6, RandomSpreadType.LINEAR, 157813
				)));
		context.register(FStructureKeys.JACARANDA_AMETHYST_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.JACARANDA_AMETHYST
				))),
				new RandomSpreadStructurePlacement(
						12, 4, RandomSpreadType.LINEAR, 423784
				)));
		context.register(FStructureKeys.JACARANDA_STONE_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.JACARANDA_STONE
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 453283
				)));

		// ----------------------
		// ORCHARD
		// ----------------------

		context.register(FStructureKeys.ORCHARD_POT_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.ORCHARD_POT
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 234497
				)));
		context.register(FStructureKeys.ORCHARD_BIG_POT_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.ORCHARD_BIG_POT
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 342838
				)));
		context.register(FStructureKeys.ORCHARD_FARM_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.ORCHARD_FARM
				))),
				new RandomSpreadStructurePlacement(
						18, 6, RandomSpreadType.LINEAR, 523838
				)));

		// ----------------------
		// DESERT
		// ----------------------

		context.register(FStructureKeys.DESERT_PALM_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.DESERT_PALM
				))),
				new RandomSpreadStructurePlacement(
						18, 6, RandomSpreadType.LINEAR, 453283
				)));
		context.register(FStructureKeys.DESERT_STONE_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.DESERT_STONE
				))),
				new RandomSpreadStructurePlacement(
						9, 3, RandomSpreadType.LINEAR, 453283
				)));
		context.register(FStructureKeys.DESERT_MUD_PYRAMID_SET, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructureKeys.DESERT_MUD_PYRAMID
				))),
				new RandomSpreadStructurePlacement(
						36, 12, RandomSpreadType.LINEAR, 453283
				)));
	}
}
