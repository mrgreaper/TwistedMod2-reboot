package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.AlarmHandler;
import com.mrgreaper.twistedmod2.handlers.AlarmHandler2;
import com.mrgreaper.twistedmod2.handlers.SoundHandlerLooped;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 09/07/2014.
 */
public class TileEntitySpeaker extends TileEntity {

    private boolean isPlaying = false; //when the tile entity is created we want to have it not playing
    private boolean shouldStart = false; //the triger we will use to start the sound
    private boolean shouldStop = false;
    private String soundName = "alarm-airraidA"; //setting the default sound name
    private float volume = 2f; //default volume set to 2 that should be 32 block radius...hmmm should i make that an int...would be easier
    //private AlarmHandler alarm;


    @Override
    public void updateEntity() {
        if (!isPlaying && shouldStart) {
            shouldStart = false;
            shouldStop = false;
            isPlaying = true;
            // AlarmHandler alarm = new AlarmHandler(TileEntitySpeaker.this, soundName,volume,this);
            AlarmHandler2 alarm2 = new AlarmHandler2(worldObj.getTileEntity(xCoord, yCoord, zCoord), "alarm-airraidA");
            Minecraft.getMinecraft().getSoundHandler().playSound(alarm2);
        }

    }


    public boolean isShouldStop() {
        return shouldStop;
    }

    public void setShouldStart(boolean shouldStart) {
        this.shouldStart = shouldStart;
    }

    public void setShouldStop(boolean shouldStop) {
        if (isPlaying) {
            isPlaying = false;
            this.shouldStop = shouldStop;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    /*   //shouldnt be needed as it will be set in the tile entity itself
    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }
    */
}
