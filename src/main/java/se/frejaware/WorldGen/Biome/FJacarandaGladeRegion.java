package se.frejaware.WorldGen.Biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import se.frejaware.F;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class FJacarandaGladeRegion extends Region {
	public FJacarandaGladeRegion() {
		super(
				F.id("jacaranda_glade"),
				RegionType.OVERWORLD,
				1
		);
	}

	@Override
	public void addBiomes(
			Registry<Biome> registry,
			Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper
	) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

		new ParameterUtils.ParameterPointListBuilder()
				.temperature(ParameterUtils.Temperature.span(
						ParameterUtils.Temperature.WARM,
						ParameterUtils.Temperature.HOT
				))
				.humidity(ParameterUtils.Humidity.HUMID)
				.continentalness(ParameterUtils.Continentalness.FAR_INLAND)
				.erosion(ParameterUtils.Erosion.span(
						ParameterUtils.Erosion.EROSION_4,
						ParameterUtils.Erosion.EROSION_5
				))
				.depth(ParameterUtils.Depth.SURFACE)
				.weirdness(ParameterUtils.Weirdness.span(
						ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING,
						ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING
				))
				.build()
				.forEach(point -> builder.add(
						point,
						FBiomes.JACARANDA_GLADE
				));
		builder.build().forEach(mapper);
	}
}