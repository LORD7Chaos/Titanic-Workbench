package com.lord.titanicworkbench.gui;

import com.lord.titanicworkbench.MyMod;
import com.lord.titanicworkbench.container.ContainerTitanicWorkbench;
import com.lord.titanicworkbench.tileentity.TileEntityTitanicWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int TITANIC_WORKBENCH_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == TITANIC_WORKBENCH_GUI_ID) {
            TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
            if (tile instanceof TileEntityTitanicWorkbench) {
                return new ContainerTitanicWorkbench(player.inventory, (TileEntityTitanicWorkbench) tile);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == TITANIC_WORKBENCH_GUI_ID) {
            TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
            if (tile instanceof TileEntityTitanicWorkbench) {
                return new GuiTitanicWorkbench(
                        new ContainerTitanicWorkbench(player.inventory, (TileEntityTitanicWorkbench) tile));
            }
        }
        return null;
    }
}