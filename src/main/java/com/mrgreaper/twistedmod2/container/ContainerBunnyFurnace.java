package com.mrgreaper.twistedmod2.container;

import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

/**
 * Created by david on 26/06/2014.
 */
public class ContainerBunnyFurnace extends Container{

    private TileEntityBunnyFurnace BunnyFurnace;

    public int lastBurnTime; //the number of ticks a fresh copy of the currently burning item would keep the furnace burning for

    public int lastCurrentItemBurnTime; //the number of ticks that the current item has been cooking for

    public int lastCookTime;

    public ContainerBunnyFurnace(InventoryPlayer inventory, TileEntityBunnyFurnace tileentity) {
        this.BunnyFurnace = tileentity;

        this.addSlotToContainer(new Slot(tileentity,0,53,33));
        this.addSlotToContainer(new Slot(tileentity,1,7,57));
        this.addSlotToContainer(new SlotFurnace(inventory.player,tileentity,2,115,35));

        for (int i = 0; i<3;i++){//setup our player inventory in the gui(well make the slots for it)
            for (int j= 0; j< 9; j++){
                this.addSlotToContainer(new Slot(inventory,j+ i * 9 +9,8+j*18,84+i*18));//the last part sets the starting height
            }
        }

        for(int i= 0; i<9;i++){
            this.addSlotToContainer(new Slot(inventory,i,8+i*18,142));
        }
    }

    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters((icrafting));
        icrafting.sendProgressBarUpdate(this,0,this.BunnyFurnace.cookTime);
        icrafting.sendProgressBarUpdate(this,1,this.BunnyFurnace.burnTime);
        icrafting.sendProgressBarUpdate(this,2,this.BunnyFurnace.currentItemBurnTime);
    }

    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for(int i= 0; i< this.crafters.size();i++){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastCookTime != this.BunnyFurnace.cookTime){
                icrafting.sendProgressBarUpdate(this,0,this.BunnyFurnace.cookTime);
            }
            if (this.lastBurnTime != this.BunnyFurnace.burnTime){
                icrafting.sendProgressBarUpdate(this,1,this.BunnyFurnace.burnTime);
            }
            if (this.lastCurrentItemBurnTime != this.BunnyFurnace.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this,2,this.BunnyFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime =this.BunnyFurnace.cookTime;
        this.lastBurnTime=this.BunnyFurnace.burnTime;
        this.lastCurrentItemBurnTime=this.BunnyFurnace.currentItemBurnTime;

    }

    @SideOnly(Side.CLIENT)
    public void updateProgresssBar(int slot,int newValue){

    }














    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
