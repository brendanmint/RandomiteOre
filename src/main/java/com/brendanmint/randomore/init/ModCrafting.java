package com.brendanmint.randomore.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting 
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.unstablePowder, 4), "IC","CI",'I',Blocks.IRON_ORE,'C',Items.COAL);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.randomiteore), "UUU", "UOU", "UUU",'U',ModItems.unstablePowder, 'O', Blocks.IRON_ORE);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.randomiteore), "UUU", "UOU", "UUU",'U',ModItems.unstablePowder, 'O', Items.COAL);
		GameRegistry.addSmelting(ModBlocks.randomiteore, new ItemStack(ModBlocks.randomiteorenether), 0.1f);
	}

}
