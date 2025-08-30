package com.lord.titanicworkbench.jei;

import com.lord.titanicworkbench.MyMod;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TitanicWorkbenchRecipeCategory implements IRecipeCategory<TitanicWorkbenchRecipeWrapper> {

    public static final String UID = MyMod.MODID + ".titanic_workbench";
    private final IDrawable background;
    private final IDrawable icon;

    public TitanicWorkbenchRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(180, 180);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(com.lord.titanicworkbench.blocks.ModBlocks.TITANIC_WORKBENCH));
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return "Titanic Workbench";
    }

    @Override
    public String getModName() {
        return MyMod.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, TitanicWorkbenchRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();

        int slotIndex = 0;
        int startX = 0;
        int startY = 0;
        int slotSize = 16;


        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                int x = startX + col * (slotSize + 2);
                int y = startY + row * (slotSize + 2);
                stacks.init(slotIndex, true, x, y);
                if (ingredients.getInputs(ItemStack.class).size() > slotIndex) {
                    stacks.set(slotIndex, ingredients.getInputs(ItemStack.class).get(slotIndex));
                }
                slotIndex++;
            }
        }

        stacks.init(slotIndex, false, 160, 80);
        if (!ingredients.getOutputs(ItemStack.class).isEmpty()) {
            stacks.set(slotIndex, ingredients.getOutputs(ItemStack.class).get(0));
        }
    }
}