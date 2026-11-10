package se.frejaware.client.Model.Parrot;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.parrot.Parrot;
import se.frejaware.F;

public final class ParrotVariants {
	public static final String[] NAMES = {"conure", "galah"};

	public static Identifier texture(Parrot.Variant variant) {
		String name = variant.getSerializedName();
		for (String n : NAMES) {
			if (n.equals(name)) {
				return F.id("textures/entity/parrot/parrot_" + n + ".png");
			}
		}
		return null;
	}

	public static Parrot.Variant get(String name) {
		return Parrot.Variant.valueOf(name.toUpperCase(java.util.Locale.ROOT));
	}
}