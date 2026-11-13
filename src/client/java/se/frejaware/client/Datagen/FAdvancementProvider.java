package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.MinMaxBounds;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.predicates.entity.EntityTypePredicate;
import net.minecraft.advancements.predicates.entity.PlayerPredicate;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.Items.FItems;
import se.frejaware.WorldGen.Biome.FBiomes;
import se.frejaware.WorldGen.Structures.FStructures;

import java.util.Optional;
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
		try {
			var itemRegistry = registryLookup.lookupOrThrow(Registries.ITEM);
			var biomeRegistry = registryLookup.lookupOrThrow(Registries.BIOME);
			var structureRegistry = registryLookup.lookupOrThrow(Registries.STRUCTURE);

			// ------------------
			// FREJAWARE
			// ------------------

			AdvancementHolder root = Advancement.Builder.advancement()
					.rootDisplay(
							FItems.PEAR,
							Component.translatable(
									"advancements.frejaware.root.title"
							),
							Component.translatable(
									"advancements.frejaware.root.description"
							),
							F.id("gui/advancements/background/frejaware"),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.requirements(AdvancementRequirements.Strategy.OR)
					.addCriterion(
							"visit_pear_meadow_root",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inBiome(
											biomeRegistry.getOrThrow(FBiomes.PEAR_MEADOW)
									)
							)
					)
					.addCriterion(
							"visit_jacaranda_glade_root",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inBiome(
											biomeRegistry.getOrThrow(FBiomes.JACARANDA_GLADE)
									)
							)
					)
					.save(consumer, F.id("frejaware/root"));

			AdvancementHolder fourTwenty = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FItems.POPPY_SEEDS,
							Component.translatable(
									"advancements.frejaware.four_twenty.title"
							),
							Component.translatable(
									"advancements.frejaware.four_twenty.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"eat_poppy_seeds",
							ConsumeItemTrigger.TriggerInstance.usedItem(
									itemRegistry, FItems.POPPY_SEEDS
							)
					)
					.save(consumer, F.id("frejaware/four_twenty"));
			AdvancementHolder druglord = Advancement.Builder.advancement()
					.parent(fourTwenty)
					.display(
							Items.POPPY,
							Component.translatable(
									"advancements.frejaware.druglord.title"
							),
							Component.translatable(
									"advancements.frejaware.druglord.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"eat_10_poppy_seeds",
							CriteriaTriggers.TICK.createCriterion(
									new PlayerTrigger.TriggerInstance(Optional.of(EntityPredicate.wrap(
											EntityPredicate.Builder.entity()
													.player(PlayerPredicate.Builder.player()
															.addStat(Stats.ITEM_USED,
																	FItems.POPPY_SEEDS.builtInRegistryHolder(),
																	MinMaxBounds.Ints.atLeast(
																			10
																	)
															)
															.build()
													)
									)))
							)
					)
					.save(consumer, F.id("frejaware/druglord"));

			AdvancementHolder florist = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FBlocks.WHITE_ORCHID.asItem(),
							Component.translatable(
									"advancements.frejaware.florist.title"
							),
							Component.translatable(
									"advancements.frejaware.florist.description"
							),
							AdvancementType.CHALLENGE,
							true,
							true,
							false
					)
					.rewards(AdvancementRewards.Builder.experience(100))
					.requirements(AdvancementRequirements.Strategy.AND)
					.addCriterion(
							"collect_white_orchid",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.WHITE_ORCHID
							)
					)
					.addCriterion(
							"collect_yellow_tulip",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.YELLOW_TULIP
							)
					)
					.addCriterion(
							"collect_white_hibiscus",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.WHITE_HIBISCUS
							)
					)
					.addCriterion(
							"collect_yellow_hibiscus",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.YELLOW_HIBISCUS
							)
					)
					.addCriterion(
							"collect_white_crocus",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.WHITE_CROCUS
							)
					)
					.addCriterion(
							"collect_lilac_crocus",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.LILAC_CROCUS
							)
					)
					.addCriterion(
							"collect_purple_crocus",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.PURPLE_CROCUS
							)
					)
					.addCriterion(
							"collect_lily_of_the_glade",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.LILY_OF_THE_GLADE
							)
					)
					.save(consumer, F.id("frejaware/florist"));

			AdvancementHolder jingle_bells = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FBlocks.IRON_BELL.asItem(),
							Component.translatable(
									"advancements.frejaware.jingle_bells.title"
							),
							Component.translatable(
									"advancements.frejaware.jingle_bells.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.requirements(AdvancementRequirements.Strategy.AND)
					.addCriterion(
							"obtain_bell",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									Items.BELL
							)
					)
					.addCriterion(
							"obtain_iron_bell",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FBlocks.IRON_BELL
							)
					)
					.save(consumer, F.id("frejaware/jingle_bells"));

			// ------------------
			// ORCHARD
			// ------------------

			AdvancementHolder makeMeJuice = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FBlocks.ORANGE_SAPLING.asItem(),
							Component.translatable(
									"advancements.frejaware.make_me_juice.title"
							),
							Component.translatable(
									"advancements.frejaware.make_me_juice.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"visit_orchard",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inBiome(biomeRegistry.getOrThrow(
											FBiomes.ORCHARD
									))
							)
					)
					.save(consumer, F.id("frejaware/make_me_juice"));

			AdvancementHolder underTheSea = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FItems.PINEAPPLE.asItem(),
							Component.translatable(
									"advancements.frejaware.pineapple_under_the_sea.title"
							),
							Component.translatable(
									"advancements.frejaware.pineapple_under_the_sea.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"obtain_pineapple",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FItems.PINEAPPLE
							)
					)
					.save(consumer, F.id("frejaware/pineapple_under_the_sea"));

			// ------------------
			// JACARANDA
			// ------------------

			AdvancementHolder jackThatRanda = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FBlocks.JACARANDA_SAPLING.asItem(),
							Component.translatable(
									"advancements.frejaware.jack_that_randa.title"
							),
							Component.translatable(
									"advancements.frejaware.jack_that_randa.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"visit_jacaranda_glade",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inBiome(biomeRegistry.getOrThrow(
											FBiomes.JACARANDA_GLADE
									))
							)
					)
					.save(consumer, F.id("frejaware/jack_that_randa"));

			AdvancementHolder wellWellWell = Advancement.Builder.advancement()
					.parent(jackThatRanda)
					.display(
							FBlocks.JACARANDA_LOG.asItem(),
							Component.translatable(
									"advancements.frejaware.well_well_well.title"
							),
							Component.translatable(
									"advancements.frejaware.well_well_well.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"find_jacaranda_well",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inStructure(structureRegistry.getOrThrow(
											FStructures.JACARANDA_WELL
									))
							)
					)
					.save(consumer, F.id("frejaware/well_well_well"));

			// ------------------
			// PEAR
			// ------------------

			AdvancementHolder ohMyMeadows = Advancement.Builder.advancement()
					.parent(root)
					.display(
							FBlocks.PEAR_SAPLING.asItem(),
							Component.translatable(
									"advancements.frejaware.oh_my_meadows.title"
							),
							Component.translatable(
									"advancements.frejaware.oh_my_meadows.description"
							),
							AdvancementType.TASK,
							true,
							true,
							false
					)
					.addCriterion(
							"visit_pear_meadow",
							PlayerTrigger.TriggerInstance.located(
									LocationPredicate.Builder.inBiome(biomeRegistry.getOrThrow(
											FBiomes.PEAR_MEADOW
									))
							)
					)
					.save(consumer, F.id("frejaware/oh_my_meadows"));

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
					.save(consumer, F.id("frejaware/milk_jugs"));
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
					.addCriterion(
							"obtain_saffron_milk",
							InventoryChangeTrigger.TriggerInstance.hasItems(
									FItems.SAFFRON_MILK_BOTTLE
							)
					)
					.save(consumer, F.id("frejaware/milk_enthusiast"));

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
					.save(consumer, F.id("frejaware/good_blowjob"));
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
					.save(consumer, F.id("frejaware/berry_good"));

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
					.save(consumer, F.id("frejaware/chocolatier"));

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
					.save(consumer, F.id("frejaware/pop_that_cherry"));
			AdvancementHolder kindaFruity = Advancement.Builder.advancement()
					.parent(popThatCherry)
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
					.addCriterion(
							"eat_pineapple",
							ConsumeItemTrigger.TriggerInstance.usedItem(
									itemRegistry,
									FItems.PINEAPPLE
							)
					)
					.save(consumer, F.id("frejaware/kinda_fruity"));

			// ------------------
			// ROSE QUARTZ
			// ------------------

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "FAdvancementProvider";
	}
}