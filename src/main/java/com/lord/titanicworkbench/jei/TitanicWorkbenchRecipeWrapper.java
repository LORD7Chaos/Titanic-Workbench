package com.lord.titanicworkbench.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class TitanicWorkbenchRecipeWrapper implements IRecipeWrapper {

    private final List<List<ItemStack>> inputs;
    private final ItemStack output;

    public TitanicWorkbenchRecipeWrapper(List<List<ItemStack>> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        ingredients.setInputLists(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }
}