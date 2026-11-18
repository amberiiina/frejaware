package se.frejaware.client.Model.Glacierman;

import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CarriedBlockLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import se.frejaware.Entities.Custom.FGlacierman;
import se.frejaware.F;
import se.frejaware.client.Model.FModelLayers;

public class FGlaciermanRenderer extends MobRenderer<FGlacierman, FGlaciermanRenderState, FGlaciermanModel<FGlaciermanRenderState>> {
	public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
	private static final Identifier GLACIERMAN_LOCATION = F.id("textures/entity/glacierman/glacierman.png");
	private final RandomSource random = RandomSource.create();
	private final BlockModelResolver blockModelResolver;

	public FGlaciermanRenderer(final EntityRendererProvider.Context context) {
		super(context, new FGlaciermanModel(context.bakeLayer(FModelLayers.GLACIERMAN)), 0.5F);
		this.blockModelResolver = context.getBlockModelResolver();
		this.addLayer(new FGlacierEyesLayer(this));
		this.addLayer(new FCarriedBlockLayer(this));
	}

	public Vec3 getRenderOffset(final FGlaciermanRenderState state) {
		Vec3 offset = super.getRenderOffset(state);
		if (state.isCreepy) {
			double d = 0.02 * (double)state.scale;
			return offset.add(this.random.nextGaussian() * d, 0.0F, this.random.nextGaussian() * d);
		} else {
			return offset;
		}
	}

	public Identifier getTextureLocation(final FGlaciermanRenderState state) {
		return GLACIERMAN_LOCATION;
	}

	public FGlaciermanRenderState createRenderState() {
		return new FGlaciermanRenderState();
	}

	public void extractRenderState(final FGlacierman entity, final FGlaciermanRenderState state, final float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		HumanoidMobRenderer.extractHumanoidRenderState(entity, state, partialTicks, this.itemModelResolver);
		state.isCreepy = entity.isCreepy();
		BlockState carriedBlock = entity.getCarriedBlock();
		if (carriedBlock != null) {
			this.blockModelResolver.update(state.carriedBlock, carriedBlock, BLOCK_DISPLAY_CONTEXT);
		} else {
			state.carriedBlock.clear();
		}
	}
}