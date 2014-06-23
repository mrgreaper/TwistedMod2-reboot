package com.mrgreaper.twistedmod2;

import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import com.mrgreaper.twistedmod2.handlers.Drops;
import com.mrgreaper.twistedmod2.items.ItemInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by david on 19/06/2014.
 */
@Mod(modid="twistedmod2",name = "Mr G Reapers Twisted Mod 2",version="1.7.2.1.0")

public class TwistedMod2 {
    public static String MODID = "twistedmod2";
    public static String VERSION= "1.7.2.1.0";

    public static CreativeTabs TwistedModTab;

    @Mod.Instance("TwistedMod2")
    public static TwistedMod2 instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        TwistedModTab = new CreativeTabs("TwistedMod2") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Items.arrow;
            }
        };
        ItemInfo.init();//to make things neater lets use an info class
        BlockInfo.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new Drops());//register our drop handler example

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
