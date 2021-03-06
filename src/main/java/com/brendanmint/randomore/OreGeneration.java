package com.brendanmint.randomore;

import java.util.Random;

import com.brendanmint.randomore.init.ModBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator
{
	private static WorldGenerator generateOreSurface;
	private static WorldGenerator generateOreNether;
	
	public OreGeneration()
	{
		generateOreSurface = new WorldGenMinable(ModBlocks.randomiteore.getDefaultState(), ConfigHandler.randomiteSpawnSize);
		generateOreNether = new WorldGenMinable(ModBlocks.randomiteorenether.getDefaultState(), ConfigHandler.randomiteSpawnSizeNether, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		 case 0:
			 runGenerator(generateOreSurface,world,random,chunkX,chunkZ,ConfigHandler.randomiteSpawnTries,ConfigHandler.randomiteSpawnMin,ConfigHandler.randomiteSpawnMax);
			 break;
		 case -1:
			 runGenerator(generateOreNether,world,random,chunkX,chunkZ,ConfigHandler.randomiteSpawnTriesNether,ConfigHandler.randomiteSpawnMinNether,ConfigHandler.randomiteSpawnMaxNether);
			 break;
		 default:
			 break;
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
	{
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
	
	
}
