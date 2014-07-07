package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaker;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


/**
 * Created by david on 23/06/2014.
 */
public class blockSpeaker extends BlockContainer {

    private boolean isOn;

    //@SideOnly(Side.SERVER)
    public IIcon activeIcon;


    public blockSpeaker(Material material) {
        super(material);

        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySpeaker();
    }


    public void onNeighborBlockChange(World world, int xCord, int yCord, int zCord, Block blockID) {
        LogHelper.info(this.isOn);
        if (!world.isRemote) {
            if (this.isOn && !world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
                world.scheduleBlockUpdate(xCord, yCord, zCord, this, 4); //hmmm not sure what the 4 is
                isOn = false;
            } else if (!this.isOn && world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
                isOn = true;
                TileEntitySpeaker spealer2 = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord);
                spealer2.activateSpeaker(true, "alarm-genericA");


            }
        }
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
        this.activeIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5) + "_active");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {

        TileEntitySpeaker speaker = (TileEntitySpeaker) world.getTileEntity(x, y, z);

        return speaker.isActived() ? activeIcon : blockIcon;
    }
}
