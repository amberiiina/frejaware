package se.frejaware.client.mixin;

import net.minecraft.client.renderer.entity.CodRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import se.frejaware.client.Model.Cod.CodVariantHolder;
import se.frejaware.client.Model.Cod.CodVariants;

@Mixin(CodRenderer.class)
public abstract class CodRendererMixin {
	@Inject(method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;)Lnet/minecraft/resources/Identifier;",
			at = @At("HEAD"), cancellable = true)
	private void frejaware$texture(LivingEntityRenderState state, CallbackInfoReturnable<Identifier> cir) {
		Identifier tex = CodVariants.texture(((CodVariantHolder) state).frejaware$getVariant());
		if (tex != null) {
			cir.setReturnValue(tex);
		}
	}
}