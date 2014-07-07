package com.mrgreaper.twistedmod2.handlers;

import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by david on 06/07/2014.
 */
public class SoundHandlerLooped extends PositionedSound implements ITickableSound {
    protected boolean donePlaying = false;
    private boolean continuePlaying;
    private int counterToStop;

    public SoundHandlerLooped(ResourceLocation path, int xCord, int yCord, int zCord, float volume, float pitch) {
        super(path);
        this.repeat = true;
        this.volume = volume;
        this.field_147663_c = pitch;
        this.xPosF = xCord;
        this.yPosF = yCord;
        this.zPosF = zCord;
        this.field_147665_h = 0;
    }

    public SoundHandlerLooped(String path, int xCord, int yCord, int zCord, float volume, float pitch) {
        this(new ResourceLocation(path), xCord, yCord, zCord, volume, pitch);
    }

    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }

    @Override
    public void update() {
        this.counterToStop++;
        if (!this.continuePlaying) {
            this.donePlaying = true;
        }
        if (this.counterToStop >= 200) {
            this.counterToStop = 0;
            this.donePlaying = true;
        }
    }

    public void setContinuePlaying(boolean var1) {
        this.continuePlaying = var1;
    }


}
