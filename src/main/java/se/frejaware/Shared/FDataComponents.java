package se.frejaware.Shared;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import se.frejaware.Entities.Custom.FMoobloom;
import se.frejaware.F;

import java.util.function.UnaryOperator;

public class FDataComponents {
	public static final DataComponentType<FMoobloom.Variant> MOOBLOOM_VARIANT =
			register(
					"moobloom/variant",
					(b) -> b.persistent(FMoobloom.Variant.CODEC)
							.networkSynchronized(FMoobloom.Variant.STREAM_CODEC)
			);

	private static <T> DataComponentType<T> register(
			final String id,
			final UnaryOperator<DataComponentType.Builder<T>> builder) {
		return Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				F.id(id),
				builder.apply(DataComponentType.builder()).build()
		);
	}

	public static void init() {}
}