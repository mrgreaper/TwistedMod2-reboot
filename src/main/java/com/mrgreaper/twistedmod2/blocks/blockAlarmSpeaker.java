package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaker;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
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
        if (!world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) { //ok so if we are server side and we are NOT getting power but there has been a block update
            world.addBlockEvent(xCord, yCord, zCord, this, 1, 0);
        }
        if (world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) { //we check to see if we are server side and if the block is getting powered and if theres been a block update around us
            tile = (TileEntitySpeaker) world.getTileEntity(xCord, yCord, zCord); //we make sure that tile is the TileEntitySpeaker thats at our blocks location (ok were not checking it is a TileEntitySpeaker, more casting it as...should be though unless something went wrong)
            //tile.setShouldStart(true); //we tell the tileEntitySpeaker that we want shouldStart to be true
            world.addBlockEvent(xCord, yCord, zCord, this, 0, 0); //hmm so (x,y,z, block? if thats this block then this, event id, event paramater?)
            //LogHelper.info("Block event sent: block was " + this + " x:" + xCord + " y:" + yCord + " z:" + zCord);
        }
    }

    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventPramater) {
        LogHelper.info("i recieved a block event with world:" + world + " x:" + x + " y:" + y + " z:" + z + " event id :" + eventId + "event paramater :" + eventPramater);
        if (world.isRemote && eventId == 0) {
            //LogHelper.info("i realised that im on the client side and that the id is 0 so i will now tell the tile to start");
            tile = (TileEntitySpeaker) world.getTileEntity(x, y, z);
            tile.setShouldStart(true);
        }
        if (!world.isRemote && eventId == 0) {
            //LogHelper.info("and im on the server side but i noticed that the block was updated and that the id was 0 ...i wont tell the sound to start though");
        }
        if (world.isRemote && eventId == 1) {
            //LogHelper.info("so you wanna kill sound and your on the client side...ok");
            tile = (TileEntitySpeaker) world.getTileEntity(x, y, z);
            tile.setShouldStop(true);
        }
        return true;
    }
}

