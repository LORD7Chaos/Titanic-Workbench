package com.lord.titanicworkbench.crafttweaker;

import com.lord.titanicworkbench.recipes.RecipeTitanicWorkbench;
import com.lord.titanicworkbench.recipes.TitanicWorkbenchRecipes;
import crafttweaker.IAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.*;

import java.util.List;

@ZenRegister
@ZenClass("mods.titanicworkbench.TitanicWorkbench")
public class TitanicWorkbenchTweaker {

    @ZenMethod
    public static void addRecipe(ItemStack output, List<ItemStack> inputs) {
        if (inputs.size() != 121) {
            CraftTweakerAPI.logError("Titanic Workbench requires exactly 121 inputs (11x11). Got: " + inputs.size());
            return;
        }
        CraftTweakerAPI.apply(new Add(output, inputs));
    }

    @ZenMethod
    public static void removeRecipe(ItemStack output) {
        CraftTweakerAPI.apply(new Remove(output));
    }

    // === IAction классы ===
    private static class Add implements IAction {
        private final ItemStack output;
        private final List<ItemStack> inputs;

        public Add(ItemStack output, List<ItemStack> inputs) {
            this.output = output;
            this.inputs = inputs;
        }

        @Override
        public void apply() {
            TitanicWorkbenchRecipes.addRecipe(new RecipeTitanicWorkbench(inputs, output));
        }

        @Override
        public String describe() {
            return "Adding Titanic Workbench recipe for " + output.getDisplayName();
        }
    }

    private static class Remove implements IAction {
        private final ItemStack output;

        public Remove(ItemStack output) {
            this.output = output;
        }

        @Override
        public void apply() {
            TitanicWorkbenchRecipes.removeRecipe(output);
        }

        @Override
        public String describe() {
            return "Removing Titanic Workbench recipe for " + output.getDisplayName();
        }
    }
}