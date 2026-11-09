package se.frejaware.client.Model.IronBell;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import org.jspecify.annotations.Nullable;

public class FIronBellRenderState extends BlockEntityRenderState {
	public @Nullable Direction shakeDirection;
	public float ticks;
}
