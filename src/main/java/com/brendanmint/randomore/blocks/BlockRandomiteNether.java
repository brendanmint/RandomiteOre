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

public class BlockRandomiteNether extends Block{

	private static String oreDrop = "None";
	private static int rando;
	private static String[] oreHold = {"dye","5"};
	private static int oreMeta;
	
	public BlockRandomiteNether() 
	{
		super(Material.ROCK);
		
		setHarvestLevel("pickaxe", 2);
		setHardness(4.0f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		setUnlocalizedName(Reference.randOreBlocks.RANDOMITEORENETHER.getUnlocalisedName());
		setRegistryName(Reference.randOreBlocks.RANDOMITEORENETHER.getRegistryName());
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		if(ConfigHandler.randomiteStableNether) rando = RANDOM.nextInt(101);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(ConfigHandler.randomiteStableNether)
		{
			if(rando < 20)
			{
				oreDrop = "minecraft:coal";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 20 && rando < 40)
			{
				oreDrop = "minecraft:iron_ore";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 40 && rando < 50)
			{
				oreDrop = "minecraft:diamond";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 50 && rando < 65) 
			{
				oreDrop = "minecraft:gold_ore";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 65 && rando < 90)
			{
				oreDrop = "minecraft:quartz";
				return Item.getByNameOrId(oreDrop);
			}
			else if(rando >= 90 && rando < 95)
			{
				oreDrop = "randomore:ItemUnstablePowder";
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
			oreDrop = ConfigHandler.randomiteUnstableWhiteListNether[RANDOM.nextInt(ConfigHandler.randomiteUnstableWhiteListNether.length)];
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
	public int quantityDropped(Random random) 
	{
		if(ConfigHandler.randomiteStableNether)
		{
			if(oreDrop == "minecraft:coal") return 3 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:iron_ore") return 3 + RANDOM.nextInt(3);
			else if(oreDrop == "minecraft:diamond") return 1 + RANDOM.nextInt(3);
			else if(oreDrop == "minecraft:gold_ore") return 2 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:quartz") return 4 + RANDOM.nextInt(4);
			else if(oreDrop == "minecraft:ender_pearl") return 2 + RANDOM.nextInt(2);
			else if(oreDrop == "randomore:ItemUnstablePowder") return 2 + RANDOM.nextInt(4);
			else return  3;
		}
		else return ConfigHandler.randomiteDropsUnstableBaseNether + RANDOM.nextInt(ConfigHandler.randomiteDropsUnstableChanceNether+1);
	}
}
