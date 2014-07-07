package com.mrgreaper.twistedmod2.entitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 06/07/2014.
 */
public class TileEntitySpeaker extends TileEntity {


    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        //nbt tags will be loaded in here...none at mo

    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        //nbt tags will be saved in here when we have some

    }
}
