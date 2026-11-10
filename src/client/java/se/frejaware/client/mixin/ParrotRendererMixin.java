package se.frejaware.client.mixin;

import net.minecraft.client.renderer.entity.ParrotRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.parrot.Parrot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import se.frejaware.F;
import se.frejaware.client.Model.Parrot.ParrotVariants;

@Mixin(ParrotRenderer.class)
public class ParrotRendererMixin {
	@Inject(method = "getVariantTexture", at = @At("HEAD"), cancellable = true)
	private static void frejaware$texture(Parrot.Variant variant, CallbackInfoReturnable<Identifier> cir) {
		Identifier tex = ParrotVariants.texture(variant);
		if (tex != null) cir.setReturnValue(tex);
	}
}