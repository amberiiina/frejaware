package se.frejaware.client.Model.Glacierman;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class FGlaciermanRenderState extends HumanoidRenderState {
	public boolean isCreepy;
	public final BlockModelRenderState carriedBlock = new BlockModelRenderState();
}