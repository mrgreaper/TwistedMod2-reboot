package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by david on 24/06/2014.
 */
public class blockBunnyFurnace extends BlockContainer {

    private final boolean isActive;

    @SideOnly(Side.CLIENT)
    private IIcon IconFront;

    @SideOnly(Side.CLIENT)
    private IIcon IconTop;

    public blockBunnyFurnace(boolean isActive,Material material) {
        super(material);
        this.isActive = false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(TwistedMod2.MODID+":"+"BunnyFurnace_side");
        this.IconFront = iconRegister.registerIcon(TwistedMod2.MODID+":"+(this.isActive ? "BunnyFurnace_front_on" : "BunnyFurnace_front_off"));
        this.IconTop = iconRegister.registerIcon(TwistedMod2.MODID+":"+"BunnyFurnace_top");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
       // return metadata ==0 && side == 3 ? this.IconFront : (side ==metadata ? this.IconFront : this.blockIcon );
       return side == 3? this.IconFront : side ==1 ? this.IconTop :(side ==0 ? this.IconTop : (side !=metadata ? this.blockIcon: this.IconTop));
    //side 3 is the front 1 is top 0 is the bottom
    }
    
    public Item getItemDropped(World world,int x, int y, int z) {
        return Item.getItemFromBlock(BlockInfo.blockBunnyFurnaceIdle);
    }//always drop an idle furnace
    
    public void onBlockAdded(World world,int x,int y,int z){
        super.onBlockAdded(world,x,y,z);
        this.setDefaultDirection(world,x,y,z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block b1 = world.getBlock(x, y, z - 1);
            Block b2 = world.getBlock(x, y, z + 1);
            Block b3 = world.getBlock(x-1, y, z );
            Block b4 = world.getBlock(x+1, y, z );

            byte b0 =3;

            if (b1.func_149730_j() && !b2.func_149730_j()){
                b0=3;
            }
            if (b2.func_149730_j() && !b3.func_149730_j()){
                b0=2;
            }
            if (b3.func_149730_j() && !b4.func_149730_j()){
                b0=5;
            }

            if (b4.func_149730_j() && !b3.func_149730_j()){
                b0=4;
            }
            world.setBlockMetadataWithNotify(x,y,z,b0,2);
        }
    }
    //TODO onblockActiated

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }

    //TODO randomDisplayTick

    public void onBlockPlacedBy(World world,int x,int y,int z,EntityLivingBase entityplayer,ItemStack itemstack) {
        int I = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0f / 360.f)+ 0.50) & 3;

        if (I == 0){
            world.setBlockMetadataWithNotify(x,y,z,2,2);
        }
        if (I == 3){
            world.setBlockMetadataWithNotify(x,y,z,5,2);
        }
        if (I == 2){
            world.setBlockMetadataWithNotify(x,y,z,3,2);
        }
        if (I == 0){
            world.setBlockMetadataWithNotify(x,y,z,4,2);
        }
            //TODO 	if(itemstack.hasDisplayName()) {((TileEntityBunnyFurnace)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());

    }
    
    








    /*
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(TwistedMod2.MODID+":"+this.getUnlocalizedName().substring(5));
    }*/
}
