package se.frejaware.client.Model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.model.object.skull.SkullModelBase;

public class FGolemSkullModel extends SkullModelBase {
	private final ModelPart head;

	public FGolemSkullModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition head = root.addOrReplaceChild(
				"head",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-4, -10, -4, 8, 10, 8),
				PartPose.ZERO
		);

		head.addOrReplaceChild(
				"nose",
				CubeListBuilder.create()
						.texOffs(24, 0)
						.addBox(-1, -3, -6, 2, 4, 2),
				PartPose.ZERO
		);

		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	public void setupAnim(SkullModelBase.State state) {
		head.yRot = state.yRot;
		head.xRot = state.xRot;
	}
}