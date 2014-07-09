package com.mrgreaper.twistedmod2.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by david on 09/07/2014.
 */
public class ContainerLivingBunny extends Container { //this is part of guiLiving bunny

    public ContainerLivingBunny(EntityPlayer player) {

        //this is where we would add slots etc

    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;//so we can open it
    }


}
