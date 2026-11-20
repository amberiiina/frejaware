package se.frejaware.client.Datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBrewingProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.world.level.ItemLike;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.Entities.FMobEffects;
import se.frejaware.Items.FItems;
import se.frejaware.Shared.FItemTags;

public class FRecipeProvider extends FabricRecipeProvider {
	public FRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
		return new RecipeProvider(recipes, advancements) {
			@Override
			public void buildRecipes() {
				new FBrewingProvider(output).buildRecipes();
				// ----------------------
				// MOLLY
				// ----------------------

				// 1x bell
				shaped(RecipeCategory.DECORATIONS, Items.BELL)
						.pattern("LLL")
						.pattern(" G ")
						.define('L', ItemTags.LOGS)
						.define('G', Items.GOLD_BLOCK)
						.unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
						.save(output);
				// 1x iron bell
				shaped(RecipeCategory.DECORATIONS, FBlocks.IRON_BELL)
						.pattern("LLL")
						.pattern(" I ")
						.define('L', ItemTags.LOGS)
						.define('I', Items.IRON_BLOCK)
						.unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
						.save(output);
				// 1x butterfly pottery sherd
				shapeless(RecipeCategory.DECORATIONS, FItems.BUTTERFLY_POTTERY_SHERD)
						.requires(Items.HEART_POTTERY_SHERD)
						.requires(FItemTags.POT_FLOWERS)
						.unlockedBy(getHasName(Items.HEART_POTTERY_SHERD), has(Items.HEART_POTTERY_SHERD))
						.save(output);
				// 1x pink bone meal
				shapeless(RecipeCategory.MISC, FItems.PINK_BONE_MEAL)
						.requires(Items.BONE_MEAL)
						.requires(Items.DYE.pink())
						.requires(FBlocks.WHITE_ORCHID)
						.unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
						.save(output);

				// flowers
				flowerDye(FBlocks.WHITE_ORCHID, Items.DYE.white());
				flowerDye(FBlocks.YELLOW_TULIP, Items.DYE.yellow());
				flowerDye(FBlocks.WHITE_HIBISCUS, Items.DYE.white());
				flowerDye(FBlocks.YELLOW_HIBISCUS, Items.DYE.yellow());

				flowerDye(FBlocks.WHITE_CROCUS, Items.DYE.white());
				flowerDye(FBlocks.LILAC_CROCUS, Items.DYE.magenta());
				flowerDye(FBlocks.PURPLE_CROCUS, Items.DYE.purple());
				flowerDye(FBlocks.LILY_OF_THE_GLADE, Items.DYE.purple());

				flowerDye(FBlocks.FROSTBLOOM, Items.DYE.lightBlue());
				flowerDye(FBlocks.SNOWBELL, Items.DYE.white());

				flowerDye(FBlocks.WHITE_CACTUS_FLOWER, Items.DYE.white());
				flowerDye(FBlocks.YELLOW_CACTUS_FLOWER, Items.DYE.yellow());
				flowerDye(FBlocks.WHITE_ALLIUM, Items.DYE.white());
				flowerDye(FBlocks.PINK_CARNATION, Items.DYE.pink());
				flowerDye(FBlocks.WHITE_CARNATION, Items.DYE.white());
				flowerDye(FBlocks.CORAL_CARNATION, Items.DYE.red());
				flowerDye(FBlocks.VIOLET_CARNATION, Items.DYE.purple());
				flowerDye(FBlocks.YELLOW_CARNATION, Items.DYE.yellow());

				flowerDye(FBlocks.BLUE_SUCCULENT, Items.DYE.blue());
				flowerDye(FBlocks.RED_SUCCULENT, Items.DYE.red());
				flowerDye(FBlocks.GREEN_SUCCULENT, Items.DYE.green());
				flowerDye(FBlocks.TEAL_SUCCULENT, Items.DYE.cyan());
				flowerDye(FBlocks.PURPLE_SUCCULENT, Items.DYE.purple());
				flowerDye(FBlocks.BROWN_SUCCULENT, Items.DYE.brown());
				flowerDye(FBlocks.YELLOW_SUCCULENT, Items.DYE.yellow());

				flowerDye(FBlocks.WHITE_PETALS, Items.DYE.white());
				flowerDye(FBlocks.PURPLE_PETALS, Items.DYE.purple());
				flowerDye(FBlocks.LIGHT_BLUE_PETALS, Items.DYE.lightBlue());

				flowerDye(FBlocks.DRY_CACTUS, Items.DYE.green());

				// ----------------------
				// ENTITIES
				// ----------------------

				// 2x glaze powder
				shapeless(RecipeCategory.MISC, FItems.GLAZE_POWDER, 2)
						.requires(FItems.GLAZE_ROD)
						.unlockedBy(getHasName(FItems.GLAZE_ROD), has(FItems.GLAZE_ROD))
						.save(output);
				// 4x glaze shards
				shapeless(RecipeCategory.MISC, FItems.GLAZE_SHARD, 4)
						.requires(FItems.GLAZE_POWDER)
						.unlockedBy(getHasName(FItems.GLAZE_ROD), has(FItems.GLAZE_ROD))
						.save(output);
				// 1x glacier eye
				shapeless(RecipeCategory.MISC, FItems.GLACIER_EYE)
						.requires(FItems.GLACIER_PEARL)
						.requires(FItems.GLAZE_POWDER)
						.unlockedBy(getHasName(FItems.GLACIER_PEARL), has(FItems.GLACIER_PEARL))
						.save(output);
				// 1x frostbow
				shaped(RecipeCategory.TOOLS, FItems.FROSTBOW)
						.pattern(" RS")
						.pattern("RES")
						.pattern(" RS")
						.define('R', FItems.GLAZE_ROD)
						.define('S', FItems.FROSTBITE_STRING)
						.define('E', FItems.GLACIER_EYE)
						.unlockedBy(getHasName(FItems.FROSTBITE_STRING), has(FItems.FROSTBITE_STRING))
						.save(output);

				// ----------------------
				// VANILLA BLOCK VARIANTS
				// ----------------------

				stairBuilder(FBlocks.SNOW_STAIRS, Ingredient.of(Items.SNOW_BLOCK))
						.unlockedBy(getHasName(Items.SNOW_BLOCK), has(Items.SNOW_BLOCK))
						.save(output);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.SNOW_SLAB, Items.SNOW_BLOCK);
				stairBuilder(FBlocks.ICE_STAIRS, Ingredient.of(Items.ICE))
						.unlockedBy(getHasName(Items.ICE), has(Items.ICE))
						.save(output);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.ICE_SLAB, Items.ICE);
				stairBuilder(FBlocks.PACKED_ICE_STAIRS, Ingredient.of(Items.PACKED_ICE))
						.unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE))
						.save(output);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.PACKED_ICE_SLAB, Items.PACKED_ICE);
				stairBuilder(FBlocks.BLUE_ICE_STAIRS, Ingredient.of(Items.BLUE_ICE))
						.unlockedBy(getHasName(Items.BLUE_ICE), has(Items.BLUE_ICE))
						.save(output);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.BLUE_ICE_SLAB, Items.BLUE_ICE);

				SimpleCookingRecipeBuilder.smelting(Ingredient.of(FBlocks.YELLOW_SAND), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS,
						Items.STAINED_GLASS.yellow(), 0.35F, 200)
						.unlockedBy(getHasName(FBlocks.YELLOW_SAND), has(FBlocks.YELLOW_SAND))
						.save(output, "yellow_stained_glass_from_yellow_sand");
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(FBlocks.GRAY_SAND), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS,
						Items.STAINED_GLASS.lightGray(), 0.35F, 200)
						.unlockedBy(getHasName(FBlocks.GRAY_SAND), has(FBlocks.GRAY_SAND))
						.save(output, "light_gray_stained_glass_from_light_gray_sand");
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(FBlocks.PINK_SAND), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS,
						Items.STAINED_GLASS.pink(), 0.35F, 200)
						.unlockedBy(getHasName(FBlocks.PINK_SAND), has(FBlocks.PINK_SAND))
						.save(output, "pink_stained_glass_from_pink_sand");

				// ----------------------
				// ARCTIC
				// ----------------------

				// 1x aquamarine block
				shaped(RecipeCategory.MISC, FBlocks.AQUAMARINE_BLOCK)
						.pattern("##")
						.pattern("##")
						.define('#', FItems.AQUAMARINE_SHARD)
						.unlockedBy(getHasName(FItems.AQUAMARINE_SHARD), has(FItems.AQUAMARINE_SHARD))
						.save(output);
				// 4x aquamarine shard
				shapeless(RecipeCategory.MISC, FItems.AQUAMARINE_SHARD, 4)
						.requires(FBlocks.AQUAMARINE_BLOCK)
						.unlockedBy(getHasName(FBlocks.AQUAMARINE_BLOCK), has(FBlocks.AQUAMARINE_BLOCK))
						.save(output);

				// ----------------------
				// FOOD
				// ----------------------

				// 1x berry juice bottle
				shapeless(RecipeCategory.FOOD, FItems.BERRY_JUICE_BOTTLE)
						.requires(Items.GLASS_BOTTLE)
						.requires(ConventionalItemTags.BERRY_FOODS)
						.requires(ConventionalItemTags.BERRY_FOODS)
						.requires(ConventionalItemTags.BERRY_FOODS)
						.unlockedBy("has_berry", has(ConventionalItemTags.BERRY_FOODS))
						.save(output);
				// 1x jam
				foodSmelting(FItems.JAM, FItems.JAM_BLEND);
				// 1x jam blend
				shapeless(RecipeCategory.FOOD, FItems.JAM_BLEND)
						.requires(Items.GLASS_BOTTLE)
						.requires(ConventionalItemTags.BERRY_FOODS)
						.requires(ConventionalItemTags.BERRY_FOODS)
						.requires(Items.SUGAR)
						.unlockedBy("has_berry", has(ConventionalItemTags.BERRY_FOODS))
						.save(output);

				// 1x golden pear
				shaped(RecipeCategory.FOOD, FItems.GOLDEN_PEAR)
						.pattern("GGG")
						.pattern("GPG")
						.pattern("GGG")
						.define('G', Items.GOLD_INGOT)
						.define('P', FItems.PEAR)
						.unlockedBy(getHasName(FItems.PEAR), has(FItems.PEAR))
						.save(output);
				// 1x enchanted golden pear
				shaped(RecipeCategory.FOOD, FItems.ENCHANTED_GOLDEN_PEAR)
						.pattern("GGG")
						.pattern("GPG")
						.pattern("GGG")
						.define('G', Items.GOLD_INGOT)
						.define('P', FItems.GOLDEN_PEAR)
						.unlockedBy(getHasName(FItems.PEAR), has(FItems.PEAR))
						.save(output);
				// 1x saffron
				shapeless(RecipeCategory.FOOD, FItems.SAFFRON)
						.requires(FItemTags.CROCUSES)
						.unlockedBy("has_crocus", has(FItemTags.CROCUSES))
						.save(output);
				// 1x saffron milk
				shapeless(RecipeCategory.FOOD, FItems.SAFFRON_MILK_BOTTLE, 2)
						.requires(FItems.MILK_BOTTLE)
						.requires(FItems.SAFFRON)
						.requires(Items.HONEY_BOTTLE)
						.requires(Items.GOLD_INGOT)
						.unlockedBy(getHasName(FItems.SAFFRON), has(FItems.SAFFRON))
						.save(output);
				// 1x poppy seed
				shapeless(RecipeCategory.FOOD, FItems.POPPY_SEEDS)
						.requires(Items.POPPY)
						.unlockedBy(getHasName(Items.POPPY), has(Items.POPPY))
						.save(output);
				// 1x pineapple seed
				shapeless(RecipeCategory.MISC, FItems.PINEAPPLE_SEEDS)
						.requires(FItems.PINEAPPLE)
						.unlockedBy(getHasName(FItems.PINEAPPLE), has(FItems.PINEAPPLE))
						.save(output);
				// 1x marmalade
				foodSmelting(FItems.MARMALADE, FItems.MARMALADE_BLEND);
				// 1x marmalade blend
				shapeless(RecipeCategory.FOOD, FItems.MARMALADE_BLEND)
						.requires(Items.GLASS_BOTTLE)
						.requires(FItems.ORANGE)
						.requires(Items.SUGAR)
						.unlockedBy(getHasName(FItems.ORANGE), has(FItems.ORANGE))
						.save(output);

				// 8x milk bottle
				shapeless(RecipeCategory.FOOD, FItems.MILK_BOTTLE, 8)
						.requires(Items.MILK_BUCKET)
						.unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
						.save(output);
				// 2x milkshake bottle
				shapeless(RecipeCategory.FOOD, FItems.MILKSHAKE_BOTTLE, 2)
						.requires(FItems.MILK_BOTTLE)
						.requires(FItems.ICE_CREAM)
						.requires(FItems.PINKBERRIES)
						.unlockedBy(getHasName(FItems.MILK_BOTTLE), has(FItems.MILK_BOTTLE))
						.save(output);
				// 1x ice cream
				shapeless(RecipeCategory.FOOD, FItems.ICE_CREAM)
						.requires(Items.BOWL)
						.requires(FItems.MILK_BOTTLE)
						.requires(Items.SUGAR)
						.unlockedBy(getHasName(FItems.MILK_BOTTLE), has(FItems.MILK_BOTTLE))
						.save(output);

				// 1x cocoa butter
				SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.COCOA_BEANS),
								RecipeCategory.FOOD, FItems.COCOA_BUTTER,
								0.35F, 200)
						.unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
						.save(output);
				// 4x chocolate
				shapeless(RecipeCategory.FOOD, FItems.CHOCOLATE, 4)
						.requires(Items.COCOA_BEANS, 4)
						.requires(FItems.COCOA_BUTTER, 2)
						.requires(Items.HONEY_BOTTLE, 1)
						.unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
						.save(output);
				// 1x chocolate bar
				combineTwoFood(FItems.CHOCOLATE_BAR,
						FItems.CHOCOLATE, Items.SUGAR, FItems.COCOA_BUTTER);
				// 1x chocolate dipped pear
				shapeless(RecipeCategory.FOOD, FItems.CHOCOLATE_DIPPED_PEAR)
						.requires(FItems.PEAR)
						.requires(FItems.CHOCOLATE)
						.unlockedBy(getHasName(FItems.PEAR), has(FItems.PEAR))
						.save(output);
				// 1x chocolate bottle
				combineTwoFood(FItems.CHOCOLATE_BOTTLE, FItems.MILK_BOTTLE, FItems.CHOCOLATE);
				// 1x chocolate ice cream
				shapeless(RecipeCategory.FOOD, FItems.CHOCOLATE_ICE_CREAM)
						.requires(Items.BOWL)
						.requires(FItems.MILK_BOTTLE)
						.requires(Items.SUGAR)
						.requires(FItems.CHOCOLATE)
						.unlockedBy(getHasName(FItems.MILK_BOTTLE), has(FItems.MILK_BOTTLE))
						.save(output);
				// 1x chocolate ice cream
				combineTwoFood(FItems.CHOCOLATE_ICE_CREAM,
						FItems.ICE_CREAM, FItems.CHOCOLATE,
						"chocolate_ice_cream_from_ice_cream");

				// 1x fruit salad
				shapeless(RecipeCategory.FOOD, FItems.FRUIT_SALAD)
						.requires(Items.BOWL)
						.requires(ConventionalItemTags.FRUIT_FOODS)
						.requires(ConventionalItemTags.FRUIT_FOODS)
						.requires(ConventionalItemTags.FRUIT_FOODS)
						.unlockedBy("has_fruit", has(ConventionalItemTags.FRUIT_FOODS))
						.save(output);
				// 1x pancake
				shapeless(RecipeCategory.FOOD, FItems.PANCAKE)
						.requires(Items.WHEAT)
						.requires(FItems.MILK_BOTTLE)
						.requires(Items.EGG)
						.unlockedBy(getHasName(Items.EGG), has(Items.EGG))
						.save(output);
				// 1x swedish pancake from raw
				shapeless(RecipeCategory.FOOD, FItems.SWEDISH_PANCAKE)
						.requires(Items.WHEAT)
						.requires(FItems.MILK_BOTTLE)
						.requires(Items.EGG)
						.requires(FItems.JAM)
						.unlockedBy(getHasName(Items.EGG), has(Items.EGG))
						.save(output);
				// 1x swedish pancake
				shapeless(RecipeCategory.FOOD, FItems.SWEDISH_PANCAKE)
						.requires(FItems.PANCAKE)
						.requires(FItems.JAM)
						.unlockedBy(getHasName(Items.EGG), has(Items.EGG))
						.save(output, "swedish_pancake_from_pancake");
				// 1x toast
				foodSmelting(FItems.TOAST, Items.BREAD);
				// 1x marmalade toast
				shapeless(RecipeCategory.FOOD, FItems.MARMALADE_TOAST)
						.requires(FItems.TOAST)
						.requires(FItems.MARMALADE)
						.unlockedBy(getHasName(FItems.ORANGE), has(FItems.ORANGE))
						.save(output);
				// 1x jam toast
				shapeless(RecipeCategory.FOOD, FItems.JAM_TOAST)
						.requires(FItems.TOAST)
						.requires(FItems.JAM)
						.unlockedBy("has_berry", has(ConventionalItemTags.BERRY_FOODS))
						.save(output);
				// 1x ham sandwich
				shaped(RecipeCategory.FOOD, FItems.HAM_SANDWICH)
						.pattern("T")
						.pattern("H")
						.pattern("T")
						.define('T', FItems.TOAST)
						.define('H', FItems.SMOKED_HAM)
						.unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
						.save(output);

				// 1x smoked ham
				SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.COOKED_PORKCHOP), RecipeCategory.FOOD, FItems.SMOKED_HAM, 0.35F, 200)
						.unlockedBy(getHasName(Items.PORKCHOP), has(Items.PORKCHOP))
						.save(output);

				// ----------------------
				// BLUE SPRUCE
				// ----------------------

				woodFromLogs(FBlocks.BLUE_SPRUCE_WOOD, FBlocks.BLUE_SPRUCE_LOG);
				woodFromLogs(FBlocks.STRIPPED_BLUE_SPRUCE_WOOD, FBlocks.STRIPPED_BLUE_SPRUCE_LOG);
				woodenBoat(FItems.BLUE_SPRUCE_BOAT, FBlocks.BLUE_SPRUCE_PLANKS);
				chestBoat(FItems.BLUE_SPRUCE_CHEST_BOAT, FItems.BLUE_SPRUCE_BOAT);
				buttonBuilder(FBlocks.BLUE_SPRUCE_BUTTON, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				doorBuilder(FBlocks.BLUE_SPRUCE_DOOR, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				fenceBuilder(FBlocks.BLUE_SPRUCE_FENCE, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				fenceGateBuilder(FBlocks.BLUE_SPRUCE_FENCE_GATE, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				signBuilder(FBlocks.BLUE_SPRUCE_SIGN, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				hangingSignBuilder(FBlocks.BLUE_SPRUCE_HANGING_SIGN, Ingredient.of(FBlocks.STRIPPED_BLUE_SPRUCE_LOG))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.STRIPPED_BLUE_SPRUCE_LOG))
						.save(output);
				shelf(FBlocks.BLUE_SPRUCE_SHELF, FBlocks.STRIPPED_BLUE_SPRUCE_LOG);
				planksFromLog(FBlocks.BLUE_SPRUCE_PLANKS, FItemTags.BLUE_SPRUCE_LOGS, 4);
				pressurePlate(FBlocks.BLUE_SPRUCE_PRESSURE_PLATE, FBlocks.BLUE_SPRUCE_PLANKS);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.BLUE_SPRUCE_SLAB, FBlocks.BLUE_SPRUCE_PLANKS);
				stairBuilder(FBlocks.BLUE_SPRUCE_STAIRS, Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);
				trapdoorBuilder(FBlocks.BLUE_SPRUCE_TRAPDOOR,  Ingredient.of(FBlocks.BLUE_SPRUCE_PLANKS))
						.unlockedBy(getHasName(FBlocks.BLUE_SPRUCE_PLANKS), has(FBlocks.BLUE_SPRUCE_PLANKS))
						.save(output);

				// ----------------------
				// JACARANDA
				// ----------------------

				woodFromLogs(FBlocks.JACARANDA_WOOD, FBlocks.JACARANDA_LOG);
				woodFromLogs(FBlocks.STRIPPED_JACARANDA_WOOD, FBlocks.STRIPPED_JACARANDA_LOG);
				woodenBoat(FItems.JACARANDA_BOAT, FBlocks.JACARANDA_PLANKS);
				chestBoat(FItems.JACARANDA_CHEST_BOAT, FItems.JACARANDA_BOAT);
				buttonBuilder(FBlocks.JACARANDA_BUTTON, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				doorBuilder(FBlocks.JACARANDA_DOOR, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				fenceBuilder(FBlocks.JACARANDA_FENCE, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				fenceGateBuilder(FBlocks.JACARANDA_FENCE_GATE, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				signBuilder(FBlocks.JACARANDA_SIGN, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				hangingSignBuilder(FBlocks.JACARANDA_HANGING_SIGN, Ingredient.of(FBlocks.STRIPPED_JACARANDA_LOG))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.STRIPPED_JACARANDA_LOG))
						.save(output);
				shelf(FBlocks.JACARANDA_SHELF, FBlocks.STRIPPED_JACARANDA_LOG);
				planksFromLog(FBlocks.JACARANDA_PLANKS, FItemTags.JACARANDA_LOGS, 4);
				pressurePlate(FBlocks.JACARANDA_PRESSURE_PLATE, FBlocks.JACARANDA_PLANKS);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.JACARANDA_SLAB, FBlocks.JACARANDA_PLANKS);
				stairBuilder(FBlocks.JACARANDA_STAIRS, Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);
				trapdoorBuilder(FBlocks.JACARANDA_TRAPDOOR,  Ingredient.of(FBlocks.JACARANDA_PLANKS))
						.unlockedBy(getHasName(FBlocks.JACARANDA_PLANKS), has(FBlocks.JACARANDA_PLANKS))
						.save(output);

				// ----------------------
				// PEAR
				// ----------------------

				woodFromLogs(FBlocks.PEAR_WOOD, FBlocks.PEAR_LOG);
				woodFromLogs(FBlocks.STRIPPED_PEAR_WOOD, FBlocks.STRIPPED_PEAR_LOG);
				woodenBoat(FItems.PEAR_BOAT, FBlocks.PEAR_PLANKS);
				chestBoat(FItems.PEAR_CHEST_BOAT, FItems.PEAR_BOAT);
				buttonBuilder(FBlocks.PEAR_BUTTON, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				doorBuilder(FBlocks.PEAR_DOOR, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				fenceBuilder(FBlocks.PEAR_FENCE, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				fenceGateBuilder(FBlocks.PEAR_FENCE_GATE, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				signBuilder(FBlocks.PEAR_SIGN, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				hangingSignBuilder(FBlocks.PEAR_HANGING_SIGN, Ingredient.of(FBlocks.STRIPPED_PEAR_LOG))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.STRIPPED_PEAR_LOG))
						.save(output);
				shelf(FBlocks.PEAR_SHELF, FBlocks.STRIPPED_PEAR_LOG);
				planksFromLog(FBlocks.PEAR_PLANKS, FItemTags.PEAR_LOGS, 4);
				pressurePlate(FBlocks.PEAR_PRESSURE_PLATE, FBlocks.PEAR_PLANKS);
				slab(RecipeCategory.BUILDING_BLOCKS, FBlocks.PEAR_SLAB, FBlocks.PEAR_PLANKS);
				stairBuilder(FBlocks.PEAR_STAIRS, Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);
				trapdoorBuilder(FBlocks.PEAR_TRAPDOOR,  Ingredient.of(FBlocks.PEAR_PLANKS))
						.unlockedBy(getHasName(FBlocks.PEAR_PLANKS), has(FBlocks.PEAR_PLANKS))
						.save(output);

				// ----------------------
				// TRANSIUM
				// ----------------------

				// 9x transium -> 1x block
				shapeless(RecipeCategory.MISC, FBlocks.TRANSIUM_BLOCK)
						.requires(FItems.TRANSIUM, 9)
						.unlockedBy(getHasName(
								FItems.TRANSIUM), has(FItems.TRANSIUM)
						)
						.save(output);
				// 1x block -> 9x transium
				shapeless(RecipeCategory.MISC, FItems.TRANSIUM, 9)
						.requires(FBlocks.TRANSIUM_BLOCK)
						.unlockedBy(getHasName(
								FBlocks.TRANSIUM_BLOCK), has(FBlocks.TRANSIUM_BLOCK)
						)
						.save(output, "transium_from_block");

				// 1x pink dye + 1x light blue dye + 1x white dye  -> 3x transium dye
				shapeless(RecipeCategory.MISC, FItems.TRANSIUM_DYE, 3)
						.requires(Items.DYE.lightBlue())
						.requires(Items.DYE.pink())
						.requires(Items.DYE.white())
						.unlockedBy("has_light_blue_dye", has(Items.DYE.lightBlue()))
						.unlockedBy("has_pink_dye", has(Items.DYE.pink()))
						.unlockedBy("has_white_dye", has(Items.DYE.white()))
						.save(output);
				// 4x transium dye + 1x diamond -> 1x transium
				shaped(RecipeCategory.MISC, FItems.TRANSIUM)
						.pattern(" T ")
						.pattern("TDT")
						.pattern(" T ")
						.define('T', FItems.TRANSIUM_DYE)
						.define('D', Items.DIAMOND)
						.unlockedBy(getHasName(
								FItems.TRANSIUM_DYE), has(FItems.TRANSIUM_DYE)
						)
						.save(output);

				// tools & armor
				tools(
						FItems.TRANSIUM,
						FItems.TRANSIUM_PICKAXE,
						FItems.TRANSIUM_SHOVEL,
						FItems.TRANSIUM_AXE,
						FItems.TRANSIUM_HOE,
						FItems.TRANSIUM_SWORD,
						FItems.TRANSIUM_SPEAR
				);
				armor(
						FItems.TRANSIUM,
						FItems.TRANSIUM_HELMET,
						FItems.TRANSIUM_CHESTPLATE,
						FItems.TRANSIUM_LEGGINGS,
						FItems.TRANSIUM_BOOTS
				);

				// ----------------------
				// ROSE QUARTZ
				// ----------------------

				// 9x rose quartz -> 1x block
				shapeless(RecipeCategory.MISC, FBlocks.ROSE_QUARTZ_BLOCK)
						.requires(FItems.ROSE_QUARTZ, 9)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ), has(FItems.ROSE_QUARTZ)
						)
						.save(output);
				// 1x block -> 9x rose quartz
				shapeless(RecipeCategory.MISC, FItems.ROSE_QUARTZ, 9)
						.requires(FBlocks.ROSE_QUARTZ_BLOCK)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BLOCK), has(FBlocks.ROSE_QUARTZ_BLOCK)
						)
						.save(output, "rose_quartz_from_block");

				// 1x fragment + 8x end stone -> 8x bricks
				shapeless(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_BRICKS, 8)
						.requires(FItems.ROSE_QUARTZ_FRAGMENT)
						.requires(Items.END_STONE, 8)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 6x bricks -> 4 stairs
				stairBuilder(
						FBlocks.ROSE_QUARTZ_BRICK_STAIRS,
						Ingredient.of(FBlocks.ROSE_QUARTZ_BRICKS)
				)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BRICKS), has(FBlocks.ROSE_QUARTZ_BRICKS)
						)
						.save(output);
				// 3x bricks -> 6x slabs
				slabBuilder(
						RecipeCategory.BUILDING_BLOCKS,
						FBlocks.ROSE_QUARTZ_BRICK_SLAB,
						Ingredient.of(FBlocks.ROSE_QUARTZ_BRICKS)
				)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BRICKS), has(FBlocks.ROSE_QUARTZ_BRICKS)
						)
						.save(output);
				// 6x bricks -> 6x walls
				wallBuilder(
						RecipeCategory.BUILDING_BLOCKS,
						FBlocks.ROSE_QUARTZ_BRICK_WALL,
						Ingredient.of(FBlocks.ROSE_QUARTZ_BRICKS)
				)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BRICKS), has(FBlocks.ROSE_QUARTZ_BRICKS)
						)
						.save(output);
				// 2x slabs (v) -> 1x chiseled
				chiseledBuilder(
						RecipeCategory.BUILDING_BLOCKS,
						FBlocks.CHISELED_ROSE_QUARTZ_BRICKS,
						Ingredient.of(FBlocks.ROSE_QUARTZ_BRICK_SLAB)
				)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BRICKS), has(FBlocks.ROSE_QUARTZ_BRICKS)
						)
						.save(output);
				// 2x slabs (h) ->
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_BRICKS)
						.pattern("##")
						.define('#', FBlocks.ROSE_QUARTZ_BRICK_SLAB)
						.unlockedBy(getHasName(
								FBlocks.ROSE_QUARTZ_BRICK_SLAB), has(FBlocks.ROSE_QUARTZ_BRICK_SLAB)
						)
						.save(output, "rose_quartz_bricks_from_slabs");

				// 6x fragments -> 3x doors
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_DOOR, 3)
						.pattern("##")
						.pattern("##")
						.pattern("##")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 4x fragments -> 2x trapdoors
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_TRAPDOOR, 2)
						.pattern("##")
						.pattern("##")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 7x fragments -> 16x ladders
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_LADDER, 16)
						.pattern("# #")
						.pattern("###")
						.pattern("# #")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 6x fragments -> 16x bars
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_BARS, 16)
						.pattern("###")
						.pattern("###")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 3x fragments -> 8x chains
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_CHAIN, 6)
						.pattern("#")
						.pattern("#")
						.pattern("#")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 8x fragment + 1 torch -> 8x lanterns
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_LANTERN, 8)
						.pattern("###")
						.pattern("#T#")
						.pattern("###")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.define('T', Items.TORCH)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 2x fragment -> 4x pressure plates
				shaped(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_PRESSURE_PLATE, 4)
						.pattern("##")
						.define('#', FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);
				// 1x fragment -> 4x button
				shapeless(RecipeCategory.BUILDING_BLOCKS, FBlocks.ROSE_QUARTZ_BUTTON, 4)
						.requires(FItems.ROSE_QUARTZ_FRAGMENT)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output);

				// 4x shard + 1x shulker shell -> 1x rose quartz
				shaped(RecipeCategory.MISC, FItems.ROSE_QUARTZ)
						.pattern(" R ")
						.pattern("RSR")
						.pattern(" R ")
						.define('R', FItems.ROSE_QUARTZ_SHARD)
						.define('S', Items.SHULKER_SHELL)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_SHARD), has(FItems.ROSE_QUARTZ_SHARD)
						)
						.save(output);
				// 1x rose quartz -> 4x shard
				shapeless(RecipeCategory.MISC, FItems.ROSE_QUARTZ_SHARD, 4)
						.requires(FItems.ROSE_QUARTZ)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ), has(FItems.ROSE_QUARTZ)
						)
						.save(output);

				// 1x shard -> 8x fragments
				shapeless(RecipeCategory.MISC, FItems.ROSE_QUARTZ_FRAGMENT, 8)
						.requires(FItems.ROSE_QUARTZ_SHARD)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_SHARD), has(FItems.ROSE_QUARTZ_SHARD)
						)
						.save(output);
				// 8x fragments -> 1x shard
				shapeless(RecipeCategory.MISC, FItems.ROSE_QUARTZ_SHARD)
						.requires(FItems.ROSE_QUARTZ_FRAGMENT, 8)
						.unlockedBy(getHasName(
								FItems.ROSE_QUARTZ_FRAGMENT), has(FItems.ROSE_QUARTZ_FRAGMENT)
						)
						.save(output, "rose_quartz_shard_from_rose_quartz_fragments");

				// duplicate template
				copySmithingTemplate(
						FItems.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE,
						Items.END_STONE
				);

				// 1x ore -> 1x shard, smelting
				oreSmelting(
						List.of(FBlocks.ROSE_QUARTZ_ORE),
						RecipeCategory.MISC,
						CookingBookCategory.MISC,
						FItems.ROSE_QUARTZ_SHARD,
						0.7f,
						200,
						"rose_quartz_shard"
				);
				// 1x ore -> 1x shard, blasting
				oreBlasting(
						List.of(FBlocks.ROSE_QUARTZ_ORE),
						RecipeCategory.MISC,
						CookingBookCategory.MISC,
						FItems.ROSE_QUARTZ_SHARD,
						0.7f,
						200,
						"rose_quartz_shard"
				);

				// upgrade tools
				roseQuartzSmithing(
						Items.NETHERITE_PICKAXE,
						RecipeCategory.TOOLS,
						FItems.ROSE_QUARTZ_PICKAXE
				);
				roseQuartzSmithing(
						Items.NETHERITE_SHOVEL,
						RecipeCategory.TOOLS,
						FItems.ROSE_QUARTZ_SHOVEL
				);
				roseQuartzSmithing(
						Items.NETHERITE_AXE,
						RecipeCategory.TOOLS,
						FItems.ROSE_QUARTZ_AXE
				);
				roseQuartzSmithing(
						Items.NETHERITE_HOE,
						RecipeCategory.TOOLS,
						FItems.ROSE_QUARTZ_HOE
				);
				roseQuartzSmithing(
						Items.NETHERITE_SWORD,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_SWORD
				);
				roseQuartzSmithing(
						Items.NETHERITE_SPEAR,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_SPEAR
				);
				// upgrade shield
				roseQuartzSmithing(
						Items.SHIELD,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_SHIELD
				);
				// shield banner
				SpecialRecipeBuilder.special(
								() -> new ShieldDecorationRecipe(
										this.tag(ItemTags.BANNERS),
										Ingredient.of(FItems.ROSE_QUARTZ_SHIELD),
										new ItemStackTemplate(FItems.ROSE_QUARTZ_SHIELD))
						)
						.save(this.output, "shield_decoration");

				// upgrade armor
				roseQuartzSmithing(
						Items.NETHERITE_HELMET,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_HELMET
				);
				roseQuartzSmithing(
						Items.NETHERITE_CHESTPLATE,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_CHESTPLATE
				);
				roseQuartzSmithing(
						Items.NETHERITE_LEGGINGS,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_LEGGINGS
				);
				roseQuartzSmithing(
						Items.NETHERITE_BOOTS,
						RecipeCategory.COMBAT,
						FItems.ROSE_QUARTZ_BOOTS
				);

				// ----------------------
				// GOLEM HEADS
				// ----------------------

				golemHead(FBlocks.GOLEM_HEAD_COAL, Items.COAL);
				golemHead(FBlocks.GOLEM_HEAD_IRON, Items.IRON_INGOT);
				golemHead(FBlocks.GOLEM_HEAD_REDSTONE, Items.REDSTONE);
				golemHead(FBlocks.GOLEM_HEAD_GOLD, Items.GOLD_INGOT);
				golemHead(FBlocks.GOLEM_HEAD_LAPIS, Items.LAPIS_LAZULI);
				golemHead(FBlocks.GOLEM_HEAD_AMETHYST, Items.AMETHYST_SHARD);
				golemHead(FBlocks.GOLEM_HEAD_DIAMOND, Items.DIAMOND);
				golemHead(FBlocks.GOLEM_HEAD_EMERALD, Items.EMERALD);
				golemHead(FBlocks.GOLEM_HEAD_NETHERITE, Items.NETHERITE_INGOT);
			}

			public void tools(
					final Item base,
					final Item pickaxe,
					final Item shovel,
					final Item axe,
					final Item hoe,
					final Item sword,
					final Item spear
			) {
				shaped(RecipeCategory.TOOLS, pickaxe)
						.pattern("###")
						.pattern(" S ")
						.pattern(" S ")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.TOOLS, shovel)
						.pattern("#")
						.pattern("S")
						.pattern("S")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.TOOLS, axe)
						.pattern("##")
						.pattern("#S")
						.pattern(" S")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.TOOLS, hoe)
						.pattern("##")
						.pattern(" S")
						.pattern(" S")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.TOOLS, sword)
						.pattern("#")
						.pattern("#")
						.pattern("S")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.TOOLS, spear)
						.pattern("  #")
						.pattern(" S ")
						.pattern("S  ")
						.define('#', base)
						.define('S', Items.STICK)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
			}

			public void armor(
					final Item base,
					final Item helmet,
					final Item chestplate,
					final Item leggings,
					final Item boots
			) {
				shaped(RecipeCategory.COMBAT, helmet)
						.pattern("###")
						.pattern("# #")
						.define('#', base)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.COMBAT, chestplate)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.define('#', base)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.COMBAT, leggings)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.define('#', base)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
				shaped(RecipeCategory.COMBAT, boots)
						.pattern("# #")
						.pattern("# #")
						.define('#', base)
						.unlockedBy(getHasName(
								base), has(base)
						)
						.save(output);
			}

			public void roseQuartzSmithing(
					final Item base, final RecipeCategory category, final Item result) {
				SmithingTransformRecipeBuilder.smithing(
								Ingredient.of(FItems.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.of(base),
								Ingredient.of(FItems.ROSE_QUARTZ),
								category,
								result
						)
						.unlocks("has_rose_quartz", this.has(FItems.ROSE_QUARTZ))
						.save(this.output, getItemName(result) + "_smithing");
			}

			private void golemHead(ItemLike head, ItemLike material) {
				shaped(RecipeCategory.DECORATIONS, head)
						.pattern("MMM")
						.pattern("MPM")
						.pattern("MMM")
						.define('M', material)
						.define('P', Items.CARVED_PUMPKIN)
						.unlockedBy(getHasName(material), has(material))
						.save(output);
			}

			// MOLLY
			private void flowerDye(ItemLike flower, ItemLike dye) {
				shapeless(RecipeCategory.MISC, dye)
						.requires(flower)
						.unlockedBy(getHasName(flower), has(flower))
						.save(output, getItemName(dye) + "_from_" + getItemName(flower));
			}
			private void combineTwoDecorations(
					ItemLike result, ItemLike item, ItemLike item2) {
				shapeless(RecipeCategory.DECORATIONS, result)
						.requires(item)
						.requires(item2)
						.unlockedBy(getHasName(item), has(item))
						.save(output);
			}
			private void combineTwoFood(
					ItemLike result, ItemLike item, ItemLike item2) {
				shapeless(RecipeCategory.FOOD, result)
						.requires(item)
						.requires(item2)
						.unlockedBy(getHasName(item), has(item))
						.unlockedBy(getHasName(item2), has(item2))
						.save(output);
			}
			private void combineTwoFood(
					ItemLike result, ItemLike item, ItemLike item2, ItemLike unlockedBy) {
				shapeless(RecipeCategory.FOOD, result)
						.requires(item)
						.requires(item2)
						.unlockedBy(getHasName(unlockedBy), has(unlockedBy))
						.save(output);
			}
			private void combineTwoFood(
					ItemLike result, ItemLike item, ItemLike item2, String outputName) {
				shapeless(RecipeCategory.FOOD, result)
						.requires(item)
						.requires(item2)
						.unlockedBy(getHasName(item), has(item))
						.unlockedBy(getHasName(item2), has(item2))
						.save(output, outputName);
			}
			private void foodSmelting(
					ItemLike result, ItemLike input
			) {
				SimpleCookingRecipeBuilder.smelting(
								Ingredient.of(input),
								RecipeCategory.FOOD,
								CookingBookCategory.FOOD,
								result,
								0.35F,
								200
						)
						.unlockedBy(getHasName(input), has(input))
						.save(output);
				SimpleCookingRecipeBuilder.smoking(
								Ingredient.of(input),
								RecipeCategory.FOOD,
								result,
								0.35F,
								200
						)
						.unlockedBy(getHasName(input), has(input))
						.save(output, getItemName(input) + "_from_smoking");
				SimpleCookingRecipeBuilder.campfireCooking(
								Ingredient.of(input),
								RecipeCategory.FOOD,
								result,
								0.35F,
								600
						)
						.unlockedBy(getHasName(input), has(input))
						.save(output, getItemName(input) + "_from_campfire_cooking");
			}
		};
	}

	@Override
	public String getName() {
		return "FRecipeProvider";
	}
}