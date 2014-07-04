package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by david on 24/06/2014.
 */
public class blockBunnyFurnace extends BlockContainer {

    private final boolean isActive;

    @SideOnly(Side.CLIENT)
    private IIcon IconFront;

    private static boolean keepInventory;
    private Random rand = new Random();

    @SideOnly(Side.CLIENT)
    private IIcon IconTop;

    public blockBunnyFurnace(boolean isActive,Material material) {
        super(material);
        this.isActive = false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID+":"+"BunnyFurnace_side");
        this.IconFront = iconRegister.registerIcon(Reference.MODID+":"+(this.isActive ? "BunnyFurnace_front_on" : "BunnyFurnace_front_off"));
        this.IconTop = iconRegister.registerIcon(Reference.MODID+":"+"BunnyFurnace_top");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
       // return metadata ==0 && side == 3 ? this.IconFront : (side ==metadata ? this.IconFront : this.blockIcon );
        return metadata == 0 && side == 3 ? this.IconFront : side == 1 ? this.IconTop : (side == 0 ? this.IconTop : (side == metadata ? this.IconFront : this.blockIcon));
    //side 3 is the front 1 is top 0 is the bottom
    }
    
    public Item getItemDropped(int i,Random random, int j) {
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
            if (b2.func_149730_j() && !b1.func_149730_j()){
                b0=2;
            }
            if (b3.func_149730_j() && !b4.func_149730_j()){
                b0=5;
            }

            if (b4.func_149730_j() && !b3.func_149730_j()){
                b0=4;
            }
            world.setBlockMetadataWithNotify(x,y,x,b0,2);
        }
    }
    public boolean onBlockActivated(World world,int x,int y,int z, EntityPlayer player,int side,float hitX,float hitY,float hitZ){
        if (!world.isRemote){
            FMLNetworkHandler.openGui(player,TwistedMod2.instance,BlockInfo.guiIDBunnyFurnace,world,x,y,z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world,int i) {
        return new TileEntityBunnyFurnace();
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if(this.isActive) {
            int direction = world.getBlockMetadata(x, y, z);

            float x1 = (float)x + 0.5F;
            float y1 = (float)y + random.nextFloat();
            float z1 = (float)z + 0.5F;

            float f = 0.52F;
            float f1 = random.nextFloat() * 0.6F - 0.3F;

            if(direction == 4){
                world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
            }

            if(direction == 5){
                world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
            }

            if(direction == 2){
                world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
            }

            if(direction == 3){
                world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
            }
        }
    }

    public void onBlockPlacedBy(World world,int x,int y,int z,EntityLivingBase entityplayer,ItemStack itemstack) {
        int I = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0f / 360.f)+ 0.5D) & 3;

        if (I == 0){
            world.setBlockMetadataWithNotify(x,y,z,2,2);
        }
        if (I == 1){
            world.setBlockMetadataWithNotify(x,y,z,5,2);
        }
        if (I == 2){
            world.setBlockMetadataWithNotify(x,y,z,3,2);
        }
        if (I == 3){
            world.setBlockMetadataWithNotify(x,y,z,4,2);
        }
            ((TileEntityBunnyFurnace)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());

    }

    public static void updateblockBunnyFurnaceState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
        int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;
        if (active) {
            worldObj.setBlock(xCoord, yCoord, zCoord, BlockInfo.blockBunnyFurnaceActive);
        } else {
            worldObj.setBlock(xCoord, yCoord, zCoord, BlockInfo.blockBunnyFurnaceIdle);
        }

        keepInventory = false;

        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
        if (tileentity != null) {
            tileentity.validate();
            worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) { //so when broken we get the items out of it
        if(!keepInventory) {
            TileEntityBunnyFurnace tileentity = (TileEntityBunnyFurnace) world.getTileEntity(x, y, z);

            if(tileentity != null) {
                for(int i = 0; i < tileentity.getSizeInventory(); i++) {
                    ItemStack itemstack = tileentity.getStackInSlot(i);

                    if(itemstack != null) {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while(itemstack.stackSize > 0) {
                            int j = this.rand.nextInt(21) + 10;

                            if(j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;

                            EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if(itemstack.hasTagCompound()) {
                                item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            world.spawnEntityInWorld(item);
                        }
                    }
                }

                world.func_147453_f(x, y, z, oldblock);
            }
        }

        super.breakBlock(world, x, y, z, oldblock, oldMetadata);
    }

    public Item getItem(World world, int x, int y, int z) { //insures we drop an idle furnace when it is smashed
        return Item.getItemFromBlock(BlockInfo.blockBunnyFurnaceIdle);
    }







    /*
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(TwistedMod2.MODID+":"+this.getUnlocalizedName().substring(5));
    }*/
}
