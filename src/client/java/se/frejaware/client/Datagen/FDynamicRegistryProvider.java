package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.*;
import se.frejaware.F;
import se.frejaware.Items.FEnchantments;

import java.util.concurrent.CompletableFuture;

public class FDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	public FDynamicRegistryProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		try {
			entries.addAll(registries.lookupOrThrow(Registries.TRIM_MATERIAL));

			entries.addAll(registries.lookupOrThrow(Registries.FEATURE));
			entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));
			entries.addAll(registries.lookupOrThrow(Registries.BIOME));

			entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE));
			entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE_SET));
			entries.addAll(registries.lookupOrThrow(Registries.TEMPLATE_POOL));

			entries.addAll(registries.lookupOrThrow(Registries.PAINTING_VARIANT));

			entries.addAll(registries.lookupOrThrow(Registries.BLOCK_STATE_PROVIDER));

			entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "FDynamicRegistryProvider";
	}
}