package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 23/06/2014.
 */
public class TwistedFuel implements IFuelHandler{


    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem()== ItemInfo.itemDeadBunny) return 800;
        return 0;
    }



}
