package se.frejaware.client.Datagen;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import se.frejaware.F;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FLanguageProvider extends FabricLanguageProvider {
	public FLanguageProvider(
			FabricPackOutput output,
			CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, "en_us", registryLookup);
	}

	private static final Map<String, String> BLOCK_OVERRIDES = Map.ofEntries(
			// FOOD
			Map.entry("blackberry_crop", "Blackberries"),
			Map.entry("blowberry_crop", "Blowberries"),
			Map.entry("blueberry_crop", "Blueberries"),
			Map.entry("pinkberry_crop", "Pinkberries"),

			// GOLEM
			Map.entry("golem_head_amethyst", "Amethyst Golem Head"),
			Map.entry("golem_head_coal", "Coal Golem Head"),
			Map.entry("golem_head_diamond", "Diamond Golem Head"),
			Map.entry("golem_head_emerald", "Emerald Golem Head"),
			Map.entry("golem_head_gold", "Gold Golem Head"),
			Map.entry("golem_head_iron", "Iron Golem Head"),
			Map.entry("golem_head_lapis", "Lapis Golem Head"),
			Map.entry("golem_head_netherite", "Netherite Golem Head"),
			Map.entry("golem_head_redstone", "Redstone Golem Head")
	);

	private static final Map<String, String> ITEM_OVERRIDES = Map.ofEntries(
			// FOOD
			Map.entry("chocolate_bottle", "Bottle of Chocolate"),
			Map.entry("milk_bottle", "Bottle of Milk"),
			Map.entry("berry_juice_bottle", "Bottle of Berry Juice"),
			Map.entry("milkshake_bottle", "Bottle of Milkshake"),
			Map.entry("saffron_milk_bottle", "Bottle of Saffron Milk"),

			// ROSE QUARTZ
			Map.entry("rose_quartz_upgrade_smithing_template", "Rose Quartz Upgrade"),

			// GOLEM
			Map.entry("golem_spawn_egg_amethyst", "Amethyst Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_coal", "Coal Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_diamond", "Diamond Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_emerald", "Emerald Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_gold", "Gold Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_lapis", "Lapis Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_netherite", "Netherite Golem Spawn Egg"),
			Map.entry("golem_spawn_egg_redstone", "Redstone Golem Spawn Egg")
	);

	@Override
	public void generateTranslations(
			HolderLookup.Provider registryLookup,
			TranslationBuilder builder
	) {
		Set<String> addedKeys = new HashSet<>();

		// load existing
		InputStream stream = getClass().getResourceAsStream(
				"/assets/frejaware/lang.json"
		);
		if (stream != null) {
			JsonObject existing = JsonParser.parseReader(
					new InputStreamReader(stream, StandardCharsets.UTF_8)
			).getAsJsonObject();

			existing.entrySet().forEach(entry -> {
				String key = entry.getKey();
				builder.add(key, entry.getValue().getAsString());
				addedKeys.add(key);
			});
		}

		// items
		BuiltInRegistries.ITEM.forEach(item -> {
			if (item instanceof BlockItem) return;

			var id = BuiltInRegistries.ITEM.getKey(item);

			if (!id.getNamespace().equals(F.MOD_ID)) return;

			String path = id.getPath();
			String key = item.getDescriptionId();

			if (!addedKeys.add(key)) return;

			builder.add(
					item,
					ITEM_OVERRIDES.getOrDefault(path, toTitleCase(path))
			);
		});

		// blocks
		BuiltInRegistries.BLOCK.forEach(block -> {
			var id = BuiltInRegistries.BLOCK.getKey(block);

			if (!id.getNamespace().equals(F.MOD_ID)) return;

			String path = id.getPath();
			String key = block.getDescriptionId();

			if (!addedKeys.add(key)) return;

			builder.add(
					block,
					BLOCK_OVERRIDES.getOrDefault(path, toTitleCase(path))
			);
		});
	}

	private static String toTitleCase(String path) {
		return Arrays.stream(path.split("_"))
				.filter(word -> !word.isEmpty())
				.map(word -> Character.toUpperCase(word.charAt(0))
						+ word.substring(1))
				.collect(Collectors.joining(" "));
	}

	@Override
	public String getName() {
		return "FLanguageProvider";
	}
}