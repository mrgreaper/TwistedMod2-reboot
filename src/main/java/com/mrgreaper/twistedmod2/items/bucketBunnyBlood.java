package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;

/**
 * Created by david on 06/07/2014.
 */
public class bucketBunnyBlood extends ItemBucket {
    public bucketBunnyBlood(Block fluidBlock) {
        super(fluidBlock);
        this.setUnlocalizedName("bucketOfBunnyBlood");
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}