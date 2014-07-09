package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.AlarmHandler2;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 09/07/2014.
 */
public class TileEntitySpeaker extends TileEntity {

    private boolean isPlaying = false; //when the tile entity is created we want to have it not playing
    private boolean shouldStart = false; //the triger we will use to start the sound
    private boolean shouldStop = false;
    private String soundName = "alarm-airraidA"; //setting the default sound name, later a gui will allow me to change it
    private float volume = 2f; //default volume set to 2 that should be 32 block radius, later a gui will help me to change it


    @Override
    public void updateEntity() {
        if (!isPlaying && shouldStart) {//check to see if we are not already playing (to stop infinite amounts playing) and if we should start
            shouldStart = false; //set should start to false to stop us trying to play more
            shouldStop = false; //this is so when we have played and then stopped we can play again...yeah that was a bugger to solve!
            isPlaying = true; //we tell it we are now playing

            //TODO need to use a proxy for this....ahhhh crap
            // AlarmHandler alarm = new AlarmHandler(TileEntitySpeaker.this, soundName,volume,this);
            // AlarmHandler2 alarm2 = new AlarmHandler2(worldObj.getTileEntity(xCoord, yCoord, zCoord), "alarm-airraidA"); //create a new instance of the alarmhandler2
            //Minecraft.getMinecraft().getSoundHandler().playSound(alarm2); //make some noise
        }
    }


    public boolean isShouldStop() { //so we can see if we should stop this method allows checking for it
        return shouldStop;
    }

    public void setShouldStart(boolean shouldStart) { //this is what we call from our block and set to true to play sound
        this.shouldStart = shouldStart;
    }

    public void setShouldStop(boolean shouldStop) { //we call this to stop the sound..well to set it up to stop
        if (isPlaying) { //we make sure sound is playing, otherwise a bug in the way minecraft deals with block updates causes it to start and stop immediatly
            isPlaying = false; //since were stoping it we set this to false to say the sound is no longer playing
            this.shouldStop = shouldStop;
        }
    }

    public boolean isPlaying() { //we use this to allow other classes to see if were playing or not
        return isPlaying;
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        soundName = nbt.getString("sndName");
        shouldStop = nbt.getBoolean("shouldStop");
        shouldStart = nbt.getBoolean("shouldStart");
        volume = nbt.getFloat("vol");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setString("sndName", soundName);
        nbt.setBoolean("shouldStop", shouldStop);
        nbt.setBoolean("shouldStart", shouldStart);
        nbt.setFloat("vol", volume);
        //we allow isPlaying to reset itself to false...i possibly dont need to save some of the others lol
    }

}
