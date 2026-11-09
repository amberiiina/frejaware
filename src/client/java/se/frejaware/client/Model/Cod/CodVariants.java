package se.frejaware.client.Model.Cod;

import net.minecraft.resources.Identifier;
import se.frejaware.F;

import java.util.Arrays;
import java.util.UUID;

public class CodVariants {
	public static final Identifier[] TEXTURES = {
			null,
			F.id("textures/entity/fish/atlantic_cod.png"),
			F.id("textures/entity/fish/pacific_cod.png"),
			F.id("textures/entity/fish/eastern_cod.png")
	};

	private static final int[] WEIGHTS = { 30, 30, 30, 10 };

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

	private CodVariants() {}
}