package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.SpeechThreaded;
import li.cil.oc.api.network.Arguments;
import li.cil.oc.api.network.Callback;
import li.cil.oc.api.network.Context;
import li.cil.oc.api.network.SimpleComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.Iterator;
import java.util.List;

/**
 * Created by david on 21/07/2014.
 */
public class TileEntitySpeaky extends TileEntity implements SimpleComponent {
    @Override
    public String getComponentName() {
        return "SpeechSynth";
    }


    @Callback
    public Object[] speak(final Context context, final Arguments args) {
        int voice = (args.checkInteger(0));
        int pitch = (args.checkInteger(1));
        int pitchRange = (args.checkInteger(2));
        int pitchShift = (args.checkInteger(3));
        String sentence = (args.checkString(4));
        int range = (args.checkInteger(5));
        AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, (double) (this.xCoord + 1), (double) (this.yCoord + 1), (double) (this.zCoord + 1)).expand(range, range, range);
        axisalignedbb.maxY = (double) this.worldObj.getHeight();
        List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
        Iterator iterator = list.iterator();
        EntityPlayer entityplayer;

        while (iterator.hasNext()) {
            entityplayer = (EntityPlayer) iterator.next();
            SpeechThreaded.speechSynth(voice, pitch, pitchRange, pitchShift, sentence);

        }

        return new Object[]{true};
    }


}
