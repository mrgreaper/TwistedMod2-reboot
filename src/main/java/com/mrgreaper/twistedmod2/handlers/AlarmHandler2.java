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
    private TileEntitySpeaker tileSpeaker; //again we make a value that will be used to get information from


    public AlarmHandler2(TileEntity tile, String Soundname) { //we are taking in the tile entity and the sound name
        super(new ResourceLocation(Reference.MODID + ":" + Soundname)); //setting the location of the sound file
        this.tileentity = tile; //we tell it that tileentity is the TileEntity we passed it on creating this instance
        this.repeat = true; //we say that we want the sound to repeat
        volume = 2f; //we hard code the volume....i need to actually pass it the volume i just forgot that untill this comment but meh thats easy, will do it later
        this.xPosF = tileentity.xCoord; //so were getting the location of the tile entity and putting them into values that the sound player WILL use (where i went wrong before)
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileSpeaker = (TileEntitySpeaker) tileentity; // since we know that the TileEntity is going to be a TileEntitySpeaker we can safely cast this variable as one :)
    }


    public void update() { //this is run every tick
        // LogHelper.info("i should be making noise oh and volume is " + volume); //this is designed to give me feedback when debuging...its invaluable!
        if (tileSpeaker.isShouldStop()) { //ok so each tick we are looking at the speaker tile entity to see if we should stop or not
            //LogHelper.info("ok ill shut up now");
            this.donePlaying = true; //stop making that awful noise we say
        }
    }

    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    } //this is how the sound manager checks to see if it can shut the hell up yet :)
}