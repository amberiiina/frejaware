package se.frejaware.WorldGen.Biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import se.frejaware.F;

public class FBiomes {
	public static final ResourceKey<Biome> PEAR_MEADOW =
			ResourceKey.create(
					Registries.BIOME,
					F.id("pear_meadow")
			);
	public static final ResourceKey<Biome> JACARANDA_GLADE =
			ResourceKey.create(
					Registries.BIOME,
					F.id("jacaranda_glade")
			);

	private FBiomes() {}
}