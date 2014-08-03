package com.mrgreaper.twistedmod2.reference;

import com.mrgreaper.twistedmod2.handlers.ConfigHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by david on 23/06/2014.
 */
public class Recipies {

    public static void init() {
        //shaped recipies bellow...yes it doesnt conform to the standards but i no care, it looks better to me and im the one coding this
        //file coding conformety issues along with spelling issues in your recycle bin :)
        GameRegistry.addRecipe(new ItemStack(BlockInfo.blockBunnyite), new Object[]{
                "ccc",
                "ccc",
                "ccc",
                'c', ItemInfo.itemBunnyiteIngot});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyitePickaxe), new Object[]{
                "ccc",
                " s ",
                " s ",
                'c', ItemInfo.itemBunnyiteIngot, 's', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteAxe), new Object[]{
                " cc",
                " sc",
                " s ",
                'c', ItemInfo.itemBunnyiteIngot, 's', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteSpade), new Object[]{
                " c ",
                " s ",
                " s ",
                'c', ItemInfo.itemBunnyiteIngot, 's', Items.stick});

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemDeadBunny), new Object[]{
                "cdc",
                "dbd",
                "cdc",
                'c', Items.carrot, 'd', Blocks.dirt, 'b', ItemInfo.itemBunnyiteIngot});
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnySword), new Object[]{
                " C ",//crafting grid
                " B ",
                " S ",

                'B', ItemInfo.itemLivingBunny, //take one living bunny
                'S', ItemInfo.itemBunnySwordHilt, //one orphan bone hilt
                'C', Blocks.cobblestone}); //ram the the bunny on with a bit of cobblestone
        //its wierd people say im evil..... wierd that
        //dont worry you will hear the click when the orphan hilt enters fig b of the bunny and clips into place
        //or a scream....probably a scream....you heartless person you!
        //that poor cobblestone

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemDeathOrb), new Object[]{
                " f ",
                "fif",
                " f ",
                'f', Items.flint, 'i', Items.iron_ingot
        });

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteAxe), new Object[]{
                " II",
                " SI",
                " S ",
                'I', ItemInfo.itemBunnyiteIngot, 'S', Items.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyitePickaxe), new Object[]{
                "III",
                " S ",
                " S ",
                'I', ItemInfo.itemBunnyiteIngot, 'S', Items.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteSpade), new Object[]{
                " I ",
                " S ",
                " S ",
                'I', ItemInfo.itemBunnyiteIngot, 'S', Items.stick
        });

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemSecurityId), new Object[]{
                "ppp",
                "pip",
                "ppp",
                'i', ItemInfo.itemBunnyiteIngot, 'p', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(BlockInfo.blockSpeaky), new Object[]{
                "IRI",
                "ILI",
                "IRI",
                'I', Items.iron_ingot, 'L', ItemInfo.itemLivingBunny, 'R', Items.redstone
        });

        if (ConfigHandler.nonBunnySpeechSynth) {
            GameRegistry.addRecipe(new ItemStack(BlockInfo.blockSpeaky), new Object[]{
                    "IRI",
                    "ILI",
                    "IRI",
                    'I', Items.iron_ingot, 'L', Blocks.diamond_block, 'R', Items.redstone
            });
        }

        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemDeathOrb), new Object[]{
                " F ",
                "FBF",
                " F ",
                'F', Items.flint, 'B', Items.bucket
        });


        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyitePlate, 4), new Object[]{"IH", 'H', ItemInfo.itemBunnyiteIngot, 'I', new ItemStack(ItemInfo.itemTwistedHammer, 1, OreDictionary.WILDCARD_VALUE)});
        //ore wildcard allows us to ignore its durability
        GameRegistry.addRecipe(new ItemStack(ItemInfo.itemBunnyiteWasher, 4), new Object[]{"IH", 'H', ItemInfo.itemBunnyitePlate, 'I', new ItemStack(ItemInfo.itemBunnyitePunch, 1, OreDictionary.WILDCARD_VALUE)});

        //test shapeless recipie bellow
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInfo.itemBunnyiteIngot, 9), new Object[]{BlockInfo.blockBunnyite});
        if (ConfigHandler.easyMode) {
            GameRegistry.addSmelting(ItemInfo.itemLivingBunny, new ItemStack(Items.nether_star), 0.1f);
        } else {
            GameRegistry.addSmelting(ItemInfo.itemLivingBunny, new ItemStack(Items.skull, 1, 1), 0.1f);
        }
        GameRegistry.addSmelting(ItemInfo.itemOrphanLeg, new ItemStack(ItemInfo.itemBunnySwordHilt), 0.1f);//TODO needs new texture
        GameRegistry.addSmelting(BlockInfo.oreBunnyite, new ItemStack(ItemInfo.itemBunnyiteIngot), 0);
        GameRegistry.addSmelting(ItemInfo.itemBaconUncooked, new ItemStack(ItemInfo.itemBacon), 0);

        if (ConfigHandler.leathSmelt) {
            GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1f);
        }

        if (ConfigHandler.grassCraft) {
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), Blocks.vine, Blocks.dirt);
        }

    }
}
