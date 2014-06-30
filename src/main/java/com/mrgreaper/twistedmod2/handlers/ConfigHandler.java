package com.mrgreaper.twistedmod2.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by david on 23/06/2014.
 */
public class ConfigHandler {

    public static void init(File configFile){
        Configuration configuration = new Configuration(configFile);

        try{
            //load config
            configuration.load();
            //read propertys
            boolean configValue = configuration.get(Configuration.CATEGORY_GENERAL, "test Value", true,"an example comment").getBoolean(true);

        }
        //catch errors
        catch (Exception e)
        {}
        finally { //finally runs at the end of a try catch no matter what
            //save configuration
            configuration.save();
            System.out.println("TwistMod saved config (it may not of changed :) )");
        }
    }
}
