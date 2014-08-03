package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.handlers.ConfigHandler;
import com.mrgreaper.twistedmod2.handlers.SpeechThreaded;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.Optional;
import li.cil.oc.api.Network;
import li.cil.oc.api.driver.Container;
import li.cil.oc.api.driver.Slot;
import li.cil.oc.api.network.*;
import li.cil.oc.api.prefab.DriverItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.Iterator;
import java.util.List;

/**
 * Created by david on 03/08/2014.
 */
public class OCdriverCardSpeaky extends DriverItem {
    public OCdriverCardSpeaky() {
        super(new ItemStack(ItemInfo.OCcardSpeaky));
    }

    @Override
    public Slot slot(ItemStack stack) {
        return Slot.Card;
    }

    @Override
    public ManagedEnvironment createEnvironment(ItemStack stack, Container container) {
        if (container instanceof TileEntity) {
            return new Environment((TileEntity) container);
        }
        return null;
    }

    public class Environment extends li.cil.oc.api.prefab.ManagedEnvironment {
        protected final TileEntity container;

        public Environment(TileEntity container) {
            this.container = container;
            node = Network.newNode(this, Visibility.Neighbors).withComponent("speaky").create();

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
            AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double) container.xCoord, (double) container.yCoord, (double) container.zCoord, (double) (container.xCoord + 1), (double) (container.yCoord + 1), (double) (container.zCoord + 1)).expand(range, range, range);
            axisalignedbb.maxY = (double) container.getWorldObj().getHeight();
            List list = container.getWorldObj().getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
            Iterator iterator = list.iterator();
            EntityPlayer entityplayer;

            while (iterator.hasNext()) {
                entityplayer = (EntityPlayer) iterator.next();
                if (!container.getWorldObj().isRemote) {
                    SpeechThreaded.speechSynth(voice, pitch, pitchRange, pitchShift, sentence);
                }

            }

            return new Object[]{true};
        }

    }


}
