package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.handlers.materials;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class ItemInfo {
    //rather then clutter up my main java file with item info lets pool it all here
    public static Item itemDeadBunny;
    public static Item itemBunnyiteIngot;
    public static Item itemLivingBunny;
    public static Item itemBunnyiteWasher;
    public static Item itemRedballoon;
    public static Item itemDeathOrb;
    public static Item itemOrphanLeg;
    public static Item itemBunnySwordHilt;
    public static Item itemBunnySword;
    public static Item itemEnergizedBunny;
    public static Item itemTwistedHammer;
    public static Item itemBunnyitePunch;
    public static Item itemBunnyitePlate;
    public static Item itemBunnyitePickaxe;
    public static Item itemBunnyiteAxe;
    public static Item itemBunnyiteSpade;
    public static Item itemBloodCrystal;


    public static void init(){

        itemDeadBunny = new twistedItems().setUnlocalizedName("DeadBunny");
        itemBunnyiteIngot = new twistedItems().setUnlocalizedName("BunnyiteIngot");
        itemLivingBunny = new twistedItems().setUnlocalizedName("LivingBunny");
        itemBunnyiteWasher = new twistedItems().setUnlocalizedName("BunnyiteWasher");
        itemRedballoon = new twistedItems().setUnlocalizedName("RedBalloon");
        itemDeathOrb = new twistedItems().setUnlocalizedName("DeathOrb");
        itemOrphanLeg = new twistedItems().setUnlocalizedName("OrphanLeg");
        itemBunnySwordHilt = new twistedItems().setUnlocalizedName("BunnySwordHilt");
        itemBunnySword = new itemBunnySword(materials.BunnyiteMaterial).setUnlocalizedName("BunnySword");
        itemEnergizedBunny = new twistedItems().setUnlocalizedName("EnergizedBunny");
        itemTwistedHammer = new itemTwistedHammer().setUnlocalizedName("TwistedHammer");
        itemBunnyitePunch = new itemBunnyitePunch().setUnlocalizedName("BunnyitePunch");
        itemBunnyitePlate = new twistedItems().setUnlocalizedName("BunnyitePlate");
        itemBunnyitePickaxe = new itemBunnyitePickaxe(materials.BunnyiteMaterial).setUnlocalizedName("BunnyitePickaxe");
        itemBunnyiteAxe = new itemBunnyiteAxe(materials.BunnyiteMaterial).setUnlocalizedName("BunnyiteAxe");
        itemBunnyiteSpade = new itemBunnyiteSpade(materials.BunnyiteMaterial).setUnlocalizedName("BunnyiteSpade");
        itemBloodCrystal = new twistedItems().setUnlocalizedName("TwistedBloodCrystal");

        GameRegistry.registerItem(itemDeadBunny,"deadBunny");
        GameRegistry.registerItem(itemBunnyiteIngot,"BunnyiteIngot");
        GameRegistry.registerItem(itemLivingBunny,"LivingBunny");
        GameRegistry.registerItem(itemBunnyiteWasher,"BunnyiteWasher");
        GameRegistry.registerItem(itemRedballoon,"RedBalloon");
        GameRegistry.registerItem(itemDeathOrb,"DeathOrb");
        GameRegistry.registerItem(itemOrphanLeg,"OrphanLeg");
        GameRegistry.registerItem(itemBunnySwordHilt,"BunnySwordHilt");
        GameRegistry.registerItem(itemBunnySword,"BunnySword");
        GameRegistry.registerItem(itemBloodCrystal,"TwistedBloodCrystal");
        GameRegistry.registerItem(itemBunnyiteSpade,"BunnyiteSpade");
        GameRegistry.registerItem(itemEnergizedBunny,"EnergizedBunny");
        GameRegistry.registerItem(itemTwistedHammer,"TwistedHammer");
        GameRegistry.registerItem(itemBunnyitePunch,"BunnyitePunch");
        GameRegistry.registerItem(itemBunnyitePlate,"BunnyitePlate");
        GameRegistry.registerItem(itemBunnyitePickaxe,"BunnyitePickaxe");
        GameRegistry.registerItem(itemBunnyiteAxe,"BunnyiteAxe");

    }
}
