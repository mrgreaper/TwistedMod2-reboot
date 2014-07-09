package com.mrgreaper.twistedmod2.handlers;

import com.mrgreaper.twistedmod2.container.ContainerBunnyFurnace;
import com.mrgreaper.twistedmod2.container.ContainerLivingBunny;
import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import com.mrgreaper.twistedmod2.gui.GuiBunnyFurnace;
import com.mrgreaper.twistedmod2.gui.GuiLivingBunny;
import com.mrgreaper.twistedmod2.reference.BlockInfo;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 26/06/2014.
 */
public class GuiHandler implements IGuiHandler {


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case BlockInfo.guiIDBunnyFurnace:
                    if (entity instanceof TileEntityBunnyFurnace) {
                        return new ContainerBunnyFurnace(player.inventory, (TileEntityBunnyFurnace) entity);
                    }
                    //return null;
                case BlockInfo.guiIDLivingBunny:
                    return new ContainerLivingBunny(player);


            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case BlockInfo.guiIDBunnyFurnace:
                    if (entity instanceof TileEntityBunnyFurnace) {
                        return new GuiBunnyFurnace(player.inventory, (TileEntityBunnyFurnace) entity);
                    }
                    //  return null;
                case BlockInfo.guiIDLivingBunny:
                    return new GuiLivingBunny(player);
            }
        }
        return null;
    }
}
