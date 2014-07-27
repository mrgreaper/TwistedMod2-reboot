package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.handlers.materials;
import com.mrgreaper.twistedmod2.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class ItemInfo {
    //rather then clutter up my main java file with item info lets pool it all here
    public static Item itemDeadBunny = new twistedItems().setUnlocalizedName("DeadBunny");
    public static Item itemBunnyiteIngot = new twistedItems().setUnlocalizedName("BunnyiteIngot");
    public static Item itemLivingBunny = new itemLivingBunny().setUnlocalizedName("LivingBunny");
    public static Item itemBunnyiteWasher = new twistedItems().setUnlocalizedName("BunnyiteWasher");
    public static Item itemRedballoon = new twistedItems().setUnlocalizedName("RedBalloon");
    public static Item itemDeathOrb = new itemDeathOrb().setUnlocalizedName("DeathOrb");
    public static Item itemOrphanLeg = new twistedItems().setUnlocalizedName("OrphanLeg");
    public static Item itemBunnySwordHilt = new twistedItems().setUnlocalizedName("BunnySwordHilt");
    public static Item itemBunnySword = new com.mrgreaper.twistedmod2.items.itemBunnySword(materials.BunnyiteMaterial).setUnlocalizedName("BunnySword");
    public static Item itemEnergizedBunny = new itemElectricBunny(10000, 100, 100).setUnlocalizedName("EnergizedBunny");
    public static Item itemTwistedHammer = new itemTwistedHammer().setUnlocalizedName("TwistedHammer");
    public static Item itemBunnyitePunch = new itemBunnyitePunch().setUnlocalizedName("BunnyitePunch");
    public static Item itemBunnyitePlate = new twistedItems().setUnlocalizedName("BunnyitePlate");
    public static Item itemBunnyitePickaxe = new itemBunnyitePickaxe(materials.BunnyiteMaterial).setUnlocalizedName("BunnyitePickaxe");
    public static Item itemBunnyiteAxe = new itemBunnyiteAxe(materials.BunnyiteMaterial).setUnlocalizedName("BunnyiteAxe");
    public static Item itemBunnyiteSpade = new itemBunnyiteSpade(materials.BunnyiteMaterial).setUnlocalizedName("BunnyiteSpade");
    public static Item itemBloodCrystal = new twistedItems().setUnlocalizedName("TwistedBloodCrystal");
    public static Item itemSecurityId = new itemSecurityId().setUnlocalizedName("SecurityId").setMaxStackSize(1);


    public static void init() {
        GameRegistry.registerItem(itemDeadBunny, "deadBunny");
        GameRegistry.registerItem(itemBunnyiteIngot, "BunnyiteIngot");
        GameRegistry.registerItem(itemLivingBunny, "LivingBunny");
        GameRegistry.registerItem(itemBunnyiteWasher, "BunnyiteWasher");
        GameRegistry.registerItem(itemRedballoon, "RedBalloon");
        GameRegistry.registerItem(itemDeathOrb, "DeathOrb");
        GameRegistry.registerItem(itemOrphanLeg, "OrphanLeg");
        GameRegistry.registerItem(itemBunnySwordHilt, "BunnySwordHilt");
        GameRegistry.registerItem(itemBunnySword, "BunnySword");
        GameRegistry.registerItem(itemBloodCrystal, "TwistedBloodCrystal");
        GameRegistry.registerItem(itemBunnyiteSpade, "BunnyiteSpade");
        GameRegistry.registerItem(itemEnergizedBunny, "EnergizedBunny");
        GameRegistry.registerItem(itemTwistedHammer, "TwistedHammer");
        GameRegistry.registerItem(itemBunnyitePunch, "BunnyitePunch");
        GameRegistry.registerItem(itemBunnyitePlate, "BunnyitePlate");
        GameRegistry.registerItem(itemBunnyitePickaxe, "BunnyitePickaxe");
        GameRegistry.registerItem(itemBunnyiteAxe, "BunnyiteAxe");
        GameRegistry.registerItem(itemSecurityId, "SecurityId");

    }
}
