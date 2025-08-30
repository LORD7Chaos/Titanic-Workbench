package com.lord.titanicworkbench.gui;

import com.lord.titanicworkbench.MyMod;
import com.lord.titanicworkbench.container.ContainerTitanicWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiTitanicWorkbench extends GuiContainer {

    private static final ResourceLocation BG_TEXTURE =
            new ResourceLocation("titanicworkbench", "textures/gui/titanic_workbench.png");

    public GuiTitanicWorkbench(ContainerTitanicWorkbench container) {
        super(container);
        this.xSize = 256;
        this.ySize = 350;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        fontRenderer.drawString("Titanic Workbench", 8, 6, 4210752);

        fontRenderer.drawString("Inventory", 48, ySize - 96 + 2, 4210752);
    }
}