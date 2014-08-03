package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.reference.ItemInfo;
import li.cil.oc.api.Network;
import li.cil.oc.api.driver.Slot;
import li.cil.oc.api.network.Environment;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.DriverItem;
import li.cil.oc.api.prefab.ManagedEnvironment;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

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
    public ManagedEnvironment createEnviroment(ItemStack stack, TileEntity container) {
        return new Environment(container);
    }

    public class Enviroment extends ManagedEnvironment {
        protected final TileEntity container;

        public Enviroment(TileEntity container) {
            this.container = container;
            node = Network.newNode(this, Visibility.Neighbors).withComponent("speaky").create();

        }

    }


}
