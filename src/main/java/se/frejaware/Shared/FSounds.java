package se.frejaware.Shared;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import se.frejaware.F;

public class FSounds {
	public static final SoundEvent MUSIC_DISC_RYM = register(
			"music_disc.read_your_mind");
	public static final SoundEvent MUSIC_DISC_GFF = register(
			"music_disc.great_fairy_fountain");

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