package com.mrgreaper.twistedmod2.proxy;

import com.mrgreaper.twistedmod2.client.render.renderDeathorb;
import com.mrgreaper.twistedmod2.client.render.renderEntityBunny;
import com.mrgreaper.twistedmod2.entitys.entityBunnyMob;
import com.mrgreaper.twistedmod2.entitys.entityDeathOrb;
import com.mrgreaper.twistedmod2.handlers.AlarmHandler2;
import com.mrgreaper.twistedmod2.models.ModelBunny;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 02/07/2014.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void alarmSound(TileEntity tileEntity, String soundName) {
        LogHelper.info(" proxy recieved :" + soundName + " as the sound name");
        AlarmHandler2 alarm2 = new AlarmHandler2(tileEntity, soundName); //create a new instance of the alarmhandler2
        Minecraft.getMinecraft().getSoundHandler().playSound(alarm2); //make some noise
    }

    public void registerRenderThings() {
        RenderingRegistry.registerEntityRenderingHandler(entityBunnyMob.class, new renderEntityBunny(new ModelBunny(), 0));
        RenderingRegistry.registerEntityRenderingHandler(entityDeathOrb.class, new renderDeathorb());

    }

}
