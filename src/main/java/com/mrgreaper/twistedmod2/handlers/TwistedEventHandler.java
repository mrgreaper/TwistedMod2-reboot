package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.reference.FluidInfo;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import sun.rmi.runtime.Log;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by david on 02/07/2014.
 */
public class TwistedEventHandler {

    private String current;
    private String old;
    private boolean hasPlayed = false;

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MODID)) {
            ConfigHandler.loadConfiguration();
        }
    }

    //test script
    @SubscribeEvent
    public void TwistedTickEvent(TickEvent.PlayerTickEvent event) {
        //LogHelper.info("the event is working : TwistedTickEvent");
        ItemStack itemstack = event.player.getCurrentEquippedItem();
        if (itemstack != null) {
            current = (event.player.getDisplayName() + itemstack.getItem().getUnlocalizedName()).toString();
        }//should clear up npe when we try to get the itemstack details from null or nothing ...oops
        else {
            current = (event.player.getDisplayName() + "item.nothing");
        }
        //LogHelper.info("current = : " + current);
        //LogHelper.info("condition test 1 : " + current.equals(old));
        if (!current.equals(old) && !event.player.worldObj.isRemote) {
            //LogHelper.info("should only be seen on one side");
            old = current;
            if (itemstack != null) {//have to check its not null first or BLAM there goes the server when it trys to look up the item
                //here we put in the sounds for on holding our items, these will only play client side to save possible use on griefing and because my sound handler is set up that way lol


                if (itemstack.getItem() == FluidInfo.orphanTearsBucket && !event.player.worldObj.isRemote){
                    //SoundHandler.onEntityPlay("orphanCry", event.player.worldObj, event.player,1,1);
                    SoundHandler.atWorldplace(event.player.worldObj,event.player.posX,event.player.posY,event.player.posZ,"orphanCry",1,1);
                }
                if (itemstack.getItem() == ItemInfo.itemDeathOrb && !event.player.worldObj.isRemote){
                    SoundHandler.onEntityPlay("deathOrbStartup", event.player.worldObj, event.player, 1, 1);
                }
                if (itemstack.getItem() == ItemInfo.itemDeadBunny && !event.player.worldObj.isRemote){
                    int ran =ThreadLocalRandom.current().nextInt(5)+1;
                    switch(ran){
                        case 1:
                           SoundHandler.miniSoundPlay("evilvoice-IsItDead",event.player);
                            break;
                        case 2:
                            SoundHandler.miniSoundPlay("evilvoice-BringToLife",event.player);
                            break;
                        case 3:
                            SoundHandler.miniSoundPlay("evilvoice-WeakBringLife",event.player);
                            break;
                        case 4:
                            SoundHandler.miniSoundPlay("evilvoice-NoPower",event.player);
                            break;
                        case 5:
                            SoundHandler.miniSoundPlay("evilvoice-WorldTremble",event.player);
                    }
                }
                if (itemstack.getItem() == ItemInfo.itemLivingBunny && !event.player.worldObj.isRemote){
                    int ran =ThreadLocalRandom.current().nextInt(7)+1;
                    switch(ran){
                        case 1:
                            SoundHandler.miniSoundPlay("evilvoice-Beautiful",event.player);
                            break;
                        case 2:
                            SoundHandler.miniSoundPlay("evilvoice-BeCareful",event.player);
                            break;
                        case 3:
                            SoundHandler.miniSoundPlay("evilvoice-BurnIt",event.player);
                            break;
                        case 4:
                            SoundHandler.miniSoundPlay("evilvoice-LookCreated",event.player);
                            break;
                        case 5:
                            SoundHandler.miniSoundPlay("evilvoice-NoseTwitch",event.player);
                            break;
                        case 6:
                            SoundHandler.miniSoundPlay("evilvoice-ReleaseEvilCreature",event.player);
                            break;
                        case 7:
                            SoundHandler.miniSoundPlay("evilvoice-ThePowerCalls",event.player);
                            break;
                    }
                }

                if (itemstack.getItem() == ItemInfo.itemOrphanLeg && !event.player.worldObj.isRemote){
                    int ran =ThreadLocalRandom.current().nextInt(3)+1;
                    switch(ran){
                        case 1:
                            SoundHandler.miniSoundPlay("evilvoice-Delicous",event.player);
                            break;
                        case 2:
                            SoundHandler.miniSoundPlay("evilvoice-DoNotPityOrphan",event.player);
                            break;
                        case 3:
                            SoundHandler.miniSoundPlay("evilvoice-Replant",event.player);
                            break;
                        case 4:
                            //SoundHandler.miniSoundPlay("evilvoice-NoPower",event.player);
                            break;
                        case 5:
                            //SoundHandler.miniSoundPlay("evilvoice-WorldTremble",event.player);
                    }
                }


                if (itemstack.getItem() == ItemInfo.itemEnergizedBunny && !event.player.worldObj.isRemote) {
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
                }
            }
        }
    }

    @SubscribeEvent
    public void TwistedChatEvent(ServerChatEvent event) {
        String chatMessage = event.message;
        //LogHelper.info("message is :" + chatMessage);
        if (ConfigHandler.botsPmChat) { //only talk to the bots if its enabled
            if (chatMessage.startsWith("max")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());

                try {
                    String answer = BotHandler.maxBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(0, 5, 4, 2, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "Max");
                } catch (Exception e) {
                    LogHelper.error("max didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
            if (chatMessage.startsWith("fred")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());
                try {
                    String answer = BotHandler.fredBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(0, 11, 11, 10, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "Fred");
                } catch (Exception e) {
                    LogHelper.error("fred didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
            if (chatMessage.startsWith("george")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());
                try {
                    String answer = BotHandler.georgeBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(1, 0, 60, 10, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "George");
                } catch (Exception e) {
                    LogHelper.error("George didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
        }
    }


    @SubscribeEvent//test event
    public void TwistedPickupEvent(PlayerEvent.ItemPickupEvent event) {
        LogHelper.info("if i can read this then the event handler is working" + event.pickedUp);


    }


}
