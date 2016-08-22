package com.brendanmint.randomore;

public class Reference
{
	public static final String MOD_ID = "randomore";
	public static final String NAME = "Randomite Ore Mod";
	public static final String VERSION = "1.2.0";
	public static final String ACCEPTEDMCVERSIONS = "[1.10.2]";
	public static final String UPDATE_JSON = "https://raw.githubusercontent.com/brendanmint/RandomiteOre/master/update.json";
	
	public static final String GUIFACTORYLOCATION = "com.brendanmint.randomore.GUI.ConfigGUIFactory";
	public static final String CLIENT_PROXYCLASS = "com.brendanmint.randomore.proxy.ClientProxy";
	public static final String SERVER_PROXYCLASS = "com.brendanmint.randomore.proxy.ServerProxy";
	
	public static enum randOreItems
	{
		UNSTABLEPOWDER("unstablePowder","ItemUnstablePowder");
		private String unlocalisedName;
		private String registryName;
		
		randOreItems(String unlocalisedName,String registryName)
		{
			this.unlocalisedName = unlocalisedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalisedName() 
		{
			return unlocalisedName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
	}
	
	public static enum randOreBlocks
	{
		RANDOMITEORE("randomiteOre","BlockRandomiteOre"),
		RANDOMITEORENETHER("randomiteOreNether","BlockRandomiteOreNether");
		private String unlocalisedName;
		private String registryName;
		
		randOreBlocks(String unlocalisedName,String registryName)
		{
			this.unlocalisedName = unlocalisedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalisedName() 
		{
			return unlocalisedName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
	}
}
