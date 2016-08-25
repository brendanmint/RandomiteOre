package com.brendanmint.randomore.blocks;

import java.util.Random;

import com.brendanmint.randomore.ConfigHandler;
import com.brendanmint.randomore.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRandomite extends Block{

	private static String oreDrop = "None";
	private static int rando;
	private static String[] oreHold = {"dye","5"};
	private static int oreMeta;
	
	public BlockRandomite() 
	{
		super(Material.ROCK);
		
		setHarvestLevel("pickaxe", 2);
		setHardness(3.0f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		setUnlocalizedName(Reference.randOreBlocks.RANDOMITEORE.getUnlocalisedName());
		setRegistryName(Reference.randOreBlocks.RANDOMITEORE.getRegistryName());
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		if(ConfigHandler.randomiteStable) rando = RANDOM.nextInt(101);
		oreMeta = 0;
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(ConfigHandler.randomiteStable)
		{
			if(rando < 25)
			{
				oreDrop = "minecraft:coal";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 25 && rando < 50)
			{
				oreDrop = "minecraft:iron_ore";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 50 && rando < 60)
			{
				oreDrop = "minecraft:diamond";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 60 && rando < 75) 
			{
				oreDrop = "minecraft:gold_ore";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 75 && rando < 80)
			{
				oreDrop = "minecraft:dye"; //Lapis. Damage Vaule 4
				oreMeta = 4;
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 80 && rando < 95)
			{
				oreDrop = "minecraft:redstone";
				return Item.getByNameOrId(oreDrop);
			}
			else
			{
				oreDrop = "minecraft:ender_pearl";
				return Item.getByNameOrId(oreDrop);
			}
		}
		else 
		{
			oreDrop = ConfigHandler.randomiteUnstableWhiteList[RANDOM.nextInt(ConfigHandler.randomiteUnstableWhiteList.length)];
			oreMeta = 0;
			if(oreDrop.contains("."))
			{
					oreHold = oreDrop.split("\\.");
					oreMeta = Integer.parseInt(oreHold[1]);
					return Item.getByNameOrId(oreHold[0]);
			}
			else return Item.getByNameOrId(oreDrop);
		}
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return oreMeta == 0 ? 0 : oreMeta;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if(ConfigHandler.randomiteStable)
		{
			if(oreDrop == "minecraft:coal") return 3 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:iron_ore") return 3 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:diamond") return 1 + RANDOM.nextInt(2);
			else if(oreDrop == "minecraft:gold_ore") return 2 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:dye") return 4 + RANDOM.nextInt(5);
			else if(oreDrop == "minecraft:redStone") return 4 + RANDOM.nextInt(5);
			else if(oreDrop == "minecraft:ender_pearl") return 1 + RANDOM.nextInt(2);
			else if(oreDrop == "randomore:ItemUnstablePowder") return 2 + RANDOM.nextInt(4);
			else return 4;
		}
		else return ConfigHandler.randomiteDropsUnstableBase + RANDOM.nextInt(ConfigHandler.randomiteDropsUnstableChance+1);
	}
}
