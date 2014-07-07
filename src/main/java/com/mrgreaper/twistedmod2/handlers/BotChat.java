package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * Created by david on 07/07/2014.
 */
public class BotChat implements Runnable {
    private static EntityPlayerMP player;
    private static String message;
    private static String bot;

    public static void incoming(EntityPlayerMP playerIn, String messageIn, String botIn) {
        player = playerIn;
        message = messageIn;
        bot = botIn;
        Thread T1 = new Thread(new BotChat());
    }

    public void run() {
        String[] messageMod = message.split(" ", 2);
        LogHelper.info("Original message: " + message);
        LogHelper.info("Adapted message reads :" + messageMod[1]);
        String answer = "";
        if (bot.equals("max")) {
            try {
                answer = BotHandler.maxBot(messageMod[1]);
            } catch (Exception e) {
                LogHelper.info("maxbot error " + e);
            }
        }
        if (bot.equals("george")) {
            try {
                answer = BotHandler.georgeBot(messageMod[1]);
            } catch (Exception e) {
                LogHelper.info("george bot error " + e);
            }
        }
        if (bot.equals("fred")) {
            try {
                answer = BotHandler.fredBot(messageMod[1]);
            } catch (Exception e) {
                LogHelper.info("fred bot error " + e);
            }
        }
        ChatHandler.pmChat(player, messageMod[1], player.getDisplayName());
        ChatHandler.pmChat(player, answer, bot);
    }
}
