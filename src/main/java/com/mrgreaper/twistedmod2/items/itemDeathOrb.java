package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.entitys.entityDeathOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by david on 27/07/2014.
 */
public class itemDeathOrb extends twistedItems {
    public itemDeathOrb() {
        this.maxStackSize = 1;
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(new entityDeathOrb(world, x + 0.5, y + 1.5, z + 0.5));

            stack.stackSize--;

            return true;
        } else {
            return false;
        }

    }

}
