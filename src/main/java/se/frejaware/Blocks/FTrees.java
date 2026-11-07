package se.frejaware.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import se.frejaware.F;
import se.frejaware.WorldGen.FFeatures;

public class FTrees {
	public static final TreeGrower PEAR_GROWER = new TreeGrower(
			"frejaware:pear",
//			WeightedList.of(
//					FFeatures.PEAR_TREE_FEATURE_KEY,
//					FFeatures.PEAR_TREE_UPWARDS_FEATURE_KEY
//			),
			WeightedList.of(
					new Weighted<>(FFeatures.PEAR_TREE_FEATURE_KEY, 1),
					new Weighted<>(FFeatures.PEAR_TREE_UPWARDS_FEATURE_KEY, 1)
			),
			WeightedList.of(),
			WeightedList.of(),
			FFeatures.PEAR_TREE_FEATURE_KEY
	);

	public static final BlockSetType PEAR_SET = new BlockSetType(
			"pear",
			true,
			true,
			true,
			BlockSetType.PressurePlateSensitivity.EVERYTHING,
			SoundType.CHERRY_WOOD,
			SoundEvents.CHERRY_WOOD_DOOR_CLOSE,
			SoundEvents.CHERRY_WOOD_DOOR_OPEN,
			SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE,
			SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN,
			SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
			SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
			SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF,
			SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON
	);

	public static final WoodType PEAR_WOOD = WoodTypeBuilder
			.copyOf(WoodType.CHERRY)
			.build(F.id("pear"), PEAR_SET);

//	public static final WoodType PEAR_WOOD = new WoodType(
//			"pear",
//			PEAR_SET,
//			SoundType.CHERRY_WOOD,
//			SoundType.CHERRY_WOOD_HANGING_SIGN,
//			SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
//			SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
//	);
}