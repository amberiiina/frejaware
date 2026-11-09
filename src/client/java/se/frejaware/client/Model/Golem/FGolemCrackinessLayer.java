package se.frejaware.client.Model.Golem;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Crackiness;

import java.util.Map;

public class FGolemCrackinessLayer extends RenderLayer<FGolemRenderState, FGolemModel> {
	private static final Map<Crackiness.Level, Identifier> identifiers;

	public FGolemCrackinessLayer(
			final RenderLayerParent<FGolemRenderState, FGolemModel> renderer) {
		super(renderer);
	}

	public void submit(
			final PoseStack poseStack,
			final SubmitNodeCollector submitNodeCollector,
			final int lightCoords,
			final FGolemRenderState state,
			final float yRot,
			final float xRot) {
		if (!state.isInvisible) {
			Crackiness.Level crackiness = state.crackiness;
			if (crackiness != Crackiness.Level.NONE) {
				Identifier damageTexture = identifiers.get(crackiness);
				renderColoredCutoutModel(
						this.getParentModel(),
						damageTexture,
						poseStack,
						submitNodeCollector,
						lightCoords,
						state,
						-1,
						1
				);
			}
		}
	}

	static {
		identifiers = ImmutableMap.of(
				Crackiness.Level.LOW,
				Identifier.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_low.png"),
				Crackiness.Level.MEDIUM,
				Identifier.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_medium.png"),
				Crackiness.Level.HIGH,
				Identifier.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_high.png"));
	}
}
