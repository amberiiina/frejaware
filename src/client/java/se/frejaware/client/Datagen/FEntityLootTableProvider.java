package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.F;
import java.util.concurrent.CompletableFuture;

public class FEntityLootTableProvider extends FabricEntityLootSubProvider {
	protected FEntityLootTableProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		add(FEntityTypes.GOLEM_AMETHYST, golemLoot(Items.AMETHYST_SHARD));
		add(FEntityTypes.GOLEM_COAL, golemLoot(Items.COAL));
		add(FEntityTypes.GOLEM_DIAMOND, golemLoot(Items.DIAMOND));
		add(FEntityTypes.GOLEM_EMERALD, golemLoot(Items.EMERALD));
		add(FEntityTypes.GOLEM_GOLD, golemLoot(Items.GOLD_INGOT));
		add(FEntityTypes.GOLEM_LAPIS, golemLoot(Items.LAPIS_LAZULI));
		add(FEntityTypes.GOLEM_NETHERITE, golemLoot(Items.NETHERITE_INGOT));
		add(FEntityTypes.GOLEM_REDSTONE, golemLoot(Items.REDSTONE));
	}

	private static Holder<ContextIntProvider> value(int v) {
		return Holder.direct(new ConstantValue(v));
	}

	private static Holder<ContextIntProvider> between(int min, int max) {
		return Holder.direct(new UniformGenerator(value(min), value(max)));
	}

	private static LootTable.Builder golemLoot(ItemLike material) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(value(1))
						.add(LootItem.lootTableItem(Items.POPPY)
								.apply(SetItemCountFunction.setCount(between(0, 2)))))
				.withPool(LootPool.lootPool()
						.setRolls(value(1))
						.add(LootItem.lootTableItem(material)
								.apply(SetItemCountFunction.setCount(between(3, 5)))))
				.setRandomSequence(F.id("entities/golem_coal"))
		;
	}

	@Override
	public String getName() {
		return "FEntityLootTableProvider";
	}
}