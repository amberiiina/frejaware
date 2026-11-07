package se.frejaware.Blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import se.frejaware.F;

import java.util.Optional;

public class FPaintings {
	public static final ResourceKey<PaintingVariant> PLANT_KEY = create("plant");
	public static final ResourceKey<PaintingVariant> WANDERER_KEY = create("the_wanderer");
	public static final ResourceKey<PaintingVariant> RIBBON_KEY = create("ribbon");

	public static void bootstrap(BootstrapContext<PaintingVariant> context) {
		register(context, PLANT_KEY, 1, 1, true);
		register(context, WANDERER_KEY, 1, 2, true);
		register(context, RIBBON_KEY, 1, 1, true);
	}

	private static ResourceKey<PaintingVariant> create(final String id) {
		return ResourceKey.create(
				Registries.PAINTING_VARIANT,
				F.id(id)
		);
	}

	private static void register(
			final BootstrapContext<PaintingVariant> context,
			final ResourceKey<PaintingVariant> key,
			final int width,
			final int height,
			final boolean hasAuthor) {
		context.register(
				key,
				new PaintingVariant(width, height, key.identifier(),
						Optional.of(Component.translatable(
								key.identifier().toLanguageKey(
										"painting", "title"
								)
						).withColor(TextColor.LIGHT_PURPLE)),
						hasAuthor ? Optional.of(Component.translatable(
								key.identifier().toLanguageKey(
										"painting", "author"
								)
						).withColor(TextColor.GRAY)) : Optional.empty()
				)
		);
	}
}