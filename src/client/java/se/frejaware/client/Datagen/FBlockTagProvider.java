package se.frejaware.client.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import se.frejaware.Blocks.FBlockIds;
import se.frejaware.Blocks.FBlockItemIds;
import se.frejaware.Items.FItems;
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

		builder(FBlockTags.POT_FLOWERS)
				.add(FBlockItemIds.WHITE_ORCHID)
				.add(FBlockItemIds.YELLOW_TULIP)
				.add(FBlockItemIds.WHITE_HIBISCUS)
				.add(FBlockItemIds.YELLOW_HIBISCUS)
				.add(FBlockItemIds.WHITE_CROCUS)
				.add(FBlockItemIds.LILAC_CROCUS)
				.add(FBlockItemIds.PURPLE_CROCUS)
				.add(FBlockItemIds.LILY_OF_THE_GLADE);
		builder(FBlockTags.OTHER_FLOWERS)
				.add(FBlockItemIds.WHITE_CACTUS_FLOWER)
				.add(FBlockItemIds.YELLOW_CACTUS_FLOWER);

		builder(BlockTags.SMALL_FLOWERS)
				.addTag(FBlockTags.POT_FLOWERS);
		builder(BlockTags.FLOWER_POTS)
				.addTag(FBlockTags.POT_FLOWERS);
		builder(BlockTags.WASHED_AWAY_BY_FLUIDS)
				.addTag(FBlockTags.POT_FLOWERS);

		builder(BlockTags.ENDERMAN_HOLDABLE)
				.addTag(FBlockTags.OTHER_FLOWERS);
		builder(BlockTags.WALL_POST_OVERRIDE)
				.addTag(FBlockTags.OTHER_FLOWERS);

		builder(BlockTags.BEE_ATTRACTIVE)
				.addTag(FBlockTags.POT_FLOWERS)
				.addTag(FBlockTags.OTHER_FLOWERS);
		builder(BlockTags.FLOWERS)
				.addTag(FBlockTags.POT_FLOWERS)
				.addTag(FBlockTags.OTHER_FLOWERS);


		// LOGS
		builder(FBlockTags.JACARANDA_LOGS)
				.add(FBlockItemIds.JACARANDA_LOG)
				.add(FBlockItemIds.STRIPPED_JACARANDA_LOG)
				.add(FBlockItemIds.JACARANDA_WOOD)
				.add(FBlockItemIds.STRIPPED_JACARANDA_WOOD);

		builder(BlockItemTags.LOGS_THAT_BURN)
				.addTag(FBlockTags.JACARANDA_LOGS);

		builder(BlockTags.OVERWORLD_NATURAL_LOGS)
				.add(FBlockItemIds.JACARANDA_LOG);

		// LEAVES
		builder(BlockTags.LEAVES)
				.add(FBlockItemIds.JACARANDA_LEAVES);

		builder(BlockTags.FLOWERS)
				.add(FBlockItemIds.JACARANDA_LEAVES);

		builder(BlockTags.MINEABLE_WITH_HOE)
				.add(FBlockItemIds.JACARANDA_LEAVES);

		// SAPLINGS
		builder(BlockTags.SAPLINGS)
				.add(FBlockItemIds.JACARANDA_SAPLING);

		builder(BlockTags.FLOWER_POTS)
				.add(FBlockIds.POTTED_JACARANDA_SAPLING);

		// PLANKS
		builder(BlockTags.PLANKS)
				.add(FBlockItemIds.JACARANDA_PLANKS);

		// STAIRS
		builder(BlockTags.STAIRS)
				.add(FBlockItemIds.JACARANDA_STAIRS);

		builder(BlockTags.WOODEN_STAIRS)
				.add(FBlockItemIds.JACARANDA_STAIRS);

		// SLABS
		builder(BlockTags.SLABS)
				.add(FBlockItemIds.JACARANDA_SLAB);

		builder(BlockTags.WOODEN_SLABS)
				.add(FBlockItemIds.JACARANDA_SLAB);

		// FENCES
		builder(BlockTags.FENCES)
				.add(FBlockItemIds.JACARANDA_FENCE);

		builder(BlockTags.WOODEN_FENCES)
				.add(FBlockItemIds.JACARANDA_FENCE);

		// FENCE GATES
		builder(BlockTags.FENCE_GATES)
				.add(FBlockItemIds.JACARANDA_FENCE_GATE);

		// DOORS
		builder(BlockTags.DOORS)
				.add(FBlockItemIds.JACARANDA_DOOR);

		builder(BlockTags.WOODEN_DOORS)
				.add(FBlockItemIds.JACARANDA_DOOR);

		// TRAPDOORS
		builder(BlockTags.TRAPDOORS)
				.add(FBlockItemIds.JACARANDA_TRAPDOOR);

		builder(BlockTags.WOODEN_TRAPDOORS)
				.add(FBlockItemIds.JACARANDA_TRAPDOOR);

		// BUTTONS
		builder(BlockTags.BUTTONS)
				.add(FBlockItemIds.JACARANDA_BUTTON);

		builder(BlockTags.WOODEN_BUTTONS)
				.add(FBlockItemIds.JACARANDA_BUTTON);

		// PRESSURE PLATES
		builder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(FBlockItemIds.JACARANDA_PRESSURE_PLATE);

		// SIGNS
		builder(BlockTags.ALL_SIGNS)
				.add(FBlockItemIds.JACARANDA_SIGN)
				.add(FBlockIds.JACARANDA_WALL_SIGN);

		builder(BlockTags.STANDING_SIGNS)
				.add(FBlockItemIds.JACARANDA_SIGN);

		builder(BlockTags.WALL_SIGNS)
				.add(FBlockIds.JACARANDA_WALL_SIGN);

		// HANGING SIGNS
		builder(BlockTags.ALL_HANGING_SIGNS)
				.add(FBlockItemIds.JACARANDA_HANGING_SIGN)
				.add(FBlockIds.JACARANDA_WALL_HANGING_SIGN);

		builder(BlockTags.CEILING_HANGING_SIGNS)
				.add(FBlockItemIds.JACARANDA_HANGING_SIGN);

		builder(BlockTags.WALL_HANGING_SIGNS)
				.add(FBlockIds.JACARANDA_WALL_HANGING_SIGN);

		// MINEABLE
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