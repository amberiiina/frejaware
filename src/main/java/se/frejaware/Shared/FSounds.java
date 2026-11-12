package se.frejaware.Shared;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import se.frejaware.F;

public class FSounds {
	public static final SoundEvent MUSIC_DISC_RYM = register(
			"music_disc.read_your_mind");

	private static SoundEvent register(String path) {
		return Registry.register(
				BuiltInRegistries.SOUND_EVENT,
				F.id(path),
				SoundEvent.createVariableRangeEvent(
						F.id(path)
				)
		);
	}

	public static void init() {}
}