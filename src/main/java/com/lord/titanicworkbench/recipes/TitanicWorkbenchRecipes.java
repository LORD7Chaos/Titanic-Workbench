package com.lord.titanicworkbench.recipes;

import net.minecraft.item.ItemStack;
import com.lord.titanicworkbench.blocks.ModBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TitanicWorkbenchRecipes {

    private static final List<RecipeTitanicWorkbench> RECIPES = new ArrayList<>();

    public static List<RecipeTitanicWorkbench> getAll() {
        return RECIPES;
    }

    public static void init() {
        List<List<ItemStack>> inputs = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            inputs.add(Collections.singletonList(ItemStack.EMPTY));
        }

        ItemStack output = new ItemStack(ModBlocks.TITANIC_WORKBENCH);

        RECIPES.add(new RecipeTitanicWorkbench(inputs, output));
    }
}