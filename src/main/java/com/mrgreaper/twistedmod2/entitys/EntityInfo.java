package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.GuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by david on 26/06/2014.
 */
public class EntityInfo {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityBunnyFurnace.class,"BunnyFurnace");
    }
}
