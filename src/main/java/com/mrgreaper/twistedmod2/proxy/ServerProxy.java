package com.mrgreaper.twistedmod2.proxy;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 02/07/2014.
 */
public class ServerProxy extends CommonProxy {


    @Override
    public void alarmSound(TileEntity tileEntity, String soundName) {
        //dont do it! sounds are client side...bad mod ...dont make me get the newspaper!
    }
}
