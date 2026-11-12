package se.frejaware.client.mixin;

import net.minecraft.client.resources.SplashManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(SplashManager.class)
public abstract class SplashMixin {
	@Shadow
	@Mutable
	private List<Component> splashes;

	@Inject(method = "apply", at = @At("TAIL"))
	private void frejaware$addSplashes(
			List<Component> preparations,
			net.minecraft.server.packs.resources.ResourceManager manager,
			net.minecraft.util.profiling.ProfilerFiller profiler,
			CallbackInfo ci
	) {

		List<Component> list = new ArrayList<>();

		splash(list, "Trans rights! ️");
		splash(list, "You are a brat <3 ️");
		splash(list, "Not vanilla - Minecraft and Bed");
		splash(list, "FUCK TRUMP");
		splash(list, "Alexian <333");
		splash(list, "Penis!!");
		splash(list, "Alexian + Freja + Molly");
		splash(list, "Hit me harder, Daddy~~");
		splash(list, "Whip it out!");
		splash(list, "Send bobs and vegana");
		splash(list, "Breed us~");
		splash(list, "Rio!");
		splash(list, "Dio!");
		splash(list, "Iggy!");
		splash(list, "Nördar <333");
		splash(list, "Takashi Yamazaki <333");
		splash(list, "Submissive!");
		splash(list, "Dominant!");
		splash(list, "Switch! (not the console)");
		splash(list, "Stream Kolmat's music!");
		splash(list, "Pillow princess!");
		splash(list, "I'm scared of your browsing history..");
		splash(list, "...Never gonna give you up, Never gonna let you down");
		splash(list, "Alexians kuk <3");
		splash(list, "Ride that dick!");
		splash(list, "BDSM");

		splash(list, "Also try Ark!");
		splash(list, "Also try Dressmaker!");
		splash(list, "Also try Doom!");
		splash(list, "Also try Payday!");
		splash(list, "Also try Raft!");
		splash(list, "Also try The Forest!");
		splash(list, "Also try Stalker!");
		splash(list, "Also try Subnautica!");
		splash(list, "Also try Valheim!");
		splash(list, "Also try Windrose!");
		splash(list, "Also try Wolfenstein!");

		splashes = List.copyOf(list);
	}

	@Unique
	private void splash(List<Component> list, String text) {
		list.add(Component.literal(text).withStyle(Style.EMPTY.withColor(-256)));
	}
}