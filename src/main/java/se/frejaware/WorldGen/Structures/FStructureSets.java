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
	public static final ResourceKey<StructureSet> PEAR_BERRY_FARM =
			create("pear_berry_farm");
	public static final ResourceKey<StructureSet> PEAR_ARCH =
			create("pear_arch");
	public static final ResourceKey<StructureSet> PEAR_STONE =
			create("pear_stone");

	public static final ResourceKey<StructureSet> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<StructureSet> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<StructureSet> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<StructureSet> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");
	public static final ResourceKey<StructureSet> JACARANDA_STONE =
			create("jacaranda_stone");

	public static final ResourceKey<StructureSet> DESERT_PALM =
			create("desert_palm");
	public static final ResourceKey<StructureSet> DESERT_STONE =
			create("desert_stone");

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

		// PEAR
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
		context.register(PEAR_ARCH, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.PEAR_ARCH
				))),
				new RandomSpreadStructurePlacement(
						18,
						6,
						RandomSpreadType.LINEAR,
						523783
				)
		));
		context.register(PEAR_STONE, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.PEAR_STONE
				))),
				new RandomSpreadStructurePlacement(
						9,
						3,
						RandomSpreadType.LINEAR,
						732178
				)
		));

		// JACARANDA
		context.register(JACARANDA_WELL, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_WELL
				))),
				new RandomSpreadStructurePlacement(
						16,
						6,
						RandomSpreadType.LINEAR,
						597432
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
						842381
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
		context.register(JACARANDA_STONE, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.JACARANDA_STONE
				))),
				new RandomSpreadStructurePlacement(
						9,
						3,
						RandomSpreadType.LINEAR,
						453283
				)
		));

		// VANILLA
		context.register(DESERT_PALM, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.DESERT_PALM
				))),
				new RandomSpreadStructurePlacement(
						18,
						6,
						RandomSpreadType.LINEAR,
						453283
				)
		));
		context.register(DESERT_STONE, new StructureSet(
				List.of(StructureSet.entry(structures.getOrThrow(
						FStructures.DESERT_STONE
				))),
				new RandomSpreadStructurePlacement(
						9,
						3,
						RandomSpreadType.LINEAR,
						453283
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