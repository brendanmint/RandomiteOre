package com.brendanmint.randomore;

import com.brendanmint.randomore.init.ModBlocks;
import com.brendanmint.randomore.init.ModCrafting;
import com.brendanmint.randomore.init.ModItems;
import com.brendanmint.randomore.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTEDMCVERSIONS,guiFactory = Reference.GUIFACTORYLOCATION)
public class RandomOre
{
	@Mod.Instance(Reference.MOD_ID)
	public static RandomOre instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXYCLASS,serverSide = Reference.SERVER_PROXYCLASS)
	public static CommonProxy proxy;
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigHandler.init(e.getSuggestedConfigurationFile());
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent e)
	{
		//MinecraftForge.EVENT_BUS.register(instance);
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModCrafting.register();
		GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.init();
	}
}
