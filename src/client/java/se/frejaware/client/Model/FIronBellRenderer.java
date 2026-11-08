package se.frejaware.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import se.frejaware.Blocks.Custom.FIronBellBlockEntity;
import se.frejaware.F;

public class FIronBellRenderer implements BlockEntityRenderer<FIronBellBlockEntity, FIronBellRenderState> {
	public static final SpriteId BELL_TEXTURE;
	private final SpriteGetter sprites;
	private final FIronBellModel model;

	public FIronBellRenderer(final BlockEntityRendererProvider.Context context) {
		this.sprites = context.sprites();
		this.model = new FIronBellModel(context.bakeLayer(FModelLayers.IRON_BELL));
	}

	public FIronBellRenderState createRenderState() {
		return new FIronBellRenderState();
	}

	public void extractRenderState(final FIronBellBlockEntity blockEntity, final FIronBellRenderState state, final float partialTicks, final Vec3 cameraPosition, final ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
		BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
		state.ticks = (float)blockEntity.ticks + partialTicks;
		state.shakeDirection = blockEntity.shaking ? blockEntity.clickDirection : null;
	}

	public void submit(final FIronBellRenderState state, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final CameraRenderState camera) {
		FIronBellModel.State modelState = new FIronBellModel.State(state.ticks, state.shakeDirection);
		this.model.setupAnim(modelState);
		submitNodeCollector.submitModel(this.model, modelState, poseStack, state.lightCoords, OverlayTexture.NO_OVERLAY, -1, BELL_TEXTURE, this.sprites, 0);
		if (state.breakProgress != null) {
			submitNodeCollector.order(1).submitCrumblingOverlay(this.model, modelState, poseStack, BELL_TEXTURE.renderType(this.model.renderType()), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
		}
	}

	static {
		BELL_TEXTURE = Sheets.BLOCK_ENTITIES_MAPPER.apply(
				F.id("iron_bell/iron_bell_body")
		);
	}
}
