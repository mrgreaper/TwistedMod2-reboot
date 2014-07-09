package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by david on 09/07/2014.
 */

//learning how to add a gui to to an item...should also help to learn more about gui's in general https://www.youtube.com/watch?v=7F-uvqkt5iw

//wonder if this is how tinker construct does its rather cool books?

//we also need a container see ContainerLivingBunny
public class GuiLivingBunny extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/gui/basic.png"); //the texture for our GUI

    public final int xSizeOfTexture = 176; //the width of your texture
    public final int ySizeOfTexture = 88;  //the height of our texture


    public GuiLivingBunny(EntityPlayer player) { //normally the gui data is stored to a tile entity...no tile entity means we have to find an ....alternative

    }

    @Override
    public void drawScreen(int x, int y, float f) {
        drawDefaultBackground(); //draws default background (an overlay in the background)

        GL11.glColor4f(1f, 1f, 1f, 1f); //set the colour to black (yeah the method is missing a u but that seems common in minecraft O.o

        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

        //above sets the background texture
        super.drawScreen(x, y, f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false; //dont pause the game
    }


}
