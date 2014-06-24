package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.items.ItemInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 24/06/2014.
 */
public class CraftingHandler {

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
        final IInventory craftMatrix = null;
        for (int i = 0;i < event.craftMatrix.getSizeInventory(); i++){//scroll through the crafting matrix inventory
            if (event.craftMatrix.getStackInSlot(i) != null) {//make sure the item is not null ie blank
                ItemStack item0 = event.craftMatrix.getStackInSlot(i); //ok so lets see what the item is and put it into item0
                if (item0 !=null && item0.getItem() == ItemInfo.itemTwistedHammer){ //recheck its not null and see if its a TwistedHammer
                    ItemStack k = new ItemStack(ItemInfo.itemTwistedHammer,2,(item0.getItemDamage()+1)); // if it is then lets damage it!
                if (k.getItemDamage() >= k.getMaxDamage()){ //check to make sure the damage is not at or above max damage
                    k.stackSize--; //if it is then we need to destroy the hammer and send it to toolbox heaven
                }
                    event.craftMatrix.setInventorySlotContents(i,k); //then we set that stack to be the new damaged hammer
                }
                ItemStack item1 = event.craftMatrix.getStackInSlot(i); //as above :)
                if (item0 !=null && item1.getItem() == ItemInfo.itemBunnyitePunch){
                    ItemStack k = new ItemStack(ItemInfo.itemBunnyitePunch,2,(item1.getItemDamage()+1));
                    if (k.getItemDamage() >= k.getMaxDamage()){
                        k.stackSize--;
                    }
                    event.craftMatrix.setInventorySlotContents(i,k);
                }
            }
        }
    }



}
