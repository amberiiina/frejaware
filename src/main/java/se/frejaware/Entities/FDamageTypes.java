package se.frejaware.Entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import se.frejaware.F;

public class FDamageTypes {
	public static final ResourceKey<DamageType> GLAZEBALL = ResourceKey.create(Registries.DAMAGE_TYPE, F.id("glazeball"));
	public static final ResourceKey<DamageType> GLAZE_SHARD = ResourceKey.create(Registries.DAMAGE_TYPE, F.id("glaze_shard"));

	public static DamageSource glazeball(Level level, Entity projectile, @Nullable Entity owner) {
		return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(GLAZEBALL), projectile, owner);
	}
	public static DamageSource glaze_shard(Level level, Entity projectile, @Nullable Entity owner) {
		return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(GLAZE_SHARD), projectile, owner);
	}
}