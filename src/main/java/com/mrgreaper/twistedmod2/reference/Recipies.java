package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.blocks.BlockInfo;
import com.mrgreaper.twistedmod2.items.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by david on 23/06/2014.
 */
public class Recipies {

    public static void init(){
        //shaped recipies bellow...yes it doesnt conform to the standards but i no care, it looks better to me and im the one coding this
        //file coding conformety issues along with spelling issues in your recycle bin :)
        GameRegistry.addRecipe(new ItemStack(BlockInfo.blockBunnyite), new Object[]{"ccc",
                                                                                    "ccc",
                                                                                    "ccc",
                                                                                    'c', ItemInfo.itemBunnyiteIngot});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyitePickaxe), new Object[]{"ccc",
                                                                                         " s ",
                                                                                         " s ",
                'c', ItemInfo.itemBunnyiteIngot,'s', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteAxe), new Object[]{" cc",
                                                                                     " sc",
                                                                                     " s ",
                'c', ItemInfo.itemBunnyiteIngot,'s', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteSpade), new Object[]{" c ",
                " s ",
                " s ",
                'c', ItemInfo.itemBunnyiteIngot,'s', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyitePlate,4),new Object[]{"IH", 'H',ItemInfo.itemBunnyiteIngot, 'I',new ItemStack(ItemInfo.itemTwistedHammer, 1, OreDictionary.WILDCARD_VALUE)});
        //ore wildcard allows us to ignore its durability
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteWasher,4),new Object[]{"IH", 'H',ItemInfo.itemBunnyitePlate, 'I',new ItemStack(ItemInfo.itemBunnyitePunch, 1, OreDictionary.WILDCARD_VALUE)});

        //test shapeless recipie bellow
//GameRegistry.addShapelessRecipe(new ItemStack(BlockInfo.oreBunnyite),new Object[]{ItemInfo.itemBunnyiteIngot, Blocks.cobblestone});
GameRegistry.addShapelessRecipe(new ItemStack(ItemInfo.itemBunnyiteIngot,9),new Object[]{BlockInfo.blockBunnyite});



        }
        }
