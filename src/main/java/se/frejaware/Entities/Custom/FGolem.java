package se.frejaware.Entities.Custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.level.Level;
import se.frejaware.Entities.FEntityTypes;

public class FGolem extends IronGolem {
	public FGolem(EntityType<? extends FGolem> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createGolemAttributes(FEntityTypes.GolemStats stats) {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, stats.health)
				.add(Attributes.MOVEMENT_SPEED, stats.speed)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
				.add(Attributes.ATTACK_DAMAGE, stats.damage)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}
}