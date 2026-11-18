package se.frejaware.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.SkullBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.frejaware.Blocks.FBlockEntityTypes;
import se.frejaware.client.Model.FGlaciermanParticle;
import se.frejaware.Shared.FParticles;
import se.frejaware.Blocks.Custom.FSkullBlock;
import se.frejaware.Entities.FEntityTypes;
import se.frejaware.Entities.Custom.FGolem;
import se.frejaware.F;
import se.frejaware.client.Model.FrostbiteCrawler.FFrostbiteCrawlerRenderer;
import se.frejaware.client.Model.Glacierman.FGlaciermanRenderer;
import se.frejaware.client.Model.Glaze.FGlazeRenderer;
import se.frejaware.client.Model.IronBell.FIronBellRenderer;
import se.frejaware.client.Model.FModelLayers;
import se.frejaware.client.Model.Golem.FGolemRenderer;
import se.frejaware.client.Model.Moobloom.FMoobloomRenderer;
import se.frejaware.client.mixin.SkullBlockRendererAccessor;

import java.util.Map;

public class FClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		FModelLayers.init();

		// MOLLY
		BlockEntityRenderers.register(FBlockEntityTypes.IRON_BELL, FIronBellRenderer::new);

		// ENTITIES
		EntityRenderers.register(FEntityTypes.MOOBLOOM, FMoobloomRenderer::new);

		EntityRenderers.register(FEntityTypes.GLAZE, FGlazeRenderer::new);
		EntityRenderers.register(FEntityTypes.GLAZEBALL, ThrownItemRenderer::new);
		EntityRenderers.register(FEntityTypes.GLAZE_SHARD, ThrownItemRenderer::new);

		EntityRenderers.register(FEntityTypes.GLACIERMAN, FGlaciermanRenderer::new);
		ParticleProviderRegistry.getInstance().register(FParticles.GLACIERMAN, FGlaciermanParticle.Provider::new);

		EntityRenderers.register(FEntityTypes.FROSTBITE_CRAWLER, FFrostbiteCrawlerRenderer::new);

		// WOOD
		ParticleProviderRegistry.getInstance().register(FParticles.SNOWFLAKE, FallingLeavesParticle.CherryProvider::new);
		EntityRenderers.register(FEntityTypes.BLUE_SPRUCE_BOAT, context -> new BoatRenderer(context, FModelLayers.BLUE_SPRUCE_BOAT));
		EntityRenderers.register(FEntityTypes.BLUE_SPRUCE_CHEST_BOAT, context -> new BoatRenderer(context, FModelLayers.BLUE_SPRUCE_CHEST_BOAT));
		ParticleProviderRegistry.getInstance().register(FParticles.JACARANDA_LEAVES, FallingLeavesParticle.CherryProvider::new);
		EntityRenderers.register(FEntityTypes.JACARANDA_BOAT, context -> new BoatRenderer(context, FModelLayers.JACARANDA_BOAT));
		EntityRenderers.register(FEntityTypes.JACARANDA_CHEST_BOAT, context -> new BoatRenderer(context, FModelLayers.JACARANDA_CHEST_BOAT));
		ParticleProviderRegistry.getInstance().register(FParticles.PEAR_LEAVES, FallingLeavesParticle.CherryProvider::new);
		EntityRenderers.register(FEntityTypes.PEAR_BOAT, context -> new BoatRenderer(context, FModelLayers.PEAR_BOAT));
		EntityRenderers.register(FEntityTypes.PEAR_CHEST_BOAT, context -> new BoatRenderer(context, FModelLayers.PEAR_CHEST_BOAT));

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
		Map<SkullBlock.Type, Identifier> skins = SkullBlockRendererAccessor.frejaware$getSkinByType();

		skins.put(FSkullBlock.Types.AMETHYST, F.id("textures/entity/golem_head/golem_head_amethyst.png"));
		skins.put(FSkullBlock.Types.COAL, F.id("textures/entity/golem_head/golem_head_coal.png"));
		skins.put(FSkullBlock.Types.DIAMOND, F.id("textures/entity/golem_head/golem_head_diamond.png"));
		skins.put(FSkullBlock.Types.EMERALD, F.id("textures/entity/golem_head/golem_head_emerald.png"));
		skins.put(FSkullBlock.Types.GOLD, F.id("textures/entity/golem_head/golem_head_gold.png"));
		skins.put(FSkullBlock.Types.IRON, F.id("textures/entity/golem_head/golem_head_iron.png"));
		skins.put(FSkullBlock.Types.LAPIS, F.id("textures/entity/golem_head/golem_head_lapis.png"));
		skins.put(FSkullBlock.Types.NETHERITE, F.id("textures/entity/golem_head/golem_head_netherite.png"));
		skins.put(FSkullBlock.Types.REDSTONE, F.id("textures/entity/golem_head/golem_head_redstone.png"));
	}

	private static void registerGolem(EntityType<FGolem> type, String material) {
		Identifier texture = F.id("textures/entity/golem/golem_" + material + ".png");
		EntityRenderers.register(type, context -> new FGolemRenderer(context, texture));
	}
}