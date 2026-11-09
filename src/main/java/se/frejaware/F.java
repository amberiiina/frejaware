package se.frejaware;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.frejaware.Blocks.FParticles;
import se.frejaware.Blocks.Custom.FSkullBlockEntityTypes;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Shared.FCreativeTabs;
import se.frejaware.Shared.FLootTables;
import se.frejaware.Items.FItems;
import se.frejaware.WorldGen.FPlacedFeatures;
import se.frejaware.WorldGen.Custom.FFeatureTypes;
import se.frejaware.WorldGen.Structures.FStructureTypes;

public class F implements ModInitializer {
	public static final String MOD_ID = "frejaware";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FBlocks.initialize();
		FSkullBlockEntityTypes.register();
		FItems.initialize();
		FCreativeTabs.initialize();
		FEntityTypes.initialize();
		FLootTables.initialize();
		FStructureTypes.init();

		// BLOCK ENTITIES
		BlockEntityTypes.BELL.addValidBlock(FBlocks.IRON_BELL);

		BlockEntityTypes.SHELF.addValidBlock(FBlocks.JACARANDA_SHELF);
		BlockEntityTypes.SIGN.addValidBlock(FBlocks.JACARANDA_SIGN);
		BlockEntityTypes.SIGN.addValidBlock(FBlocks.JACARANDA_WALL_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(FBlocks.JACARANDA_HANGING_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(FBlocks.JACARANDA_WALL_HANGING_SIGN);

		BlockEntityTypes.SHELF.addValidBlock(FBlocks.PEAR_SHELF);
		BlockEntityTypes.SIGN.addValidBlock(FBlocks.PEAR_SIGN);
		BlockEntityTypes.SIGN.addValidBlock(FBlocks.PEAR_WALL_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(FBlocks.PEAR_HANGING_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(FBlocks.PEAR_WALL_HANGING_SIGN);

		// PARTICLES
		Registry.register(
				BuiltInRegistries.PARTICLE_TYPE,
				id("pear_leaves"),
				FParticles.PEAR_LEAVES
		);
		Registry.register(
				BuiltInRegistries.PARTICLE_TYPE,
				id("jacaranda_leaves"),
				FParticles.JACARANDA_LEAVES
		);

		// WORLD GEN
		FFeatureTypes.register();
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(
						Biomes.SMALL_END_ISLANDS,
						Biomes.END_MIDLANDS,
						Biomes.END_HIGHLANDS,
						Biomes.END_BARRENS
				),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				FPlacedFeatures.ROSE_QUARTZ_ORE_VEIN_PLACED_KEY
		);
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(
						Biomes.CHERRY_GROVE
				),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				FPlacedFeatures.PEAR_TREE_CHERRY_PLACED_KEY
		);

		LOGGER.info("Frejaware Initialized");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}