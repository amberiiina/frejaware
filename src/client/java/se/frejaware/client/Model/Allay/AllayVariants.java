package se.frejaware.client.Model.Allay;

import net.minecraft.resources.Identifier;
import se.frejaware.F;

import java.util.Arrays;
import java.util.UUID;

public class AllayVariants {
	public static final Identifier[] TEXTURES = {
			null,
			F.id("textures/entity/allay/allay_pink.png")
	};

	private static final int[] WEIGHTS = { 50, 50 };

	private static final int TOTAL = Arrays.stream(WEIGHTS).sum();

	public static int pick(UUID uuid) {
		int roll = Math.floorMod(uuid.hashCode(), TOTAL);
		for (int i = 0; i < WEIGHTS.length; i++) {
			if (roll < WEIGHTS[i]) return i;
			roll -= WEIGHTS[i];
		}
		return 0;
	}

	public static Identifier texture(int variant) {
		return TEXTURES[variant];
	}

	private AllayVariants() {}
}