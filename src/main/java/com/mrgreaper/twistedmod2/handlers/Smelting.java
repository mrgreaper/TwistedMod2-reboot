package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.BlockInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import com.mrgreaper.twistedmod2.reference.ItemInfo;

/**
 * Created by david on 23/06/2014.
 */
public class Smelting {

    public static void init(){
        GameRegistry.addSmelting(BlockInfo.oreBunnyite,new ItemStack(ItemInfo.itemBunnyiteIngot), 0);
        // GameRegistry.addSmelting(BlockInfo.oreBunnyite,new ItemStack(ItemInfo.itemBunnyiteIngot, 2), 0); //would give 2
    }

}
