package se.frejaware.WorldGen.Custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BulkSectionAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.AbstractOreFeature;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class FRoseQuartzOreFeature extends AbstractOreFeature {
	public FRoseQuartzOreFeature(
			List<BlockReplacement> targetStates,
			int size,
			float discardChanceOnAirExposure
	) {
		super(targetStates, size, discardChanceOnAirExposure);
	}

	public static final MapCodec<FRoseQuartzOreFeature> CODEC =
			makeCodec(FRoseQuartzOreFeature::new);

	@Override
	public MapCodec<FRoseQuartzOreFeature> codec() {
		return CODEC;
	}

	private record OrePlacement(BlockPos pos, BlockState state) {}

	private boolean isValidVein(
			WorldGenLevel level,
			List<OrePlacement> positions
	) {
		boolean hasAllowedExposure = false;

		for (OrePlacement placement : positions) {
			BlockPos pos = placement.pos();

			// Reject the entire vein if any ore block has air above it.
			if (level.getBlockState(pos.above()).isAir()) {
				return false;
			}

			// At least one block must be exposed horizontally or below.
			if (level.getBlockState(pos.north()).isAir()
					|| level.getBlockState(pos.south()).isAir()
					|| level.getBlockState(pos.east()).isAir()
					|| level.getBlockState(pos.west()).isAir()
					|| level.getBlockState(pos.below()).isAir()) {
				hasAllowedExposure = true;
			}
		}

		return hasAllowedExposure;
	}

	@Override
	public boolean place(
			final WorldGenLevel level,
			final ChunkGenerator chunkGenerator,
			final RandomSource random,
			final BlockPos origin
	) {
		float dir = random.nextFloat() * (float) Math.PI;
		float spreadXY = this.size / 8.0F;
		int maxRadius = Mth.ceil(
				(this.size / 16.0F * 2.0F + 1.0F) / 2.0F
		);

		double x0 = origin.getX() + Math.sin(dir) * spreadXY;
		double x1 = origin.getX() - Math.sin(dir) * spreadXY;
		double z0 = origin.getZ() + Math.cos(dir) * spreadXY;
		double z1 = origin.getZ() - Math.cos(dir) * spreadXY;

		double y0 = origin.getY() + random.nextInt(3) - 2;
		double y1 = origin.getY() + random.nextInt(3) - 2;

		int xStart = origin.getX() - Mth.ceil(spreadXY) - maxRadius;
		int yStart = origin.getY() - 2 - maxRadius;
		int zStart = origin.getZ() - Mth.ceil(spreadXY) - maxRadius;

		int sizeXZ = 2 * (Mth.ceil(spreadXY) + maxRadius);
		int sizeY = 2 * (2 + maxRadius);

		for (int xprobe = xStart; xprobe <= xStart + sizeXZ; xprobe++) {
			for (int zprobe = zStart; zprobe <= zStart + sizeXZ; zprobe++) {
				if (yStart <= level.getHeight(
						Heightmap.Types.OCEAN_FLOOR_WG,
						xprobe,
						zprobe
				)) {
					return this.doPlace(
							level, random,
							x0, x1, z0, z1, y0, y1,
							xStart, yStart, zStart,
							sizeXZ, sizeY
					);
				}
			}
		}

		return false;
	}

	protected boolean doPlace(
			WorldGenLevel level,
			RandomSource random,
			double x0, double x1,
			double z0, double z1,
			double y0, double y1,
			int xStart, int yStart, int zStart,
			int sizeXZ, int sizeY
	) {
		List<OrePlacement> placements = new ArrayList<>();
		BitSet tested = new BitSet(sizeXZ * sizeY * sizeXZ);
		BlockPos.MutableBlockPos orePos = new BlockPos.MutableBlockPos();
		double[] data = new double[this.size * 4];

		for (int i = 0; i < this.size; i++) {
			float step = (float) i / this.size;
			double xx = Mth.lerp(step, x0, x1);
			double yy = Mth.lerp(step, y0, y1);
			double zz = Mth.lerp(step, z0, z1);
			double ss = random.nextDouble() * this.size / 16.0;
			double r = (
					(Mth.sin((float) Math.PI * step) + 1.0F) * ss + 1.0
			) / 2.0;

			data[i * 4] = xx;
			data[i * 4 + 1] = yy;
			data[i * 4 + 2] = zz;
			data[i * 4 + 3] = r;
		}

		for (int i1 = 0; i1 < this.size - 1; i1++) {
			if (!(data[i1 * 4 + 3] <= 0.0)) {
				for (int i2 = i1 + 1; i2 < this.size; i2++) {
					if (!(data[i2 * 4 + 3] <= 0.0)) {
						double dx = data[i1 * 4] - data[i2 * 4];
						double dy = data[i1 * 4 + 1] - data[i2 * 4 + 1];
						double dz = data[i1 * 4 + 2] - data[i2 * 4 + 2];
						double dr = data[i1 * 4 + 3] - data[i2 * 4 + 3];

						if (dr * dr > dx * dx + dy * dy + dz * dz) {
							if (dr > 0.0) {
								data[i2 * 4 + 3] = -1.0;
							} else {
								data[i1 * 4 + 3] = -1.0;
							}
						}
					}
				}
			}
		}

		try (BulkSectionAccess sectionGetter = new BulkSectionAccess(level)) {
			for (int i = 0; i < this.size; i++) {
				double r = data[i * 4 + 3];

				if (!(r < 0.0)) {
					double xx = data[i * 4];
					double yy = data[i * 4 + 1];
					double zz = data[i * 4 + 2];

					int xMin = Math.max(Mth.floor(xx - r), xStart);
					int yMin = Math.max(Mth.floor(yy - r), yStart);
					int zMin = Math.max(Mth.floor(zz - r), zStart);

					int xMax = Math.max(Mth.floor(xx + r), xMin);
					int yMax = Math.max(Mth.floor(yy + r), yMin);
					int zMax = Math.max(Mth.floor(zz + r), zMin);

					for (int x = xMin; x <= xMax; x++) {
						double xd = (x + 0.5 - xx) / r;

						if (xd * xd < 1.0) {
							for (int y = yMin; y <= yMax; y++) {
								double yd = (y + 0.5 - yy) / r;

								if (xd * xd + yd * yd < 1.0) {
									for (int z = zMin; z <= zMax; z++) {
										double zd = (z + 0.5 - zz) / r;

										if (xd * xd + yd * yd + zd * zd < 1.0
												&& !level.isOutsideBuildHeight(y)) {

											int bitSetIndex = x - xStart
													+ (y - yStart) * sizeXZ
													+ (z - zStart) * sizeXZ * sizeY;

											if (!tested.get(bitSetIndex)) {
												tested.set(bitSetIndex);
												orePos.set(x, y, z);

												if (level.ensureCanWrite(orePos)) {
													LevelChunkSection section =
															sectionGetter.getSection(orePos);

													if (section != null) {
														int sectionRelativeX = SectionPos.sectionRelative(x);
														int sectionRelativeY = SectionPos.sectionRelative(y);
														int sectionRelativeZ = SectionPos.sectionRelative(z);

														BlockState blockState = section.getBlockState(
																sectionRelativeX,
																sectionRelativeY,
																sectionRelativeZ
														);

														for (BlockReplacement targetState : this.targetStates) {
															if (targetState.target().test(
																	blockState,
																	orePos,
																	random
															)) {
																placements.add(
																		new OrePlacement(
																				orePos.immutable(),
																				targetState.state()
																		)
																);
																break;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// Validate the complete vein before placing any ore.
		if (placements.isEmpty() || !isValidVein(level, placements)) {
			return false;
		}

		System.out.println("[RoseQuartz] Vein accepted! Blocks: " + placements.size());

		// Second pass: place the entire validated vein.
		try (BulkSectionAccess sectionGetter = new BulkSectionAccess(level)) {
			BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

			for (OrePlacement placement : placements) {
				BlockPos pos = placement.pos();
				mutablePos.set(pos);

				if (!level.ensureCanWrite(mutablePos)) {
					continue;
				}

				LevelChunkSection section = sectionGetter.getSection(mutablePos);

				if (section != null) {
					section.setBlockState(
							SectionPos.sectionRelative(pos.getX()),
							SectionPos.sectionRelative(pos.getY()),
							SectionPos.sectionRelative(pos.getZ()),
							placement.state(),
							false
					);
				}
			}
		}
		return true;
	}
}