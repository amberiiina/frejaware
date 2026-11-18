package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import se.frejaware.Entities.FEntityTypeIds;

import java.util.concurrent.CompletableFuture;

public class FEntityTypeTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public FEntityTypeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		try {
			// MOLLY
			builder(EntityTypeTags.FALL_DAMAGE_IMMUNE)
					.add(FEntityTypeIds.GLAZE);
			builder(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
					.add(FEntityTypeIds.GLAZE);
			builder(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS)
					.add(FEntityTypeIds.GLAZE);
			builder(EntityTypeTags.ARTHROPOD)
					.add(FEntityTypeIds.FROSTBITE_CRAWLER);
			builder(EntityTypeTags.NO_ANGER_FROM_WIND_CHARGE)
					.add(FEntityTypeIds.FROSTBITE_CRAWLER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "FEntityTypeTagProvider";
	}
}