package se.frejaware.WorldGen.Structures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import se.frejaware.F;

public class FStructureKeys {
	// ----------------------
	// PEAR
	// ----------------------

	public static final ResourceKey<Structure> PEAR_BERRY_FARM =
			create("pear_berry_farm");
	public static final ResourceKey<StructureSet> PEAR_BERRY_FARM_SET =
			createSet("pear_berry_farm_set");
	public static final ResourceKey<StructureTemplatePool> PEAR_BERRY_FARM_POOL =
			createPool("pear_berry_farm_pool");

	public static final ResourceKey<Structure> PEAR_ARCH =
			create("pear_arch");
	public static final ResourceKey<StructureSet> PEAR_ARCH_SET =
			createSet("pear_arch_set");
	public static final ResourceKey<StructureTemplatePool> PEAR_ARCH_POOL =
			createPool("pear_arch_pool");

	public static final ResourceKey<Structure> PEAR_STONE =
			create("pear_stone");
	public static final ResourceKey<StructureSet> PEAR_STONE_SET =
			createSet("pear_stone_set");
	public static final ResourceKey<StructureTemplatePool> PEAR_STONE_POOL =
			createPool("pear_stone_pool");

	// ----------------------
	// JACARANDA
	// ----------------------

	public static final ResourceKey<Structure> JACARANDA_WELL =
			create("jacaranda_well");
	public static final ResourceKey<StructureSet> JACARANDA_WELL_SET =
			createSet("jacaranda_well_set");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_WELL_POOL =
			createPool("jacaranda_well_pool");

	public static final ResourceKey<Structure> JACARANDA_POT =
			create("jacaranda_pot");
	public static final ResourceKey<StructureSet> JACARANDA_POT_SET =
			createSet("jacaranda_pot_set");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_POT_POOL =
			createPool("jacaranda_pot_pool");

	public static final ResourceKey<Structure> JACARANDA_ARCH =
			create("jacaranda_arch");
	public static final ResourceKey<StructureSet> JACARANDA_ARCH_SET =
			createSet("jacaranda_arch_set");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_ARCH_POOL =
			createPool("jacaranda_arch_pool");

	public static final ResourceKey<Structure> JACARANDA_AMETHYST =
			create("jacaranda_amethyst");
	public static final ResourceKey<StructureSet> JACARANDA_AMETHYST_SET =
			createSet("jacaranda_amethyst_set");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_AMETHYST_POOL =
			createPool("jacaranda_amethyst_pool");

	public static final ResourceKey<Structure> JACARANDA_STONE =
			create("jacaranda_stone");
	public static final ResourceKey<StructureSet> JACARANDA_STONE_SET =
			createSet("jacaranda_stone_set");
	public static final ResourceKey<StructureTemplatePool> JACARANDA_STONE_POOL =
			createPool("jacaranda_stone_pool");

	// ----------------------
	// ORCHARD
	// ----------------------

	public static final ResourceKey<Structure> ORCHARD_POT =
			create("orchard_pot");
	public static final ResourceKey<StructureSet> ORCHARD_POT_SET =
			createSet("orchard_pot_set");
	public static final ResourceKey<StructureTemplatePool> ORCHARD_POT_POOL =
			createPool("orchard_pot_pool");

	public static final ResourceKey<Structure> ORCHARD_BIG_POT =
			create("orchard_big_pot");
	public static final ResourceKey<StructureSet> ORCHARD_BIG_POT_SET =
			createSet("orchard_big_pot_set");
	public static final ResourceKey<StructureTemplatePool> ORCHARD_BIG_POT_POOL =
			createPool("orchard_big_pot_pool");

	public static final ResourceKey<Structure> ORCHARD_FARM =
			create("orchard_farm");
	public static final ResourceKey<StructureSet> ORCHARD_FARM_SET =
			createSet("orchard_farm_set");
	public static final ResourceKey<StructureTemplatePool> ORCHARD_FARM_POOL =
			createPool("orchard_farm_pool");

	// ----------------------
	// DESERT
	// ----------------------

	public static final ResourceKey<Structure> DESERT_PALM =
			create("desert_palm");
	public static final ResourceKey<StructureSet> DESERT_PALM_SET =
			createSet("desert_palm_set");
	public static final ResourceKey<StructureTemplatePool> DESERT_PALM_POOL =
			createPool("desert_palm_pool");

	public static final ResourceKey<Structure> DESERT_STONE =
			create("desert_stone");
	public static final ResourceKey<StructureSet> DESERT_STONE_SET =
			createSet("desert_stone_set");
	public static final ResourceKey<StructureTemplatePool> DESERT_STONE_POOL =
			createPool("desert_stone_pool");

	public static final ResourceKey<Structure> DESERT_MUD_PYRAMID =
			create("desert_mud_pyramid");
	public static final ResourceKey<StructureSet> DESERT_MUD_PYRAMID_SET =
			createSet("desert_mud_pyramid_set");
	public static final ResourceKey<StructureTemplatePool> DESERT_MUD_PYRAMID_POOL =
			createPool("desert_mud_pyramid_pool");

	// ----------------------
	// METHODS
	// ----------------------

	private static ResourceKey<Structure> create(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE,
				F.id(name)
		);
	}
	private static ResourceKey<StructureSet> createSet(final String name) {
		return ResourceKey.create(
				Registries.STRUCTURE_SET,
				F.id(name)
		);
	}
	private static ResourceKey<StructureTemplatePool> createPool(final String name) {
		return ResourceKey.create(
				Registries.TEMPLATE_POOL,
				F.id(name)
		);
	}

	public static void init() {}
}