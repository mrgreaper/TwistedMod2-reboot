package com.mrgreaper.twistedmod2.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 08/07/2014.
 */
public class itemSpeakerBlocks extends ItemBlock {


    final static String[] metaBlocks = new String[]{"notActive", "isActive"}; //this will be the different meta data blocks

    public itemSpeakerBlocks(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int i = itemstack.getItemDamage();
        if (i < 0 || i >= metaBlocks.length) {
            i = 0;
        }

        return super.getUnlocalizedName() + "." + metaBlocks[i];
    }

    public int getMetadata(int meta) {
        return meta;
    }
}
