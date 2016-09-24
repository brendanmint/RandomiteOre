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
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockRandomiteNether extends Block{

	private static String oreDrop = "None";
	private static String[] oreHold = {"dye","5"};
	private static int oreMeta;
	private static int dropMin;
	private static int dropMax;
	
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
		setDrop();
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		oreDrop = "minecraft:coal";
		dropMax = 3;
		super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(ConfigHandler.randomiteStableNether) return Item.getByNameOrId(oreDrop);
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
			if(dropMax - dropMin > 0) return dropMin + RANDOM.nextInt(dropMax - dropMin);
			else return 0;
		}
		else return ConfigHandler.randomiteDropsUnstableBaseNether + RANDOM.nextInt(ConfigHandler.randomiteDropsUnstableChanceNether+1);
	}
	
	public static void setDrop()
	{
		if(ConfigHandler.randomiteStableNether)
		{
			oreDrop = ConfigHandler.randomiteStableWhiteListNether[RANDOM.nextInt(ConfigHandler.randomiteStableWhiteListNether.length)];
			if(oreDrop.contains("."))
			{
				oreHold = oreDrop.split("[.+-]");
				System.out.println("oreHold: " + oreHold.length);
				dropMax = Integer.parseInt(oreHold[3]);
				dropMin = Integer.parseInt(oreHold[2]);
				oreMeta = Integer.parseInt(oreHold[1]);
				oreDrop = oreHold[0];
			}
			else
			{
				oreHold = oreDrop.split("[.+-]");
				System.out.println("oreHold: " + oreHold.length);
				dropMax = Integer.parseInt(oreHold[2]);
				dropMin = Integer.parseInt(oreHold[1]);
				oreMeta = 0;
				oreDrop = oreHold[0];
			}
		}
	}
}
