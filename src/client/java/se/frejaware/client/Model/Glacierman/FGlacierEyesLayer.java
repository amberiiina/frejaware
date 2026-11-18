package se.frejaware.client.Model.Glacierman;

import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import se.frejaware.F;

public class FGlacierEyesLayer extends EyesLayer<FGlaciermanRenderState, FGlaciermanModel<FGlaciermanRenderState>> {
	private static final RenderType GLACIERMAN_EYES = RenderTypes.eyes(F.id("textures/entity/glacierman/glacierman_eyes.png"));

	public FGlacierEyesLayer(final RenderLayerParent<FGlaciermanRenderState, FGlaciermanModel<FGlaciermanRenderState>> renderer) {
		super(renderer);
	}

	public RenderType renderType() {
		return GLACIERMAN_EYES;
	}
}
