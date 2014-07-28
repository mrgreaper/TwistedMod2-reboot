package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.handlers.SoundHandler;
import cpw.mods.fml.common.Optional;
import li.cil.oc.api.network.Arguments;
import li.cil.oc.api.network.Callback;
import li.cil.oc.api.network.Context;
import li.cil.oc.api.network.SimpleComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 09/07/2014.
 */
@Optional.Interface(iface = "li.cil.oc.api.network.SimpleComponent", modid = "OpenComputers")
public class TileEntitySpeaker extends TileEntity implements SimpleComponent {
    @Override
    public String getComponentName() {
        return "Alarmer";
    }

    private boolean isPlaying = false; //when the tile entity is created we want to have it not playing
    private boolean shouldStart = false; //the triger we will use to start the sound
    private boolean shouldStop = false;
    private String soundName = "alarm-airraidA"; //setting the default sound name, later a gui will allow me to change it
    private float volume = 2f; //default volume set to 2 that should be 32 block radius, later a gui will help me to change it
    private String[] alarms = {"Dummy", "alarm-airraidA", "alarm-airraidB", "alarm-genericA", "alarm-genericB", "alarm-genericC", "alarm-genericD", "alarm-genericE", "alarm-genericF", "alarm-scifiA", "alarm-scifiB", "alarm-scifiC", "alarm-klaxonA", "alarm-klaxonB", "alarm-klaxonB"};
    private int numAlarms = alarms.length;


    @Override
    public void updateEntity() {
        if (!isPlaying && shouldStart) {//check to see if we are not already playing (to stop infinite amounts playing) and if we should start
            shouldStart = false; //set should start to false to stop us trying to play more
            shouldStop = false; //this is so when we have played and then stopped we can play again...yeah that was a bugger to solve!
            isPlaying = true; //we tell it we are now playing

            //TODO need to use a proxy for this....ahhhh crap
            if (this.worldObj.isRemote) {
                TwistedMod2.proxy.alarmSound(worldObj.getTileEntity(xCoord, yCoord, zCoord), soundName);
            }
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

    public void alarmSound(int i) {
        if (i < numAlarms && i > 0) {
            soundName = alarms[i];
        } else {
            soundName = alarms[1];
        }

    }

    //open computers functions
    @Callback
    @Optional.Method(modid = "OpenComputers") // component.Alarmer.setAlarm(1) will set the alarm to alarm 1
    public Object[] setAlarm(final Context context, final Arguments args) {
        alarmSound((args.checkInteger(0)));
        return new Object[]{true};
    }

    @Callback
    @Optional.Method(modid = "OpenComputers") // component.Alarmer.testAlarm() will test the alarm
    public Object[] testAlarm(final Context context, final Arguments args) {
        SoundHandler.atWorldplace(worldObj, xCoord, yCoord, zCoord, soundName, volume, 1);
        return new Object[]{true};
    }

    @Callback
    @Optional.Method(modid = "OpenComputers") // component.Alarmer.alarmOn()
    public Object[] alarmOn(final Context context, final Arguments args) {
        //boolean soundAlarm = (args.checkBoolean(1));

        shouldStart = true;

        return new Object[]{true};
    }

    @Callback
    @Optional.Method(modid = "OpenComputers") // component.Alarmer.alarmOff()
    public Object[] alarmOff(final Context context, final Arguments args) {
        //boolean soundAlarm = (args.checkBoolean(1));

        shouldStop = true;

        return new Object[]{true};
    }

}
