package se.frejaware.client.Model;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.animal.cow.CowModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import se.frejaware.F;
import se.frejaware.client.Model.FrostbiteCrawler.FFrostbiteCrawlerModel;
import se.frejaware.client.Model.Glacierman.FGlaciermanModel;
import se.frejaware.client.Model.Glaze.FGlazeModel;
import se.frejaware.client.Model.IronBell.FIronBellModel;
import se.frejaware.client.Model.IronBell.FIronBellSpecialRenderer;
import se.frejaware.client.Model.Golem.FGolemModel;
import se.frejaware.client.Model.Golem.FGolemSkullModel;

public class FModelLayers {
	// ----------------------
	// MODEL LAYERS
	// ----------------------

	// MOLLY
	public static final ModelLayerLocation IRON_BELL = create("iron_bell/iron_bell_body");

	// ENTITIES
	public static final ModelLayerLocation MOOBLOOM = create("moobloom");
	public static final ModelLayerLocation MOOBLOOM_BABY = create("moobloom_baby");
	public static final ModelLayerLocation GLAZE = create("glaze");
	public static final ModelLayerLocation GLACIERMAN = create("glacierman");
	public static final ModelLayerLocation FROSTBITE_CRAWLER = create("frostbite_crawler");

	// WOOD
	public static final ModelLayerLocation BLUE_SPRUCE_BOAT = create("boat/blue_spruce");
	public static final ModelLayerLocation BLUE_SPRUCE_CHEST_BOAT = create("chest_boat/blue_spruce");
	public static final ModelLayerLocation JACARANDA_BOAT = create("boat/jacaranda");
	public static final ModelLayerLocation JACARANDA_CHEST_BOAT = create("chest_boat/jacaranda");
	public static final ModelLayerLocation PEAR_BOAT = create("boat/pear");
	public static final ModelLayerLocation PEAR_CHEST_BOAT = create("chest_boat/pear");

	// ROSE QUARTZ
	public static final ModelLayerLocation ROSE_QUARTZ_SHIELD = create("rose_quartz_shield");

	// GOLEMS
	public static final ModelLayerLocation GOLEM_HEAD = create("golem_head");
	public static final ModelLayerLocation GOLEM = create("golem");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static ModelLayerLocation create(String name) {
		return new ModelLayerLocation(F.id(name), "main");
	}

	public static void init() {
		// MOLLY
		SpecialModelRenderers.ID_MAPPER.put(F.id("iron_bell"), FIronBellSpecialRenderer.Unbaked.MAP_CODEC);
		ModelLayerRegistry.registerModelLayer(IRON_BELL, FIronBellModel::createBodyLayer);

		// ENTITIES
		ModelLayerRegistry.registerModelLayer(MOOBLOOM, CowModel::createBodyLayer);
		ModelLayerRegistry.registerModelLayer(MOOBLOOM_BABY, CowModel::createBodyLayer);
		ModelLayerRegistry.registerModelLayer(GLAZE, FGlazeModel::createBodyLayer);
		ModelLayerRegistry.registerModelLayer(GLACIERMAN, FGlaciermanModel::createBodyLayer);
		ModelLayerRegistry.registerModelLayer(FROSTBITE_CRAWLER, FFrostbiteCrawlerModel::createBodyLayer);

		// WOOD
		ModelLayerRegistry.registerModelLayer(BLUE_SPRUCE_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(BLUE_SPRUCE_CHEST_BOAT, BoatModel::createChestBoatModel);
		ModelLayerRegistry.registerModelLayer(JACARANDA_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(JACARANDA_CHEST_BOAT, BoatModel::createChestBoatModel);
		ModelLayerRegistry.registerModelLayer(PEAR_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(PEAR_CHEST_BOAT, BoatModel::createChestBoatModel);

		// ROSE QUARTZ
		SpecialModelRenderers.ID_MAPPER.put(F.id("rose_quartz_shield"), FRoseQuartzShieldSpecialRenderer.Unbaked.MAP_CODEC);
		ModelLayerRegistry.registerModelLayer(ROSE_QUARTZ_SHIELD, ShieldModel::createLayer);

		// GOLEMS
		ModelLayerRegistry.registerModelLayer(GOLEM_HEAD, FGolemSkullModel::createLayer);
		ModelLayerRegistry.registerModelLayer(GOLEM, FGolemModel::createBodyLayer);
	}
}