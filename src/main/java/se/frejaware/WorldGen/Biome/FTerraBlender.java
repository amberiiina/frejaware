package se.frejaware.WorldGen.Biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import se.frejaware.F;
import terrablender.api.MaterialRuleManager;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class FTerraBlender implements TerraBlenderApi {
	private static final ResourceKey<MaterialRule> ARCTIC_SNOW = ResourceKey.create(Registries.MATERIAL_RULE, F.id("arctic_surface"));

	@Override
	public void onTerraBlenderInitialized() {
		MaterialRuleManager.addRules(MaterialRuleManager.RuleCategory.OVERWORLD, "frejaware", ARCTIC_SNOW);

		Regions.register(new FPearMeadowRegion());
		Regions.register(new FJacarandaGladeRegion());
		Regions.register(new FOrchardRegion());
		Regions.register(new FArcticRegion());

		F.LOGGER.info("TerraBlender Initialized");
	}
}