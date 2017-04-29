package com.brendanmint.randomore.GUI;

import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import java.util.Set;

public class ConfigGUIFactory implements IModGuiFactory
{

	@Override
	public void initialize(Minecraft minecraftInstance) {
		// TODO Auto-generated method stub	
	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return ConfigGUI.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("deprecation")
	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		// TODO Auto-generated method stub
		return null;
	}

  @Override
  public boolean hasConfigGui() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public GuiScreen createConfigGui(GuiScreen parentScreen) {
    // TODO Auto-generated method stub
    return null;
  }

}
