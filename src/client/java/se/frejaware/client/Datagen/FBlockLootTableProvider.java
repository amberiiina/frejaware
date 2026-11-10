package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Items.FItems;

import java.util.concurrent.CompletableFuture;

public class FBlockLootTableProvider extends FabricBlockLootSubProvider {
	protected FBlockLootTableProvider(
			FabricPackOutput packOutput,
			CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(packOutput, registryLookup);
	}

	@Override
	public void generate() {
		// MOLLY
		LootItemCondition.Builder isPineappleMaxAge = MatchBlock.blockMatches(
				blocks,
				FBlocks.PINEAPPLE,
				StatePropertiesPredicate.Builder.properties()
						.hasProperty(CropBlock.AGE, 7)
		);
		add(FBlocks.PINEAPPLE, createCropDrops(
				FBlocks.PINEAPPLE,
				FItems.PINEAPPLE, FItems.PINEAPPLE_SEEDS,
				isPineappleMaxAge
		));
//		dropOther(FBlocks.PINEAPPLE, FItems.PINEAPPLE);

		dropSelf(FBlocks.IRON_BELL);

		dropSelf(FBlocks.WHITE_CACTUS_FLOWER);
		dropSelf(FBlocks.YELLOW_CACTUS_FLOWER);
		dropSelf(FBlocks.WHITE_ORCHID);
		dropSelf(FBlocks.YELLOW_TULIP);
		dropSelf(FBlocks.ROUND_BUSH);
		dropSelf(FBlocks.WHITE_HIBISCUS);
		dropSelf(FBlocks.YELLOW_HIBISCUS);
		dropSelf(FBlocks.WHITE_CROCUS);
		dropSelf(FBlocks.LILAC_CROCUS);
		dropSelf(FBlocks.PURPLE_CROCUS);
		dropSelf(FBlocks.LILY_OF_THE_GLADE);

		// FOOD
		add(Blocks.CHERRY_LEAVES, block -> createCherryLeavesDrops(
				block, Blocks.CHERRY_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES
		));

		// JACARANDA
		dropSelf(FBlocks.JACARANDA_LOG);
		dropSelf(FBlocks.STRIPPED_JACARANDA_LOG);
		dropSelf(FBlocks.JACARANDA_WOOD);
		dropSelf(FBlocks.STRIPPED_JACARANDA_WOOD);

		add(
				FBlocks.JACARANDA_LEAVES,
				block -> createLeavesDrops(
						block,
						FBlocks.JACARANDA_SAPLING,
						NORMAL_LEAVES_SAPLING_CHANCES
				)
		);
		dropSelf(FBlocks.JACARANDA_SAPLING);
		dropPottedContents(FBlocks.POTTED_JACARANDA_SAPLING);

		dropSelf(FBlocks.JACARANDA_PLANKS);
		dropSelf(FBlocks.JACARANDA_STAIRS);
		add(FBlocks.JACARANDA_SLAB, this::createSlabItemTable);
		dropSelf(FBlocks.JACARANDA_FENCE);
		dropSelf(FBlocks.JACARANDA_FENCE_GATE);
		add(FBlocks.JACARANDA_DOOR, this::createDoorTable);
		dropSelf(FBlocks.JACARANDA_TRAPDOOR);
		dropSelf(FBlocks.JACARANDA_BUTTON);
		dropSelf(FBlocks.JACARANDA_PRESSURE_PLATE);
		dropSelf(FBlocks.JACARANDA_SIGN);
		dropOther(FBlocks.JACARANDA_WALL_SIGN, FBlocks.JACARANDA_SIGN);
		dropSelf(FBlocks.JACARANDA_HANGING_SIGN);
		dropOther(FBlocks.JACARANDA_WALL_HANGING_SIGN, FBlocks.JACARANDA_HANGING_SIGN);
		dropSelf(FBlocks.JACARANDA_SHELF);

		add(FBlocks.PURPLE_PETALS,
				createSegmentedBlockDrops(FBlocks.PURPLE_PETALS)
		);

		// PEAR
		dropSelf(FBlocks.PEAR_LOG);
		dropSelf(FBlocks.STRIPPED_PEAR_LOG);
		dropSelf(FBlocks.PEAR_WOOD);
		dropSelf(FBlocks.STRIPPED_PEAR_WOOD);

		add(
				FBlocks.PEAR_LEAVES,
				block -> createPearLeavesDrops(
						block,
						FBlocks.PEAR_SAPLING,
						NORMAL_LEAVES_SAPLING_CHANCES
				)
		);
		dropSelf(FBlocks.PEAR_SAPLING);
		dropPottedContents(FBlocks.POTTED_PEAR_SAPLING);

		dropSelf(FBlocks.PEAR_PLANKS);
		dropSelf(FBlocks.PEAR_STAIRS);
		add(FBlocks.PEAR_SLAB, this::createSlabItemTable);
		dropSelf(FBlocks.PEAR_FENCE);
		dropSelf(FBlocks.PEAR_FENCE_GATE);
		add(FBlocks.PEAR_DOOR, this::createDoorTable);
		dropSelf(FBlocks.PEAR_TRAPDOOR);
		dropSelf(FBlocks.PEAR_BUTTON);
		dropSelf(FBlocks.PEAR_PRESSURE_PLATE);
		dropSelf(FBlocks.PEAR_SIGN);
		dropOther(FBlocks.PEAR_WALL_SIGN, FBlocks.PEAR_SIGN);
		dropSelf(FBlocks.PEAR_HANGING_SIGN);
		dropOther(FBlocks.PEAR_WALL_HANGING_SIGN, FBlocks.PEAR_HANGING_SIGN);
		dropSelf(FBlocks.PEAR_SHELF);

		add(FBlocks.WHITE_PETALS,
				createSegmentedBlockDrops(FBlocks.WHITE_PETALS)
		);

		// TRANSIUM
		dropSelf(FBlocks.TRANSIUM_BLOCK);

		// ROSE QUARTZ
		add(FBlocks.ROSE_QUARTZ_ORE,
				createOreDrop(
						FBlocks.ROSE_QUARTZ_ORE,
						FItems.ROSE_QUARTZ_SHARD
				)
		);
		dropSelf(FBlocks.ROSE_QUARTZ_BLOCK);

		dropSelf(FBlocks.ROSE_QUARTZ_BRICKS);
		dropSelf(FBlocks.ROSE_QUARTZ_BRICK_STAIRS);
		dropSelf(FBlocks.ROSE_QUARTZ_BRICK_SLAB);
		dropSelf(FBlocks.ROSE_QUARTZ_BRICK_WALL);
		dropSelf(FBlocks.CHISELED_ROSE_QUARTZ_BRICKS);

		add(FBlocks.ROSE_QUARTZ_DOOR, this::createDoorTable);
		dropSelf(FBlocks.ROSE_QUARTZ_TRAPDOOR);
		dropSelf(FBlocks.ROSE_QUARTZ_LADDER);
		dropSelf(FBlocks.ROSE_QUARTZ_BARS);
		dropSelf(FBlocks.ROSE_QUARTZ_CHAIN);
		dropSelf(FBlocks.ROSE_QUARTZ_LANTERN);
		dropSelf(FBlocks.ROSE_QUARTZ_PRESSURE_PLATE);
		dropSelf(FBlocks.ROSE_QUARTZ_BUTTON);

		// GOLEM HEADS
		dropSelf(FBlocks.GOLEM_HEAD_COAL);
		dropSelf(FBlocks.GOLEM_HEAD_DIAMOND);
		dropSelf(FBlocks.GOLEM_HEAD_EMERALD);
		dropSelf(FBlocks.GOLEM_HEAD_GOLD);
		dropSelf(FBlocks.GOLEM_HEAD_IRON);
		dropSelf(FBlocks.GOLEM_HEAD_LAPIS);
		dropSelf(FBlocks.GOLEM_HEAD_AMETHYST);
		dropSelf(FBlocks.GOLEM_HEAD_NETHERITE);
		dropSelf(FBlocks.GOLEM_HEAD_REDSTONE);
	}

