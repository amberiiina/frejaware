package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import se.frejaware.F;

import java.util.concurrent.CompletableFuture;

public class FTrimMaterialProvider extends FabricDynamicRegistryProvider {
	public FTrimMaterialProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registries
	) {
		super(output, registries);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		ResourceKey<TrimMaterial> key = ResourceKey.create(
				Registries.TRIM_MATERIAL,
				F.id("rose_quartz")
		);

		TrimMaterial material = new TrimMaterial(
				F.id("trim/rose_quartz"),
				Component.translatable("trim_material.frejaware.rose_quartz")
						.withStyle(Style.EMPTY.withColor(0xD3639B))
		);

		entries.add(key, material);
	}

	@Override
	public String getName() {
		return "FTrimMaterialProvider";
	}
}