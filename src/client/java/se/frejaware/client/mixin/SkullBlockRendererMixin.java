package se.frejaware.client.mixin;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.world.level.block.SkullBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import se.frejaware.Blocks.Custom.FSkullBlock;
import se.frejaware.client.Model.FModelLayers;
import se.frejaware.client.Model.FGolemSkullModel;

@Mixin(SkullBlockRenderer.class)
public class SkullBlockRendererMixin {
	@Inject(method = "createModel", at = @At("HEAD"), cancellable = true)
	private static void frejaware$createGolemModel(
			EntityModelSet modelSet,
			SkullBlock.Type type,
			CallbackInfoReturnable<SkullModelBase> cir
	) {
		if (type instanceof FSkullBlock.Types) {
			cir.setReturnValue(
					new FGolemSkullModel(
							modelSet.bakeLayer(FModelLayers.GOLEM_HEAD)
					)
			);
		}
	}
}