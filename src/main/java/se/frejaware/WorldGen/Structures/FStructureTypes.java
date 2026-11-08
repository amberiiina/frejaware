package se.frejaware.WorldGen.Structures;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import se.frejaware.F;

public class FStructureTypes {
	public static final StructureType<FJigsawStructure> FJIGSAW =
			Registry.register(
					BuiltInRegistries.STRUCTURE_TYPE,
					F.id("jigsaw"), () -> FJigsawStructure.CODEC
			);

	public static void init() {}
}