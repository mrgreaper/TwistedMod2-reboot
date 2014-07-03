package com.mrgreaper.twistedmod2;

import com.mrgreaper.twistedmod2.proxy.IProxy;
import com.mrgreaper.twistedmod2.reference.Recipies;
import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import com.mrgreaper.twistedmod2.entitys.EntityInfo;
import com.mrgreaper.twistedmod2.handlers.*;
import com.mrgreaper.twistedmod2.items.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
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
@Mod(modid=Reference.MODID,name = Reference.MOD_NAME,version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class TwistedMod2 {


    TwistedWorldGen eventWorldGen = new TwistedWorldGen();

    public static CreativeTabs TwistedModTab;

    //materials moved to materials in handlers


    @Mod.Instance(Reference.MODID)
    public static TwistedMod2 instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        TwistedModTab = new CreativeTabs(Reference.MOD_NAME) {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ItemInfo.itemDeadBunny;
            }
        };
        ItemInfo.init();//to make things neater lets use an info class
        BlockInfo.init();
        Recipies.init();
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        


        LogHelper.info("pre initialisation complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new CraftingHandler()); //for our durable items
        FMLCommonHandler.instance().bus().register(new EventHandler());// out misc event handler class
        NetworkRegistry.INSTANCE.registerGuiHandler(this,new GuiHandler());
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
