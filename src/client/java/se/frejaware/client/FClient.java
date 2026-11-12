package se.frejaware.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.SkullBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.frejaware.Blocks.FBlockEntityTypes;
import se.frejaware.Blocks.FParticles;
import se.frejaware.Blocks.Custom.FSkullBlock;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Entities.Custom.FGolem;
import se.frejaware.F;
import se.frejaware.client.Model.IronBell.FIronBellRenderer;
import se.frejaware.client.Model.FModelLayers;
import se.frejaware.client.Model.Golem.FGolemRenderer;
import se.frejaware.client.Model.Moobloom.FMoobloomRenderer;
import se.frejaware.client.mixin.SkullBlockRendererAccessor;

import java.util.Map;

public class FClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(F.MOD_ID);
	private static boolean hasLoggedMainMenu = false;

	@Override
	public void onInitializeClient() {
		FModelLayers.init();

		// MOLLY
		EntityRenderers.register(
				FEntityTypes.MOOBLOOM,
				FMoobloomRenderer::new
		);

		BlockEntityRenderers.register(
				FBlockEntityTypes.IRON_BELL,
				FIronBellRenderer::new
		);

		// JACARANDA
		ParticleProviderRegistry.getInstance().register(
				FParticles.JACARANDA_LEAVES,
				FallingLeavesParticle.CherryProvider::new
		);
		EntityRenderers.register(
				FEntityTypes.JACARANDA_BOAT,
				context -> new BoatRenderer(context, FModelLayers.JACARANDA_BOAT)
		);
		EntityRenderers.register(
				FEntityTypes.JACARANDA_CHEST_BOAT,
				context -> new BoatRenderer(context, FModelLayers.JACARANDA_CHEST_BOAT)
		);

		// PEAR
		ParticleProviderRegistry.getInstance().register(
				FParticles.PEAR_LEAVES,
				FallingLeavesParticle.CherryProvider::new
		);
		EntityRenderers.register(
				FEntityTypes.PEAR_BOAT,
				context -> new BoatRenderer(context, FModelLayers.PEAR_BOAT)
		);
		EntityRenderers.register(
				FEntityTypes.PEAR_CHEST_BOAT,
				context -> new BoatRenderer(context, FModelLayers.PEAR_CHEST_BOAT)
		);

		// GOLEMS
		registerGolem(FEntityTypes.GOLEM_AMETHYST, "amethyst");
		registerGolem(FEntityTypes.GOLEM_COAL, "coal");
		registerGolem(FEntityTypes.GOLEM_DIAMOND, "diamond");
		registerGolem(FEntityTypes.GOLEM_EMERALD, "emerald");
		registerGolem(FEntityTypes.GOLEM_GOLD, "gold");
		registerGolem(FEntityTypes.GOLEM_LAPIS, "lapis");
		registerGolem(FEntityTypes.GOLEM_NETHERITE, "netherite");
		registerGolem(FEntityTypes.GOLEM_REDSTONE, "redstone");

		// GOLEM HEADS
		Map<SkullBlock.Type, Identifier> skins =
				SkullBlockRendererAccessor.frejaware$getSkinByType();

		skins.put(
				FSkullBlock.Types.AMETHYST,
				F.id("textures/entity/golem_head/golem_head_amethyst.png")
		);
		skins.put(
				FSkullBlock.Types.COAL,
				F.id("textures/entity/golem_head/golem_head_coal.png")
		);
		skins.put(
				FSkullBlock.Types.DIAMOND,
				F.id("textures/entity/golem_head/golem_head_diamond.png")
		);
		skins.put(
				FSkullBlock.Types.EMERALD,
				F.id("textures/entity/golem_head/golem_head_emerald.png")
		);
		skins.put(
				FSkullBlock.Types.GOLD,
				F.id("textures/entity/golem_head/golem_head_gold.png")
		);
		skins.put(
				FSkullBlock.Types.IRON,
				F.id("textures/entity/golem_head/golem_head_iron.png")
		);
		skins.put(
				FSkullBlock.Types.LAPIS,
				F.id("textures/entity/golem_head/golem_head_lapis.png")
		);
		skins.put(
				FSkullBlock.Types.NETHERITE,
				F.id("textures/entity/golem_head/golem_head_netherite.png")
		);
		skins.put(
				FSkullBlock.Types.REDSTONE,
				F.id("textures/entity/golem_head/golem_head_redstone.png")
		);

		ScreenEvents.AFTER_INIT.register((
				minecraft, screen, scaledWidth, scaledHeight) -> {
			if (screen instanceof TitleScreen && !hasLoggedMainMenu) {
				hasLoggedMainMenu = true;
				LOGGER.info("Loaded into main menu");
			}
		});
	}

	private static void registerGolem(EntityType<FGolem> type, String material) {
		Identifier texture = F.id("textures/entity/golem/golem_" + material + ".png");
		EntityRenderers.register(type, context -> new FGolemRenderer(context, texture));
	}
}