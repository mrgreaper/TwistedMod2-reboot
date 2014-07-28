package com.mrgreaper.twistedmod2.client.render;

import com.mrgreaper.twistedmod2.entitys.entityBunnyMob;
import com.mrgreaper.twistedmod2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class renderEntityBunny extends RenderLiving {
    private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MODID + ":ModelBunny.png");
    private static final String __OBFID = "CL_00000984";

    public renderEntityBunny(ModelBase p_i1253_1_, float p_i1253_2_) {
        super(p_i1253_1_, p_i1253_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(entityBunnyMob entity) {
        return mobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((entityBunnyMob) entity);
    }
}