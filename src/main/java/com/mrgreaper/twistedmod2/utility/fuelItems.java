package com.mrgreaper.twistedmod2.utility;

import com.mrgreaper.twistedmod2.handlers.ConfigHandler;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by david on 03/07/2014.
 */
public class fuelItems {

    public static int getItemBurntime(ItemStack itemstack) {//a helper util for fuels
        if (itemstack == null) {
            return 0;
        } else {
            Item item = itemstack.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {//this bit is to deal with if the item is a block...we get the item version of it
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.sapling) return 100;
                if (block == Blocks.coal_block) return 14400;
            }
            if (item == ItemInfo.itemDeadBunny) return ConfigHandler.deadBunnyBurnTime;
            if (item == ItemInfo.itemLivingBunny) return ConfigHandler.livingBunnyBurnTime;
            if (item == Items.coal) return 1600;
            if (item == Items.stick) return 100;
            if (item == Items.lava_bucket) return 2000;
            if (item == Items.blaze_rod) return 2400;
        }
        return GameRegistry.getFuelValue(itemstack);
    }
}
