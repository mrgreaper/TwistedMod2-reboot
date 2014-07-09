package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.entitys.TileEntityAlarm;
import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaker;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by david on 26/06/2014.
 */
public class EntityInfo {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityBunnyFurnace.class, "BunnyFurnace");
        GameRegistry.registerTileEntity(TileEntityAlarm.class, "twistedAlarm");
        GameRegistry.registerTileEntity(TileEntitySpeaker.class, "twistedSpeaker");
    }
}
