package se.frejaware.WorldGen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import se.frejaware.F;
import se.frejaware.WorldGen.Custom.FRoseQuartzOreFeature;

public class FFeatureTypes {
	public static void register() {
		Registry.register(
				BuiltInRegistries.FEATURE_TYPE,
				F.id("rose_quartz_ore_vein"),
				FRoseQuartzOreFeature.CODEC
		);
	}
}