package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by david on 23/06/2014.
 */
public class TwistedWorldGen implements IWorldGenerator{



    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case 0:
                //generate our surface world
                generateSurface(world, random, chunkX*16,chunkZ*16);

            case -1:
                //generate our nether world
                generateNether(world, random, chunkX * 16, chunkZ * 16);

            case 1:
                //generate our end world
                generateEndworld(world, random, chunkX*16,chunkZ*16);
        }

    }
    private void generateSurface(World world,Random random,int x,int z){
        //this.addOreSpawn( ORE NAME , world, random, x=block x position, z = block z position, max x,max z,max vain size, chance to spawn, min y , max y)
        this.addOreSpawn(BlockInfo.oreBunnyite, world, random, x, z,16,16,4+random.nextInt(6), 25, 10,40);

    }


    private void generateNether(World world,Random random,int x,int z){

    }


    private void generateEndworld(World world,Random random,int x,int z){

    }

    public void addOreSpawn(Block block, World world, Random random, int blockXpos, int blockZpos, int maxX, int maxZ, int maxVainSize, int chanceToSpawn, int minY, int maxY){
        for(int i= 0;i<chanceToSpawn; i++){ //for as many times as the random chance.. loop
            int posX = blockXpos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZpos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVainSize)).generate(world,random,posX,posY,posZ);
        }

    }
}
