package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.*;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by david on 26/06/2014.
 */
public class EntityInfo {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityBunnyFurnace.class, "BunnyFurnace");
        GameRegistry.registerTileEntity(TileEntityAlarm.class, "twistedAlarm");
        GameRegistry.registerTileEntity(TileEntitySpeaker.class, "twistedSpeaker");
        GameRegistry.registerTileEntity(TileEntitySpeaky.class, "speaky");
        EntityRegistry.registerModEntity(entityDeathOrb.class, "EntityDeathOrb", 1, TwistedMod2.instance, 80, 3, true);
    }
}
