package se.frejaware.Items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import se.frejaware.F;
import se.frejaware.Shared.FBlockTags;
import se.frejaware.Shared.FItemTags;

import java.util.Map;

public class FMaterials {
	// ----------------------
	// TOOLS
	// ----------------------

	// TRANSIUM
	public static final ToolMaterial TRANSIUM_TOOL_MATERIAL = new ToolMaterial(
			FBlockTags.INCORRECT_FOR_TRANSIUM_TOOL,
			1561,
			8.0F,
			3.0F,
			10,
			FItemTags.REPAIRS_TRANSIUM
	);

	// ROSE QUARTZ
	public static final ToolMaterial ROSE_QUARTZ_TOOL_MATERIAL = new ToolMaterial(
			FBlockTags.INCORRECT_FOR_ROSE_QUARTZ_TOOL,
			1091,
			12.0F,
			5.0F,
			25,
			FItemTags.REPAIRS_ROSE_QUARTZ
	);

	// ----------------------
	// ARMOR
	// ----------------------

	// TRANSIUM
	public static final ResourceKey<EquipmentAsset> TRANSIUM_ARMOR_MATERIAL_KEY = ResourceKey.create(
			EquipmentAssets.ROOT_ID, F.id("transium"));
	public static final ArmorMaterial TRANSIUM_ARMOR_MATERIAL = new ArmorMaterial(
			33,
			Map.of(
					ArmorType.HELMET, 3,
					ArmorType.CHESTPLATE, 8,
					ArmorType.LEGGINGS, 6,
					ArmorType.BOOTS, 3,
					ArmorType.BODY, 11
			),
			10,
			SoundEvents.ARMOR_EQUIP_DIAMOND,
			2.0F,
			0.0F,
			FItemTags.REPAIRS_TRANSIUM,
			TRANSIUM_ARMOR_MATERIAL_KEY
	);

	// ROSE QUARTZ
	public static final ResourceKey<EquipmentAsset> ROSE_QUARTZ_ARMOR_MATERIAL_KEY = ResourceKey.create(
			EquipmentAssets.ROOT_ID, F.id("rose_quartz"));
	public static final ArmorMaterial ROSE_QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(
			33,
			Map.of(
					ArmorType.HELMET, 3,
					ArmorType.CHESTPLATE, 8,
					ArmorType.LEGGINGS, 6,
					ArmorType.BOOTS, 3,
					ArmorType.BODY, 20
			),
			25,
			SoundEvents.ARMOR_EQUIP_NETHERITE,
			3.0F,
			0.1F,
			FItemTags.REPAIRS_ROSE_QUARTZ,
			ROSE_QUARTZ_ARMOR_MATERIAL_KEY
	);
}