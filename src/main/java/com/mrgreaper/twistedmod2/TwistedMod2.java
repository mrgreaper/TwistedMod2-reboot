package com.mrgreaper.twistedmod2;

import com.mrgreaper.twistedmod2.entitys.EntityInfo;
import com.mrgreaper.twistedmod2.handlers.*;
import com.mrgreaper.twistedmod2.proxy.IProxy;
import com.mrgreaper.twistedmod2.reference.*;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by david on 19/06/2014.
 */
@Mod(modid = Reference.MODID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class TwistedMod2 {


    public static CreativeTabs TwistedModTab;
    @Mod.Instance(Reference.MODID)
    public static TwistedMod2 instance;

    //materials moved to materials in handlers
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    TwistedWorldGen eventWorldGen = new TwistedWorldGen();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TwistedModTab = new CreativeTabs(Reference.MOD_NAME) {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ItemInfo.itemDeadBunny;
            }
        };
        FMLCommonHandler.instance().bus().register(new TwistedEventHandler());// out misc event handler class
        MinecraftForge.EVENT_BUS.register(new TwistedEventHandler());
        ItemInfo.init();//to make things neater lets use an info class
        BlockInfo.init();//and a block one
        Recipies.init();//and a recipie one
        FluidInfo.init();// and a fluid one
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);
        ConfigHandler.init(event.getSuggestedConfigurationFile());


        LogHelper.info("pre initialisation complete!");//left so i wont forget how to use the log helper..not that its exactly rocket science, for one theres no rockets :(
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new CraftingHandler()); //for our durable items
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new DropsHandler());//register our drop handler example
        Smelting.init();
        EntityInfo.init();

        GameRegistry.registerFuelHandler(new TwistedFuel());


        LogHelper.info("initialisation complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        LogHelper.info("post initialisation complete!");
    }


}
