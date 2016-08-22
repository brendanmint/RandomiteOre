package com.brendanmint.randomore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.brendanmint.randomore.Reference;

public class ItemUnstablePowder extends Item 
{
	public ItemUnstablePowder()
	{
		setCreativeTab(CreativeTabs.MISC);
		setUnlocalizedName(Reference.randOreItems.UNSTABLEPOWDER.getUnlocalisedName());
		setRegistryName(Reference.randOreItems.UNSTABLEPOWDER.getRegistryName());
	}
}
