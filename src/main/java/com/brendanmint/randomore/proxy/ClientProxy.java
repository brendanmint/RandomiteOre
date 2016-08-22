package com.brendanmint.randomore.proxy;

import com.brendanmint.randomore.ConfigHandler;
import com.brendanmint.randomore.init.ModBlocks;
import com.brendanmint.randomore.init.ModItems;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements CommonProxy
{

	@Override
	public void init()
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	}
}
