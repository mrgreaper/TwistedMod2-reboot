package com.mrgreaper.twistedmod2.handlers;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by david on 30/06/2014.
 */
public class materials {

    // public static Item.ToolMaterial NAME = EnumHelper.addToolMaterial(name,havestlevel,maxuses,efficiency,damage,enchantability)

    public static Item.ToolMaterial BunnyiteMaterial = EnumHelper.addToolMaterial("Bunnyite", ConfigHandler.bunnyiteToolsHarvestLevel, ConfigHandler.bunnyiteToolsMaxUses, 14.0f, 5.0f, 10);

    public static void init() {

    }
}
