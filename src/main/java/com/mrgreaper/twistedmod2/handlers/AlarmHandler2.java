package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaker;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by david on 09/07/2014.
 */
public class AlarmHandler2 extends MovingSound {
    private final TileEntity tileentity;
    private TileEntitySpeaker tileSpeaker;


    public AlarmHandler2(TileEntity tile, String Soundname) {
        super(new ResourceLocation(Reference.MODID + ":" + Soundname));
        this.tileentity = tile;
        this.repeat = true;
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileSpeaker = (TileEntitySpeaker) tileentity;
    }


    public void update() {
        LogHelper.info("i should be making noise oh and volume is " + volume);
        if (tileSpeaker.isShouldStop()) {
            LogHelper.info("ok ill shut up now");
            this.donePlaying = true;
        }
    }

    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }
}