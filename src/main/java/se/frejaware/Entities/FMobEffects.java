package se.frejaware.Entities;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import se.frejaware.F;

public class FMobEffects {
	// ----------------------
	// EFFECTS
	// ----------------------

	public static final Holder<MobEffect> FROST_RESISTANCE = createEffect("frost_resistance", new MobEffect(MobEffectCategory.BENEFICIAL, 121081) {});

	// ----------------------
 	// POTIONS
 	// ----------------------

	public static final ResourceKey<Potion> FROST_RESISTANCE_POTION_ID = createPotion("frost_resistance");
	public static final ResourceKey<Potion> FROST_RESISTANCE_POTION_LONG_ID = createPotion("long_frost_resistance");
	public static final ResourceKey<Potion> FROST_RESISTANCE_POTION_STRONG_ID = createPotion("strong_frost_resistance");

	public static final Holder<Potion> FROST_RESISTANCE_POTION = Registry.registerForHolder(BuiltInRegistries.POTION, FROST_RESISTANCE_POTION_ID,
			new Potion("frost_resistance", new MobEffectInstance(FROST_RESISTANCE, 1800, 0)));
	public static final Holder<Potion> FROST_RESISTANCE_POTION_LONG = Registry.registerForHolder(BuiltInRegistries.POTION, FROST_RESISTANCE_POTION_LONG_ID,
			new Potion("frost_resistance", new MobEffectInstance(FROST_RESISTANCE, 3600, 0)));
	public static final Holder<Potion> FROST_RESISTANCE_POTION_STRONG = Registry.registerForHolder(BuiltInRegistries.POTION, FROST_RESISTANCE_POTION_STRONG_ID,
			new Potion("frost_resistance", new MobEffectInstance(FROST_RESISTANCE, 900, 1)));

	// ----------------------
	// METHODS
	// ----------------------

	private static Holder<MobEffect> createEffect(final String name, final MobEffect mobEffect) {
		return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, F.id(name), mobEffect);
	}

	private static ResourceKey<Potion> createPotion(String name) {
		return ResourceKey.create(Registries.POTION, F.id(name));
	}

	public static void init() {}
}