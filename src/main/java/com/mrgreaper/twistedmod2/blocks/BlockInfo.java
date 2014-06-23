package com.mrgreaper.twistedmod2.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by david on 23/06/2014.
 */
public class BlockInfo {
    //same as iteminfo lets reduce clutter of the main class

    public static Block blockSpeaker;
    public static Block oreBunnyite;
    public static Block blockBunnyite;


    public static void init(){
        blockSpeaker = new blockSpeaker(Material.iron).setBlockName("Speaker");
        GameRegistry.registerBlock(blockSpeaker,"Speaker");
        oreBunnyite = new oreBunnyite(Material.rock).setBlockName("oreBunnyite");
        GameRegistry.registerBlock(oreBunnyite,"oreBunnyite");
        blockBunnyite = new blockBunnyite(Material.iron).setBlockName("blockBunnyite");
        GameRegistry.registerBlock(blockBunnyite,"blockBunnyite");


    }
}
