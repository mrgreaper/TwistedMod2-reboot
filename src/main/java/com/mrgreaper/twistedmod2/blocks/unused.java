package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by david on 24/06/2014.
 */
public class unused extends Block {
    protected unused(Material material) {
        super(material);
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(TwistedMod2.MODID+":"+this.getUnlocalizedName().substring(5));
    }
}
