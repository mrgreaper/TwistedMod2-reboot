package com.mrgreaper.twistedmod2.entitys;

import com.mrgreaper.twistedmod2.handlers.ConfigHandler;
import com.mrgreaper.twistedmod2.handlers.SpeechThreaded;
import cpw.mods.fml.common.Optional;
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
@Optional.Interface(iface = "li.cil.oc.api.network.SimpleComponent", modid = "OpenComputers")
public class TileEntitySpeaky extends TileEntity implements SimpleComponent {
    @Override
    public String getComponentName() {
        return "Speech_Synth";
    }


    @Callback
    @Optional.Method(modid = "OpenComputers")
    //to use the player would do in lua component.Speech_Synth.speak(2,25,35,2,"hello world",20) which is voice,pitch,pitchrange,pitchshift,sentence to say,range
    public Object[] speak(final Context context, final Arguments args) {
        int voice = (args.checkInteger(0));
        int pitch = (args.checkInteger(1));
        int pitchRange = (args.checkInteger(2));
        int pitchShift = (args.checkInteger(3));
        String sentence = (args.checkString(4));
        int range = (args.checkInteger(5));
        if (range > ConfigHandler.speechSynthMaxRange) {
            range = ConfigHandler.speechSynthMaxRange;
        }
        AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, (double) (this.xCoord + 1), (double) (this.yCoord + 1), (double) (this.zCoord + 1)).expand(range, range, range);
        axisalignedbb.maxY = (double) this.worldObj.getHeight();
        List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
        Iterator iterator = list.iterator();
        EntityPlayer entityplayer;

        while (iterator.hasNext()) {
            entityplayer = (EntityPlayer) iterator.next();
            if (!worldObj.isRemote) {
                SpeechThreaded.speechSynth(voice, pitch, pitchRange, pitchShift, sentence);
            }

        }

        return new Object[]{true};
    }


}
