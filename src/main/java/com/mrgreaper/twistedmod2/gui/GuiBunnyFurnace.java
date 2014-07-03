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
        String name = this.BunnyFurnace.hasCustomInventoryName() ? this.BunnyFurnace.getInventoryName() : I18n.format(this.BunnyFurnace.getInventoryName(),new Object[0]);
        this.fontRendererObj.drawString(name,this.xSize / 2 -this.fontRendererObj.getStringWidth(name)/2,6,4210752); //this writes the name (we are finding the centre of the gui then we get the width of the name and find the center of that ,font size,font colour)
        this.fontRendererObj.drawString(I18n.format("Container.inventory",new Object[0]),115,this.ySize - 96 +2,4210752); //this will write the word of inventory (128 is how far on the x alignment where you want it
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F,1F,1F,1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);

    }
}
