package se.frejaware.client.Model.Moobloom;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import se.frejaware.Entities.Custom.FMoobloom;

public class FMoobloomRenderState extends LivingEntityRenderState {
	public FMoobloom.Variant variant;
	public final BlockModelRenderState flowerModel;

	public FMoobloomRenderState() {
		this.variant = FMoobloom.Variant.YELLOW;
		this.flowerModel = new BlockModelRenderState();
	}
}