package com.lord.titanicworkbench;

import com.lord.titanicworkbench.gui.GuiHandler;
import com.lord.titanicworkbench.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MODID, name = Tags.MODNAME, version = Tags.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class MyMod {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    // Алиасы для MODID, NAME, VERSION (чтобы другие классы могли писать MyMod.MODID)
    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    @Mod.Instance
    public static MyMod instance;

    @SidedProxy(clientSide = "com.lord.titanicworkbench.proxy.ClientProxy",
            serverSide = "com.lord.titanicworkbench.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Loading " + NAME + " version " + VERSION);

        // Регистрируем TileEntity
        GameRegistry.registerTileEntity(com.lord.titanicworkbench.tileentity.TileEntityTitanicWorkbench.class,
                MODID + "_titanic_workbench");

        // Вызов прокси для клиентских ресурсов (модели, рендеры)
        proxy.preInit();
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        // Блоки регистрируются через ModBlocks.java
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        // ItemBlock для блока регистрируется через ModBlocks.java
    }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        // Рецепты можно добавлять здесь или через CraftTweaker
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Тут можно проверять взаимодействие с другими модами
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        // Серверные команды
    }
}