package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import se.frejaware.WorldGen.Biome.FBiomes;

import java.util.concurrent.CompletableFuture;

public class FBiomeTagsProvider extends FabricTagsProvider<Biome> {
	public FBiomeTagsProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, Registries.BIOME, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		builder(ConventionalBiomeTags.IS_OVERWORLD)
				.add(FBiomes.PEAR_MEADOW);
		builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD)
				.add(FBiomes.PEAR_MEADOW);
		builder(ConventionalBiomeTags.PRIMARY_WOOD_TYPE)
				.add(FBiomes.PEAR_MEADOW);
		builder(ConventionalBiomeTags.IS_DECIDUOUS_TREE)
				.add(FBiomes.PEAR_MEADOW);
		builder(ConventionalBiomeTags.IS_FLORAL)
				.add(FBiomes.PEAR_MEADOW);
	}

	@Override
	public String getName() {
		return "FBiomeTagsProvider";
	}
}