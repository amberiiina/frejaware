package se.frejaware.client.mixin;

import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SkullBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(SkullBlockRenderer.class)
public interface SkullBlockRendererAccessor {
	@Accessor("SKIN_BY_TYPE")
	static Map<SkullBlock.Type, Identifier> frejaware$getSkinByType() {
		throw new AssertionError();
	}
}