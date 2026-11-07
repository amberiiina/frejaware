package se.frejaware.Items;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import se.frejaware.F;

public class FTrimMaterials {
	public static final ResourceKey<TrimMaterial> ROSE_QUARTZ =
			ResourceKey.create(
					Registries.TRIM_MATERIAL,
					F.id("rose_quartz")
			);

	public static void bootstrap(BootstrapContext<TrimMaterial> context) {
		register(
				context,
				ROSE_QUARTZ,
				Style.EMPTY.withColor(0xD3639B),
				F.id("trim/rose_quartz")
		);
	}

	private static void register(
			BootstrapContext<TrimMaterial> context,
			ResourceKey<TrimMaterial> key,
			Style style,
			Identifier palette
	) {
		Component description = Component.translatable(
				"trim_material." + key.identifier().getNamespace()
						+ "." + key.identifier().getPath()
		).withStyle(style);

		context.register(key, new TrimMaterial(palette, description));
	}
}