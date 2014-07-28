package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.TwistedMod2;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

/**
 * Created by david on 28/07/2014.
 */
public class entityHelper {

    public static void mainRegistry() {
        registerEntity();
    }

    public static void registerEntity() {
        //here is where the mobs are added (colours are 0x then number from http://www.colorpicker.com/)
        createEntity(entityBunnyMob.class, "bunnyMob", 0x78602E, 0xFA1433);

    }

    public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId(); //so here we get a spare unused ID ...why dont more mods do that?


        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, TwistedMod2.instance, 64, 1, true);//64 is the block range to see and deal with entity
        createEgg(randomId, solidColour, spotColour);

    }

    private static void createEgg(int randomId, int solidColour, int spotColour) {
        EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
    }

}
