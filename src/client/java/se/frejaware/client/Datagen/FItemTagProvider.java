package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import se.frejaware.Blocks.FBlockItemIds;
import se.frejaware.Shared.FBlockTags;
import se.frejaware.Items.FItemIds;
import se.frejaware.Shared.FItemTags;

import java.util.concurrent.CompletableFuture;

public class FItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
	public FItemTagProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// MOLLY
		builder(ItemTags.BEE_FOOD)
				.add(FBlockItemIds.WHITE_ORCHID)
				.add(FBlockItemIds.YELLOW_TULIP)
				.add(FBlockItemIds.WHITE_CACTUS_FLOWER)
				.add(FBlockItemIds.YELLOW_CACTUS_FLOWER);

		// FOOD
		builder(ConventionalItemTags.FOODS)
				.add(FItemIds.CHERRY)
				.add(FItemIds.BANANA)
				.add(FItemIds.ORANGE)
				.add(FItemIds.PEAR)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR)
				.add(FItemIds.CHOCOLATE_BOTTLE)
				.add(FItemIds.MILK_BOTTLE)
				.add(FItemIds.BERRY_JUICE_BOTTLE)
				.add(FItemIds.MILKSHAKE_BOTTLE)
				.add(FItemIds.COCOA_BUTTER)
				.add(FItemIds.CHOCOLATE)
				.add(FItemIds.CHOCOLATE_BAR)
				.add(FBlockItemIds.BLUEBERRY_CROP)
				.add(FBlockItemIds.BLACKBERRY_CROP)
				.add(FBlockItemIds.PINKBERRY_CROP)
				.add(FBlockItemIds.BLOWBERRY_CROP)
				.add(FItemIds.FRUIT_SALAD)
				.add(FItemIds.ICE_CREAM)
				.add(FItemIds.CHOCOLATE_ICE_CREAM);

		builder(ConventionalItemTags.BERRY_FOODS)
				.add(FBlockItemIds.BLUEBERRY_CROP)
				.add(FBlockItemIds.BLACKBERRY_CROP)
				.add(FBlockItemIds.PINKBERRY_CROP)
				.add(FBlockItemIds.BLOWBERRY_CROP);
		builder(ConventionalItemTags.CANDY_FOODS)
				.add(FItemIds.MILKSHAKE_BOTTLE)
				.add(FItemIds.COCOA_BUTTER)
				.add(FItemIds.CHOCOLATE)
				.add(FItemIds.CHOCOLATE_BAR)
				.add(FItemIds.ICE_CREAM)
				.add(FItemIds.CHOCOLATE_ICE_CREAM);
		builder(ConventionalItemTags.FRUIT_FOODS)
				.add(FItemIds.CHERRY)
				.add(FItemIds.BANANA)
				.add(FItemIds.ORANGE)
				.add(FItemIds.PEAR)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR)
				.add(FItemIds.FRUIT_SALAD);
		builder(ConventionalItemTags.GOLDEN_FOODS)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR);

		builder(FItemTags.FRUIT_SALAD_INGREDIENTS)
				.add(ItemIds.APPLE)
				.add(ItemIds.MELON_SLICE)
				.add(FItemIds.CHERRY)
				.add(FItemIds.BANANA)
				.add(FItemIds.ORANGE)
				.add(FItemIds.PEAR);

		builder(ItemTags.HORSE_FOOD)
				.add(FItemIds.BANANA)
				.add(FItemIds.ORANGE)
				.add(FItemIds.PEAR)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR);
		builder(ItemTags.HORSE_TEMPT_ITEMS)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR);
		builder(ItemTags.PIGLIN_LOVED)
				.add(FItemIds.GOLDEN_PEAR)
				.add(FItemIds.ENCHANTED_GOLDEN_PEAR);

		// PEAR
		builder(ItemTags.LOGS)
				.add(FBlockItemIds.PEAR_LOG)
				.add(FBlockItemIds.STRIPPED_PEAR_LOG)
				.add(FBlockItemIds.PEAR_WOOD)
				.add(FBlockItemIds.STRIPPED_PEAR_WOOD);
		builder(FItemTags.PEAR_LOGS)
				.add(FBlockItemIds.PEAR_LOG)
				.add(FBlockItemIds.STRIPPED_PEAR_LOG)
				.add(FBlockItemIds.PEAR_WOOD)
				.add(FBlockItemIds.STRIPPED_PEAR_WOOD);
		builder(ItemTags.PLANKS)
				.add(FBlockItemIds.PEAR_PLANKS);
		builder(ItemTags.LEAVES)
				.add(FBlockItemIds.PEAR_LEAVES);
		builder(ItemTags.SAPLINGS)
				.add(FBlockItemIds.PEAR_SAPLING);
		builder(BlockItemTags.STAIRS)
				.add(FBlockItemIds.PEAR_STAIRS);
		builder(BlockItemTags.SLABS)
				.add(FBlockItemIds.PEAR_SLAB);
		builder(BlockItemTags.FENCES)
				.add(FBlockItemIds.PEAR_FENCE);
		builder(ItemTags.FENCE_GATES)
				.add(FBlockItemIds.PEAR_FENCE_GATE);
		builder(ItemTags.WOODEN_DOORS)
				.add(FBlockItemIds.PEAR_DOOR);
		builder(ItemTags.WOODEN_TRAPDOORS)
				.add(FBlockItemIds.PEAR_TRAPDOOR);
		builder(ItemTags.WOODEN_BUTTONS)
				.add(FBlockItemIds.PEAR_BUTTON);
		builder(ItemTags.WOODEN_PRESSURE_PLATES)
				.add(FBlockItemIds.PEAR_PRESSURE_PLATE);
		builder(ItemTags.SIGNS)
				.add(FBlockItemIds.PEAR_SIGN);
		builder(ItemTags.HANGING_SIGNS)
				.add(FBlockItemIds.PEAR_HANGING_SIGN);
		builder(ItemTags.BOATS)
				.add(FItemIds.PEAR_BOAT);
		builder(ItemTags.CHEST_BOATS)
				.add(FItemIds.PEAR_CHEST_BOAT);
		
		// OTHER
		builder(FItemTags.REPAIRS_ROSE_QUARTZ)
				.add(FItemIds.ROSE_QUARTZ_SHARD);
		builder(FItemTags.REPAIRS_TRANSIUM)
				.add(FItemIds.TRANSIUM);

		builder(ItemTags.TRIM_MATERIALS)
				.add(FItemIds.ROSE_QUARTZ_SHARD);

		builder(ItemTags.BEACON_PAYMENT_ITEMS)
				.add(FItemIds.ROSE_QUARTZ)
				.add(FItemIds.TRANSIUM);

		builder(ItemTags.CLUSTER_MAX_HARVESTABLES)
				.add(FItemIds.ROSE_QUARTZ_PICKAXE)
				.add(FItemIds.TRANSIUM_PICKAXE);

		builder(ItemTags.PICKAXES)
				.add(FItemIds.ROSE_QUARTZ_PICKAXE)
				.add(FItemIds.TRANSIUM_PICKAXE);
		builder(ItemTags.SHOVELS)
				.add(FItemIds.ROSE_QUARTZ_SHOVEL)
				.add(FItemIds.TRANSIUM_SHOVEL);
		builder(ItemTags.AXES)
				.add(FItemIds.ROSE_QUARTZ_AXE)
				.add(FItemIds.TRANSIUM_AXE);
		builder(ItemTags.HOES)
				.add(FItemIds.ROSE_QUARTZ_HOE)
				.add(FItemIds.TRANSIUM_HOE);
		builder(ItemTags.SWORDS)
				.add(FItemIds.ROSE_QUARTZ_SWORD)
				.add(FItemIds.TRANSIUM_SWORD);
		builder(ItemTags.SPEARS)
				.add(FItemIds.ROSE_QUARTZ_SPEAR)
				.add(FItemIds.TRANSIUM_SPEAR);

		builder(ItemTags.HEAD_ARMOR)
				.add(FItemIds.ROSE_QUARTZ_HELMET)
				.add(FItemIds.TRANSIUM_HELMET);
		builder(ItemTags.CHEST_ARMOR)
				.add(FItemIds.ROSE_QUARTZ_CHESTPLATE)
				.add(FItemIds.TRANSIUM_CHESTPLATE);
		builder(ItemTags.LEG_ARMOR)
				.add(FItemIds.ROSE_QUARTZ_LEGGINGS)
				.add(FItemIds.TRANSIUM_LEGGINGS);
		builder(ItemTags.FOOT_ARMOR)
				.add(FItemIds.ROSE_QUARTZ_BOOTS)
				.add(FItemIds.TRANSIUM_BOOTS);

		builder(ItemTags.TRIMMABLE_ARMOR)
				.add(FItemIds.ROSE_QUARTZ_HELMET)
				.add(FItemIds.ROSE_QUARTZ_CHESTPLATE)
				.add(FItemIds.ROSE_QUARTZ_LEGGINGS)
				.add(FItemIds.ROSE_QUARTZ_BOOTS)
				.add(FItemIds.TRANSIUM_HELMET)
				.add(FItemIds.TRANSIUM_CHESTPLATE)
				.add(FItemIds.TRANSIUM_LEGGINGS)
				.add(FItemIds.TRANSIUM_BOOTS);

		builder(ConventionalItemTags.SHIELD_TOOLS)
				.add(FItemIds.ROSE_QUARTZ_SHIELD);
		builder(ItemTags.DURABILITY_ENCHANTABLE)
				.add(FItemIds.ROSE_QUARTZ_SHIELD);
	}

	@Override
	public String getName() {
		return "FItemTagProvider";
	}
}