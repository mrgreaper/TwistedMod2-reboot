package com.mrgreaper.twistedmod2.models;

import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by david on 03/08/2014.
 */

@SideOnly(Side.CLIENT)
public class ModelDeathorb extends ModelBase {
    private IModelCustom ModelDeathorb;
    private ResourceLocation DeathOrb;


    public ModelDeathorb() {
        DeathOrb = new ResourceLocation(Reference.MODID + ":models/deathorb.obj");
        ModelDeathorb = AdvancedModelLoader.loadModel(DeathOrb);
    }


    public void renderWavefront() {
        ModelDeathorb.renderAll();
    }

}
