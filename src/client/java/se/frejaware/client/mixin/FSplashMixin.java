package se.frejaware.client.mixin;

import net.minecraft.client.resources.SplashManager;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(SplashManager.class)
public abstract class FSplashMixin {

	@Shadow
	@Final
	@Mutable
	private List<Component> splashes;

	@Inject(method = "apply", at = @At("TAIL"))
	private void frejaware$addSplashes(
			List<Component> preparations,
			net.minecraft.server.packs.resources.ResourceManager manager,
			net.minecraft.util.profiling.ProfilerFiller profiler,
			CallbackInfo ci
	) {
		List<Component> customSplashes = new ArrayList<>(this.splashes);

		customSplashes.add(Component.literal("Trans rights! 🏳️‍⚧️"));

		this.splashes = List.copyOf(customSplashes);
	}
}