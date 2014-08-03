package com.mrgreaper.twistedmod2.client.render;

import com.mrgreaper.twistedmod2.entitys.entityDeathOrb;
import com.mrgreaper.twistedmod2.models.ModelDeathorb;
import com.mrgreaper.twistedmod2.reference.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by david on 03/08/2014.
 */
public class renderDeathorb extends Render {

    private ModelDeathorb model;

    public renderDeathorb() {
        model = new ModelDeathorb();
        shadowSize = 0.5f;
    }

    private ResourceLocation modelTexture = new ResourceLocation(Reference.MODID + ":models/metal.png");

    public void renderDeathorb(entityDeathOrb deathOrb, double x, double y, double z, float yaw, float partialTickTime) {
        bindEntityTexture(deathOrb);
        model.renderWavefront();
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicktime) {
        renderDeathorb((entityDeathOrb) entity, x, y, z, yaw, partialTicktime);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return modelTexture;
    }


}
