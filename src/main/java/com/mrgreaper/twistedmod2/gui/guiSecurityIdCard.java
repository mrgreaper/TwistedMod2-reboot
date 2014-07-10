package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by david on 10/07/2014.
 */
public class guiSecurityIdCard extends GuiScreen {

    private final EntityPlayer viewer;
    private final String accesscode;
    private final String username;

    ResourceLocation bground = new ResourceLocation(Reference.MODID + ":" + "textures/gui/SecurityId.png");

    public final int xSizeOfTexture = 220; //the width of your texture
    public final int ySizeOfTexture = 152;  //the height of our texture


    public guiSecurityIdCard(EntityPlayer player, String code, String user) { //hmmm really needed that to be the itemstack...gonna have to do some wierd stuff here
        this.viewer = player;
        this.accesscode = user;//yeah i got them the long way around and im being lazy
        this.username = code;
    }

    @Override
    public void drawScreen(int x, int y, float f) {
        drawDefaultBackground(); //draws default background (an overlay in the background)

        GL11.glColor4f(1f, 1f, 1f, 1f); //set the colour to black (yeah the method is missing a u but that seems common in minecraft O.o

        int posX = (this.width - xSizeOfTexture) / 2; //so we can center the gui on the screen
        int posY = (this.height - ySizeOfTexture) / 2;

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
        drawCenteredString(fontRendererObj, username, posX + 145 - username.length(), posY + 30, 0x0055cc);
        if (viewer.getDisplayName().equals(username)) {
            drawCenteredString(fontRendererObj, accesscode, posX + 155 - accesscode.length(), posY + 60, 0x66ff66);
        } else {
            drawCenteredString(fontRendererObj, EnumChatFormatting.OBFUSCATED + accesscode, posX + 155 - accesscode.length(), posY + 60, 0xee0000);
        }

        //above sets the background texture

        super.drawScreen(x, y, f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false; //dont pause the game
    }


}
