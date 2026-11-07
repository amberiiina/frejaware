package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.KilledTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.block.Blocks;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.Items.FItems;
import se.frejaware.WorldGen.Biome.FBiomes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FAdvancementProvider extends FabricAdvancementProvider {
	protected FAdvancementProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generateAdvancement(
			HolderLookup.Provider registryLookup,
			Consumer<AdvancementHolder> consumer) {
		var biomeRegistry = registryLookup.lookupOrThrow(Registries.BIOME);
		var itemRegistry = registryLookup.lookupOrThrow(Registries.ITEM);

		// ------------------
		// PEAR
		// ------------------

		AdvancementHolder ohMyMeadows = Advancement.Builder.advancement()
				.rootDisplay(
						FBlocks.PEAR_SAPLING.asItem(),
						Component.translatable(
								"advancements.frejaware.oh_my_meadows.title"
						),
						Component.translatable(
								"advancements.frejaware.oh_my_meadows.description"
						),
						F.id("block/stripped_pear_log"),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"visit_pear_meadow",
						PlayerTrigger.TriggerInstance.located(
								LocationPredicate.Builder.inBiome(
										biomeRegistry.getOrThrow(FBiomes.PEAR_MEADOW)
								)
						)
				)
				.save(consumer, F.id("pear/oh_my_meadows"));

		AdvancementHolder milkJugs = Advancement.Builder.advancement()
				.parent(ohMyMeadows)
				.display(
						FItems.MILKSHAKE_BOTTLE,
						Component.translatable(
								"advancements.frejaware.milk_jugs.title"
						),
						Component.translatable(
								"advancements.frejaware.milk_jugs.description"
						),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"obtain_milkshake",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.MILKSHAKE_BOTTLE
						)
				)
				.save(consumer, F.id("pear/milk_jugs"));
		AdvancementHolder milkEnthusiast = Advancement.Builder.advancement()
				.parent(milkJugs)
				.display(
						FItems.MILK_BOTTLE,
						Component.translatable(
								"advancements.frejaware.milk_enthusiast.title"
						),
						Component.translatable(
								"advancements.frejaware.milk_enthusiast.description"
						),
						AdvancementType.CHALLENGE,
						true,
						true,
						false
				)
				.rewards(AdvancementRewards.Builder.experience(100))
				.requirements(AdvancementRequirements.Strategy.AND)
				.addCriterion(
						"obtain_milk",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.MILK_BOTTLE
						)
				)
				.addCriterion(
						"obtain_milkshake",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.MILKSHAKE_BOTTLE
						)
				)
				.addCriterion(
						"obtain_ice_cream",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.ICE_CREAM
						)
				)
				.save(consumer, F.id("pear/milk_enthusiast"));

		AdvancementHolder goodBlowjob = Advancement.Builder.advancement()
				.parent(ohMyMeadows)
				.display(
						FItems.BLOWBERRIES,
						Component.translatable(
								"advancements.frejaware.good_blowjob.title"
						),
						Component.translatable(
								"advancements.frejaware.good_blowjob.description"
						),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"obtain_blowberries",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.BLOWBERRIES
						)
				)
				.save(consumer, F.id("pear/good_blowjob"));
		AdvancementHolder berryGood = Advancement.Builder.advancement()
				.parent(goodBlowjob)
				.display(
						FItems.BERRY_JUICE_BOTTLE,
						Component.translatable(
								"advancements.frejaware.berry_good.title"
						),
						Component.translatable(
								"advancements.frejaware.berry_good.description"
						),
						AdvancementType.CHALLENGE,
						true,
						true,
						false
				)
				.rewards(AdvancementRewards.Builder.experience(100))
				.requirements(AdvancementRequirements.Strategy.AND)
				.addCriterion(
						"obtain_blueberry",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.BLUEBERRIES
						)
				)
				.addCriterion(
						"obtain_blackberry",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.BLACKBERRIES
						)
				)
				.addCriterion(
						"obtain_pinkberry",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.PINKBERRIES
						)
				)
				.addCriterion(
						"obtain_blowberry",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.BLOWBERRIES
						)
				)
				.addCriterion(
						"obtain_berry_juice",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.BERRY_JUICE_BOTTLE
						)
				)
				.save(consumer, F.id("pear/berry_good"));

		AdvancementHolder chocolatier = Advancement.Builder.advancement()
				.parent(ohMyMeadows)
				.display(
						FItems.CHOCOLATE_BAR,
						Component.translatable(
								"advancements.frejaware.chocolatier.title"
						),
						Component.translatable(
								"advancements.frejaware.chocolatier.description"
						),
						AdvancementType.CHALLENGE,
						true,
						true,
						false
				)
				.rewards(AdvancementRewards.Builder.experience(100))
				.requirements(AdvancementRequirements.Strategy.AND)
				.addCriterion(
						"obtain_cocoa_butter",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.COCOA_BUTTER
						)
				)
				.addCriterion(
						"obtain_chocolate",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.CHOCOLATE
						)
				)
				.addCriterion(
						"obtain_chocolate_bar",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.CHOCOLATE_BAR
						)
				)
				.addCriterion(
						"obtain_chocolate_bottle",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.CHOCOLATE_BOTTLE
						)
				)
				.addCriterion(
						"obtain_chocolate_pear",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.CHOCOLATE_DIPPED_PEAR
						)
				)
				.addCriterion(
						"obtain_cocoa_bean",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								Items.COCOA_BEANS
						)
				)
				.addCriterion(
						"obtain_cookie",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								Items.COOKIE
						)
				)
				.addCriterion(
						"obtain_chocolate_ice_cream",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.CHOCOLATE_ICE_CREAM
						)
				)
				.save(consumer, F.id("pear/chocolatier"));

		AdvancementHolder popThatCherry = Advancement.Builder.advancement()
				.parent(ohMyMeadows)
				.display(
						FItems.CHERRY,
						Component.translatable(
								"advancements.frejaware.pop_that_cherry.title"
						),
						Component.translatable(
								"advancements.frejaware.pop_that_cherry.description"
						),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"eat_cherry",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								FItems.CHERRY
						)
				)
				.save(consumer, F.id("pear/pop_that_cherry"));

		AdvancementHolder kindaFruity = Advancement.Builder.advancement()
				.parent(ohMyMeadows)
				.display(
						FItems.PEAR,
						Component.translatable(
								"advancements.frejaware.kinda_fruity.title"
						),
						Component.translatable(
								"advancements.frejaware.kinda_fruity.description"
						),
						AdvancementType.CHALLENGE,
						true,
						true,
						false
				)
				.rewards(AdvancementRewards.Builder.experience(100))
				.requirements(AdvancementRequirements.Strategy.AND)
				.addCriterion(
						"eat_cherry",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								FItems.CHERRY
						)
				)
				.addCriterion(
						"eat_banana",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								FItems.BANANA
						)
				)
				.addCriterion(
						"eat_orange",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								FItems.ORANGE
						)
				)
				.addCriterion(
						"eat_pear",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								FItems.PEAR
						)
				)
				.addCriterion(
						"eat_apple",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								Items.APPLE
						)
				)
				.addCriterion(
						"eat_melon",
						ConsumeItemTrigger.TriggerInstance.usedItem(
								itemRegistry,
								Items.MELON_SLICE
						)
				)
				.save(consumer, F.id("pear/kinda_fruity"));

		// ------------------
		// ROSE QUARTZ
		// ------------------

		// ore
		AdvancementHolder obtainRoseQuartzOre = Advancement.Builder.advancement()
				.parent(createPlaceholder(
						Identifier.withDefaultNamespace("end/kill_dragon")
				))
				.display(
						FBlocks.ROSE_QUARTZ_ORE.asItem(),
						Component.translatable(
								"advancements.frejaware.obtain_rose_quartz_ore.title"
						),
						Component.translatable(
								"advancements.frejaware.obtain_rose_quartz_ore.description"
						),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"obtain_rose_quartz_ore",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FBlocks.ROSE_QUARTZ_ORE
						)
				)
				.save(consumer, F.id("obtain_rose_quartz_ore"));
		// armor
		AdvancementHolder roseQuartzArmor = Advancement.Builder.advancement()
				.parent(obtainRoseQuartzOre)
				.display(
						FItems.ROSE_QUARTZ_CHESTPLATE.asItem(),
						Component.translatable(
								"advancements.frejaware.rose_quartz_armor.title"
						),
						Component.translatable(
								"advancements.frejaware.rose_quartz_armor.description"
						),
						AdvancementType.CHALLENGE,
						true,
						true,
						false
				)
				.addCriterion(
						"rose_quartz_armor",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								FItems.ROSE_QUARTZ_HELMET,
								FItems.ROSE_QUARTZ_CHESTPLATE,
								FItems.ROSE_QUARTZ_LEGGINGS,
								FItems.ROSE_QUARTZ_BOOTS
						)
				)
				.rewards(
						AdvancementRewards.Builder.experience(200)
				)
				.save(consumer, F.id("rose_quartz_armor"));
	}

	@Override
	public String getName() {
		return "FAdvancementProvider";
	}
}