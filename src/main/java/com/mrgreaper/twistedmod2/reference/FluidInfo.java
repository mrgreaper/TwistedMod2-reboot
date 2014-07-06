package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.Fluids.OrphanTears;
import com.mrgreaper.twistedmod2.items.bucketOrphanTears;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by david on 05/07/2014.
 */
public class FluidInfo {

    public static Fluid orphanTears = new Fluid("Orphan Tears").setLuminosity(5).setViscosity(1000).setTemperature(295);
    //public static Block orphanTearsBlock = new OrphanTears(orphanTears, Material.water).setBlockName("OrphanTears"); //if you try to do as normal for blocks then you get a crash on boot..wierd
    //TODO need to fix above...it has to be here to reference it for the bucket....but it cant be as it crashes it arghhhhhhhhhhhh
    //public static Item bucketOrphanTears = new bucketOrphanTears(orphanTearsBlock);
    //TODO add bunnyblood


    public static void init(){
        FluidRegistry.registerFluid(orphanTears);
        Block orphanTearsBlock = new OrphanTears(orphanTears, Material.water).setBlockName("OrphanTears");//hurts seeing it here and not up the top..ocd moment i guess
        GameRegistry.registerBlock(orphanTearsBlock, "orphanTearsBlock");
        orphanTears.setUnlocalizedName(orphanTearsBlock.getUnlocalizedName());

    }
}
