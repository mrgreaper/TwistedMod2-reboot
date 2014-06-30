package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by david on 26/06/2014.
 */
public class GuiBunnyFurnace extends GuiContainer{

    public TileEntityBunnyFurnace BunnyFurnace;

    public GuiBunnyFurnace(InventoryPlayer inventory, TileEntityBunnyFurnace entity) {
        super(ContainerBunnyFurnace(inventory,entity));
        this.BunnyFurnace = entity;
    }


   //****************************************
   // just added to allow mod to load
    private static Container ContainerBunnyFurnace(InventoryPlayer inventory, TileEntityBunnyFurnace entity) {
    return null;
    }
    //***********************************


    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

    }
}
