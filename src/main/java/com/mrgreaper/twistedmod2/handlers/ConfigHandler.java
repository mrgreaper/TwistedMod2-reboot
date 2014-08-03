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
    public static boolean nonBunnySpeechSynth = false;
    public static int bunnyiteOreMinY = 10;
    public static int bunnyiteOreMaxY = 40;
    public static int bunnyiteOreChance = 25;//TODO make these rarer, set high for testing
    public static int bunnyBloodCrystalizedMinY = 10;
    public static int bunnyBloodCrystalizedMaxY = 40;
    public static int bunnyBloodCrystalizedChance = 25;
    public static int speechSynthMaxRange = 512;


    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }


    public static void loadConfiguration() {
        deadBunnyBurnTime = configuration.getInt("Burn Time: Dead Bunny", configuration.CATEGORY_GENERAL, deadBunnyBurnTime, 1, 9000, "The burn time of a dead bunny between 1 and 9000(as fuel)");
        livingBunnyBurnTime = configuration.getInt("Burn Time: Living Bunny", configuration.CATEGORY_GENERAL, livingBunnyBurnTime, 1, 9000, "The burn time of a living bunny between 1 and 9000(as fuel)");
        bunnyiteToolsMaxUses = configuration.getInt("Bunnyite tools: max uses", configuration.CATEGORY_GENERAL, bunnyiteToolsMaxUses, 1, 9000, "The Maximum amount of times you can use a Bunnyite tool reference: wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32");
        bunnyiteToolsHarvestLevel = configuration.getInt("Bunnyite tools: Harvest level", configuration.CATEGORY_GENERAL, bunnyiteToolsHarvestLevel, 0, 10, "The level of material Bunnyite tools can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD) WARNING higher then 3 is for other mod support and may cause issues");
        botsPmChat = configuration.getBoolean("Bots: can be pm'd ", configuration.CATEGORY_GENERAL, botsPmChat, "Control if players can pm the bots or not");
        botsUseSpeech = configuration.getBoolean("Bots: use Speech ", configuration.CATEGORY_GENERAL, botsUseSpeech, "Can the bots use thier voice to communicate?");
        easyMode = configuration.getBoolean("Option: Easymode", configuration.CATEGORY_GENERAL, easyMode, "easy mode means when you burn errr, i mean cook,a bunny you get a nether star, on false you get a wither skull");
        leathSmelt = configuration.getBoolean("Option: Leather Smelting", configuration.CATEGORY_GENERAL, leathSmelt, "Can rotten flesh be smelted to leather?");
        grassCraft = configuration.getBoolean("Option: craftable grass", configuration.CATEGORY_GENERAL, grassCraft, "can you craft grass blocks with dirt and vines?");
        bunnyiteOreMinY = configuration.getInt("Bunyite Ore: min height", configuration.CATEGORY_GENERAL, bunnyiteOreMinY, 1, 64, "the lowest height of bunyite ore can be found");
        bunnyiteOreMaxY = configuration.getInt("Bunyite Ore: max height", configuration.CATEGORY_GENERAL, bunnyiteOreMaxY, 1, 64, "the highest height of bunyite ore can be found");
        bunnyiteOreChance = configuration.getInt("Bunyite Ore: chance to spawn", configuration.CATEGORY_GENERAL, bunnyiteOreChance, 1, 64, "the chance of bunnyite ore spawning in world");
        bunnyBloodCrystalizedMinY = configuration.getInt("Crystalized BB: min height", configuration.CATEGORY_GENERAL, bunnyBloodCrystalizedMinY, 1, 64, "the lowest height of Crystalized bunny blood can be found");
        bunnyBloodCrystalizedMaxY = configuration.getInt("Crystalized BB: max height", configuration.CATEGORY_GENERAL, bunnyBloodCrystalizedMaxY, 1, 64, "the highest height of Crystalized bunny blood can be found");
        bunnyBloodCrystalizedChance = configuration.getInt("Crystalized BB: chance to spawn", configuration.CATEGORY_GENERAL, bunnyBloodCrystalizedChance, 1, 64, "the chance of Crystalized bunny blood spawning in world");
        nonBunnySpeechSynth = configuration.getBoolean("Speech Synth: non bunny recipie", configuration.CATEGORY_GENERAL, nonBunnySpeechSynth, "some people dont like the bunny aspect and only use my mods for the speech synth, thats ok heres that option");
        speechSynthMaxRange = configuration.getInt("Speech Synth: max range", configuration.CATEGORY_GENERAL, speechSynthMaxRange, 1, 2024, "Max range that the speech synth can be heard at(to prevent griefing)");


        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
