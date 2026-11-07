package se.frejaware.client.Model;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import se.frejaware.F;

public class FModelLayers {
	// ----------------------
	// MODEL LAYERS
	// ----------------------

	public static final ModelLayerLocation PEAR_BOAT =
			create("boat/pear");
	public static final ModelLayerLocation PEAR_CHEST_BOAT =
			create("chest_boat/pear");

	public static final ModelLayerLocation ROSE_QUARTZ_SHIELD =
			create("rose_quartz_shield");

	public static final ModelLayerLocation GOLEM_HEAD =
			create("golem_head");
	public static final ModelLayerLocation GOLEM =
			create("golem");

	// ----------------------
	// FUNCTIONS
	// ----------------------

	private static ModelLayerLocation create(String name) {
		return new ModelLayerLocation(F.id(name), "main");
	}

	public static void registerModelLayers() {
		ModelLayerRegistry.registerModelLayer(
				PEAR_BOAT, BoatModel::createBoatModel
		);
		ModelLayerRegistry.registerModelLayer(
				PEAR_CHEST_BOAT, BoatModel::createChestBoatModel
		);

		SpecialModelRenderers.ID_MAPPER.put(
				F.id("rose_quartz_shield"),
				FRoseQuartzShieldSpecialRenderer.Unbaked.MAP_CODEC
		);
		ModelLayerRegistry.registerModelLayer(
				ROSE_QUARTZ_SHIELD, ShieldModel::createLayer
		);

		ModelLayerRegistry.registerModelLayer(
				GOLEM_HEAD, FGolemSkullModel::createLayer
		);
		ModelLayerRegistry.registerModelLayer(
				GOLEM, FGolemModel::createBodyLayer
		);
	}
}