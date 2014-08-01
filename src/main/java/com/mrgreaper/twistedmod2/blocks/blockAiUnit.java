package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.entitys.TileEntityAiUnit;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 01/08/2014.
 */
public class blockAiUnit extends BlockContainer {
    public blockAiUnit(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAiUnit();
    }


}
