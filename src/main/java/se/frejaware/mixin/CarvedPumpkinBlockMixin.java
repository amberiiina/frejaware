package se.frejaware.mixin;

import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import se.frejaware.Entities.Custom.FGolemSpawner;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {
	@Inject(method = "getOrCreateIronGolemBase", at = @At("HEAD"), cancellable = true)
	private void frejaware$noIronGolemBase(CallbackInfoReturnable<BlockPattern> cir) {
		cir.setReturnValue(FGolemSpawner.NEVER);
	}

	@Inject(method = "getOrCreateIronGolemFull", at = @At("HEAD"), cancellable = true)
	private void frejaware$noIronGolemFull(CallbackInfoReturnable<BlockPattern> cir) {
		cir.setReturnValue(FGolemSpawner.NEVER);
	}
}