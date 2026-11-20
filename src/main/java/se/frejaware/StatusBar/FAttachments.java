package se.frejaware.StatusBar;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.codec.ByteBufCodecs;
import se.frejaware.F;

public class FAttachments {
	public static final AttachmentType<Float> COLD = AttachmentRegistry.create(
			F.id("cold"),
			b -> b.initializer(() -> 0.0f)
					.persistent(Codec.FLOAT)
					.syncWith(ByteBufCodecs.FLOAT, AttachmentSyncPredicate.targetOnly())
	);

	public static void init() {}
}