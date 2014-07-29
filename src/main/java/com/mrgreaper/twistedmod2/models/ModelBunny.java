// Date: 29/07/2014 00:00:04
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.mrgreaper.twistedmod2.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBunny extends ModelBase {
    //fields
    ModelRenderer Body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Head;
    ModelRenderer Tail;
    ModelRenderer ear1;
    ModelRenderer ear2;

    public ModelBunny() {
        textureWidth = 64;
        textureHeight = 32;

        Body = new ModelRenderer(this, 0, 8);
        Body.addBox(-1.5F, 0F, -2.2F, 3, 3, 5);
        Body.setRotationPoint(0F, 19F, 0F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        leg1 = new ModelRenderer(this, 18, 19);
        leg1.addBox(-0.8F, -0.9333333F, -0.4666667F, 1, 3, 1);
        leg1.setRotationPoint(-1.533333F, 21.8F, -1.2F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 12, 19);
        leg2.addBox(-0.9333333F, -0.6666667F, -0.4666667F, 1, 3, 1);
        leg2.setRotationPoint(-1.333333F, 21.46667F, 1.933333F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 6, 19);
        leg3.addBox(-0.1333333F, -0.8666667F, -0.5333334F, 1, 3, 1);
        leg3.setRotationPoint(1.6F, 21.8F, 2.066667F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 19);
        leg4.addBox(0.1333333F, -0.8F, -0.6666667F, 1, 3, 1);
        leg4.setRotationPoint(1.2F, 21.66667F, -1F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        ear1 = new ModelRenderer(this, 7, 26);
        ear1.addBox(-0.4666667F, -3.2F, -0.4F, 1, 3, 1);
        ear1.setRotationPoint(-0.5333334F, 19.93333F, -3.6F);
        ear1.setTextureSize(64, 32);
        ear1.mirror = true;
        setRotation(ear1, 0F, 0F, 0F);
        ear2 = new ModelRenderer(this, 0, 26);
        ear2.addBox(-0.3333333F, -3F, -0.5333334F, 1, 3, 1);
        ear2.setRotationPoint(0.6666667F, 19.8F, -3.333333F);
        ear2.setTextureSize(64, 32);
        ear2.mirror = true;
        setRotation(ear2, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-0.9333333F, -1F, -2.666667F, 2, 2, 2);
        //Head.addBox(-0.4666667F, -3.2F, -0.4F, 1, 3, 1);
        Head.setRotationPoint(0F, 20.6F, -1.8F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        Head.addChild(ear1);
        Head.addChild(ear2);
        setRotation(Head, 0F, 0F, 0F);
        Tail = new ModelRenderer(this, 48, 0);
        Tail.addBox(-0.3333333F, -0.3333333F, 0F, 1, 1, 1);
        Tail.setRotationPoint(-0.2666667F, 20.06667F, 2.333333F);
        Tail.setTextureSize(64, 32);
        Tail.mirror = true;
        setRotation(Tail, 0F, 0F, 0F);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity); //had to add ,entity
        Body.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        Head.render(f5);
        Tail.render(f5);
        ear1.render(f5);
        ear2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)//had to add ,Entity entity
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);//had to add ,entity
        float f6 = (180F / (float) Math.PI);
        this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
        //this.Body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }

}
