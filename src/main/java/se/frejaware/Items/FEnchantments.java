package se.frejaware.Items;

import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import se.frejaware.F;

public class FEnchantments {
	public static final ResourceKey<Enchantment> ICE_SKATER = create("ice_skater");

	public static void bootstrap(final BootstrapContext<Enchantment> context) {
		HolderGetter<Item> items = context.lookup(Registries.ITEM);
		HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

		context.register(ICE_SKATER, Enchantment.enchantment(Enchantment.definition(
				items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
				1, 3,
				Enchantment.dynamicCost(10, 10), Enchantment.dynamicCost(25, 10),
				8, EquipmentSlotGroup.FEET
		)).withEffect(
				EnchantmentEffectComponents.LOCATION_CHANGED,
				new EnchantmentAttributeEffect(
						F.id("enchantment.ice_skater"),
						Attributes.MOVEMENT_SPEED,
						LevelBasedValue.perLevel(0.35f,0.25f),
						AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
				LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, BlockTags.ICE)), new BlockPos(0, -1, 0))
		).build(ICE_SKATER.identifier()));
	}

	private static ResourceKey<Enchantment> create(String name) {
		return ResourceKey.create(Registries.ENCHANTMENT, F.id(name));
	}
}