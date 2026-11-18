package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import se.frejaware.Blocks.FBlockIds;
import se.frejaware.Blocks.FBlockItemIds;
import se.frejaware.Shared.FBlockTags;

import java.util.concurrent.CompletableFuture;

public class FBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
	public FBlockTagProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// MOLLY
		builder(BlockTags.CROPS)
				.add(FBlockItemIds.PINEAPPLE_CROP);
		builder(BlockTags.MAINTAINS_FARMLAND)
				.add(FBlockItemIds.PINEAPPLE_CROP);
		builder(BlockTags.WASHED_AWAY_BY_FLUIDS)
				.add(FBlockItemIds.PINEAPPLE_CROP);

		builder(BlockTags.BLOCKS_MOTION_NO_LEAVES)
				.add(FBlockItemIds.IRON_BELL);
		builder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(FBlockItemIds.IRON_BELL);
		builder(BlockTags.REPLACEABLE_BY_TREES)
				.add(BlockItemIds.SNOW);

		builder(BlockTags.BLOCKS_MOTION_NO_LEAVES)
				.add(FBlockItemIds.DRY_CACTUS);
		builder(BlockTags.DANGEROUS_FOR_TELEPORTATION)
				.add(FBlockItemIds.DRY_CACTUS);
		builder(BlockTags.ENDERMAN_HOLDABLE)
				.add(FBlockItemIds.DRY_CACTUS);
		builder(BlockTags.HAPPY_GHAST_AVOIDS)
				.add(FBlockItemIds.DRY_CACTUS);
		builder(BlockTags.SUPPORT_OVERRIDE_CACTUS_FLOWER)
				.add(FBlockItemIds.DRY_CACTUS);

		// BLOM
		builder(FBlockTags.POTTED_FLOWERS)
				.add(FBlockIds.POTTED_WHITE_ORCHID)
				.add(FBlockIds.POTTED_YELLOW_TULIP)
				.add(FBlockIds.POTTED_WHITE_HIBISCUS)
				.add(FBlockIds.POTTED_YELLOW_HIBISCUS)

				.add(FBlockIds.POTTED_WHITE_CROCUS)
				.add(FBlockIds.POTTED_LILAC_CROCUS)
				.add(FBlockIds.POTTED_PURPLE_CROCUS)
				.add(FBlockIds.POTTED_LILY_OF_THE_GLADE)

				.add(FBlockIds.POTTED_WHITE_ALLIUM)
				.add(FBlockIds.POTTED_BLUE_SUCCULENT)
				.add(FBlockIds.POTTED_RED_SUCCULENT)
				.add(FBlockIds.POTTED_GREEN_SUCCULENT)
				.add(FBlockIds.POTTED_TEAL_SUCCULENT)
				.add(FBlockIds.POTTED_PURPLE_SUCCULENT)
				.add(FBlockIds.POTTED_BROWN_SUCCULENT)
				.add(FBlockIds.POTTED_YELLOW_SUCCULENT)

				.add(FBlockIds.POTTED_ROUND_BUSH)
				.add(FBlockIds.POTTED_DRY_CACTUS);
		builder(FBlockTags.SMALL_FLOWERS)
				.add(FBlockItemIds.WHITE_ORCHID)
				.add(FBlockItemIds.YELLOW_TULIP)
				.add(FBlockItemIds.WHITE_HIBISCUS)
				.add(FBlockItemIds.YELLOW_HIBISCUS)

				.add(FBlockItemIds.WHITE_CROCUS)
				.add(FBlockItemIds.LILAC_CROCUS)
				.add(FBlockItemIds.PURPLE_CROCUS)
				.add(FBlockItemIds.LILY_OF_THE_GLADE)

				.add(FBlockItemIds.WHITE_ALLIUM);
		builder(FBlockTags.NON_POT_FLOWERS)
				.add(FBlockItemIds.WHITE_CACTUS_FLOWER)
				.add(FBlockItemIds.YELLOW_CACTUS_FLOWER);

		builder(BlockTags.SMALL_FLOWERS)
				.addTag(FBlockTags.SMALL_FLOWERS);
		builder(BlockTags.FLOWER_POTS)
				.addTag(FBlockTags.POTTED_FLOWERS);
		builder(BlockTags.WASHED_AWAY_BY_FLUIDS)
				.addTag(FBlockTags.SMALL_FLOWERS);

		builder(BlockTags.ENDERMAN_HOLDABLE)
				.addTag(FBlockTags.NON_POT_FLOWERS);
		builder(BlockTags.WALL_POST_OVERRIDE)
				.addTag(FBlockTags.NON_POT_FLOWERS);

		builder(BlockTags.BEE_ATTRACTIVE)
				.addTag(FBlockTags.SMALL_FLOWERS)
				.addTag(FBlockTags.NON_POT_FLOWERS);
		builder(BlockTags.FLOWERS)
				.addTag(FBlockTags.SMALL_FLOWERS)
				.addTag(FBlockTags.NON_POT_FLOWERS);

		// VANILLA BLOCK VARIANTS
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.BLUE_ICE_STAIRS);
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.SNOW_SLAB)
				.add(FBlockItemIds.ICE_SLAB)
				.add(FBlockItemIds.PACKED_ICE_SLAB)
				.add(FBlockItemIds.BLUE_ICE_SLAB);
		builder(BlockTags.CANNOT_SUPPORT_SNOW_LAYER)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.ICE_SLAB)
				.add(FBlockItemIds.PACKED_ICE_SLAB);
		builder(BlockTags.GEODE_INVALID_BLOCKS)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.BLUE_ICE_SLAB)
				.add(FBlockItemIds.ICE_SLAB)
				.add(FBlockItemIds.PACKED_ICE_SLAB)
				.add(FBlockItemIds.BLUE_ICE_SLAB);
		builder(BlockTags.ICE)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.BLUE_ICE_SLAB)
				.add(FBlockItemIds.ICE_SLAB)
				.add(FBlockItemIds.PACKED_ICE_SLAB)
				.add(FBlockItemIds.BLUE_ICE_SLAB);
		builder(BlockTags.ICE_SPIKE_REPLACEABLE)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB)
				.add(FBlockItemIds.ICE_SLAB);
		builder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.BLUE_ICE_SLAB)
				.add(FBlockItemIds.ICE_SLAB)
				.add(FBlockItemIds.PACKED_ICE_SLAB)
				.add(FBlockItemIds.BLUE_ICE_SLAB);
		builder(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.ICE_SLAB);
		builder(BlockTags.SUPPORTS_LILY_PAD)
				.add(FBlockItemIds.ICE_STAIRS)
				.add(FBlockItemIds.ICE_SLAB);
		builder(BlockTags.GOATS_SPAWNABLE_ON)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_SLAB)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.SNAPS_GOAT_HORN)
				.add(FBlockItemIds.PACKED_ICE_STAIRS)
				.add(FBlockItemIds.PACKED_ICE_SLAB);
		builder(BlockTags.AZALEA_GROWS_ON)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.AZALEA_ROOT_REPLACEABLE)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.BLOCKS_MOTION_NO_LEAVES)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.FOXES_SPAWNABLE_ON)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.GOATS_SPAWNABLE_ON)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.RABBITS_SPAWNABLE_ON)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.SNOW)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);
		builder(BlockTags.WOLVES_SPAWNABLE_ON)
				.add(FBlockItemIds.SNOW_STAIRS)
				.add(FBlockItemIds.SNOW_SLAB);

		// BLUE SPRUCE
		builder(FBlockTags.SUPPORTS_BLUE_SPRUCE)
				.add(BlockItemIds.SNOW_BLOCK)
				.add(BlockItemIds.ICE)
				.add(BlockItemIds.PACKED_ICE)
				.add(BlockItemIds.BLUE_ICE);
		builder(FBlockTags.BLUE_SPRUCE_LOGS)
				.add(FBlockItemIds.BLUE_SPRUCE_LOG)
				.add(FBlockItemIds.STRIPPED_BLUE_SPRUCE_LOG)
				.add(FBlockItemIds.BLUE_SPRUCE_WOOD)
				.add(FBlockItemIds.STRIPPED_BLUE_SPRUCE_WOOD);
		builder(BlockItemTags.LOGS_THAT_BURN)
				.addTag(FBlockTags.BLUE_SPRUCE_LOGS);
		builder(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(FBlockItemIds.BLUE_SPRUCE_LOG);
		builder(BlockTags.LEAVES)
				.add(FBlockItemIds.BLUE_SPRUCE_LEAVES);
		builder(BlockTags.FLOWERS)
				.add(FBlockItemIds.BLUE_SPRUCE_LEAVES);
		builder(BlockTags.MINEABLE_WITH_HOE)
				.add(FBlockItemIds.BLUE_SPRUCE_LEAVES);
		builder(BlockTags.SAPLINGS)
				.add(FBlockItemIds.BLUE_SPRUCE_SAPLING);
		builder(BlockTags.FLOWER_POTS)
				.add(FBlockIds.POTTED_BLUE_SPRUCE_SAPLING);
		builder(BlockTags.PLANKS)
				.add(FBlockItemIds.BLUE_SPRUCE_PLANKS);
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.BLUE_SPRUCE_STAIRS);
		builder(BlockTags.WOODEN_STAIRS)
				.add(FBlockItemIds.BLUE_SPRUCE_STAIRS);
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.BLUE_SPRUCE_SLAB);
		builder(BlockTags.WOODEN_SLABS)
				.add(FBlockItemIds.BLUE_SPRUCE_SLAB);
		builder(BlockTags.FENCES)
				.add(FBlockItemIds.BLUE_SPRUCE_FENCE);
		builder(BlockTags.WOODEN_FENCES)
				.add(FBlockItemIds.BLUE_SPRUCE_FENCE);
		builder(BlockTags.FENCE_GATES)
				.add(FBlockItemIds.BLUE_SPRUCE_FENCE_GATE);
		builder(BlockTags.DOORS)
				.add(FBlockItemIds.BLUE_SPRUCE_DOOR);
		builder(BlockTags.WOODEN_DOORS)
				.add(FBlockItemIds.BLUE_SPRUCE_DOOR);
		builder(BlockTags.TRAPDOORS)
				.add(FBlockItemIds.BLUE_SPRUCE_TRAPDOOR);
		builder(BlockTags.WOODEN_TRAPDOORS)
				.add(FBlockItemIds.BLUE_SPRUCE_TRAPDOOR);
		builder(BlockTags.BUTTONS)
				.add(FBlockItemIds.BLUE_SPRUCE_BUTTON);
		builder(BlockTags.WOODEN_BUTTONS)
				.add(FBlockItemIds.BLUE_SPRUCE_BUTTON);
		builder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(FBlockItemIds.BLUE_SPRUCE_PRESSURE_PLATE);
		builder(BlockTags.ALL_SIGNS)
				.add(FBlockItemIds.BLUE_SPRUCE_SIGN)
				.add(FBlockIds.BLUE_SPRUCE_WALL_SIGN);
		builder(BlockTags.STANDING_SIGNS)
				.add(FBlockItemIds.BLUE_SPRUCE_SIGN);
		builder(BlockTags.WALL_SIGNS)
				.add(FBlockIds.BLUE_SPRUCE_WALL_SIGN);
		builder(BlockTags.ALL_HANGING_SIGNS)
				.add(FBlockItemIds.BLUE_SPRUCE_HANGING_SIGN)
				.add(FBlockIds.BLUE_SPRUCE_WALL_HANGING_SIGN);
		builder(BlockTags.CEILING_HANGING_SIGNS)
				.add(FBlockItemIds.BLUE_SPRUCE_HANGING_SIGN);
		builder(BlockTags.WALL_HANGING_SIGNS)
				.add(FBlockIds.BLUE_SPRUCE_WALL_HANGING_SIGN);
		builder(BlockTags.MINEABLE_WITH_AXE)
				.add(FBlockItemIds.BLUE_SPRUCE_LOG)
				.add(FBlockItemIds.STRIPPED_BLUE_SPRUCE_LOG)
				.add(FBlockItemIds.BLUE_SPRUCE_WOOD)
				.add(FBlockItemIds.STRIPPED_BLUE_SPRUCE_WOOD)
				.add(FBlockItemIds.BLUE_SPRUCE_PLANKS)
				.add(FBlockItemIds.BLUE_SPRUCE_STAIRS)
				.add(FBlockItemIds.BLUE_SPRUCE_SLAB)
				.add(FBlockItemIds.BLUE_SPRUCE_FENCE)
				.add(FBlockItemIds.BLUE_SPRUCE_FENCE_GATE)
				.add(FBlockItemIds.BLUE_SPRUCE_DOOR)
				.add(FBlockItemIds.BLUE_SPRUCE_TRAPDOOR)
				.add(FBlockItemIds.BLUE_SPRUCE_BUTTON)
				.add(FBlockItemIds.BLUE_SPRUCE_PRESSURE_PLATE)
				.add(FBlockItemIds.BLUE_SPRUCE_SIGN)
				.add(FBlockIds.BLUE_SPRUCE_WALL_SIGN)
				.add(FBlockItemIds.BLUE_SPRUCE_HANGING_SIGN)
				.add(FBlockIds.BLUE_SPRUCE_WALL_HANGING_SIGN)
				.add(FBlockItemIds.BLUE_SPRUCE_SHELF);

		// ORANGE
		builder(BlockTags.SAPLINGS)
				.add(FBlockItemIds.ORANGE_SAPLING);
		builder(BlockTags.FLOWER_POTS)
				.add(FBlockIds.POTTED_ORANGE_SAPLING);
		builder(BlockTags.LEAVES)
				.add(FBlockItemIds.ORANGE_LEAVES);
		builder(BlockTags.FLOWERS)
				.add(FBlockItemIds.ORANGE_LEAVES);
		builder(BlockTags.MINEABLE_WITH_HOE)
				.add(FBlockItemIds.ORANGE_LEAVES);

		// JACARANDA
		builder(FBlockTags.JACARANDA_LOGS)
				.add(FBlockItemIds.JACARANDA_LOG)
				.add(FBlockItemIds.STRIPPED_JACARANDA_LOG)
				.add(FBlockItemIds.JACARANDA_WOOD)
				.add(FBlockItemIds.STRIPPED_JACARANDA_WOOD);
		builder(BlockItemTags.LOGS_THAT_BURN)
				.addTag(FBlockTags.JACARANDA_LOGS);
		builder(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(FBlockItemIds.JACARANDA_LOG);
		builder(BlockTags.LEAVES)
				.add(FBlockItemIds.JACARANDA_LEAVES);
		builder(BlockTags.FLOWERS)
				.add(FBlockItemIds.JACARANDA_LEAVES);
		builder(BlockTags.MINEABLE_WITH_HOE)
				.add(FBlockItemIds.JACARANDA_LEAVES);
		builder(BlockTags.SAPLINGS)
				.add(FBlockItemIds.JACARANDA_SAPLING);
		builder(BlockTags.FLOWER_POTS)
				.add(FBlockIds.POTTED_JACARANDA_SAPLING);
		builder(BlockTags.PLANKS)
				.add(FBlockItemIds.JACARANDA_PLANKS);
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.JACARANDA_STAIRS);
		builder(BlockTags.WOODEN_STAIRS)
				.add(FBlockItemIds.JACARANDA_STAIRS);
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.JACARANDA_SLAB);
		builder(BlockTags.WOODEN_SLABS)
				.add(FBlockItemIds.JACARANDA_SLAB);
		builder(BlockTags.FENCES)
				.add(FBlockItemIds.JACARANDA_FENCE);
		builder(BlockTags.WOODEN_FENCES)
				.add(FBlockItemIds.JACARANDA_FENCE);
		builder(BlockTags.FENCE_GATES)
				.add(FBlockItemIds.JACARANDA_FENCE_GATE);
		builder(BlockTags.DOORS)
				.add(FBlockItemIds.JACARANDA_DOOR);
		builder(BlockTags.WOODEN_DOORS)
				.add(FBlockItemIds.JACARANDA_DOOR);
		builder(BlockTags.TRAPDOORS)
				.add(FBlockItemIds.JACARANDA_TRAPDOOR);
		builder(BlockTags.WOODEN_TRAPDOORS)
				.add(FBlockItemIds.JACARANDA_TRAPDOOR);
		builder(BlockTags.BUTTONS)
				.add(FBlockItemIds.JACARANDA_BUTTON);
		builder(BlockTags.WOODEN_BUTTONS)
				.add(FBlockItemIds.JACARANDA_BUTTON);
		builder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(FBlockItemIds.JACARANDA_PRESSURE_PLATE);
		builder(BlockTags.ALL_SIGNS)
				.add(FBlockItemIds.JACARANDA_SIGN)
				.add(FBlockIds.JACARANDA_WALL_SIGN);
		builder(BlockTags.STANDING_SIGNS)
				.add(FBlockItemIds.JACARANDA_SIGN);
		builder(BlockTags.WALL_SIGNS)
				.add(FBlockIds.JACARANDA_WALL_SIGN);
		builder(BlockTags.ALL_HANGING_SIGNS)
				.add(FBlockItemIds.JACARANDA_HANGING_SIGN)
				.add(FBlockIds.JACARANDA_WALL_HANGING_SIGN);
		builder(BlockTags.CEILING_HANGING_SIGNS)
				.add(FBlockItemIds.JACARANDA_HANGING_SIGN);
		builder(BlockTags.WALL_HANGING_SIGNS)
				.add(FBlockIds.JACARANDA_WALL_HANGING_SIGN);
		builder(BlockTags.MINEABLE_WITH_AXE)
				.add(FBlockItemIds.JACARANDA_LOG)
				.add(FBlockItemIds.STRIPPED_JACARANDA_LOG)
				.add(FBlockItemIds.JACARANDA_WOOD)
				.add(FBlockItemIds.STRIPPED_JACARANDA_WOOD)
				.add(FBlockItemIds.JACARANDA_PLANKS)
				.add(FBlockItemIds.JACARANDA_STAIRS)
				.add(FBlockItemIds.JACARANDA_SLAB)
				.add(FBlockItemIds.JACARANDA_FENCE)
				.add(FBlockItemIds.JACARANDA_FENCE_GATE)
				.add(FBlockItemIds.JACARANDA_DOOR)
				.add(FBlockItemIds.JACARANDA_TRAPDOOR)
				.add(FBlockItemIds.JACARANDA_BUTTON)
				.add(FBlockItemIds.JACARANDA_PRESSURE_PLATE)
				.add(FBlockItemIds.JACARANDA_SIGN)
				.add(FBlockIds.JACARANDA_WALL_SIGN)
				.add(FBlockItemIds.JACARANDA_HANGING_SIGN)
				.add(FBlockIds.JACARANDA_WALL_HANGING_SIGN)
				.add(FBlockItemIds.JACARANDA_SHELF);

		// LOGS
		builder(FBlockTags.PEAR_LOGS)
				.add(FBlockItemIds.PEAR_LOG)
				.add(FBlockItemIds.STRIPPED_PEAR_LOG)
				.add(FBlockItemIds.PEAR_WOOD)
				.add(FBlockItemIds.STRIPPED_PEAR_WOOD);

		builder(BlockItemTags.LOGS_THAT_BURN)
				.addTag(FBlockTags.PEAR_LOGS);

		builder(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(FBlockItemIds.PEAR_LOG);

		// LEAVES
		builder(BlockTags.LEAVES)
				.add(FBlockItemIds.PEAR_LEAVES);

		builder(BlockTags.FLOWERS)
				.add(FBlockItemIds.PEAR_LEAVES);

		builder(BlockTags.MINEABLE_WITH_HOE)
				.add(FBlockItemIds.PEAR_LEAVES);

		// SAPLINGS
		builder(BlockTags.SAPLINGS)
				.add(FBlockItemIds.PEAR_SAPLING);

		builder(BlockTags.FLOWER_POTS)
				.add(FBlockIds.POTTED_PEAR_SAPLING);

		// PLANKS
		builder(BlockTags.PLANKS)
				.add(FBlockItemIds.PEAR_PLANKS);

		// STAIRS
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.PEAR_STAIRS);

		builder(BlockTags.WOODEN_STAIRS)
				.add(FBlockItemIds.PEAR_STAIRS);

		// SLABS
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.PEAR_SLAB);

		builder(BlockTags.WOODEN_SLABS)
				.add(FBlockItemIds.PEAR_SLAB);

		// FENCES
		builder(BlockTags.FENCES)
				.add(FBlockItemIds.PEAR_FENCE);

		builder(BlockTags.WOODEN_FENCES)
				.add(FBlockItemIds.PEAR_FENCE);

		// FENCE GATES
		builder(BlockTags.FENCE_GATES)
				.add(FBlockItemIds.PEAR_FENCE_GATE);

		// DOORS
		builder(BlockTags.DOORS)
				.add(FBlockItemIds.PEAR_DOOR);

		builder(BlockTags.WOODEN_DOORS)
				.add(FBlockItemIds.PEAR_DOOR);

		// TRAPDOORS
		builder(BlockTags.TRAPDOORS)
				.add(FBlockItemIds.PEAR_TRAPDOOR);

		builder(BlockTags.WOODEN_TRAPDOORS)
				.add(FBlockItemIds.PEAR_TRAPDOOR);

		// BUTTONS
		builder(BlockTags.BUTTONS)
				.add(FBlockItemIds.PEAR_BUTTON);

		builder(BlockTags.WOODEN_BUTTONS)
				.add(FBlockItemIds.PEAR_BUTTON);

		// PRESSURE PLATES
		builder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(FBlockItemIds.PEAR_PRESSURE_PLATE);

		// SIGNS
		builder(BlockTags.ALL_SIGNS)
				.add(FBlockItemIds.PEAR_SIGN)
				.add(FBlockIds.PEAR_WALL_SIGN);

		builder(BlockTags.STANDING_SIGNS)
				.add(FBlockItemIds.PEAR_SIGN);

		builder(BlockTags.WALL_SIGNS)
				.add(FBlockIds.PEAR_WALL_SIGN);

		// HANGING SIGNS
		builder(BlockTags.ALL_HANGING_SIGNS)
				.add(FBlockItemIds.PEAR_HANGING_SIGN)
				.add(FBlockIds.PEAR_WALL_HANGING_SIGN);

		builder(BlockTags.CEILING_HANGING_SIGNS)
				.add(FBlockItemIds.PEAR_HANGING_SIGN);

		builder(BlockTags.WALL_HANGING_SIGNS)
				.add(FBlockIds.PEAR_WALL_HANGING_SIGN);

		// MINEABLE
		builder(BlockTags.MINEABLE_WITH_AXE)
				.add(FBlockItemIds.PEAR_LOG)
				.add(FBlockItemIds.STRIPPED_PEAR_LOG)
				.add(FBlockItemIds.PEAR_WOOD)
				.add(FBlockItemIds.STRIPPED_PEAR_WOOD)
				.add(FBlockItemIds.PEAR_PLANKS)
				.add(FBlockItemIds.PEAR_STAIRS)
				.add(FBlockItemIds.PEAR_SLAB)
				.add(FBlockItemIds.PEAR_FENCE)
				.add(FBlockItemIds.PEAR_FENCE_GATE)
				.add(FBlockItemIds.PEAR_DOOR)
				.add(FBlockItemIds.PEAR_TRAPDOOR)
				.add(FBlockItemIds.PEAR_BUTTON)
				.add(FBlockItemIds.PEAR_PRESSURE_PLATE)
				.add(FBlockItemIds.PEAR_SIGN)
				.add(FBlockIds.PEAR_WALL_SIGN)
				.add(FBlockItemIds.PEAR_HANGING_SIGN)
				.add(FBlockIds.PEAR_WALL_HANGING_SIGN)
				.add(FBlockItemIds.PEAR_SHELF);

		// OTHER
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_STAIRS);
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_SLAB);
		builder(BlockTags.WALLS)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_WALL);
		builder(BlockTags.BLOCKS_MOTION_NO_LEAVES)
				.add(FBlockItemIds.CHISELED_ROSE_QUARTZ_BRICKS);
		builder(BlockTags.DOORS)
				.add(FBlockItemIds.ROSE_QUARTZ_DOOR);
		builder(BlockTags.TRAPDOORS)
				.add(FBlockItemIds.ROSE_QUARTZ_TRAPDOOR);
		builder(BlockTags.CLIMBABLE)
				.add(FBlockItemIds.ROSE_QUARTZ_LADDER);
		builder(BlockTags.CHAINS)
				.add(FBlockItemIds.ROSE_QUARTZ_CHAIN);
		builder(BlockTags.LANTERNS)
				.add(FBlockItemIds.ROSE_QUARTZ_LANTERN);
		builder(BlockTags.PRESSURE_PLATES)
				.add(FBlockItemIds.ROSE_QUARTZ_PRESSURE_PLATE);
		builder(BlockTags.WALL_POST_OVERRIDE)
				.add(FBlockItemIds.ROSE_QUARTZ_PRESSURE_PLATE);
		builder(BlockTags.BUTTONS)
				.add(FBlockItemIds.ROSE_QUARTZ_BUTTON);

		builder(BlockTags.BEACON_BASE_BLOCKS)
				.add(FBlockItemIds.ROSE_QUARTZ_BLOCK)
				.add(FBlockItemIds.TRANSIUM_BLOCK);
		builder(BlockTags.INCORRECT_FOR_IRON_TOOL)
				.add(FBlockItemIds.TRANSIUM_BLOCK);
		builder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
				.add(FBlockItemIds.ROSE_QUARTZ_ORE)
				.add(FBlockItemIds.ROSE_QUARTZ_BLOCK);

		builder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(FBlockItemIds.TRANSIUM_BLOCK)

				.add(FBlockItemIds.ROSE_QUARTZ_ORE)
				.add(FBlockItemIds.ROSE_QUARTZ_BLOCK)

				.add(FBlockItemIds.ROSE_QUARTZ_BRICKS)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_STAIRS)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_SLAB)
				.add(FBlockItemIds.ROSE_QUARTZ_BRICK_WALL)
				.add(FBlockItemIds.CHISELED_ROSE_QUARTZ_BRICKS)

				.add(FBlockItemIds.ROSE_QUARTZ_DOOR)
				.add(FBlockItemIds.ROSE_QUARTZ_TRAPDOOR)
				.add(FBlockItemIds.ROSE_QUARTZ_LADDER)
				.add(FBlockItemIds.ROSE_QUARTZ_CHAIN)
				.add(FBlockItemIds.ROSE_QUARTZ_LANTERN)
				.add(FBlockItemIds.ROSE_QUARTZ_PRESSURE_PLATE)
				.add(FBlockItemIds.ROSE_QUARTZ_BUTTON)

				.add(FBlockItemIds.GOLEM_HEAD_AMETHYST)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_AMETHYST)
				.add(FBlockItemIds.GOLEM_HEAD_COAL)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_COAL)
				.add(FBlockItemIds.GOLEM_HEAD_DIAMOND)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_DIAMOND)
				.add(FBlockItemIds.GOLEM_HEAD_EMERALD)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_EMERALD)
				.add(FBlockItemIds.GOLEM_HEAD_REDSTONE)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_REDSTONE)
				.add(FBlockItemIds.GOLEM_HEAD_GOLD)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_GOLD)
				.add(FBlockItemIds.GOLEM_HEAD_IRON)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_IRON)
				.add(FBlockItemIds.GOLEM_HEAD_LAPIS)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_LAPIS)
				.add(FBlockItemIds.GOLEM_HEAD_NETHERITE)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_NETHERITE);

		builder(BlockTags.NEEDS_STONE_TOOL)
				.add(FBlockItemIds.GOLEM_HEAD_IRON)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_IRON)
				.add(FBlockItemIds.GOLEM_HEAD_LAPIS)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_LAPIS);

		builder(BlockTags.NEEDS_IRON_TOOL)
				.add(FBlockItemIds.GOLEM_HEAD_DIAMOND)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_DIAMOND)
				.add(FBlockItemIds.GOLEM_HEAD_EMERALD)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_EMERALD)
				.add(FBlockItemIds.GOLEM_HEAD_GOLD)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_GOLD);

		builder(BlockTags.NEEDS_DIAMOND_TOOL)
				.add(FBlockItemIds.GOLEM_HEAD_NETHERITE)
				.add(FBlockItemIds.GOLEM_WALL_HEAD_NETHERITE);
	}
}