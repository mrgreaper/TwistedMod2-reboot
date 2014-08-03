package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaky;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 23/07/2014.
 */
public class blockSpeaky extends BlockContainer {
    public blockSpeaky(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySpeaky();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
