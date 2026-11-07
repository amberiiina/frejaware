package se.frejaware.Shared;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import se.frejaware.F;

public class FItemTags {
	// FOOD
	public static final TagKey<Item> FRUIT_SALAD_INGREDIENTS = TagKey.create(
			BuiltInRegistries.ITEM.key(),
			F.id("fruit_salad_ingredients")
	);

	// PEAR
	public static final TagKey<Item> PEAR_LOGS = TagKey.create(
			BuiltInRegistries.ITEM.key(),
			F.id("pear_logs")
	);

	// TRANSIUM
	public static final TagKey<Item> REPAIRS_TRANSIUM = TagKey.create(
			BuiltInRegistries.ITEM.key(),
			F.id("repairs_transium")
	);

	// ROSE QUARTZ
	public static final TagKey<Item> REPAIRS_ROSE_QUARTZ = TagKey.create(
			BuiltInRegistries.ITEM.key(),
			F.id("repairs_rose_quartz")
	);
}