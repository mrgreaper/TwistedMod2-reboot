package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
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


    public static void init(){

        itemDeadBunny = new twistedItems().setUnlocalizedName("DeadBunny");
        GameRegistry.registerItem(itemDeadBunny,"deadBunny");
        itemBunnyiteIngot = new twistedItems().setUnlocalizedName("BunnyiteIngot");
        GameRegistry.registerItem(itemBunnyiteIngot,"BunnyiteIngot");
        itemLivingBunny = new twistedItems().setUnlocalizedName("LivingBunny");
        GameRegistry.registerItem(itemLivingBunny,"LivingBunny");
        itemBunnyiteWasher = new twistedItems().setUnlocalizedName("BunnyiteWasher");
        GameRegistry.registerItem(itemBunnyiteWasher,"BunnyiteWasher");
        itemRedballoon = new twistedItems().setUnlocalizedName("RedBalloon");
        GameRegistry.registerItem(itemRedballoon,"RedBalloon");
        itemDeathOrb = new twistedItems().setUnlocalizedName("DeathOrb");
        GameRegistry.registerItem(itemDeathOrb,"DeathOrb");
        itemOrphanLeg = new twistedItems().setUnlocalizedName("OrphanLeg");
        GameRegistry.registerItem(itemOrphanLeg,"OrphanLeg");
        itemBunnySwordHilt = new twistedItems().setUnlocalizedName("BunnySwordHilt");
        GameRegistry.registerItem(itemBunnySwordHilt,"BunnySwordHilt");
        itemBunnySword = new itemBunnySword(TwistedMod2.BunnyiteMaterial).setUnlocalizedName("BunnySword");
        GameRegistry.registerItem(itemBunnySword,"BunnySword");
        itemEnergizedBunny = new twistedItems().setUnlocalizedName("EnergizedBunny");
        GameRegistry.registerItem(itemEnergizedBunny,"EnergizedBunny");
        itemTwistedHammer = new itemTwistedHammer().setUnlocalizedName("TwistedHammer");
        GameRegistry.registerItem(itemTwistedHammer,"TwistedHammer");
        itemBunnyitePunch = new itemBunnyitePunch().setUnlocalizedName("BunnyitePunch");
        GameRegistry.registerItem(itemBunnyitePunch,"BunnyitePunch");
        itemBunnyitePlate = new twistedItems().setUnlocalizedName("BunnyitePlate");
        GameRegistry.registerItem(itemBunnyitePlate,"BunnyitePlate");
        itemBunnyitePickaxe = new itemBunnyitePickaxe(TwistedMod2.BunnyiteMaterial).setUnlocalizedName("BunnyitePickaxe");
        GameRegistry.registerItem(itemBunnyitePickaxe,"BunnyitePickaxe");
        itemBunnyiteAxe = new itemBunnyiteAxe(TwistedMod2.BunnyiteMaterial).setUnlocalizedName("BunnyiteAxe");
        GameRegistry.registerItem(itemBunnyiteAxe,"BunnyiteAxe");
        itemBunnyiteSpade = new itemBunnyiteSpade(TwistedMod2.BunnyiteMaterial).setUnlocalizedName("BunnyiteSpade");
        GameRegistry.registerItem(itemBunnyiteSpade,"BunnyiteSpade");


    }
}
