package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by david on 02/07/2014.
 */
public class EventHandler {

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MODID)){
            ConfigHandler.loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onPlayerUseItem(PlayerUseItemEvent event){
        ItemStack item = event.item;
        LogHelper.info("Item is : " + item);
        if (item.getItem() == ItemInfo.itemEnergizedBunny){
            int ran = ThreadLocalRandom.current().nextInt(4)+1;
            LogHelper.info("ran is equal to :"+ran);
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
}
