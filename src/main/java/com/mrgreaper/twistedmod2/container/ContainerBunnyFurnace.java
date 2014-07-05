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
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Created by david on 26/06/2014.
 */
public class ContainerBunnyFurnace extends Container {

    public int lastBurnTime; //the number of ticks a fresh copy of the currently burning item would keep the furnace burning for
    public int lastCurrentItemBurnTime; //the number of ticks that the current item has been cooking for
    public int lastCookTime;
    private TileEntityBunnyFurnace BunnyFurnace;

    public ContainerBunnyFurnace(InventoryPlayer inventory, TileEntityBunnyFurnace tileentity) {
        this.BunnyFurnace = tileentity;

        this.addSlotToContainer(new Slot(tileentity, 0, 53, 33));
        this.addSlotToContainer(new Slot(tileentity, 1, 7, 57));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 115, 35));

        for (int i = 0; i < 3; i++) {//setup our player inventory in the gui(well make the slots for it)
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));//the last part sets the starting height
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting icrafting) {
        super.addCraftingToCrafters((icrafting));
        icrafting.sendProgressBarUpdate(this, 0, this.BunnyFurnace.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.BunnyFurnace.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.BunnyFurnace.currentItemBurnTime);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);
            if (this.lastCookTime != this.BunnyFurnace.cookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.BunnyFurnace.cookTime);
            }
            if (this.lastBurnTime != this.BunnyFurnace.burnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.BunnyFurnace.burnTime);
            }
            if (this.lastCurrentItemBurnTime != this.BunnyFurnace.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.BunnyFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.BunnyFurnace.cookTime;
        this.lastBurnTime = this.BunnyFurnace.burnTime;
        this.lastCurrentItemBurnTime = this.BunnyFurnace.currentItemBurnTime;

    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int newValue) {//not used but added just incase it fixed my issue..it did not
        if (slot == 0) {
            this.BunnyFurnace.cookTime = newValue;
        }

        if (slot == 1) {
            this.BunnyFurnace.cookTime = newValue;
        }


        if (slot == 2) {
            this.BunnyFurnace.cookTime = newValue;
        }
    }


    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityBunnyFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (par2 >= 3 && par2 < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }


    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
