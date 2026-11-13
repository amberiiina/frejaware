package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import se.frejaware.Blocks.FBlocks;
import se.frejaware.F;
import se.frejaware.Items.FItems;
import se.frejaware.client.Model.FRoseQuartzShieldSpecialRenderer;

import java.util.Map;
import java.util.Optional;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class FModelProvider extends FabricModelProvider {
	public FModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockGen) {
		try {
			// MOLLY
			blockGen.createCropBlock(
					FBlocks.PINEAPPLE, BlockStateProperties.AGE_7, 0, 0, 0, 0, 1, 1, 1, 2
			);

			blockGen.registerSimpleFlatItemModel(FBlocks.IRON_BELL);

			// BLOM
			blockGen.createPlantWithDefaultItem(
					FBlocks.WHITE_ORCHID,
					FBlocks.POTTED_WHITE_ORCHID,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.YELLOW_TULIP,
					FBlocks.POTTED_YELLOW_TULIP,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.WHITE_HIBISCUS,
					FBlocks.POTTED_WHITE_HIBISCUS,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.YELLOW_HIBISCUS,
					FBlocks.POTTED_YELLOW_HIBISCUS,
					BlockModelGenerators.PlantType.NOT_TINTED
			);

			blockGen.createPlantWithDefaultItem(
					FBlocks.WHITE_CROCUS,
					FBlocks.POTTED_WHITE_CROCUS,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.LILAC_CROCUS,
					FBlocks.POTTED_LILAC_CROCUS,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.PURPLE_CROCUS,
					FBlocks.POTTED_PURPLE_CROCUS,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.LILY_OF_THE_GLADE,
					FBlocks.POTTED_LILY_OF_THE_GLADE,
					BlockModelGenerators.PlantType.NOT_TINTED
			);

			blockGen.createCrossBlockWithDefaultItem(
					FBlocks.WHITE_CACTUS_FLOWER,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createCrossBlockWithDefaultItem(
					FBlocks.YELLOW_CACTUS_FLOWER,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.WHITE_ALLIUM,
					FBlocks.POTTED_WHITE_ALLIUM,
					BlockModelGenerators.PlantType.NOT_TINTED
			);

			blockGen.createFlowerBed(FBlocks.LIGHT_BLUE_PETALS);
			blockGen.createFlowerBed(FBlocks.WHITE_PETALS);
			blockGen.createFlowerBed(FBlocks.PURPLE_PETALS);

			blockGen.createPlantWithDefaultItem(
					FBlocks.ROUND_BUSH,
					FBlocks.POTTED_ROUND_BUSH,
					BlockModelGenerators.PlantType.NOT_TINTED
			);

			// FOOD
			blockGen.registerSimpleFlatItemModel(FItems.BLUEBERRIES);
			blockGen.blockStateOutput.accept(
					MultiVariantGenerator.dispatch(FBlocks.BLUEBERRY_BUSH)
							.with(PropertyDispatch.initial(BlockStateProperties.AGE_3)
									.generate((age) -> BlockModelGenerators.plainVariant(
											blockGen.createSuffixedVariant(
													FBlocks.BLUEBERRY_BUSH,
													"_stage" + age,
													ModelTemplates.CROSS,
													TextureMapping::cross
											)
									))
							)
			);
			blockGen.registerSimpleFlatItemModel(FItems.BLACKBERRIES);
			blockGen.blockStateOutput.accept(
					MultiVariantGenerator.dispatch(FBlocks.BLACKBERRY_BUSH)
							.with(PropertyDispatch.initial(BlockStateProperties.AGE_3)
									.generate((age) -> BlockModelGenerators.plainVariant(
											blockGen.createSuffixedVariant(
													FBlocks.BLACKBERRY_BUSH,
													"_stage" + age,
													ModelTemplates.CROSS,
													TextureMapping::cross
											)
									))
							)
			);
			blockGen.registerSimpleFlatItemModel(FItems.PINKBERRIES);
			blockGen.blockStateOutput.accept(
					MultiVariantGenerator.dispatch(FBlocks.PINKBERRY_BUSH)
							.with(PropertyDispatch.initial(BlockStateProperties.AGE_3)
									.generate((age) -> BlockModelGenerators.plainVariant(
											blockGen.createSuffixedVariant(
													FBlocks.PINKBERRY_BUSH,
													"_stage" + age,
													ModelTemplates.CROSS,
													TextureMapping::cross
											)
									))
							)
			);
			blockGen.registerSimpleFlatItemModel(FItems.BLOWBERRIES);
			blockGen.blockStateOutput.accept(
					MultiVariantGenerator.dispatch(FBlocks.BLOWBERRY_BUSH)
							.with(PropertyDispatch.initial(BlockStateProperties.AGE_3)
									.generate((age) -> BlockModelGenerators.plainVariant(
											blockGen.createSuffixedVariant(
													FBlocks.BLOWBERRY_BUSH,
													"_stage" + age,
													ModelTemplates.CROSS,
													TextureMapping::cross
											)
									))
							)
			);

			// ORANGE
			blockGen.createTrivialBlock(
					FBlocks.ORANGE_LEAVES, TexturedModel.LEAVES
			);
			createOrangeSapling(blockGen, FBlocks.ORANGE_SAPLING);
			createPottedOrangeSapling(blockGen, FBlocks.POTTED_ORANGE_SAPLING);

			// JACARANDA
			blockGen.woodProvider(FBlocks.JACARANDA_LOG).logUVLocked(FBlocks.JACARANDA_LOG).wood(FBlocks.JACARANDA_WOOD);
			blockGen.woodProvider(FBlocks.STRIPPED_JACARANDA_LOG).logUVLocked(FBlocks.STRIPPED_JACARANDA_LOG).wood(FBlocks.STRIPPED_JACARANDA_WOOD);
			blockGen.createTrivialBlock(
					FBlocks.JACARANDA_LEAVES, TexturedModel.LEAVES
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.JACARANDA_SAPLING,
					FBlocks.POTTED_JACARANDA_SAPLING,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.family(FBlocks.JACARANDA_PLANKS)
					.stairs(FBlocks.JACARANDA_STAIRS)
					.slab(FBlocks.JACARANDA_SLAB)
					.fence(FBlocks.JACARANDA_FENCE)
					.fenceGate(FBlocks.JACARANDA_FENCE_GATE)
					.button(FBlocks.JACARANDA_BUTTON)
					.pressurePlate(FBlocks.JACARANDA_PRESSURE_PLATE);
			blockGen.createDoor(FBlocks.JACARANDA_DOOR);
			blockGen.createOrientableTrapdoor(FBlocks.JACARANDA_TRAPDOOR);
			blockGen.createShelf(FBlocks.JACARANDA_SHELF, FBlocks.STRIPPED_JACARANDA_LOG);
			sign(
					blockGen,
					FBlocks.JACARANDA_SIGN,
					FBlocks.JACARANDA_WALL_SIGN,
					FBlocks.JACARANDA_PLANKS
			);
			hangingSign(
					blockGen,
					FBlocks.JACARANDA_HANGING_SIGN,
					FBlocks.JACARANDA_WALL_HANGING_SIGN,
					FBlocks.STRIPPED_JACARANDA_LOG
			);

			// PEAR
			blockGen.woodProvider(FBlocks.PEAR_LOG).logUVLocked(FBlocks.PEAR_LOG).wood(FBlocks.PEAR_WOOD);
			blockGen.woodProvider(FBlocks.STRIPPED_PEAR_LOG).logUVLocked(FBlocks.STRIPPED_PEAR_LOG).wood(FBlocks.STRIPPED_PEAR_WOOD);
			blockGen.createTrivialBlock(
					FBlocks.PEAR_LEAVES, TexturedModel.LEAVES
			);
			blockGen.createPlantWithDefaultItem(
					FBlocks.PEAR_SAPLING,
					FBlocks.POTTED_PEAR_SAPLING,
					BlockModelGenerators.PlantType.NOT_TINTED
			);
			blockGen.family(FBlocks.PEAR_PLANKS)
					.stairs(FBlocks.PEAR_STAIRS)
					.slab(FBlocks.PEAR_SLAB)
					.fence(FBlocks.PEAR_FENCE)
					.fenceGate(FBlocks.PEAR_FENCE_GATE)
					.button(FBlocks.PEAR_BUTTON)
					.pressurePlate(FBlocks.PEAR_PRESSURE_PLATE);
			blockGen.createDoor(FBlocks.PEAR_DOOR);
			blockGen.createOrientableTrapdoor(FBlocks.PEAR_TRAPDOOR);
			blockGen.createShelf(FBlocks.PEAR_SHELF, FBlocks.STRIPPED_PEAR_LOG);
			sign(
					blockGen,
					FBlocks.PEAR_SIGN,
					FBlocks.PEAR_WALL_SIGN,
					FBlocks.PEAR_PLANKS
			);
			hangingSign(
					blockGen,
					FBlocks.PEAR_HANGING_SIGN,
					FBlocks.PEAR_WALL_HANGING_SIGN,
					FBlocks.STRIPPED_PEAR_LOG
			);

			// TRANSIUM
			blockGen.createTrivialCube(FBlocks.TRANSIUM_BLOCK);

			// ROSE QUARTZ
			blockGen.createTrivialCube(FBlocks.ROSE_QUARTZ_ORE);
			blockGen.createTrivialCube(FBlocks.ROSE_QUARTZ_BLOCK);

			blockGen.family(FBlocks.ROSE_QUARTZ_BRICKS)
					.stairs(FBlocks.ROSE_QUARTZ_BRICK_STAIRS)
					.slab(FBlocks.ROSE_QUARTZ_BRICK_SLAB)
					.wall(FBlocks.ROSE_QUARTZ_BRICK_WALL)
					.pressurePlate(FBlocks.ROSE_QUARTZ_PRESSURE_PLATE)
					.button(FBlocks.ROSE_QUARTZ_BUTTON);
			blockGen.createTrivialCube(FBlocks.CHISELED_ROSE_QUARTZ_BRICKS);
			blockGen.createDoor(FBlocks.ROSE_QUARTZ_DOOR);
			blockGen.createOrientableTrapdoor(FBlocks.ROSE_QUARTZ_TRAPDOOR);
			blockGen.createBarsAndItem(FBlocks.ROSE_QUARTZ_BARS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemGen) {
		try {
			// MOLLY
			itemGen.generateFlatItem(FItems.MOOBLOOM_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.MUSIC_DISC_RYM, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.BUTTERFLY_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FBlocks.PEACH_SEASHELL.asItem(), ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FBlocks.PEARL_SEASHELL.asItem(), ModelTemplates.FLAT_ITEM);

			// FOOD
			itemGen.generateFlatItem(FItems.BERRY_JUICE_BOTTLE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.JAM, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.JAM_BLEND, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(FItems.PEAR, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.GOLDEN_PEAR, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.ENCHANTED_GOLDEN_PEAR, FItems.GOLDEN_PEAR, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHERRY, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.BANANA, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.ORANGE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.SAFFRON, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.SAFFRON_MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.POPPY_SEEDS, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.PINEAPPLE, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(FItems.MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.MILKSHAKE_BOTTLE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.ICE_CREAM, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(FItems.COCOA_BUTTER, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHOCOLATE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHOCOLATE_BAR, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHOCOLATE_DIPPED_PEAR, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHOCOLATE_BOTTLE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.CHOCOLATE_ICE_CREAM, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(FItems.FRUIT_SALAD, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.PANCAKE, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.SWEDISH_PANCAKE, ModelTemplates.FLAT_ITEM);

			// JACARANDA
			itemGen.generateFlatItem(FItems.JACARANDA_BOAT, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.JACARANDA_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

			// PEAR
			itemGen.generateFlatItem(FItems.PEAR_BOAT, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(FItems.PEAR_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

			// TRANSIUM
			itemGen.generateFlatItem(
					FItems.TRANSIUM, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_DYE, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(
					FItems.TRANSIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.TRANSIUM_SPEAR, ModelTemplates.FLAT_HANDHELD_ITEM);

			itemGen.generateTrimmableArmorSet(
					FItems.TRANSIUM_HELMET,
					FItems.TRANSIUM_CHESTPLATE,
					FItems.TRANSIUM_LEGGINGS,
					FItems.TRANSIUM_BOOTS,
					false,
					Map.of()
			);

			// ROSE QUARTZ
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_SHARD, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_FRAGMENT, ModelTemplates.FLAT_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.ROSE_QUARTZ_SPEAR, ModelTemplates.FLAT_HANDHELD_ITEM);

			Identifier vanillaShieldModelLocation =
					ModelLocationUtils.getModelLocation(Items.SHIELD);
			Identifier modelLocation =
					ModelLocationUtils.getModelLocation(FItems.ROSE_QUARTZ_SHIELD);
			ModelTemplate shieldTemplate =
					new ModelTemplate(
							Optional.of(vanillaShieldModelLocation),
							Optional.empty(),
							TextureSlot.PARTICLE);
			shieldTemplate.create(modelLocation, TextureMapping.singleSlot(
					TextureSlot.PARTICLE,
					new Material(ModelLocationUtils.getModelLocation(
							Blocks.CHERRY_PLANKS))), itemGen.modelOutput
			);
			ModelTemplate blockingShieldTemplate =
					new ModelTemplate(Optional.of(
							vanillaShieldModelLocation.withSuffix("_blocking")),
							Optional.empty(), TextureSlot.PARTICLE);
			blockingShieldTemplate.create(
					modelLocation.withSuffix("_blocking"),
					TextureMapping.singleSlot(
							TextureSlot.PARTICLE,
							new Material(ModelLocationUtils.getModelLocation(
									Blocks.CHERRY_PLANKS))), itemGen.modelOutput
			);
			FRoseQuartzShieldSpecialRenderer.Unbaked specialRenderer =
					new FRoseQuartzShieldSpecialRenderer.Unbaked(
							F.id("rose_quartz_shield_base"),
							F.id("rose_quartz_shield_base_nopattern")
					);
			itemGen.itemModelOutput.accept(
					FItems.ROSE_QUARTZ_SHIELD,
					ItemModelUtils.conditional(
							FRoseQuartzShieldSpecialRenderer.DEFAULT_TRANSFORMATION,
							ItemModelUtils.isUsingItem(),
							ItemModelUtils.specialModel(
									modelLocation.withSuffix("_blocking"), specialRenderer
							),
							ItemModelUtils.specialModel(modelLocation, specialRenderer)
					)
			);

			itemGen.generateTrimmableArmorSet(
					FItems.ROSE_QUARTZ_HELMET,
					FItems.ROSE_QUARTZ_CHESTPLATE,
					FItems.ROSE_QUARTZ_LEGGINGS,
					FItems.ROSE_QUARTZ_BOOTS,
					false,
					Map.of()
			);

			// GOLEM HEADS
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_AMETHYST, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_COAL, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_DIAMOND, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_EMERALD, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_GOLD, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_LAPIS, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_NETHERITE, ModelTemplates.FLAT_HANDHELD_ITEM);
			itemGen.generateFlatItem(
					FItems.GOLEM_SPAWN_EGG_REDSTONE, ModelTemplates.FLAT_HANDHELD_ITEM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sign(BlockModelGenerators gen, Block sign, Block wallSign, Block particle) {
		TextureMapping mapping = new TextureMapping()
				.put(TextureSlot.ALL, TextureMapping.getBlockTexture(sign))
				.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(particle));

		MultiVariant rot0 = BlockModelGenerators.plainVariant(ModelTemplates.SIGN_ROT_0.create(ModelLocationUtils.getModelLocation(sign, "_rot_0"), mapping, gen.modelOutput));
		MultiVariant rot1 = BlockModelGenerators.plainVariant(ModelTemplates.SIGN_ROT_1.create(ModelLocationUtils.getModelLocation(sign, "_rot_1"), mapping, gen.modelOutput));
		MultiVariant rot2 = BlockModelGenerators.plainVariant(ModelTemplates.SIGN_ROT_2.create(ModelLocationUtils.getModelLocation(sign, "_rot_2"), mapping, gen.modelOutput));
		MultiVariant rot3 = BlockModelGenerators.plainVariant(ModelTemplates.SIGN_ROT_3.create(ModelLocationUtils.getModelLocation(sign, "_rot_3"), mapping, gen.modelOutput));
		gen.blockStateOutput.accept(BlockModelGenerators.createSign(sign, rot0, rot1, rot2, rot3));

		MultiVariant wall = BlockModelGenerators.plainVariant(ModelTemplates.WALL_SIGN.create(wallSign, mapping, gen.modelOutput));
		gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(wallSign, wall).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING_ALT));

		gen.registerSimpleFlatItemModel(sign.asItem());
	}

	private void hangingSign(BlockModelGenerators gen, Block hanging, Block wallHanging, Block particle) {
		TextureMapping mapping = new TextureMapping()
				.put(TextureSlot.ALL, TextureMapping.getBlockTexture(hanging))
				.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(particle));

		MultiVariant[] rot = new MultiVariant[4];
		MultiVariant[] att = new MultiVariant[4];
		ModelTemplate[] rotT = {ModelTemplates.HANGING_SIGN_ROT_0, ModelTemplates.HANGING_SIGN_ROT_1, ModelTemplates.HANGING_SIGN_ROT_2, ModelTemplates.HANGING_SIGN_ROT_3};
		ModelTemplate[] attT = {ModelTemplates.ATTACHED_HANGING_SIGN_ROT_0, ModelTemplates.ATTACHED_HANGING_SIGN_ROT_1, ModelTemplates.ATTACHED_HANGING_SIGN_ROT_2, ModelTemplates.ATTACHED_HANGING_SIGN_ROT_3};
		for (int i = 0; i < 4; i++) {
			rot[i] = BlockModelGenerators.plainVariant(rotT[i].create(ModelLocationUtils.getModelLocation(hanging, "_rot_" + i), mapping, gen.modelOutput));
			att[i] = BlockModelGenerators.plainVariant(attT[i].create(ModelLocationUtils.getModelLocation(hanging, "_attached_rot_" + i), mapping, gen.modelOutput));
		}
		gen.blockStateOutput.accept(BlockModelGenerators.createHangingSign(hanging, rot[0], rot[1], rot[2], rot[3], att[0], att[1], att[2], att[3]));

		MultiVariant wall = BlockModelGenerators.plainVariant(ModelTemplates.WALL_HANGING_SIGN.create(wallHanging, mapping, gen.modelOutput));
		gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(wallHanging, wall).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING_ALT));

		gen.registerSimpleFlatItemModel(hanging.asItem());
	}

	public final void createOrangeSapling(
			BlockModelGenerators gen, final Block block) {
		MultiVariant model = plainVariant(
				ModelTemplates.AZALEA.create(block, TextureMapping.cubeTop(block),
						gen.modelOutput
				)
		);
		gen.blockStateOutput.accept(createSimpleBlock(block, model));
	}

	public final void createPottedOrangeSapling(
			BlockModelGenerators gen, final Block block) {
		MultiVariant model = plainVariant(
				ModelTemplates.POTTED_FLOWERING_AZALEA.create(
						block, TextureMapping.pottedAzalea(block),
						gen.modelOutput
				)
		);
		gen.blockStateOutput.accept(createSimpleBlock(block, model));
	}

	@Override
	public String getName() {
		return "FModelProvider";
	}
}