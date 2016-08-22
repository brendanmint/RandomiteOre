package com.brendanmint.randomore.init;

import com.brendanmint.randomore.blocks.BlockRandomite;
import com.brendanmint.randomore.blocks.BlockRandomiteNether;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block randomiteore;
	public static Block randomiteorenether;
	
	public static void init()
	{
		randomiteore = new BlockRandomite();
		randomiteorenether = new BlockRandomiteNether();
	}
	
	public static void register()
	{
		registerBlock(randomiteore);
		registerBlock(randomiteorenether);
	}
	
	private static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(randomiteore);
		registerRender(randomiteorenether);
	}
	
	private static void registerRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
