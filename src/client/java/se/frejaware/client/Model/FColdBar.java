package se.frejaware.client.Model;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import se.frejaware.F;
import se.frejaware.StatusBar.FAttachments;

public class FColdBar {
	private static final Identifier CONTAINER = tex("container");
	private static final Identifier FULL = tex("full");
	private static final Identifier HALF = tex("half");

	private static final int ICON = 9; // PNG size, must match your files
	private static final int SPACING = 8; // vanilla heart spacing
	private static final int ICONS = 10;

	private static Identifier tex(String name) {
		return F.id("textures/gui/cold_bar/" + name + ".png");
	}

	public static void init() {
		HudElementRegistry.attachElementAfter(VanillaHudElements.HOTBAR, F.id("cold_bar"), FColdBar::extract);
	}

	private static void extract(GuiGraphicsExtractor g, DeltaTracker delta) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player == null || mc.player.isSpectator() || mc.player.isCreative()) return;

		float value = mc.player.getAttachedOrElse(FAttachments.COLD, 0.0f);
		if (value <= 0.001f) return;

		int units = Math.round(value * ICONS * 2); // 0..20 half-icons

		int left = g.guiWidth() / 2 + 10;

		Player player = mc.player;
		boolean bubbles = player.isEyeInFluid(FluidTags.WATER) || player.getAirSupply() < player.getMaxAirSupply();
		int y = g.guiHeight() - 49 - (bubbles ? 10 : 0);
		if (player.getVehicle() instanceof LivingEntity) y -= 10;

		for (int i = 0; i < ICONS; i++) {
			int x = left + i * SPACING;
			draw(g, CONTAINER, x, y);
			if (units >= i * 2 + 2) draw(g, FULL, x, y);
			else if (units == i * 2 + 1) draw(g, HALF, x, y);
		}
	}

	private static void draw(GuiGraphicsExtractor extractor, Identifier texture, int x, int y) {
		extractor.blit(RenderPipelines.GUI_TEXTURED, texture, x, y, 0, 0, ICON, ICON, ICON, ICON);
	}
}