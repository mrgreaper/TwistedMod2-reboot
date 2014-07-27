package com.mrgreaper.twistedmod2.client;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by david on 28/07/2014.
 */
public class modelDeathOrb extends ModelBase {
    private IModelCustom ModelDeathOrb;

    public modelDeathOrb() {
        //ModelDeathOrb = AdvancedModelLoader.loadModel(Reference.MODID + ":" + "models/deathorb.obj"); //"/assets/twisted/models/deathorb.obj"
    }

    public void renderWavefront() {
        ModelDeathOrb.renderAll();
    }

}