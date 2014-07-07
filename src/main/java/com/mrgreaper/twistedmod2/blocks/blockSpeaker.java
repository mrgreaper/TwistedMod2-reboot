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
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 23/06/2014.
 */
public class blockSpeaker extends Block {


    public blockSpeaker(Material material) {
        super(material);

        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    public boolean isactive = false;
    private ISound testSound2;


    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySpeaker();
    }


    public void onNeighborBlockChange(World world, int xCord, int yCord, int zCord, Block blockID) {
        LogHelper.info("change");
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
            LogHelper.info("I see it i see it!");
            testSound2 = new SoundHandlerLooped(Reference.MODID + ":alarm-genericB", xCord, yCord, zCord, 1, 1);
            // Minecraft.getMinecraft().getSoundHandler().playSound(testSound2); //commented out for now
        }

        if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(xCord, yCord, zCord)) {
            //testSound2.setcontinuePlaying(false);
            LogHelper.info("arghhhhhhhhhhhhhhhhhhhhhhhhhh");
        }
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
