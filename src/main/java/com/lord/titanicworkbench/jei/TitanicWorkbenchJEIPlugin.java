package com.lord.titanicworkbench.jei;

import com.lord.titanicworkbench.MyMod;
import com.lord.titanicworkbench.blocks.ModBlocks;
import com.lord.titanicworkbench.recipes.RecipeTitanicWorkbench;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

@JEIPlugin
public class TitanicWorkbenchJEIPlugin implements IModPlugin {

    public static final ResourceLocation UID = new ResourceLocation(MyMod.MODID, "titanic_workbench");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(
                new TitanicWorkbenchRecipeCategory(registry.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void register(IModRegistry registry) {
        registry.handleRecipes(
                RecipeTitanicWorkbench.class,
                TitanicWorkbenchRecipeWrapper::new,
                UID
        );

        List<RecipeTitanicWorkbench> recipes = RecipeTitanicWorkbench.getAllRecipes();
        registry.addRecipes(recipes, UID);

        registry.addRecipeClickArea(
                com.lord.titanicworkbench.client.gui.GuiTitanicWorkbench.class,
                90, 35, 20, 20, UID
        );

        registry.addRecipeCatalyst(new ItemStack(ModBlocks.TITANIC_WORKBENCH), UID);
    }
}