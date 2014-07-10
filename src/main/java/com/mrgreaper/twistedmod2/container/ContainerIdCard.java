package com.mrgreaper.twistedmod2.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by david on 10/07/2014.
 */
public class ContainerIdCard extends Container { //this is part of guiSecurityIdCard

    public ContainerIdCard(EntityPlayer player) {

        //this is where we would add slots etc

    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;//so we can open it
    }


}
