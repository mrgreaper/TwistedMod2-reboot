package com.mrgreaper.twistedmod2;

import com.mrgreaper.twistedmod2.reference.Recipies;
import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import com.mrgreaper.twistedmod2.entitys.EntityInfo;
import com.mrgreaper.twistedmod2.handlers.*;
import com.mrgreaper.twistedmod2.items.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
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
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by david on 19/06/2014.
 */
@Mod(modid="twistedmod2",name = "Mr G Reapers Twisted Mod 2",version="1.7.2.1.0")

public class TwistedMod2 {


    TwistedWorldGen eventWorldGen = new TwistedWorldGen();

    public static CreativeTabs TwistedModTab;

    //materials moved to materials in handlers
    // public static Item.ToolMaterial NAME = EnumHelper.addToolMaterial(name,havestlevel,maxuses,efficiency,damage,enchantability)

    @Mod.Instance(Reference.MODID)
    public static TwistedMod2 instance;

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
        GameRegistry.registerWorldGenerator(eventWorldGen,0);
        ConfigHandler.init(event.getSuggestedConfigurationFile());

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new CraftingHandler()); //for our durable items
        NetworkRegistry.INSTANCE.registerGuiHandler(this,new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new Drops());//register our drop handler example
        Smelting.init();
        EntityInfo.init();

        GameRegistry.registerFuelHandler(new TwistedFuel());


    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
