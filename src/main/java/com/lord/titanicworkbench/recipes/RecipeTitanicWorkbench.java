package com.lord.titanicworkbench.recipes;

import com.lord.titanicworkbench.MyMod;
import com.lord.titanicworkbench.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeTitanicWorkbench {

    public static void initRecipes() {

        ItemStack result = new ItemStack(ModBlocks.TITANIC_WORKBENCH);

        GameRegistry.addShapedRecipe(
                new ResourceLocation(MyMod.MODID, "titanic_workbench_recipe"),
                "titanic_workbench", // группа
                result,
                "WWW",
                "WDW",
                "WWW",
                'W', Blocks.PLANKS,
                'D', Blocks.DIAMOND_BLOCK
        );
    }
}