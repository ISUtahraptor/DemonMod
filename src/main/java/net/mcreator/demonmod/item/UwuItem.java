
package net.mcreator.demonmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.demonmod.DemonmodModElements;

@DemonmodModElements.ModElement.Tag
public class UwuItem extends DemonmodModElements.ModElement {
	@ObjectHolder("demonmod:uwu")
	public static final Item block = null;
	public UwuItem(DemonmodModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, DemonmodModElements.sounds.get(new ResourceLocation("demonmod:nonono")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("uwu");
		}
	}
}
