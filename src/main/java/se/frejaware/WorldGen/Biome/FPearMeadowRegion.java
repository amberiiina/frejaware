package se.frejaware.WorldGen.Biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import se.frejaware.F;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class FPearMeadowRegion extends Region {
	public FPearMeadowRegion() {
		super(
				F.id("pear_meadow"),
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
				// MOLLY
				.temperature(ParameterUtils.Temperature.NEUTRAL)
				.humidity(ParameterUtils.Humidity.span(
						ParameterUtils.Humidity.NEUTRAL,
						ParameterUtils.Humidity.WET
				))
				.continentalness(ParameterUtils.Continentalness.COAST)
				.erosion(ParameterUtils.Erosion.span(
						ParameterUtils.Erosion.EROSION_2,
						ParameterUtils.Erosion.EROSION_5
				))
				.depth(ParameterUtils.Depth.SURFACE)
				.weirdness(ParameterUtils.Weirdness.span(
						ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING,
						ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING
				))

				// JAG
//				.temperature(ParameterUtils.Temperature.NEUTRAL)
//				.humidity(ParameterUtils.Humidity.span(
//						ParameterUtils.Humidity.NEUTRAL,
//						ParameterUtils.Humidity.WET
//				))
//				.continentalness(ParameterUtils.Continentalness.span(
//						ParameterUtils.Continentalness.COAST,
//						ParameterUtils.Continentalness.NEAR_INLAND
//				))
//				.erosion(ParameterUtils.Erosion.span(
//						ParameterUtils.Erosion.EROSION_2,
//						ParameterUtils.Erosion.EROSION_5
//				))
//				.depth(ParameterUtils.Depth.SURFACE)
//				.weirdness(ParameterUtils.Weirdness.span(
//						ParameterUtils.Weirdness.VALLEY,
//						ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING
//				))

				// MEADOW
//				.temperature(Climate.Parameter.span(-0.45F, 0.2F))
//				.humidity(Climate.Parameter.span(-1.0F, 0.3F))
//				.continentalness(Climate.Parameter.span(0.03F, 1.0F))
//				.erosion(Climate.Parameter.span(-0.78F, 0.05F))
//				.depth(ParameterUtils.Depth.SURFACE)
//				.weirdness(Climate.Parameter.span(-1.0F, 1.0F))
				.build()
				.forEach(point -> builder.add(
						point,
						FBiomes.PEAR_MEADOW
				));
		builder.build().forEach(mapper);
	}
}