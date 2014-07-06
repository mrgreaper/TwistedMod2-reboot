package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by david on 02/07/2014.
 */
public class TwistedEventHandler {

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MODID)) {
            ConfigHandler.loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onPlayerUseItem(PlayerUseItemEvent event) {
        ItemStack item = event.item;
        LogHelper.info("Item is : " + item);
        if (item.getItem() == ItemInfo.itemEnergizedBunny) {
            int ran = ThreadLocalRandom.current().nextInt(4) + 1;
            LogHelper.info("ran is equal to :" + ran);
            switch (ran) { //use that number
                case 1:
                    SoundHandler.onEntityPlay("bunnyBegA", event.entityPlayer.worldObj, event.entityPlayer, 1, 1);
                    break;
                case 2:
                    SoundHandler.onEntityPlay("bunnyBegB", event.entityPlayer.worldObj, event.entityPlayer, 1, 1);
                    break;
                case 3:
                    SoundHandler.onEntityPlay("bunnyBegC", event.entityPlayer.worldObj, event.entityPlayer, 1, 1);
                    break;
                case 4:
                    SoundHandler.onEntityPlay("bunnyBegD", event.entityPlayer.worldObj, event.entityPlayer, 1, 1);
                    break;
                case 5:
                    SoundHandler.onEntityPlay("bunnyBegE", event.entityPlayer.worldObj, event.entityPlayer, 1, 1);
                    break;
            }

        }
    }

    private String current;
    private String old;

    //test script
    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public void TwistedTickEvent(TickEvent.PlayerTickEvent event){
        LogHelper.info("test 1");
        ItemStack itemstack = event.player.getCurrentEquippedItem();
        current = event.player.getDisplayName()+itemstack;
        LogHelper.info("current = : "+current);
        if (itemstack !=null && current != old){
            if (itemstack.getItem()==ItemInfo.itemEnergizedBunny) {
                int ran = ThreadLocalRandom.current().nextInt(5) + 1;
                switch (ran) { //use that number
                    case 1:
                        SoundHandler.onEntityPlay("bunnyBegA", event.player.worldObj, event.player, 1, 1);
                        break;
                    case 2:
                        SoundHandler.onEntityPlay("bunnyBegB", event.player.worldObj, event.player, 1, 1);
                        break;
                    case 3:
                        SoundHandler.onEntityPlay("bunnyBegC", event.player.worldObj, event.player, 1, 1);
                        break;
                    case 4:
                        SoundHandler.onEntityPlay("bunnyBegD", event.player.worldObj, event.player, 1, 1);
                        break;
                    case 5:
                        SoundHandler.onEntityPlay("bunnyBegE", event.player.worldObj, event.player, 1, 1);
                        break;
                }
                old = current;
            }


        }else{
            old = event.player.getDisplayName()+" none ";
            LogHelper.info("Detected empty hands :"+old);
        }
    }

    @SubscribeEvent//test event
    public void TwistedPickupEvent(PlayerEvent.ItemPickupEvent event) {
        LogHelper.info("if i can read this then the event handler is working"+event.pickedUp);

    }


}
