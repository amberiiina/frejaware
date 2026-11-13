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
	// PEAR
	public static final TreeGrower PEAR_GROWER = new TreeGrower(
			"frejaware:pear",
			WeightedList.of(FFeatures.PEAR_TREE),
			WeightedList.of(),
			WeightedList.of(),
			FFeatures.PEAR_TREE
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

	// JACARANDA
	public static final TreeGrower JACARANDA_GROWER = new TreeGrower(
			"frejaware:jacaranda",
			WeightedList.of(FFeatures.JACARANDA_TREE),
			WeightedList.of(),
			WeightedList.of(),
			FFeatures.JACARANDA_TREE
	);
	public static final BlockSetType JACARANDA_SET = new BlockSetType(
			"jacaranda",
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
	public static final WoodType JACARANDA_WOOD = WoodTypeBuilder
			.copyOf(WoodType.CHERRY)
			.build(F.id("jacaranda"), JACARANDA_SET);

	// ORANGE
	public static final TreeGrower ORANGE_GROWER = new TreeGrower(
			"frejaware:orange",
			WeightedList.of(FFeatures.ORANGE_TREE),
			WeightedList.of(),
			WeightedList.of(),
			FFeatures.ORANGE_TREE
	);
}