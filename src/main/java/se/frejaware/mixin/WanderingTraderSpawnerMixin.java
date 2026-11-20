package se.frejaware.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTraderSpawner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WanderingTraderSpawner.class)
public class WanderingTraderSpawnerMixin {
	@WrapOperation(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I", ordinal = 0))
	private int desertBoost(RandomSource random, int bound, Operation<Integer> original, @Local(argsOnly = true) ServerLevel level, @Local Player player) {
		boolean inDesert = level.getBiome(player.blockPosition()).is(Biomes.DESERT);
		// vanilla is 1-in-10; in deserts make it 1-in-2
		return original.call(random, inDesert ? 2 : bound);
	}
}