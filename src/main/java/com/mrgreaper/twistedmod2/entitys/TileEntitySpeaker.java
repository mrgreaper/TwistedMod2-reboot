package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.SoundHandlerLooped;
import com.mrgreaper.twistedmod2.handlers.SpeechThreaded;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 06/07/2014.
 */
public class TileEntitySpeaker extends TileEntity {
    private String soundName = " ";
    private boolean isPlaying;
    private boolean shouldStop;
    public boolean Actived;
    private boolean start = false;
    private SoundHandlerLooped alarmSound;
    //private SpeechThreaded speech = new SpeechThreaded();

    public boolean isActived() {
        return Actived;
    }

    public void activateSpeaker(boolean active, String sndName) {
        Actived = active;
        soundName = sndName;
        LogHelper.info(active + sndName);
        shouldStop = false;
        start = true;
    }

    public void setShouldStop(boolean toggle) {
        shouldStop = toggle;
    }


    @Override
    public void updateEntity() {
        //LogHelper.info("Start =  "+start);
        if (start) {
            LogHelper.info("YES DETECETED");
            alarmSound = new SoundHandlerLooped(worldObj.getTileEntity(xCoord, yCoord, zCoord), soundName);
            start = false;
            isPlaying = true;
            if (!worldObj.isRemote) {
                LogHelper.info("YES IS CLIENT SIDE");
                // SpeechThreaded.speechSynth(1,0,60,10,"This is a test of the speech system");
                Minecraft.getMinecraft().getSoundHandler().playSound(alarmSound);
            }
        }
        if (isPlaying && shouldStop) {
            LogHelper.info("stopping sound");
            isInvalid();
            shouldStop = false;
        }
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        soundName = nbt.getString("sndName");
        isPlaying = nbt.getBoolean("isPlay");
        shouldStop = nbt.getBoolean("shouldStop");
        Actived = nbt.getBoolean("activated");

        //nbt tags will be loaded in here...none at mo

    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setString("sndName", soundName);
        nbt.setBoolean("isPlay", isPlaying);
        nbt.setBoolean("shouldStop", shouldStop);
        nbt.setBoolean("activated", Actived);
        //nbt tags will be saved in here when we have some
    }
}
