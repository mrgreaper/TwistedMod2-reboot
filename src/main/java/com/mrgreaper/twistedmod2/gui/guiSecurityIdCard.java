package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.handlers.ReaperHelper;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
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
    private String username;

    ResourceLocation bground = new ResourceLocation(Reference.MODID + ":" + "textures/gui/SecurityId.png");
    private ResourceLocation ownerface;


    public final int xSize = 220; //the width of your texture
    public final int ySize = 152;  //the height of our texture
    public final int faceXSize = 64; // the image we get for the face should always be the same size!
    public final int faceYsize = 32;
    public final int faceStartX = 8; //where the face starts
    public final int faceStartY = 8;
    public final int faceOverlayStartX = 40; //face is made of two parts
    public final int faceOverlayStartY = 8;//not really needed as its ths same height as face start y but meh it keeps it neat
    private int guiLeft;
    private int guiTop;


    public guiSecurityIdCard(EntityPlayer player, String code, String user) { //hmmm really needed that to be the itemstack...gonna have to do some wierd stuff here
        this.viewer = player;
        this.accesscode = user;//yeah i got them the long way around and im being lazy
        this.username = code;
        this.ownerface = new ResourceLocation(ReaperHelper.getSkin(username) + "");
    }

    @Override
    public void drawScreen(int x, int y, float f) {
        drawDefaultBackground(); //draws default background (an overlay in the background)

        GL11.glColor4f(1f, 1f, 1f, 1f); //set the colour to black (yeah the method is missing a u but that seems common in minecraft O.o

        this.guiLeft = (this.width - this.xSize) / 2; //so we can center the gui on the screen
        this.guiTop = (this.height - this.ySize) / 2;

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        Minecraft.getMinecraft().getTextureManager().bindTexture(ownerface);
        drawTexturedModalRect(guiLeft + 30, guiTop + 25, faceStartX, faceStartY, 8, 8);
        drawTexturedModalRect(guiLeft + 30, guiTop + 25, faceOverlayStartX, faceOverlayStartY, 8, 8);
        drawCenteredString(fontRendererObj, username, guiLeft + 145 - username.length(), guiTop + 30, 0x0055cc);
        LogHelper.info(ReaperHelper.getSkin(username));
        if (viewer.getDisplayName().equals(username)) {
            drawCenteredString(fontRendererObj, accesscode, guiLeft + 130 - accesscode.length(), guiTop + 125, 0x66ff66);
        } else {
            drawCenteredString(fontRendererObj, EnumChatFormatting.OBFUSCATED + accesscode, guiLeft + 125 - accesscode.length(), guiTop + 125, 0xee0000);
        }

        //above sets the background texture

        super.drawScreen(x, y, f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false; //dont pause the game
    }


}