	public LootTable.Builder createPearLeavesDrops(
			final Block original, final Block sapling, final float... saplingChances) {
		return createLeavesDrops(original, sapling, saplingChances)
				.withPool(
						LootPool.lootPool()
								.setRolls(ContextIntProviders.exactly(1))
								.when(doesNotHaveShearsOrSilkTouch())
								.add(
										applyExplosionCondition(original, LootItem.lootTableItem(FItems.PEAR))
												.when(
														BonusLevelTableCondition.bonusLevelFlatChance(enchantments.getOrThrow(Enchantments.FORTUNE), 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.025F)
												)
								)
				);
	}
	public LootTable.Builder createCherryLeavesDrops(
			final Block original, final Block sapling, final float... saplingChances) {
		return createLeavesDrops(original, sapling, saplingChances)
				.withPool(
						LootPool.lootPool()
								.setRolls(ContextIntProviders.exactly(1))
								.when(doesNotHaveShearsOrSilkTouch())
								.add(
										applyExplosionCondition(original, LootItem.lootTableItem(FItems.CHERRY))
												.when(
														BonusLevelTableCondition.bonusLevelFlatChance(enchantments.getOrThrow(Enchantments.FORTUNE), 0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.025F)
												)
								)
				);
	}
	public LootTable.Builder createPoppyDrops(final Block block) {
		return LootTable.lootTable()
				.withPool(
						LootPool.lootPool()
								.setRolls(ContextIntProviders.exactly(1))
								.add(applyExplosionCondition(block, LootItem.lootTableItem(
										Items.POPPY))
								)
								.add(applyExplosionCondition(block, LootItem.lootTableItem(
										FItems.POPPY_SEEDS))
								)
				);
	}
	public LootTable.Builder createDoubleDrop(final Block block, final Item drop1, final Item drop2) {
		return this.applyExplosionDecay(
				block,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(drop1))
						)
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(drop2))
						)
		);
	}

	@Override
	public String getName() {
		return "FBlockLootTableProvider";
	}
}
