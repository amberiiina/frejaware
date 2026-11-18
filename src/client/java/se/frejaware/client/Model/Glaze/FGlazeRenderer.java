package se.frejaware.client.Model.Glaze;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import se.frejaware.Entities.Custom.FGlaze;
import se.frejaware.F;
import se.frejaware.client.Model.FModelLayers;

public class FGlazeRenderer extends MobRenderer<FGlaze, LivingEntityRenderState, FGlazeModel> {
	private static final Identifier GLAZE_LOCATION = F.id("textures/entity/glaze/glaze.png");

	public FGlazeRenderer(final EntityRendererProvider.Context context) {
		super(context, new FGlazeModel(context.bakeLayer(FModelLayers.GLAZE)), 0.5F);
	}

	protected int getBlockLightLevel(final FGlaze entity, final BlockPos blockPos) {
		return 15;
	}

	public Identifier getTextureLocation(final LivingEntityRenderState state) {
		return GLAZE_LOCATION;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}