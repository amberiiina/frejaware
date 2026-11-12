package se.frejaware.client.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.fish.Cod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import se.frejaware.client.Model.Allay.AllayVariantHolder;
import se.frejaware.client.Model.Allay.AllayVariants;
import se.frejaware.client.Model.Cod.CodVariantHolder;
import se.frejaware.client.Model.Cod.CodVariants;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
	@Inject(method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
			at = @At("TAIL"))
	private void frejaware$extract(
			LivingEntity entity,
			LivingEntityRenderState state,
			float partialTick, CallbackInfo ci) {
		if (entity instanceof Cod) {
			((CodVariantHolder) state).frejaware$setVariant(
					CodVariants.pick(entity.getUUID())
			);
		} else if (entity instanceof Allay) {
			((AllayVariantHolder) state).frejaware$setVariant(
					AllayVariants.pick(entity.getUUID())
			);
		}
	}
}