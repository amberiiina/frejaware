package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import se.frejaware.Blocks.FPaintings;
import se.frejaware.WorldGen.Biome.FBiomeBootstrap;
import se.frejaware.WorldGen.FFeatures;
import se.frejaware.WorldGen.FPlacedFeatures;

public class DataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(FAdvancementProvider::new);
		pack.addProvider(FBiomeTagsProvider::new);
		pack.addProvider(FBlockLootTableProvider::new);
		pack.addProvider(FBlockTagProvider::new);
		pack.addProvider(FDynamicRegistryProvider::new);
		pack.addProvider(FEntityLootTableProvider::new);
		pack.addProvider(FItemTagProvider::new);
		pack.addProvider(FLanguageProvider::new);
		pack.addProvider(FModelProvider::new);
		pack.addProvider(FPaintingTagsProvider::new);
		pack.addProvider(FRecipeProvider::new);
		pack.addProvider(FTrimMaterialProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.FEATURE, FFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, FPlacedFeatures::configure);
		registryBuilder.add(Registries.BIOME, FBiomeBootstrap::bootstrap);
		registryBuilder.add(Registries.PAINTING_VARIANT, FPaintings::bootstrap);
	}
}
