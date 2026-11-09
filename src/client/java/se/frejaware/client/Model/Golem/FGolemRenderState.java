package se.frejaware.client.Model.Golem;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.Crackiness;

public class FGolemRenderState extends LivingEntityRenderState {
	public float attackTicksRemaining;
	public int offerFlowerTick;
	public final BlockModelRenderState flowerBlock = new BlockModelRenderState();
	public Crackiness.Level crackiness;

	public FGolemRenderState() {
		this.crackiness = Crackiness.Level.NONE;
	}
}