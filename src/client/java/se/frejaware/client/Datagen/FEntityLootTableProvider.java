package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.F;
import se.frejaware.Items.FItems;

import java.util.concurrent.CompletableFuture;

public class FEntityLootTableProvider extends FabricEntityLootSubProvider {
	protected FEntityLootTableProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		add(FEntityTypes.MOOBLOOM, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 2))))
						.apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F)))
				)
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
						.apply(SmeltItemFunction.smelted().when(shouldSmeltLoot()))
				)
				.apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F)))
		);
		add(FEntityTypes.GLAZE, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(FItems.GLAZE_ROD).apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F))))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
				)
		);
		add(FEntityTypes.GLACIERMAN, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(FItems.GLACIER_PEARL).apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F))))
				)
		);

		add(FEntityTypes.FROSTBITE_CRAWLER, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(FItems.FROSTBITE_STRING).apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 2))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F))))
				)
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(FItems.FROSTBITE_EYE).apply(SetItemCountFunction.setCount(ContextIntProviders.between(-1, 1))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(0.0F, 1.0F))))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
				)
		);

		add(FEntityTypes.GOLEM_AMETHYST, golemLoot(Items.AMETHYST_SHARD));
		add(FEntityTypes.GOLEM_COAL, golemLoot(Items.COAL));
		add(FEntityTypes.GOLEM_DIAMOND, golemLoot(Items.DIAMOND));
		add(FEntityTypes.GOLEM_EMERALD, golemLoot(Items.EMERALD));
		add(FEntityTypes.GOLEM_GOLD, golemLoot(Items.GOLD_INGOT));
		add(FEntityTypes.GOLEM_LAPIS, golemLoot(Items.LAPIS_LAZULI));
		add(FEntityTypes.GOLEM_NETHERITE, golemLoot(Items.NETHERITE_INGOT));
		add(FEntityTypes.GOLEM_REDSTONE, golemLoot(Items.REDSTONE));
	}

	private static LootTable.Builder golemLoot(ItemLike material) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(Items.POPPY)
								.apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 2)))))
				.withPool(LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(LootItem.lootTableItem(material)
								.apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))))
				.setRandomSequence(F.id("entities/golem_coal"))
		;
	}

	@Override
	public String getName() {
		return "FEntityLootTableProvider";
	}
}