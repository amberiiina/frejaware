package se.frejaware.StatusBar;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LightLayer;
import se.frejaware.Entities.FMobEffects;
import se.frejaware.WorldGen.Biome.FBiomes;

public class FColdLogic {
	private static final float RATE = 1.0f / (30 * 20); // 30 sec to full
	private static final float PER_PIECE = 0.2f;

	public static void init() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayer p : server.getPlayerList().getPlayers()) tick(p);
		});
	}

	private static void tick(ServerPlayer player) {
		if (player.isSpectator() || player.isCreative() || !player.isAlive()) {
			player.setAttached(FAttachments.COLD, 0.0f);
			return;
		}
		ServerLevel level = player.level();
		BlockPos pos = player.blockPosition();

		// calculate change
		float value = player.getAttachedOrElse(FAttachments.COLD, 0.0f);
		float mult = 1.0f;

		if (!level.getBiome(pos).is(FBiomes.ARCTIC)) mult -= 2.0f;
		if (isNight(level)) mult += 1.0f;
		if (level.getBrightness(LightLayer.BLOCK, pos) >= 12) mult -= 0.25f;
		if (player.isInWaterOrRain()) mult += 1.5f;
		if (player.hasEffect(FMobEffects.FROST_RESISTANCE)) mult -= player.getEffect(FMobEffects.FROST_RESISTANCE).getAmplifier() + 0.5f;
		mult -= protectivePieces(player);
		if (protectivePieces(player) == PER_PIECE * 4) mult -= 0.5f;

		float change = RATE * mult;
		value = Math.min(1.0f, value + change);
		player.setAttached(FAttachments.COLD, value);

		// freezing effect
		int required = player.getTicksRequiredToFreeze();
		boolean full = value >= 1.0f;

		float t = Math.max(0f, (value - 0.4f) / 0.6f);
		int frozen = full ? required : Math.min((int) (t * required), required - 1);
		player.setTicksFrozen(frozen);

		// damage
		if (full && player.tickCount % 40 == 0) {
			player.hurtServer(level, player.damageSources().freeze(), 1f);
		}
	}

	public static boolean isNight(ServerLevel level) {
		long timeOfDay = level.getOverworldClockTime() % 24000L;
		return timeOfDay >= 13000L && timeOfDay < 23000L;
	}

	private static float protectivePieces(ServerPlayer player) {
		float value = 0.0f;

		// swap for fur armor
		if (player.getItemBySlot(EquipmentSlot.HEAD).is(Items.LEATHER_HELMET)) value += PER_PIECE;
		if (player.getItemBySlot(EquipmentSlot.CHEST).is(Items.LEATHER_CHESTPLATE)) value += PER_PIECE;
		if (player.getItemBySlot(EquipmentSlot.LEGS).is(Items.LEATHER_LEGGINGS)) value += PER_PIECE;
		if (player.getItemBySlot(EquipmentSlot.FEET).is(Items.LEATHER_BOOTS)) value += PER_PIECE;

		return value;
	}
}