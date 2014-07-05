package com.mrgreaper.twistedmod2.blocks;

import com.mrgreaper.twistedmod2.TwistedMod2;
import com.mrgreaper.twistedmod2.reference.BlockInfo;
import com.mrgreaper.twistedmod2.reference.ItemInfo;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by david on 23/06/2014.
 */
public class oreBlock extends Block {


    public oreBlock(Material material) {
        super(material);

        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(TwistedMod2.TwistedModTab);
    }

    public Item getItemDropped(int i, Random random, int j) {
        return this == BlockInfo.oreCystalizedBlood ? ItemInfo.itemBloodCrystal : Item.getItemFromBlock(this);
        // so were saying if the block is oreCystalizedBlood then drop itemBloodCrystal
    }

    public int quantityDropped(Random random) {
        return this == BlockInfo.oreCystalizedBlood ? 4 + random.nextInt(5) : 1;
        //to control the amount dropped
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
