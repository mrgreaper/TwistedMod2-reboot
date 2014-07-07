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


    public static void init() throws Exception {
        ChatterBotFactory factory = new ChatterBotFactory();
        ChatterBot max = factory.create(ChatterBotType.CLEVERBOT);
        maxSession = max.createSession();
        ChatterBot fred = factory.create(ChatterBotType.JABBERWACKY);
        fredSession = fred.createSession();
        ChatterBot george = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
        georgeSession = george.createSession();
    }

    public static String maxBot(String s) throws Exception {
        LogHelper.info("maxbot recieved :" + s);
        return maxSession.think(s);
    }

    public static String fredBot(String s) throws Exception {
        return fredSession.think(s);
    }

    public static String georgeBot(String s) throws Exception {
        return georgeSession.think(s);
    }
}
