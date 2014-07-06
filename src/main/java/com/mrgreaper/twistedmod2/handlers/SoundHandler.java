package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * Created by david on 04/07/2014.
 */
public class SoundHandler {


    public static void onEntityPlay(String name, World world, Entity entityName, float volume, float pitch) {
        world.playSoundAtEntity(entityName, (Reference.MODID + ":" + name), (float) volume, (float) pitch);
    }

    //test sound handler
    public static void atWorldplace(World worldObj,double xCord,double yCord, double zCord, String SoundName,float volume, float pitch){
        worldObj.playSoundEffect((double) xCord,(double) yCord, (double) zCord, (Reference.MODID+":"+ SoundName),(float) volume, (float) pitch);
    }
}
