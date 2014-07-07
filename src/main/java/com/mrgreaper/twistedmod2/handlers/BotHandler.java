package com.mrgreaper.twistedmod2.handlers;

/**
 * Created by david on 06/07/2014.
 */

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import com.mrgreaper.twistedmod2.utility.LogHelper;

public class BotHandler {
    private static ChatterBotSession maxSession;
    private static ChatterBotSession fredSession;
    private static ChatterBotSession georgeSession;


    public static void init() {
        ChatterBotFactory factory = new ChatterBotFactory();
        try {
            ChatterBot max = factory.create(ChatterBotType.CLEVERBOT);
            maxSession = max.createSession();
        } catch (Exception e) {

            LogHelper.info("Failed to create Max bot error : " + e);
        }
        ChatterBot fred = null;
        try {
            fred = factory.create(ChatterBotType.JABBERWACKY);
            fredSession = fred.createSession();
        } catch (Exception e) {
            LogHelper.info("Failed to create Fred bot error : " + e);
        }
        ChatterBot george = null;
        try {
            george = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
            georgeSession = george.createSession();
        } catch (Exception e) {
            LogHelper.info("Failed to create George bot error : " + e);
        }
    }

    public static String maxBot(String s) throws Exception {
        return maxSession.think(s);
    }

    public static String fredBot(String s) throws Exception {
        return fredSession.think(s);
    }

    public static String georgeBot(String s) throws Exception {
        return georgeSession.think(s);
    }
}
