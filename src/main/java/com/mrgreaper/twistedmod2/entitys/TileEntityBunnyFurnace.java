package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.utility.fuelItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 26/06/2014.
 */
public class TileEntityBunnyFurnace extends TileEntity implements ISidedInventory{

    private String localizedName;
    //define our sides
    private static final int[] slots_top=new int[]{0}; //so if we put a hoper on the top it will go to slot 0
    private static final int[] slots_bottom=new int[]{2, 1}; //is slot 2 first then slot 1 (wtf?)
    private static final int[] slots_side=new int[]{1};//side is slot 1
    //defineing sides end

    private ItemStack[] slots = new ItemStack[3]; //as we have 3 sockets in our gui that can take or remove items

    public int furnaceSpeed; // the number of ticks that the furnace will keep burning

    public int burnTime; //the number of ticks a fresh copy of the currently burning item would keep the furnace burning for

    public int currentItemBurnTime; //the number of ticks that the current item has been cooking for

    public int cookTime;


    public void setGuiDisplayName(String displayName) {
        this.localizedName= displayName;


    }

    public String getInventoryName(){
        return this.hasCustomInventoryName() ? this.localizedName :"container.BunnyFurnace"; //the :"container.BunnyFurnace" is a fail safe and in theory never be used
    }

    public boolean hasCustomInventoryName() {
        return this.localizedName !=null && this.localizedName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
    }


    public void openInventory() { }
    public void closeInventory() { }

    @Override //pretty self explanatory :)
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return i == 2 ? false :(i==1 ? isItemFuel(itemstack): true);
    }

    public static boolean isItemFuel (ItemStack itemstack) {
        return fuelItems.getItemBurntime(itemstack) > 0; //if it has a burn time its a fuel...that is neat :)
    }

    //moved fuel items to utils

    public int getSizeInventory(){ //if the code needs to know how many slots...this tells it
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override//controls what sides access what slots (var1 is the side)
    public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 0 ? slots_bottom :(var1 ==1? slots_top : slots_side);
        //so if its 0 ie bottom we get slot_bottom :(else) if it is equal to 1 then its the top and if its not either of those its a side
        //nice and simples
    }


    @Override //this controls inputting items into the inventory from say pipes or hoppers...more specificly if its possible (so in this case fuel and pre burnt item:) )
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i,itemstack);
    }

    @Override //this controls removing an item into pipes or hoppers etc
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return j != 0 || i != 1 || itemstack.getItem() == Items.bucket; //if the stack is not 0 or 1 (our input and our fuel slot then it can be extracted (so long as it aint no bucket)
    }
}
