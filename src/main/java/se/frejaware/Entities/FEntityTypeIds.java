package se.frejaware.Entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import se.frejaware.F;

public class FEntityTypeIds {
	// ----------------------
	// ENTITY IDS
	// ----------------------

	// MOLLY
	public static final ResourceKey<EntityType<?>> MOOBLOOM = create("moobloom");
	public static final ResourceKey<EntityType<?>> GLAZE = create("glaze");
	public static final ResourceKey<EntityType<?>> GLAZEBALL = create("glazeball");
	public static final ResourceKey<EntityType<?>> GLAZE_SHARD = create("glaze_shard");
	public static final ResourceKey<EntityType<?>> GLACIERMAN = create("glacierman");
	public static final ResourceKey<EntityType<?>> FROSTBITE_CRAWLER = create("frostbite_crawler");

	// PEAR
	public static ResourceKey<EntityType<?>> BLUE_SPRUCE_BOAT = create("blue_spruce_boat");
	public static ResourceKey<EntityType<?>> BLUE_SPRUCE_CHEST_BOAT = create("blue_spruce_chest_boat");

	// PEAR
	public static ResourceKey<EntityType<?>> JACARANDA_BOAT = create("jacaranda_boat");
	public static ResourceKey<EntityType<?>> JACARANDA_CHEST_BOAT = create("jacaranda_chest_boat");

	// PEAR
	public static ResourceKey<EntityType<?>> PEAR_BOAT = create("pear_boat");
	public static ResourceKey<EntityType<?>> PEAR_CHEST_BOAT = create("pear_chest_boat");

	// GOLEM
	public static ResourceKey<EntityType<?>> GOLEM_AMETHYST = create("golem_amethyst");
	public static ResourceKey<EntityType<?>> GOLEM_COAL = create("golem_coal");
	public static ResourceKey<EntityType<?>> GOLEM_DIAMOND = create("golem_diamond");
	public static ResourceKey<EntityType<?>> GOLEM_EMERALD = create("golem_emerald");
	public static ResourceKey<EntityType<?>> GOLEM_GOLD = create("golem_gold");
	public static ResourceKey<EntityType<?>> GOLEM_LAPIS = create("golem_lapis");
	public static ResourceKey<EntityType<?>> GOLEM_NETHERITE = create("golem_netherite");
	public static ResourceKey<EntityType<?>> GOLEM_REDSTONE = create("golem_redstone");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static ResourceKey<EntityType<?>> create(String name) {
		return ResourceKey.create(Registries.ENTITY_TYPE, F.id(name));
	}
}