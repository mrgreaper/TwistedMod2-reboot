package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class ItemInfo {
    //rather then clutter up my main java file with item info lets pool it all here
    public static Item itemDeadBunny;
    public static Item itemBunnyiteIngot;


    public static void init(){

        itemDeadBunny = new twistedItems().setUnlocalizedName("DeadBunny");
        GameRegistry.registerItem(itemDeadBunny,"deadBunny");
        itemBunnyiteIngot = new twistedItems().setUnlocalizedName("BunnyiteIngot");
        GameRegistry.registerItem(itemBunnyiteIngot,"BunnyiteIngot");


    }
}
