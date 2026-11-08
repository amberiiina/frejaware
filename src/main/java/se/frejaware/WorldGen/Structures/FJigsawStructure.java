package se.frejaware.WorldGen.Structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Optional;

public class FJigsawStructure extends Structure {
	public static final MapCodec<FJigsawStructure> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
			JigsawStructure.CODEC.forGetter(s -> s.jigsaw),
			Codec.INT.fieldOf("min_surface_y").forGetter(s -> s.minSurfaceY)
	).apply(i, FJigsawStructure::new));

	private final JigsawStructure jigsaw;
	private final int minSurfaceY;

	public FJigsawStructure(JigsawStructure jigsaw, int minSurfaceY) {
		super(new StructureSettings(
				jigsaw.biomes(),
				jigsaw.spawnOverrides(),
				jigsaw.step(),
				jigsaw.terrainAdaptation()
		));
		this.jigsaw = jigsaw;
		this.minSurfaceY = minSurfaceY;
	}

	@Override
	public Optional<GenerationStub> findGenerationPoint(GenerationContext ctx) {
		int x = ctx.chunkPos().getMiddleBlockX();
		int z = ctx.chunkPos().getMiddleBlockZ();
		int surface = ctx.chunkGenerator().getFirstOccupiedHeight(
				x, z, Heightmap.Types.WORLD_SURFACE_WG, ctx.heightAccessor(), ctx.randomState());
		int floor = ctx.chunkGenerator().getFirstOccupiedHeight(
				x, z, Heightmap.Types.OCEAN_FLOOR_WG, ctx.heightAccessor(), ctx.randomState());

		if (surface > floor) return Optional.empty();       // water on top
		if (surface < minSurfaceY) return Optional.empty(); // below your y limit

		return jigsaw.findGenerationPoint(ctx);
	}

	@Override
	public StructureType<?> type() {
		return FStructureTypes.FJIGSAW;
	}
}