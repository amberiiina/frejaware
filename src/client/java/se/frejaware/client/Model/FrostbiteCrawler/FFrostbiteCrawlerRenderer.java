package se.frejaware.client.Model.FrostbiteCrawler;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import se.frejaware.Entities.Custom.FFrostbiteCrawler;
import se.frejaware.F;
import se.frejaware.client.Model.FModelLayers;

public class FFrostbiteCrawlerRenderer<T extends FFrostbiteCrawler> extends MobRenderer<T, LivingEntityRenderState, FFrostbiteCrawlerModel> {
	private static final Identifier CRAWLER_LOCATION = F.id("textures/entity/frostbite_crawler/frostbite_crawler.png");

	public FFrostbiteCrawlerRenderer(final EntityRendererProvider.Context context) {
		this(context, FModelLayers.FROSTBITE_CRAWLER);
	}

	public FFrostbiteCrawlerRenderer(final EntityRendererProvider.Context context, final ModelLayerLocation model) {
		super(context, new FFrostbiteCrawlerModel(context.bakeLayer(model)), 0.8F);
		this.addLayer(new FFrostbiteCrawlerEyesLayer<>(this));
	}

	protected float getFlipDegrees() {
		return 180.0F;
	}

	public Identifier getTextureLocation(final LivingEntityRenderState state) {
		return CRAWLER_LOCATION;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	public void extractRenderState(final T entity, final LivingEntityRenderState state, final float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}
}
