package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;

/**
 * Created by david on 24/06/2014.
 */
public class itemBunnyiteSpade extends ItemSpade {


    public itemBunnyiteSpade(ToolMaterial p_i45353_1_) {
        super(p_i45353_1_);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(TwistedMod2.MODID+":"+this.getUnlocalizedName().substring(5));
    }
}
