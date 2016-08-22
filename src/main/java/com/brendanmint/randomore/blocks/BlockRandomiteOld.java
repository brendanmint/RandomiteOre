package com.brendanmint.randomore.blocks;

import java.util.Random;

import com.brendanmint.randomore.ConfigHandler;
import com.brendanmint.randomore.Reference;
import com.brendanmint.randomore.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRandomiteOld extends Block{

	private static String oreDrop = "None";
	private static int rando;
	private static int dropAmt;
	
	public BlockRandomiteOld() 
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
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(!ConfigHandler.randomiteStable) rando = RANDOM.nextInt(101);
		
		if(rando < 25) oreDrop = "coal";
		else if(rando >= 25 && rando < 50) oreDrop = "iron";
		else if(rando >= 50 && rando < 60) oreDrop = "diamond";
		else if(rando >= 60 && rando < 75) oreDrop = "gold";
		else if(rando >= 75 && rando < 80) oreDrop = "lapis";
		else if(rando >= 80 && rando < 90) oreDrop = "redStone";
		else if(rando >= 90 && rando < 98) oreDrop = "unstablePowder";
		else if(rando >= 98) oreDrop = "endPearl";
		
		if(oreDrop == "coal") return Items.COAL;
		else if(oreDrop == "iron") return ItemBlock.getItemFromBlock(Blocks.IRON_ORE);
		else if(oreDrop == "diamond") return Items.DIAMOND;
		else if(oreDrop == "gold") return ItemBlock.getItemFromBlock(Blocks.GOLD_ORE);
		else if(oreDrop == "lapis") return Items.DYE;
		else if(oreDrop == "redStone") return Items.REDSTONE;
		else if(oreDrop == "endPearl") return Items.ENDER_PEARL;
		else return ModItems.unstablePowder;
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		if(oreDrop == "lapis") return 4;
		else return 0;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if(ConfigHandler.randomiteStable)
		{
			if(oreDrop == "coal") dropAmt = 3 + RANDOM.nextInt(4);
			else if(oreDrop == "iron") dropAmt = 3 + RANDOM.nextInt(3);
			else if(oreDrop == "diamond") dropAmt = 1 + RANDOM.nextInt(3);
			else if(oreDrop == "gold") dropAmt = 2 + RANDOM.nextInt(4);
			else if(oreDrop == "lapis") dropAmt = 4 + RANDOM.nextInt(3);
			else if(oreDrop == "redStone") dropAmt = 4 + RANDOM.nextInt(4);
			else if(oreDrop == "endPearl") dropAmt = 2 + RANDOM.nextInt(2);
			else if(oreDrop == "unstablePowder") dropAmt = 2 + RANDOM.nextInt(4);
			else dropAmt = 1;
		}
		else dropAmt = ConfigHandler.randomiteDropsUnstableBase + RANDOM.nextInt(ConfigHandler.randomiteDropsUnstableChance+1);
		return dropAmt;
	}
}
