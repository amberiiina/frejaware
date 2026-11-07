package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import se.frejaware.Blocks.FPaintings;

import java.util.concurrent.CompletableFuture;

public class FPaintingTagsProvider extends FabricTagsProvider<PaintingVariant> {
	public FPaintingTagsProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, Registries.PAINTING_VARIANT, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
				.add(TagEntry.element(FPaintings.PLANT_KEY.identifier()))
				.add(TagEntry.element(FPaintings.WANDERER_KEY.identifier()))
				.add(TagEntry.element(FPaintings.RIBBON_KEY.identifier()));
	}

	@Override
	public String getName() {
		return "FPaintingTagsProvider";
	}
}