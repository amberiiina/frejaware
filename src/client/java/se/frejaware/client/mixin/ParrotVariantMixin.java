package se.frejaware.client.mixin;

import net.minecraft.world.entity.animal.parrot.Parrot;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import se.frejaware.client.Model.Parrot.ParrotVariants;

@Mixin(Parrot.Variant.class)
public abstract class ParrotVariantMixin {
	@Shadow @Final @Mutable
	private static Parrot.Variant[] $VALUES;

	@Invoker("<init>")
	private static Parrot.Variant frejaware$create(String enumName, int ordinal, int id, String name) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>",
			at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, shift = At.Shift.AFTER,
					target = "Lnet/minecraft/world/entity/animal/parrot/Parrot$Variant;$VALUES:[Lnet/minecraft/world/entity/animal/parrot/Parrot$Variant;"))
	private static void frejaware$addVariants(CallbackInfo ci) {
		Parrot.Variant[] old = $VALUES;
		String[] names = ParrotVariants.NAMES;
		Parrot.Variant[] extended = java.util.Arrays.copyOf(old, old.length + names.length);
		for (int i = 0; i < names.length; i++) {
			int index = old.length + i;
			extended[index] = frejaware$create(names[i].toUpperCase(java.util.Locale.ROOT), index, index, names[i]);
		}
		$VALUES = extended;
	}
}