package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class twistedItems extends Item {

    public twistedItems() {
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

}
