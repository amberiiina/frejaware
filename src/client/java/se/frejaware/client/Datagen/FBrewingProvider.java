package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBrewingProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Entities.FMobEffects;

public class FBrewingProvider extends FabricBrewingProvider {
	protected FBrewingProvider(RecipeOutput output) {
		super(output);
	}

	@Override
	protected void buildMixes() {
		buildStartMix(FBlocks.FROSTBLOOM.asItem(), FMobEffects.FROST_RESISTANCE_POTION);
		buildMix(FMobEffects.FROST_RESISTANCE_POTION, Items.REDSTONE, FMobEffects.FROST_RESISTANCE_POTION_LONG);
		buildMix(FMobEffects.FROST_RESISTANCE_POTION, Items.GLOWSTONE, FMobEffects.FROST_RESISTANCE_POTION_STRONG);
	}
}