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

public class FArcticRegion extends Region {
	public FArcticRegion() {
		super(
				F.id("arctic"),
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
				.temperature(ParameterUtils.Temperature.ICY)
				.humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY))
				.continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
				.erosion(ParameterUtils.Erosion.FULL_RANGE)
				.depth(ParameterUtils.Depth.SURFACE)
				.weirdness(ParameterUtils.Weirdness.FULL_RANGE)
				.build()
				.forEach(point -> builder.add(point, FBiomes.ARCTIC));
		builder.build().forEach(mapper);
	}
}