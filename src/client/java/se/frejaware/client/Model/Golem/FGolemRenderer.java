package se.frejaware.client.Model.Golem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import se.frejaware.Entities.Custom.FGolem;
import se.frejaware.client.Model.FModelLayers;

public class FGolemRenderer extends MobRenderer<FGolem, FGolemRenderState, FGolemModel> {
	public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
	private final Identifier TEXTURE;
	private final BlockModelResolver blockModelResolver;

	public FGolemRenderer(EntityRendererProvider.Context context, Identifier texture) {
		super(context, new FGolemModel(context.bakeLayer(FModelLayers.GOLEM)), 0.375f); // 0.375 shadow radius
		this.TEXTURE = texture;
		this.blockModelResolver = context.getBlockModelResolver();
		this.addLayer(new FGolemCrackinessLayer(this));
		this.addLayer(new FGolemFlowerLayer(this));
	}

	@Override
	public FGolemRenderState createRenderState() {
		return new FGolemRenderState();
	}

	@Override
	public Identifier getTextureLocation(final FGolemRenderState state) {
		return TEXTURE;
	}

	public void extractRenderState(final FGolem entity, final FGolemRenderState state, final float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.attackTicksRemaining = (float)entity.getAttackAnimationTick() > 0.0F ? (float)entity.getAttackAnimationTick() - partialTicks : 0.0F;
		state.offerFlowerTick = entity.getOfferFlowerTick();
		if (state.offerFlowerTick > 0) {
			this.blockModelResolver.update(state.flowerBlock, Blocks.POPPY.defaultBlockState(), BLOCK_DISPLAY_CONTEXT);
		} else {
			state.flowerBlock.clear();
		}

		state.crackiness = entity.getCrackiness();
	}

	protected void setupRotations(final FGolemRenderState state, final PoseStack poseStack, final float bodyRot, final float entityScale) {
		super.setupRotations(state, poseStack, bodyRot, entityScale);
		if (!((double)state.walkAnimationSpeed < 0.01)) {
			float p = 13.0F;
			float wp = state.walkAnimationPos + 6.0F;
			float triangleWave = (Math.abs(wp % 13.0F - 6.5F) - 3.25F) / 3.25F;
			poseStack.rotateDegrees(Axis.ZP, 6.5F * triangleWave);
		}
	}
}