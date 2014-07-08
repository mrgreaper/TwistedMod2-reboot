package com.mrgreaper.twistedmod2.items;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.handlers.SoundHandler;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

/**
 * Created by david on 24/06/2014.
 */
public class itemBunnySword extends ItemSword {
    public itemBunnySword(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.worldObj.isRemote) {
            SoundHandler.miniSoundPlay("bunnySwordInsert", player);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        if (!player.worldObj.isRemote) {
            SoundHandler.onEntityPlay("growl", world, player, 1, 1);
        }
        return itemStack;
    }



    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

}
