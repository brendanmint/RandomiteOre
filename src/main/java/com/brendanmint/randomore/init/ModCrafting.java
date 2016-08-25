package com.brendanmint.randomore.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting 
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.unstablePowder, 4), "ICI","CIC","ICI",'I',Blocks.IRON_ORE,'C',Items.COAL);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.randomiteore), "IUI", "UCU", "IUI",'U',ModItems.unstablePowder, 'I', Blocks.IRON_ORE, 'C',Items.COAL);
		GameRegistry.addSmelting(ModBlocks.randomiteore, new ItemStack(ModBlocks.randomiteorenether), 0.1f);
	}

}
