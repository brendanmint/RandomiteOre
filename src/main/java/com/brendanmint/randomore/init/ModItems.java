package com.brendanmint.randomore.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

//import com.brendanmint.randomore.Reference;
import com.brendanmint.randomore.items.ItemUnstablePowder;

public class ModItems
{
	public static Item unstablePowder;
	
	public static void init()
	{
		unstablePowder = new ItemUnstablePowder();
	}
	
	public static void register()
	{
		GameRegistry.register(unstablePowder);
	}
	
	public static void registerRenders()
	{
		registerRender(unstablePowder);
	}
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
