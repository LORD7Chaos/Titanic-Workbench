package com.lord.titanicworkbench.blocks;

import com.lord.titanicworkbench.MyMod;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod.EventBusSubscriber(modid = MyMod.MODID)
public class ModBlocks {
    public static Block TITANIC_WORKBENCH;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        TITANIC_WORKBENCH = new BlockTitanicWorkbench()
                .setTranslationKey("titanic_workbench")
                .setRegistryName(MyMod.MODID, "titanic_workbench");

        event.getRegistry().register(TITANIC_WORKBENCH);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(TITANIC_WORKBENCH)
                .setRegistryName(TITANIC_WORKBENCH.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(net.minecraftforge.client.event.ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(TITANIC_WORKBENCH),
                0,
                new ModelResourceLocation(TITANIC_WORKBENCH.getRegistryName(), "inventory")
        );
    }
}