package se.frejaware.Items.Custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import se.frejaware.F;

import java.util.List;

public class FSmithingTemplateItem extends SmithingTemplateItem {
	public FSmithingTemplateItem(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<Identifier> baseSlotEmptyIcons, List<Identifier> additionalSlotEmptyIcons, Properties properties) {
		super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties);
	}

	private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
	private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("container/slot/helmet");
	private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("container/slot/chestplate");
	private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("container/slot/leggings");
	private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("container/slot/boots");
	private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("container/slot/hoe");
	private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
	private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
	private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
	private static final Identifier EMPTY_SLOT_SPEAR = Identifier.withDefaultNamespace("container/slot/spear");
	private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
	private static final Identifier EMPTY_SLOT_NAUTILUS_ARMOR = Identifier.withDefaultNamespace("container/slot/nautilus_armor");
	private static final Identifier EMPTY_SLOT_ROSE_QUARTZ = F.id("container/slot/rose_quartz");

	private static final Component ROSE_QUARTZ_UPGRADE_APPLIES_TO = Component.translatable(
					Util.makeDescriptionId("item", F.id("smithing_template.rose_quartz_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMAT);
	private static final Component ROSE_QUARTZ_UPGRADE_INGREDIENTS = Component.translatable(
					Util.makeDescriptionId("item", F.id("smithing_template.rose_quartz_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMAT);
	private static final Component ROSE_QUARTZ_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
			Util.makeDescriptionId("item", F.id("smithing_template.rose_quartz_upgrade.base_slot_description"))
	);
	private static final Component ROSE_QUARTZ_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
			Util.makeDescriptionId("item", F.id("smithing_template.rose_quartz_upgrade.additions_slot_description"))
	);

	public static SmithingTemplateItem createRoseQuartzUpgradeTemplate(final Item.Properties properties) {
		return new SmithingTemplateItem(
				ROSE_QUARTZ_UPGRADE_APPLIES_TO,
				ROSE_QUARTZ_UPGRADE_INGREDIENTS,
				ROSE_QUARTZ_UPGRADE_BASE_SLOT_DESCRIPTION,
				ROSE_QUARTZ_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
				createRoseQuartzUpgradeIconList(),
				createRoseQuartzUpgradeMaterialList(),
				properties
		);
	}

	private static List<Identifier> createRoseQuartzUpgradeIconList() {
		return List.of(
				EMPTY_SLOT_HELMET,
				EMPTY_SLOT_SWORD,
				EMPTY_SLOT_CHESTPLATE,
				EMPTY_SLOT_PICKAXE,
				EMPTY_SLOT_LEGGINGS,
				EMPTY_SLOT_AXE,
				EMPTY_SLOT_BOOTS,
				EMPTY_SLOT_HOE,
				EMPTY_SLOT_SHOVEL,
				EMPTY_SLOT_NAUTILUS_ARMOR,
				EMPTY_SLOT_SPEAR
		);
	}

	private static List<Identifier> createRoseQuartzUpgradeMaterialList() {
		return List.of(EMPTY_SLOT_ROSE_QUARTZ);
	}
}