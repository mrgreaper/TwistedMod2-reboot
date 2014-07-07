package com.mrgreaper.twistedmod2.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by david on 06/07/2014.
 */
public class ChatHandler {

    public static void pmChat(EntityPlayerMP player, String message, String speaker) {
        player.addChatMessage(new ChatComponentText("<" + speaker + "> " + message));
    }

    public static void mainChat(String message, String speaker) {
        MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText("<" + speaker + "> " + message));
    }
}
