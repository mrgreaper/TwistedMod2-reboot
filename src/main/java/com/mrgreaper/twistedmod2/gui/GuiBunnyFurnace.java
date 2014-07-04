package com.mrgreaper.twistedmod2.gui;

import com.mrgreaper.twistedmod2.container.ContainerBunnyFurnace;
import com.mrgreaper.twistedmod2.entitys.TileEntityBunnyFurnace;
import com.mrgreaper.twistedmod2.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by david on 26/06/2014.
 */
public class GuiBunnyFurnace extends GuiContainer{

public static final ResourceLocation bground = new ResourceLocation(Reference.MODID+":"+"textures/gui/BunnyFurnaceGui.png");


    public TileEntityBunnyFurnace BunnyFurnace;

    public GuiBunnyFurnace(InventoryPlayer inventoryPlayer, TileEntityBunnyFurnace entity) {
        super(new ContainerBunnyFurnace(inventoryPlayer,entity));
        this.BunnyFurnace = entity;
        this.xSize=176; //in paint.net use the selection tool to measure the widith of the gui panal
        this.ySize=166;//as above but height
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2){
        String name = "Bunny Furnace";
        this.fontRendererObj.drawString(name,this.xSize / 2 -this.fontRendererObj.getStringWidth(name)/2,6,4210752); //this writes the name (we are finding the centre of the gui then we get the width of the name and find the center of that ,font size,font colour)
        this.fontRendererObj.drawString(I18n.format("container.inventory",new Object[0]),115,this.ySize - 96 +2,4210752); //this will write the word of inventory (115 is how far on the x alignment where you want it
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F,1F,1F,1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);

        if(this.BunnyFurnace.isBurning()){
            int k = this.BunnyFurnace.getBurnTimeRemainingScaled(40);//40 is th width of the scale made for this (next to fuel in slot)
            int j = 40 -k; // to invert the number as the cook time will be a count down
            drawTexturedModalRect(guiLeft + 30,guiTop + 62,176,1, 40-j,10 );//(start from far left,start from top,image were using left start,image were using start height,increment,height of image were using)
        }

        int k = this.BunnyFurnace.getCookProgressScaled(24);//24 is the width of the arrow
        drawTexturedModalRect(guiLeft + 79,guiTop +34,176,13,k+1,16);

    }


}
