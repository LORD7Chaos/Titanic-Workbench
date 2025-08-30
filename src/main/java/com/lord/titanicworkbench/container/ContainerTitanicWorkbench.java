package com.lord.titanicworkbench.container;

import com.lord.titanicworkbench.tileentity.TileEntityTitanicWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerTitanicWorkbench extends Container {

    private final TileEntityTitanicWorkbench tileEntity;

    public ContainerTitanicWorkbench(InventoryPlayer playerInventory, TileEntityTitanicWorkbench tileEntity) {
        this.tileEntity = tileEntity;

        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                this.addSlotToContainer(new Slot(tileEntity, col + row * 11,
                        8 + col * 18,
                        18 + row * 18));
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9,
                        48 + col * 18,
                        250 + row * 18));
            }
        }

        for (int col = 0; col < 9; col++) {
            this.addSlotToContainer(new Slot(playerInventory, col,
                    48 + col * 18,
                    308));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUsableByPlayer(player);
    }
}