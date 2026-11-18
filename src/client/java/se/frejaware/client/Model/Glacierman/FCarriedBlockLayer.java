package se.frejaware.client.Model.Glacierman;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class FCarriedBlockLayer extends RenderLayer<FGlaciermanRenderState, FGlaciermanModel<FGlaciermanRenderState>> {
	public FCarriedBlockLayer(final RenderLayerParent<FGlaciermanRenderState, FGlaciermanModel<FGlaciermanRenderState>> renderer) {
		super(renderer);
	}

	public void submit(final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final int lightCoords, final FGlaciermanRenderState state, final float yRot, final float xRot) {
		BlockModelRenderState carriedBlock = state.carriedBlock;
		if (!carriedBlock.isEmpty()) {
			poseStack.pushPose();
			poseStack.translate(0.0F, 0.6875F, -0.75F);
			poseStack.rotateDegrees(Axis.XP, 20.0F);
			poseStack.rotateDegrees(Axis.YP, 45.0F);
			poseStack.translate(0.25F, 0.1875F, 0.25F);
			float s = 0.5F;
			poseStack.scale(-0.5F, -0.5F, 0.5F);
			poseStack.rotateDegrees(Axis.YP, 90.0F);
			carriedBlock.submit(poseStack, submitNodeCollector, lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
			poseStack.popPose();
		}
	}
}
