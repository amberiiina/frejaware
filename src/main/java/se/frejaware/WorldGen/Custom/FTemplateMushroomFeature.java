package se.frejaware.WorldGen.Custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public record FTemplateMushroomFeature(List<Identifier> templates, BlockPredicate canPlaceOn) implements Feature {
	public static final MapCodec<FTemplateMushroomFeature> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
			Identifier.CODEC.listOf().fieldOf("templates").forGetter(FTemplateMushroomFeature::templates),
			BlockPredicate.CODEC.fieldOf("can_place_on").forGetter(FTemplateMushroomFeature::canPlaceOn)
	).apply(i, FTemplateMushroomFeature::new));

	@Override
	public MapCodec<FTemplateMushroomFeature> codec() {
		return CODEC;
	}

	private static final Block[] BLOCKS = {
			Blocks.MUSHROOM_STEM, Blocks.PALE_OAK_FENCE,
			Blocks.BROWN_MUSHROOM_BLOCK, Blocks.RED_MUSHROOM_BLOCK
	};

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos origin) {
		var server = level.getLevel().getServer();
		StructureTemplate template = server.getStructureTemplateManager().get(templates.get(random.nextInt(templates.size()))).orElse(null);
		if (template == null) return false;

		StructurePlaceSettings settings = new StructurePlaceSettings()
				.setRotation(Rotation.getRandom(random))
				.setMirror(random.nextBoolean() ? Mirror.NONE : Mirror.LEFT_RIGHT)
				.setRotationPivot(new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2))
				.setIgnoreEntities(true)
				.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);

		List<BlockPos> all = new ArrayList<>();
		for (Block b : BLOCKS)
			for (var info : template.filterBlocks(BlockPos.ZERO, settings, b)) all.add(info.pos());
		if (all.isEmpty()) return false;

		int baseY = all.stream().mapToInt(BlockPos::getY).min().getAsInt();
		List<BlockPos> base = all.stream().filter(p -> p.getY() == baseY).toList();
		int minX = base.stream().mapToInt(BlockPos::getX).min().getAsInt();
		int maxX = base.stream().mapToInt(BlockPos::getX).max().getAsInt();
		int minZ = base.stream().mapToInt(BlockPos::getZ).min().getAsInt();
		int maxZ = base.stream().mapToInt(BlockPos::getZ).max().getAsInt();

		BlockPos anchor = new BlockPos(Math.floorDiv(minX + maxX, 2), baseY, Math.floorDiv(minZ + maxZ, 2));
		BlockPos corner = origin.subtract(anchor);

		for (BlockPos b : base) {
			if (!canPlaceOn.test(level, corner.offset(b).below())) return false;
		}

		BoundingBox box = template.getBoundingBox(settings, corner);
		if (box.minY() < level.getMinY() + 1 || box.maxY() >= level.getMaxY()) return false;

		BlockPos.MutableBlockPos p = new BlockPos.MutableBlockPos();
		for (var block : new Block[]{Blocks.MUSHROOM_STEM, Blocks.BROWN_MUSHROOM_BLOCK, Blocks.RED_MUSHROOM_BLOCK}) {
			for (var info : template.filterBlocks(corner, settings, block)) {
				BlockState s = level.getBlockState(p.set(info.pos()));
				if (!s.isAir() && !s.is(BlockTags.LEAVES) && !s.is(BlockTags.REPLACEABLE_BY_MUSHROOMS)) return false;
			}
		}

		return template.placeInWorld(level, corner, corner, settings, random, 2);
	}
}