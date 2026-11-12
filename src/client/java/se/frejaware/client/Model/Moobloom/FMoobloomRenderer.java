package se.frejaware.client.Model.Moobloom;

import com.google.common.collect.Maps;
import net.minecraft.client.model.animal.cow.BabyCowModel;
import net.minecraft.client.model.animal.cow.CowModel;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import se.frejaware.Entities.Custom.FMoobloom;
import se.frejaware.F;
import se.frejaware.client.Model.FModelLayers;

import java.util.Map;

public class FMoobloomRenderer extends AgeableMobRenderer<FMoobloom, FMoobloomRenderState, CowModel> {
	public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT =
			BlockDisplayContext.create();

	private static final Map<FMoobloom.Variant, FMoobloomRenderer.MoobloomTexture> TEXTURES =
			Util.make(Maps.newHashMap(), (map) -> {
				map.put(FMoobloom.Variant.YELLOW, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_yellow.png"),
						F.id("textures/entity/cow/moobloom_yellow_baby.png")
				));
				map.put(FMoobloom.Variant.PINK, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_pink.png"),
						F.id("textures/entity/cow/moobloom_pink_baby.png")
				));
				map.put(FMoobloom.Variant.BLUE, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_blue.png"),
						F.id("textures/entity/cow/moobloom_blue_baby.png")
				));
				map.put(FMoobloom.Variant.PURPLE, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_purple.png"),
						F.id("textures/entity/cow/moobloom_purple_baby.png")
				));
				map.put(FMoobloom.Variant.BLACK, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_black.png"),
						F.id("textures/entity/cow/moobloom_black_baby.png")
				));
				map.put(FMoobloom.Variant.RED, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_red.png"),
						F.id("textures/entity/cow/moobloom_red_baby.png")
				));
				map.put(FMoobloom.Variant.WHITE, new FMoobloomRenderer.MoobloomTexture(
						F.id("textures/entity/cow/moobloom_white.png"),
						F.id("textures/entity/cow/moobloom_white_baby.png")
				));
			});

	private final BlockModelResolver blockModelResolver;

	public FMoobloomRenderer(final EntityRendererProvider.Context context) {
		super(context,
				new CowModel(context.bakeLayer(FModelLayers.MOOBLOOM)),
				new BabyCowModel(context.bakeLayer(FModelLayers.MOOBLOOM_BABY)),
				0.7F
		);
		this.blockModelResolver = context.getBlockModelResolver();
		this.addLayer(new FMoobloomFlowerLayer(this));
	}

	public Identifier getTextureLocation(final FMoobloomRenderState state) {
		return state.isBaby ? TEXTURES.get(state.variant)
				.baby : TEXTURES.get(state.variant).adult;
	}

	public FMoobloomRenderState createRenderState() {
		return new FMoobloomRenderState();
	}

	public void extractRenderState(
			final FMoobloom entity,
			final FMoobloomRenderState state,
			final float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		this.blockModelResolver.update(
				state.flowerModel, state.variant.getBlockState(), BLOCK_DISPLAY_CONTEXT
		);
	}

	private record MoobloomTexture(Identifier adult, Identifier baby) {}
}
