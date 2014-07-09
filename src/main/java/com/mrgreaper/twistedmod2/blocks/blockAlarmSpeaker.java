package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaker;
import com.mrgreaper.twistedmod2.handlers.SoundHandlerLooped;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 09/07/2014.
 */
public class blockAlarmSpeaker extends BlockContainer {

    private TileEntitySpeaker tile;


    public blockAlarmSpeaker(Material material) {
        super(material);

        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySpeaker();
    }

    @Override
    public void onNeighborBlockChange(World world, int xCord, int yCord, int zCord, Block blockID) {
        if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
            tile = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord);
            tile.setShouldStop(true);
        }
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
            tile = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord);
            tile.setShouldStart(true);
        }
    }
}

