package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import com.mrgreaper.twistedmod2.items.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 23/06/2014.
 */
public class Recipies {

    public static void init(){
        GameRegistry.addRecipe(new ItemStack(BlockInfo.blockBunnyite), new Object[]{"ccc",
                                                                                    "ccc",
                                                                                    "ccc",
                                                                                     'c', ItemInfo.itemBunnyiteIngot});

    }
}
