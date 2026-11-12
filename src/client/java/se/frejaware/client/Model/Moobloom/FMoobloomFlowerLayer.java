package se.frejaware.client.Model.Moobloom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.animal.cow.CowModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public class FMoobloomFlowerLayer extends RenderLayer<FMoobloomRenderState, CowModel> {
	public FMoobloomFlowerLayer(
			final RenderLayerParent<FMoobloomRenderState, CowModel> renderer) {
		super(renderer);
	}

	public void submit(
			final PoseStack poseStack,
			final SubmitNodeCollector submitNodeCollector,
			final int lightCoords,
			final FMoobloomRenderState state,
			final float yRot, final float xRot) {
		if (!state.isBaby && !state.flowerModel.isEmpty()) {
			boolean appearsGlowingWithInvisibility =
					state.appearsGlowing() && state.isInvisible;
			if (!state.isInvisible || appearsGlowingWithInvisibility) {
				int overlayCoords = LivingEntityRenderer.getOverlayCoords(
						state, 0.0F
				);
				poseStack.pushPose();
				poseStack.translate(0.2F, -0.35F, 0.5F);
				poseStack.rotateDegrees(Axis.YP, -48.0F);
				poseStack.scale(-1.0F, -1.0F, 1.0F);
				poseStack.translate(-0.5F, -0.5F, -0.5F);

				this.submitFlowerBlock(
						poseStack, submitNodeCollector,
						lightCoords, appearsGlowingWithInvisibility,
						state.outlineColor, state.flowerModel, overlayCoords
				);
				poseStack.popPose();
				poseStack.pushPose();
				poseStack.translate(0.2F, -0.35F, 0.5F);
				poseStack.rotateDegrees(Axis.YP, 42.0F);
				poseStack.translate(0.1F, 0.0F, -0.6F);
				poseStack.rotateDegrees(Axis.YP, -48.0F);
				poseStack.scale(-1.0F, -1.0F, 1.0F);
				poseStack.translate(-0.5F, -0.5F, -0.5F);

				this.submitFlowerBlock(
						poseStack, submitNodeCollector,
						lightCoords, appearsGlowingWithInvisibility,
						state.outlineColor, state.flowerModel, overlayCoords
				);
				poseStack.popPose();
				poseStack.pushPose();
				this.getParentModel().getHead().translateAndRotate(poseStack);
				poseStack.translate(0.0F, -0.7F, -0.2F);
				poseStack.rotateDegrees(Axis.YP, -78.0F);
				poseStack.scale(-1.0F, -1.0F, 1.0F);
				poseStack.translate(-0.5F, -0.5F, -0.5F);

				this.submitFlowerBlock(
						poseStack, submitNodeCollector,
						lightCoords, appearsGlowingWithInvisibility,
						state.outlineColor, state.flowerModel, overlayCoords
				);
				poseStack.popPose();
			}
		}
	}

	private void submitFlowerBlock(
			final PoseStack poseStack,
			final SubmitNodeCollector submitNodeCollector,
			final int lightCoords,
			final boolean appearsGlowingWithInvisibility,
			final int outlineColor,
			final BlockModelRenderState flowerModel,
			final int overlayCoords) {
		if (appearsGlowingWithInvisibility) {
			flowerModel.submitOnlyOutline(
					poseStack, submitNodeCollector,
					lightCoords, overlayCoords, outlineColor
			);
		} else {
			flowerModel.submit(
					poseStack, submitNodeCollector,
					lightCoords, overlayCoords, outlineColor
			);
		}
	}
}