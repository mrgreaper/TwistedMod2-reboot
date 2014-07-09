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

    private TileEntitySpeaker tile; //we will need this for checking booleans and methods that are unique to TileEntitySpeaker


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
        return new TileEntitySpeaker(); //creating the tile entity
    }

    @Override
    public void onNeighborBlockChange(World world, int xCord, int yCord, int zCord, Block blockID) {
        if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) { //ok so if we are server side and we are NOT getting power but there has been a block update
            tile = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord); //we make sure tile is the TileEntity that is located at our blocks location
            tile.setShouldStop(true); //we tell the tileEntitySpeaker that we want shouldStop to be true
        }
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) { //we check to see if we are server side and if the block is getting powered and if theres been a block update around us
            tile = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord); //we make sure that tile is the TileEntitySpeaker thats at our blocks location (ok were not checking it is a TileEntitySpeaker, more casting it as...should be though unless something went wrong)
            tile.setShouldStart(true); //we tell the tileEntitySpeaker that we want shouldStart to be true
        }
    }
}

