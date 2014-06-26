package com.mrgreaper.twistedmod2.container;

import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by david on 26/06/2014.
 */
public class ContainerBunnyFurnace extends Container{

    private TileEntityBunnyFurnace BunnyFurnace;

    public ContainerBunnyFurnace(InventoryPlayer inventory, TileEntityBunnyFurnace tileentity) {
        this.BunnyFurnace = tileentity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return false;
    }
}
