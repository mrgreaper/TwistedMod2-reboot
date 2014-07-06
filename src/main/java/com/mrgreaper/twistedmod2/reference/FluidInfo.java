package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.Fluids.BunnyBlood;
import com.mrgreaper.twistedmod2.Fluids.OrphanTears;
import com.mrgreaper.twistedmod2.handlers.BucketHandler;
import com.mrgreaper.twistedmod2.items.bucketBunnyBlood;
import com.mrgreaper.twistedmod2.items.bucketOrphanTears;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by david on 06/07/2014.
 */
public class FluidInfo {

    public static final Fluid orphantears = new Fluid("orphantears");
    public static Block orphantearsblock;
    public static Item orphanTearsBucket;

    public static final Fluid bunnyblood = new Fluid("bunnyblood");
    public static Block bunnybloodblock;
    public static Item bunnyBloodBucket;

    public static void init(){
        //orphan tears Fluid
        FluidRegistry.registerFluid(orphantears);
        orphantearsblock = new OrphanTears(orphantears,Material.water).setBlockName("orphantears");
        GameRegistry.registerBlock(orphantearsblock, "orphanTearsBlock");
        orphantears.setUnlocalizedName(orphantearsblock.getUnlocalizedName());


        orphanTearsBucket = new bucketOrphanTears(orphantearsblock).setUnlocalizedName("bucketOfOrphanTears");
        GameRegistry.registerItem(orphanTearsBucket,"bucketOfOrphanTears");
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("orphantears",FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(Items.bucket));
        BucketHandler.INSTANCE.buckets.put(orphantearsblock, orphanTearsBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

        //bunny Blood fluid
        FluidRegistry.registerFluid(bunnyblood);
        bunnybloodblock = new BunnyBlood(bunnyblood,Material.water).setBlockName("bunnyblood");
        GameRegistry.registerBlock(bunnybloodblock,"bunnyBloodBlock");
        bunnyblood.setUnlocalizedName(bunnybloodblock.getUnlocalizedName());

        bunnyBloodBucket = new bucketBunnyBlood(bunnybloodblock).setUnlocalizedName("bucketOfBunnyBlood");
        GameRegistry.registerItem(bunnyBloodBucket,"bucketOfBunnyBlood");
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("bunnyblood",FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.bucket));
        BucketHandler.INSTANCE.buckets.put(bunnybloodblock,bunnyBloodBucket);





    }
}
