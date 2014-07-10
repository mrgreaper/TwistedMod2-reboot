package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.handlers.ReaperHelper;
import com.mrgreaper.twistedmod2.reference.Reference;
import com.mrgreaper.twistedmod2.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
    //private String ownersUUID;

    ResourceLocation bground = new ResourceLocation(Reference.MODID + ":" + "textures/gui/SecurityId.png");
    private ResourceLocation ownerface;


    public final int xSize = 220; //the width of your texture
    public final int ySize = 152;  //the height of our texture
    public final int faceXSize = 128; // the image we get for the face should always be the same size!
    public final int faceYsize = 64;
    public final int faceStartX = 16; //where the face starts
    public final int faceStartY = 16;
    public final int faceOverlayStartX = 80; //face is made of two parts
    public final int faceOverlayStartY = 16;//not really needed as its ths same height as face start y but meh it keeps it neat
    private int guiLeft;
    private int guiTop;


    public guiSecurityIdCard(EntityPlayer player, ItemStack itemstack) { //hmmm really needed that to be the itemstack...gonna have to do some wierd stuff here
        this.viewer = player;
        this.accesscode = itemstack.stackTagCompound.getString("accessCode");
        this.username = itemstack.stackTagCompound.getString("user");
        //this.ownersUUID = itemstack.stackTagCompound.getString("uuid");
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

        /*
        ************************************
        **  WARNING HERE BE MONSTERS!!!!  **
        ************************************
        GL11.glPushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(ownerface);

        //GL11.glTranslatef(32, 32, 0);
        float scale = 3F;
        GL11.glScalef(scale, scale, scale);
        //drawTexturedModalRect(guiLeft + 10, guiTop + 15, 16, 16, 8, 8);
        //GL11.glPopMatrix();
        drawTexturedModalRect(guiLeft/2 , guiTop/2 , faceStartX, faceStartY, 16, 16);
        drawTexturedModalRect(guiLeft , guiTop, faceOverlayStartX, faceOverlayStartY, 16, 16);
        //drawTexturedQuadFit(guiLeft + 30, guiTop + 25,30,30,0);
        GL11.glPopMatrix();
        */
        Object fred = fontRendererObj;




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


    /**
     * <p>Draw a textured rectangle with the entire texture scaled to the given dimensions.</p>
     *
     * @param x      the x coordinate
     * @param y      the y coordinate
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param zLevel the z-level to draw at
     */
    public static void drawTexturedQuadFit(int x, int y, int width, int height, float zLevel) {
        Tessellator t = Tessellator.instance;
        t.startDrawingQuads();
        t.addVertexWithUV(x, y + height, zLevel, 0, 1);
        t.addVertexWithUV(x + width, y + height, zLevel, 1, 1);
        t.addVertexWithUV(x + width, y, zLevel, 1, 0);
        t.addVertexWithUV(x, y, zLevel, 0, 0);
        t.draw();
    }


}
