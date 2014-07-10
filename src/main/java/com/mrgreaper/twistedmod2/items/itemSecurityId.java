package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.handlers.ReaperHelper;
import com.mrgreaper.twistedmod2.reference.BlockInfo;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by david on 09/07/2014.
 */
public class itemSecurityId extends twistedItems {

    //while learning nbt tags i came across a guide for keys, it gave me an idea for security ids, these will be used in two ways
    //1 on a secure alarmblock that will only shut off when right clicked with an authorized id card
    //2 a secure block that will stop emiting redstone only when right clicked with a authorized id card


    @Override //ok so when the item is created we make a nbt tag but not as i know it
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        LogHelper.info("item created");
        makeNBT(itemStack, player); //lets make it a function so we can call it if theres not a tag:)
    }


    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, //cant take credit for this http://www.minecraftforge.net/wiki/Creating_NBT_for_items though im doing a lot of it VERY different
                               List list, boolean par4) {
        if (itemStack.stackTagCompound != null) {
            String owner = itemStack.stackTagCompound.getString("user");
            String code = itemStack.stackTagCompound.getString("accessCode");
            list.add("Id Belongs to : " + owner);
            if (owner.equals(player.getDisplayName())) {
                list.add(EnumChatFormatting.GREEN + "Pass Code : " + code);
            } else {
                list.add(EnumChatFormatting.RED + "Pass Code : "
                        + EnumChatFormatting.OBFUSCATED + code);
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        LogHelper.info("security id right clicked");
        if (!player.isSneaking()) {
            if (itemStack.stackTagCompound != null) {
            } else {
                LogHelper.info("no tag compound lets make one");
                makeNBT(itemStack, player);
            }
        } else {
            if (itemStack.stackTagCompound != null) {
                FMLNetworkHandler.openGui(player, TwistedMod2.instance, BlockInfo.guiIDSecurityId, world, (int) player.posX, (int) player.posY, (int) player.posZ);


            } else {
                LogHelper.info("no tag compound lets make one");
                makeNBT(itemStack, player);
            }
        }
        return itemStack;
    }

    public void makeNBT(ItemStack itemStack, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setString("user", player.getDisplayName()); //we get the username and set it as the string tag "user"
        itemStack.stackTagCompound.setString("accessCode", ReaperHelper.securityCode());//ok lets get a REALLY big number lol
    }


}
