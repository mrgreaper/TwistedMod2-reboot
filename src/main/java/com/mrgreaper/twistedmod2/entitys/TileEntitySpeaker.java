package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.utility.LogHelper;
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

    public boolean isActived() {
        return Actived;
    }

    public void activateSpeaker(boolean active, String sndName) {
        Actived = active;
        soundName = sndName;
    }


    @Override
    public void updateEntity() {

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
