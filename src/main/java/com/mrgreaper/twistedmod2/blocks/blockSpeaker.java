package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.TileEntityAlarm;
import com.mrgreaper.twistedmod2.handlers.SoundHandler;
import com.mrgreaper.twistedmod2.handlers.SoundHandlerLooped;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;


/**
 * Created by david on 23/06/2014.
 */
public class blockSpeaker extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    final static String[] metaBlocks = new String[]{"notActive", "isActive"}; //this will be the different meta data blocks

    public blockSpeaker() {
        super(Material.iron);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }


    @Override
    public void onNeighborBlockChange(World world, int xCord, int yCord, int zCord, Block blockID) {
        if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {

            world.setBlockMetadataWithNotify(xCord, yCord, zCord, 0, 3);
            world.removeTileEntity(xCord, yCord, zCord);

        } else if (!world.isRemote && world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
            world.setBlockMetadataWithNotify(xCord, yCord, zCord, 1, 3);

        }
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = new IIcon[metaBlocks.length];

        for (int i = 0; i < metaBlocks.length; i++) {
            texture[i] = iconRegister.registerIcon(Reference.MODID + ":" + "speaker-" + metaBlocks[i]);
        }
    }


    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < metaBlocks.length; i++) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return texture[meta];
    }

    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public boolean hasTileEntity(int meta) {
        if (meta == 1) {
            return true;
        }
        //TODO somehow tell it what tile entity to create...hmmm need to look into tile entitys more, must of missed something
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        if (metadata == 1) {
            return new TileEntityAlarm();
        }
        return null;
    }
}
