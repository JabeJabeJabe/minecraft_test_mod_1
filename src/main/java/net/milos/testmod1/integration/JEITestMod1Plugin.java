package net.milos.testmod1.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.milos.testmod1.TestMod1;
import net.milos.testmod1.recipe.GummoWorkstationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITestMod1Plugin implements IModPlugin {

    public static RecipeType<GummoWorkstationRecipe> WORKSTATION_TYPE =
            new RecipeType<>(GummoWorkstationRecipeCategory.UID, GummoWorkstationRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TestMod1.MOD_ID, "jei_plugin");
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                GummoWorkstationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<GummoWorkstationRecipe> recipesInfusing = rm.getAllRecipesFor(GummoWorkstationRecipe.Type.INSTANCE);
        registration.addRecipes(WORKSTATION_TYPE, recipesInfusing);

        //List<GummoWorkstationRecipe> recipesInfusing = rm.getAllRecipesFor(GummoWorkstationRecipe.Type.INSTANCE);
        //registration.addRecipes(WORKSTATION_TYPE, recipesInfusing); //za sledece typove
    }
}
