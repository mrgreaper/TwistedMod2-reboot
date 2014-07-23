package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.entitys.TileEntitySpeaky;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
}
