
package net.mcreator.demonmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.demonmod.DemonmodModElements;

@DemonmodModElements.ModElement.Tag
public class DemonArmorItem extends DemonmodModElements.ModElement {
	@ObjectHolder("demonmod:demon_armorhelmet")
	public static final Item helmet = null;
	@ObjectHolder("demonmod:demon_armorbody")
	public static final Item body = null;
	@ObjectHolder("demonmod:demon_armorlegs")
	public static final Item legs = null;
	@ObjectHolder("demonmod:demon_armorboots")
	public static final Item boots = null;
	public DemonArmorItem(DemonmodModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 6, 5, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "demon_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonmod:textures/models/armor/demon_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("demon_armorhelmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonmod:textures/models/armor/demon_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("demon_armorbody"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonmod:textures/models/armor/demon_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("demon_armorlegs"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "demonmod:textures/models/armor/demon_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("demon_armorboots"));
	}
}
