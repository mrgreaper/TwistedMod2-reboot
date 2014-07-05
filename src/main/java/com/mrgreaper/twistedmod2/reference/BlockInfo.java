package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.blocks.blockBunnyFurnace;
import com.mrgreaper.twistedmod2.blocks.oreBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by david on 23/06/2014.
 */
public class BlockInfo {
    //same as iteminfo lets reduce clutter of the main class

    public static final int guiIDBunnyFurnace = 0;
    public static Block blockSpeaker = new com.mrgreaper.twistedmod2.blocks.blockSpeaker(Material.iron).setBlockName("Speaker");
    public static Block oreBunnyite = new oreBlock(Material.rock).setBlockName("oreBunnyite");
    public static Block blockBunnyite = new com.mrgreaper.twistedmod2.blocks.blockBunnyite(Material.iron).setBlockName("blockBunnyite");
    public static Block oreCystalizedBlood = new oreBlock(Material.rock).setBlockName("oreCystalizedBlood");
    public static Block blockBunnyFurnaceIdle = new blockBunnyFurnace(false, Material.iron).setBlockName("BunnyFurnaceIdle").setCreativeTab(TwistedMod2.TwistedModTab).setHardness(3.5F);
    public static Block blockBunnyFurnaceActive = new blockBunnyFurnace(false, Material.iron).setBlockName("BunnyFurnaceActive").setCreativeTab(TwistedMod2.TwistedModTab).setHardness(3.5F).setLightLevel(2f);

    public static void init() {
        GameRegistry.registerBlock(blockSpeaker, "Speaker");
        GameRegistry.registerBlock(oreBunnyite, "oreBunnyite");
        GameRegistry.registerBlock(blockBunnyite, "blockBunnyite");
        GameRegistry.registerBlock(oreCystalizedBlood, "oreCystalizedBlood");
        GameRegistry.registerBlock(blockBunnyFurnaceIdle, "BunnyFurnaceIdle");
        GameRegistry.registerBlock(blockBunnyFurnaceActive, "BunnyFurnaceActive");
    }
}
