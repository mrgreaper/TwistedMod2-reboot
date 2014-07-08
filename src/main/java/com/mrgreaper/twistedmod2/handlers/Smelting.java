package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.BlockInfo;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 23/06/2014.
 */
public class Smelting {
    //TODO ...redundent class, either need to move all smelting to this for neetless or just move this to recipie class


    public static void init() {
        GameRegistry.addSmelting(BlockInfo.oreBunnyite, new ItemStack(ItemInfo.itemBunnyiteIngot), 0);
        // GameRegistry.addSmelting(BlockInfo.oreBunnyite,new ItemStack(ItemInfo.itemBunnyiteIngot, 2), 0); //would give 2
    }

}
