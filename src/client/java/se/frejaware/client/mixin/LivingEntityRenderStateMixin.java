package se.frejaware.client.mixin;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import se.frejaware.client.Model.Cod.CodVariantHolder;

@Mixin(LivingEntityRenderState.class)
public class LivingEntityRenderStateMixin implements CodVariantHolder {
	@Unique
	private int frejaware$variant;

	@Override public int frejaware$getVariant() {
		return frejaware$variant;
	}
	@Override public void frejaware$setVariant(int v) {
		this.frejaware$variant = v;
	}
}