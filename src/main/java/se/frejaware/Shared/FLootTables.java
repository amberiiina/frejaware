package se.frejaware.Shared;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import se.frejaware.Items.FItems;

public class FLootTables {
	public static void init() {
		LootTableEvents.MODIFY.register((
				key, builder,
				lootTableSource, provider) -> {
			if (key.equals(BuiltInLootTables.END_CITY_TREASURE)) {
				LootPool.Builder upgradePool = LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(EmptyLootItem.emptyItem().setWeight(9))
						.add(LootItem.lootTableItem(
								FItems.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE
						).setWeight(1));
				LootPool.Builder shardPool = LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(EmptyLootItem.emptyItem().setWeight(19))
						.add(LootItem.lootTableItem(
								FItems.ROSE_QUARTZ_SHARD
						).setWeight(1));
				builder.pool(upgradePool.build());
				builder.pool(shardPool.build());
			} else if (key.equals(BuiltInLootTables.ANCIENT_CITY) ||
					key.equals(BuiltInLootTables.SIMPLE_DUNGEON) ||
					key.equals(BuiltInLootTables.WOODLAND_MANSION)) {
				LootPool.Builder discPool = LootPool.lootPool()
						.setRolls(ContextIntProviders.exactly(1))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(
								FItems.MUSIC_DISC_RYM
						).setWeight(1))
						.add(LootItem.lootTableItem(
								FItems.MUSIC_DISC_GFF
						).setWeight(1));
				builder.pool(discPool.build());
			}
		});
	}
}