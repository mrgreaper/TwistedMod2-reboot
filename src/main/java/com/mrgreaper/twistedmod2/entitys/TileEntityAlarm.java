package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.SoundHandler;
import com.mrgreaper.twistedmod2.handlers.SoundHandlerLooped;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 08/07/2014.
 */
public class TileEntityAlarm extends TileEntity {

    private boolean isPlaying = false;
    private String soundName = "alarm-airraidA"; //set a default sound file...though i doubt we can change it


    @Override
    public void updateEntity() {

        //LogHelper.info("ping ping ping ping ping ");//test code shows the tile entity is working
        if (!isPlaying) {
            //code to start the alarm
            SoundHandlerLooped alarmSound = new SoundHandlerLooped(worldObj.getTileEntity(xCoord, yCoord, zCoord), "alarm-airraidA");
            Minecraft.getMinecraft().getSoundHandler().playSound(alarmSound);
            isPlaying = true;
        }
    }


    //since the sound will be stopped when we relaunchmc or in theory go to far from the chunk and it de-loads its
    //better to have it we load the isplaying at false so it restarts it
    //just need to save ths sound name were looping
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        soundName = nbt.getString("sndName");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setString("sndName", soundName);

    }


}
