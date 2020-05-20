package net.mcreator.demonmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.demonmod.item.TheBruhMachineItem;
import net.mcreator.demonmod.DemonmodModElements;

@DemonmodModElements.ModElement.Tag
public class DemonchestbuttonProcedure extends DemonmodModElements.ModElement {
	public DemonchestbuttonProcedure(DemonmodModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Demonchestbutton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(TheBruhMachineItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
