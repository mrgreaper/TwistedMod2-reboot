package com.mrgreaper.twistedmod2.handlers;

import net.minecraft.client.renderer.Tessellator;

/**
 * Created by david on 10/07/2014.
 */
public class RenderHelper {

    //ok lets see x and y are the location of where the image will be placed, width and height are the size you want it ...zlevel?
    public static void drawTexturedQuadFit(double x, double y, double width, double height, double zLevel) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0, y + height, zLevel, 0, 1);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, 1, 1);
        tessellator.addVertexWithUV(x + width, y + 0, zLevel, 1, 0);
        tessellator.addVertexWithUV(x + 0, y + 0, zLevel, 0, 0);
        tessellator.draw();
    }
/*
    GL11.glPushMatrix();
    Minecraft.getMinecraft().renderEngine.bindTexture(yourfacelocation);
    GL11.glTranslatef(faceX, faceY, 0);
    float scale = 3F;
    GL11.glScalef(scale, scale, scale);
    drawTexturedModalRect(0, 0, 8, 8, 8, 8); //correct if wrong
    GL11.glPopMatrix();
*/
}
