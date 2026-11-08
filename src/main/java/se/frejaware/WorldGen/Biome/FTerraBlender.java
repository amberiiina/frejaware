package se.frejaware.WorldGen.Biome;

import se.frejaware.F;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class FTerraBlender implements TerraBlenderApi {
	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new FPearMeadowRegion());
		Regions.register(new FJacarandaGladeRegion());

		F.LOGGER.info("TerraBlender Initialized");
	}
}