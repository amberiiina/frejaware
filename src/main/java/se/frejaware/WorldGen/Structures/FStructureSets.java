
package se.frejaware.WorldGen.Structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

public class FStructureSets {
	private static RandomSpreadStructurePlacement decor(ResourceKey<StructureSet> key) {
		return placement(key, 18, 6);
	}
	private static RandomSpreadStructurePlacement small(ResourceKey<StructureSet> key) {
		return placement(key, 24, 8);
	}
	private static RandomSpreadStructurePlacement medium(ResourceKey<StructureSet> key) {
		return placement(key, 32, 10);
	}
	private static RandomSpreadStructurePlacement large(ResourceKey<StructureSet> key) {
		return placement(key, 40, 12);
	}
	private static RandomSpreadStructurePlacement landmark(ResourceKey<StructureSet> key) {
		return placement(key, 56, 18);
	}

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		// ----------------------
		// PEAR
		// ----------------------

		register(context, FStructureKeys.PEAR_ARCH_SET, FStructureKeys.PEAR_ARCH, medium(FStructureKeys.PEAR_ARCH_SET));
		register(context, FStructureKeys.PEAR_BERRY_FARM_SET, FStructureKeys.PEAR_BERRY_FARM, large(FStructureKeys.PEAR_BERRY_FARM_SET));
		register(context, FStructureKeys.PEAR_STONE_SET, FStructureKeys.PEAR_STONE, decor(FStructureKeys.PEAR_STONE_SET));

		// ----------------------
		// JACARANDA
		// ----------------------

		register(context, FStructureKeys.JACARANDA_AMETHYST_SET, FStructureKeys.JACARANDA_AMETHYST, decor(FStructureKeys.JACARANDA_AMETHYST_SET));
		register(context, FStructureKeys.JACARANDA_ARCH_SET, FStructureKeys.JACARANDA_ARCH, medium(FStructureKeys.JACARANDA_ARCH_SET));
		register(context, FStructureKeys.JACARANDA_POT_SET, FStructureKeys.JACARANDA_POT, decor(FStructureKeys.JACARANDA_POT_SET));
		register(context, FStructureKeys.JACARANDA_STONE_SET, FStructureKeys.JACARANDA_STONE, decor(FStructureKeys.JACARANDA_STONE_SET));
		register(context, FStructureKeys.JACARANDA_WELL_SET, FStructureKeys.JACARANDA_WELL, landmark(FStructureKeys.JACARANDA_WELL_SET));

		// ----------------------
		// ORCHARD
		// ----------------------

		register(context, FStructureKeys.ORCHARD_ARCH_SET, FStructureKeys.ORCHARD_ARCH, medium(FStructureKeys.ORCHARD_ARCH_SET));
		register(context, FStructureKeys.ORCHARD_BIG_POT_SET, FStructureKeys.ORCHARD_BIG_POT, decor(FStructureKeys.ORCHARD_BIG_POT_SET));
		register(context, FStructureKeys.ORCHARD_FARM_SET, FStructureKeys.ORCHARD_FARM, large(FStructureKeys.ORCHARD_FARM_SET));
		register(context, FStructureKeys.ORCHARD_GARDEN_SHED_SET, FStructureKeys.ORCHARD_GARDEN_SHED, large(FStructureKeys.ORCHARD_GARDEN_SHED_SET));
		register(context, FStructureKeys.ORCHARD_GREENHOUSE_SET, FStructureKeys.ORCHARD_GREENHOUSE, landmark(FStructureKeys.ORCHARD_GREENHOUSE_SET));
		register(context, FStructureKeys.ORCHARD_PERGOLA_SET, FStructureKeys.ORCHARD_PERGOLA, medium(FStructureKeys.ORCHARD_PERGOLA_SET));
		register(context, FStructureKeys.ORCHARD_POT_SET, FStructureKeys.ORCHARD_POT, decor(FStructureKeys.ORCHARD_POT_SET));

		// ----------------------
		// ARCTIC
		// ----------------------

		register(context, FStructureKeys.ARCTIC_FLOWER_FARM_SET, FStructureKeys.ARCTIC_FLOWER_FARM, large(FStructureKeys.ARCTIC_FLOWER_FARM_SET));
		register(context, FStructureKeys.ARCTIC_LAMP_SET, FStructureKeys.ARCTIC_LAMP, decor(FStructureKeys.ARCTIC_LAMP_SET));
		register(context, FStructureKeys.ARCTIC_SNOWMAN_SET, FStructureKeys.ARCTIC_SNOWMAN, landmark(FStructureKeys.ARCTIC_SNOWMAN_SET));
		register(context, FStructureKeys.ARCTIC_WELL_SET, FStructureKeys.ARCTIC_WELL, landmark(FStructureKeys.ARCTIC_WELL_SET));

		// ----------------------
		// DESERT
		// ----------------------

		register(context, FStructureKeys.DESERT_ARCH_SET, FStructureKeys.DESERT_ARCH, medium(FStructureKeys.DESERT_ARCH_SET));
		register(context, FStructureKeys.DESERT_DEAD_TREE_SET, FStructureKeys.DESERT_DEAD_TREE, small(FStructureKeys.DESERT_DEAD_TREE_SET));
		register(context, FStructureKeys.DESERT_DRY_POND_SET, FStructureKeys.DESERT_DRY_POND, large(FStructureKeys.DESERT_DRY_POND_SET));
		register(context, FStructureKeys.DESERT_FOSSIL_SET, FStructureKeys.DESERT_FOSSIL, large(FStructureKeys.DESERT_FOSSIL_SET));
		register(context, FStructureKeys.DESERT_MUD_PYRAMID_SET, FStructureKeys.DESERT_MUD_PYRAMID, landmark(FStructureKeys.DESERT_MUD_PYRAMID_SET));
		register(context, FStructureKeys.DESERT_PALM_SET, FStructureKeys.DESERT_PALM, medium(FStructureKeys.DESERT_PALM_SET));
		register(context, FStructureKeys.DESERT_SHRINE_SET, FStructureKeys.DESERT_SHRINE, large(FStructureKeys.DESERT_SHRINE_SET));
		register(context, FStructureKeys.DESERT_STONE_SET, FStructureKeys.DESERT_STONE, decor(FStructureKeys.DESERT_STONE_SET));

		// ----------------------
		// BEACH
		// ----------------------

		register(context, FStructureKeys.BEACH_SANDCASTLE_SET, FStructureKeys.BEACH_SANDCASTLE, decor(FStructureKeys.BEACH_SANDCASTLE_SET));
	}

	private static RandomSpreadStructurePlacement placement(ResourceKey<StructureSet> key, int spacing, int separation) {
		int salt = key.identifier().toString().hashCode() & Integer.MAX_VALUE;
		return new RandomSpreadStructurePlacement(spacing, separation, RandomSpreadType.LINEAR, salt);
	}

	private static void register(BootstrapContext<StructureSet> context, ResourceKey<StructureSet> setKey, ResourceKey<Structure> structureKey, RandomSpreadStructurePlacement placement) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
		context.register(setKey, new StructureSet(List.of(StructureSet.entry(structures.getOrThrow(structureKey))), placement));
	}
}