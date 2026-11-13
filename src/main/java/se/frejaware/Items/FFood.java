package se.frejaware.Items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;

import java.util.List;

public class FFood {
	// ----------------------
	// FOOD
	// ----------------------

	// BERRIES
	public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties BLACKBERRIES = new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties PINKBERRIES = new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties BLOWBERRIES = new FoodProperties.Builder()
			.nutrition(1)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties BERRY_JUICE_BOTTLE = new FoodProperties.Builder()
			.nutrition(5)
			.saturationModifier(0.4F)
			.alwaysEdible()
			.build();
	public static final FoodProperties JAM = new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();

	// FRUITS
	public static final FoodProperties PEAR = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(0.3F)
			.build();
	public static final FoodProperties GOLDEN_PEAR = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(1.2F)
			.alwaysEdible()
			.build();
	public static final FoodProperties ENCHANTED_GOLDEN_PEAR = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(1.2F)
			.alwaysEdible()
			.build();
	public static final FoodProperties CHERRY = new FoodProperties.Builder()
			.nutrition(2)
			.saturationModifier(0.3F)
			.build();
	public static final FoodProperties ORANGE = new FoodProperties.Builder()
			.nutrition(3)
			.saturationModifier(0.3F)
			.build();
	public static final FoodProperties BANANA = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(0.3F)
			.build();
	public static final FoodProperties SAFFRON_MILK_BOTTLE = new FoodProperties.Builder()
			.nutrition(7)
			.saturationModifier(0.4F)
			.alwaysEdible()
			.build();
	public static final FoodProperties POPPY_SEEDS = new FoodProperties.Builder()
			.nutrition(1)
			.saturationModifier(0.1F)
			.alwaysEdible()
			.build();
	public static final FoodProperties PINEAPPLE = new FoodProperties.Builder()
			.nutrition(5)
			.saturationModifier(0.4F)
			.build();

	// MILK
	public static final FoodProperties MILK_BOTTLE = new FoodProperties.Builder()
			.nutrition(3)
			.saturationModifier(0.3F)
			.alwaysEdible()
			.build();
	public static final FoodProperties MILKSHAKE_BOTTLE = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(0.4F)
			.alwaysEdible()
			.build();
	public static final FoodProperties ICE_CREAM = new FoodProperties.Builder()
			.nutrition(6)
			.saturationModifier(0.4F)
			.build();

	// CHOCOLATE
	public static final FoodProperties COCOA_BUTTER = new FoodProperties.Builder()
			.nutrition(1)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties CHOCOLATE = new FoodProperties.Builder()
			.nutrition(3)
			.saturationModifier(0.1F)
			.build();
	public static final FoodProperties CHOCOLATE_BAR = new FoodProperties.Builder()
			.nutrition(5)
			.saturationModifier(0.2F)
			.build();
	public static final FoodProperties CHOCOLATE_DIPPED_PEAR = new FoodProperties.Builder()
			.nutrition(6)
			.saturationModifier(0.4F)
			.build();
	public static final FoodProperties CHOCOLATE_BOTTLE = new FoodProperties.Builder()
			.nutrition(4)
			.saturationModifier(0.2F)
			.alwaysEdible()
			.build();
	public static final FoodProperties CHOCOLATE_ICE_CREAM = new FoodProperties.Builder()
			.nutrition(7)
			.saturationModifier(0.4F)
			.build();

	// FINISHED FOOD
	public static final FoodProperties FRUIT_SALAD = new FoodProperties.Builder()
			.nutrition(8)
			.saturationModifier(0.6F)
			.build();
	public static final FoodProperties PANCAKE = new FoodProperties.Builder()
			.nutrition(6)
			.saturationModifier(0.4F)
			.build();
	public static final FoodProperties SWEDISH_PANCAKE = new FoodProperties.Builder()
			.nutrition(8)
			.saturationModifier(0.6F)
			.build();

	// ----------------------
	// CONSUMABLE (EFFECTS/DRINK)
	// ----------------------

	// BERRIES
	public static final Consumable BLOWBERRIES_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.POISON, 100, 0)
			))
			.build();
	public static final Consumable BERRY_JUICE_BOTTLE_CONSUMABLE = defaultDrink()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.REGENERATION, 20, 0)
			))
			.build();
	public static final Consumable JAM_CONSUMABLE = defaultDrink()
			.build();


	// FRUITS
	public static final Consumable GOLDEN_PEAR_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
					new MobEffectInstance(MobEffects.REGENERATION, 100, 1),
					new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0)
			)))
			.build();
	public static final Consumable ENCHANTED_GOLDEN_PEAR_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
					new MobEffectInstance(MobEffects.REGENERATION, 400, 1),
					new MobEffectInstance(MobEffects.RESISTANCE, 6000, 0),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0),
					new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3)
			)))
			.build();
	public static final Consumable SAFFRON_MILK_BOTTLE_CONSUMABLE = defaultDrink()
			.onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
					new MobEffectInstance(MobEffects.REGENERATION, 100, 0),
					new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0)
			)))
			.build();
	public static final Consumable POPPY_SEEDS_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
					new MobEffectInstance(MobEffects.LEVITATION, 80, 0),
					new MobEffectInstance(MobEffects.POISON, 200, 0)
			)))
			.build();

	// MILK
	public static final Consumable MILK_BOTTLE_CONSUMABLE = defaultDrink()
			.onConsume(ClearAllStatusEffectsConsumeEffect.INSTANCE)
			.build();
	public static final Consumable MILKSHAKE_BOTTLE_CONSUMABLE = defaultDrink()
			.build();

	// CHOCOLATE
	public static final Consumable COCOA_BUTTER_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.NAUSEA, 200, 0)
			))
			.build();
	public static final Consumable CHOCOLATE_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.NAUSEA, 100, 0)
			))
			.build();
	public static final Consumable CHOCOLATE_BAR_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.SPEED, 40, 2)
			))
			.build();
	public static final Consumable CHOCOLATE_BOTTLE_CONSUMABLE = defaultDrink()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.SPEED, 40, 2)
			))
			.build();

	// FINISHED FOOD
	public static final Consumable FRUIT_SALAD_CONSUMABLE = defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0)
			))
			.build();

	// ----------------------
	// FUNCTIONS
	// ----------------------

	public static Consumable.Builder defaultFood() {
		return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
	}

	public static Consumable.Builder defaultDrink() {
		return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).hasConsumeParticles(false);
	}
}