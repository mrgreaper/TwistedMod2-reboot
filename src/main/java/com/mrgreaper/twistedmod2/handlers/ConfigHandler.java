package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by david on 23/06/2014.
 */
public class ConfigHandler {

    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile){
        if(configuration==null) {
            configuration = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MODID)){
            loadConfiguration();
        }
    }


    public void loadConfiguration(){
        testValue = configuration.getBoolean("configValue",configuration.CATEGORY_GENERAL,false,"an example config value");
        if (configuration.hasChanged()){
            configuration.save();
        }
    }
}
