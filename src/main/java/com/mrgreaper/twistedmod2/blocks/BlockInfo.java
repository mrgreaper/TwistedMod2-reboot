package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
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
    public static Block oreCystalizedBlood;
    public static Block blockBunnyFurnaceIdle;
    public static Block blockBunnyFurnaceActive;
    public static final int guiIDBunnyFurnace=0;


    public static void init(){
        blockSpeaker = new blockSpeaker(Material.iron).setBlockName("Speaker");
        oreBunnyite = new oreBlock(Material.rock).setBlockName("oreBunnyite");
        blockBunnyite = new blockBunnyite(Material.iron).setBlockName("blockBunnyite");
        oreCystalizedBlood = new oreBlock(Material.rock).setBlockName("oreCystalizedBlood");
        blockBunnyFurnaceIdle = new blockBunnyFurnace(false,Material.iron).setBlockName("BunnyFurnaceIdle").setCreativeTab(TwistedMod2.TwistedModTab).setHardness(3.5F);
        blockBunnyFurnaceActive = new blockBunnyFurnace(false,Material.iron).setBlockName("BunnyFurnaceActive").setCreativeTab(TwistedMod2.TwistedModTab).setHardness(3.5F).setLightLevel(2f);

        GameRegistry.registerBlock(blockSpeaker,"Speaker");
        GameRegistry.registerBlock(oreBunnyite,"oreBunnyite");
        GameRegistry.registerBlock(blockBunnyite,"blockBunnyite");
        GameRegistry.registerBlock(oreCystalizedBlood,"oreCystalizedBlood");
        GameRegistry.registerBlock(blockBunnyFurnaceIdle, "BunnyFurnaceIdle");
        GameRegistry.registerBlock(blockBunnyFurnaceActive, "BunnyFurnaceActive");

    }
}
