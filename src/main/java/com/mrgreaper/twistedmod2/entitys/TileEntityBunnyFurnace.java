package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.blocks.blockBunnyFurnace;
import com.mrgreaper.twistedmod2.utility.fuelItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 26/06/2014.
 */
public class TileEntityBunnyFurnace extends TileEntity implements ISidedInventory {

    private String localizedName;
    //define our sides
    private static final int[] slots_top=new int[]{0}; //so if we put a hoper on the top it will go to slot 0
    private static final int[] slots_bottom=new int[]{2, 1}; //is slot 2 first then slot 1 (wtf?)
    private static final int[] slots_side=new int[]{1};//side is slot 1
    //defineing sides end

    private ItemStack[] slots = new ItemStack[3]; //as we have 3 sockets in our gui that can take or remove items

    public int furnaceSpeed =150; // the number of ticks that the furnace will keep burning

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
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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

    public boolean isBurning() {
        return this.burnTime > 0 ;
    }
    public void updateEntity() {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;
        if (this.isBurning()) {
            this.burnTime --;
        }
        if (!this.worldObj.isRemote){//if this is client side
            if(this.burnTime==0 && this.canSmelt()){
                this.currentItemBurnTime = this.burnTime = fuelItems.getItemBurntime(this.slots[1]);

                if(this.isBurning()){
                    flag1 =true;

                    if (this.slots[1] != null){//if there is an item in slot 1
                        this.slots[1].stackSize--; //remove 1 item from the stack in slot 1
                        if (this.slots[1].stackSize == 0){
                            this.slots[1]= this.slots[1].getItem().getContainerItem(this.slots[1]);//should return a bucket if it was a lava bucket
                        }
                    }
                }
            }
        }
        if (this.isBurning()&&this.canSmelt()){
            this.cookTime++; //if it can smelt and is burning the cook time goes up

            if (this.cookTime ==this.furnaceSpeed){//so when the cook time reaches the goal speed it smelts the item and adds the next, so lower furnacespeed value faster it workds
                this.cookTime = 0;
                this.smeltItem();
                flag1=true;
            }else{
                this.cookTime =0;
            }
            if (flag != this.isBurning()){
                flag1=true;
                blockBunnyFurnace.updateblockBunnyFurnaceState(this.burnTime >0, this.worldObj,this.xCoord,this.yCoord,this.zCoord);
            }
        }
        if (flag1){
            this.markDirty();
        }
    }

    public boolean canSmelt() {
        if (this.slots[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]); //this adds all recipies

            if (itemstack == null) return false;
            if (this.slots[2] == null) return true;
            if (!this.slots[2].isItemEqual(itemstack)) return false;

            int result = this.slots[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());//only smelt if the stack limit has not been reached of the item or default stack limit of 64
        }
    }
    public void smeltItem(){
        if(this.canSmelt()){
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            if (this.slots[2]==null){
                this.slots[2] = itemstack.copy(); //if outpiut slot is empty then we place the result in there
            }else if(this.slots[2].isItemEqual(itemstack)){
                this.slots[2].stackSize += itemstack.stackSize; //if its not then we add the result to it
            }
            this.slots[0].stackSize--; //we deduct 1 from the input slot as we smelted it

            if(this.slots[0].stackSize <=0 ) { //so if it hits
                this.slots[0] = null;
            }
        }
    }

    public int getSizeInventory(){ //if the code needs to know how many slots...this tells it
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.slots[var1];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if (this.slots[var1] !=null){
            ItemStack itemstack;

            if (this.slots[var1].stackSize <= var2){
                itemstack = this.slots[var1];
                this.slots[var1]=null;
                return itemstack;
            }else{
                itemstack=this.slots[var1].splitStack(var2);
                if (this.slots[var1].stackSize == 0){
                    this.slots[var1] =null;
                }
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i]!=null){
            ItemStack itemStack =this.slots[i];
                    this.slots[i] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.slots[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }
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

    public int getBurnTimeRemainingScaled(int i){
        if (this.currentItemBurnTime==0){
            this.currentItemBurnTime=this.furnaceSpeed;
        }
        return this.burnTime * i / this.currentItemBurnTime;
    }

    public int getCookProgressScaled(int i){
        return this.cookTime *i /this.furnaceSpeed;
    }
}
