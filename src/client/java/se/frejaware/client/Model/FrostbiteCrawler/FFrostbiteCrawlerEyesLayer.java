package se.frejaware.client.Model.FrostbiteCrawler;

import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import se.frejaware.F;

public class FFrostbiteCrawlerEyesLayer<M extends FFrostbiteCrawlerModel> extends EyesLayer<LivingEntityRenderState, M> {
	private static final RenderType CRAWLER_EYES = RenderTypes.eyes(F.id("textures/entity/frostbite_crawler/frostbite_crawler_eyes.png"));

	public FFrostbiteCrawlerEyesLayer(final RenderLayerParent<LivingEntityRenderState, M> renderer) {
		super(renderer);
	}

	public RenderType renderType() {
		return CRAWLER_EYES;
	}
}
