package com.mrgreaper.twistedmod2.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by david on 23/06/2014.
 */
public class ConfigHandler {

    public static Configuration configuration;
    //public static boolean testValue = false;
    public static int deadBunnyBurnTime = 800;
    public static int livingBunnyBurnTime = 3200;
    public static int bunnyiteToolsMaxUses = 1750;
    public static int bunnyiteToolsHarvestLevel = 3;
    public static boolean botsPmChat = true;
    public static boolean botsUseSpeech = true;
    public static boolean easyMode = true;
    public static boolean leathSmelt = true;
    public static boolean grassCraft = true;


    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }


    public static void loadConfiguration() {
        //testValue = configuration.getBoolean("configValue", configuration.CATEGORY_GENERAL, false, "an example config value");
        deadBunnyBurnTime = configuration.getInt("Burn Time: Dead Bunny", configuration.CATEGORY_GENERAL, deadBunnyBurnTime, 1, 9000, "The burn time of a dead bunny between 1 and 9000(as fuel)");
        livingBunnyBurnTime = configuration.getInt("Burn Time: Living Bunny", configuration.CATEGORY_GENERAL, livingBunnyBurnTime, 1, 9000, "The burn time of a living bunny between 1 and 9000(as fuel)");
        bunnyiteToolsMaxUses = configuration.getInt("Bunnyite tools: max uses", configuration.CATEGORY_GENERAL, bunnyiteToolsMaxUses, 1, 9000, "The Maximum amount of times you can use a Bunnyite tool reference: wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32");
        bunnyiteToolsHarvestLevel = configuration.getInt("Bunnyite tools: Harvest level", configuration.CATEGORY_GENERAL, bunnyiteToolsHarvestLevel, 0, 10, "The level of material Bunnyite tools can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD) WARNING higher then 3 is for other mod support and may cause issues");
        botsPmChat = configuration.getBoolean("Bots: can be pm'd ", configuration.CATEGORY_GENERAL, botsPmChat, "Control if players can pm the bots or not");
        botsUseSpeech = configuration.getBoolean("Bots: use Speech ", configuration.CATEGORY_GENERAL, botsUseSpeech, "Can the bots use thier voice to communicate?");
        easyMode = configuration.getBoolean("Option: Easymode", configuration.CATEGORY_GENERAL, easyMode, "easy mode means when you burn errr, i mean cook,a bunny you get a nether star, on false you get a wither skull");
        leathSmelt = configuration.getBoolean("Option: Leather Smelting", configuration.CATEGORY_GENERAL, leathSmelt, "Can rotten flesh be smelted to leather?");
        grassCraft = configuration.getBoolean("Option: craftable grass", configuration.CATEGORY_GENERAL, grassCraft, "can you craft grass blocks with dirt and vines?");



        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
