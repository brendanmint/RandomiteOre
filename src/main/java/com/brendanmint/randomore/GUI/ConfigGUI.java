package com.brendanmint.randomore.GUI;

import java.util.ArrayList;
import java.util.List;

import com.brendanmint.randomore.ConfigHandler;
import com.brendanmint.randomore.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGUI extends GuiConfig
{

	public ConfigGUI(GuiScreen parentScreen) 
	{
		//super(parentScreen, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),"RandomOre",false,false,"Randomite Ore");
		super(parentScreen, getConfigElements(parentScreen),Reference.MOD_ID,false,false,"Randomite Ore Advanced Configuration"); //Menus ^_^
	}
	
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        //list.add(new ConfigElement(ConfigHandler.config.getCategory("BehaviorOverworld".toLowerCase())));
        list.add(categoryElement("behavioroverworld", "Overworld Randomite Ore Behavior", "configGUI.settings.overworld"));
        list.add(categoryElement("behaviornether", "Nether Randomite Ore Behavior", "configGUI.settings.nether"));
        list.add(categoryElement("overworldgen", "Overworld Ore Generation", "configGUI.settings.overworld.generation"));
        list.add(categoryElement("netherworldgen", "Nether Ore Generation", "configGUI.settings.nether.generation"));

        return list;
    }
	
	private static IConfigElement categoryElement(String category, String name, String tooltip_key) 
	{
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key, new ConfigElement(ConfigHandler.config.getCategory(category)).getChildElements());
    }
}
