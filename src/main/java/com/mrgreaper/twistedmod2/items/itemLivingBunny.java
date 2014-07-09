package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.reference.BlockInfo;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by david on 09/07/2014.
 */
public class itemLivingBunny extends twistedItems {

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        LogHelper.info("you right clicked");
        //player.openGui(TwistedMod2.instance, BlockInfo.guiIDLivingBunny,world,(int)player.posX,(int)player.posY,(int)player.posZ);
        FMLNetworkHandler.openGui(player, TwistedMod2.instance, BlockInfo.guiIDLivingBunny, world, (int) player.posX, (int) player.posY, (int) player.posZ);

        return itemStack;

    }

}
