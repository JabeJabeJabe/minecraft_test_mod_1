package net.milos.testmod1.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.milos.testmod1.TestMod1;
import net.milos.testmod1.block.ModBlocks;
import net.milos.testmod1.recipe.GummoWorkstationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GummoWorkstationRecipeCategory implements IRecipeCategory<GummoWorkstationRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(TestMod1.MOD_ID, "gummo_workstation");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TestMod1.MOD_ID, "textures/gui/gummo_workstation_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public GummoWorkstationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GUMMO_WORKSTATION.get()));
    }

    @Override
    public RecipeType<GummoWorkstationRecipe> getRecipeType() {
        return JEITestMod1Plugin.WORKSTATION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Gummo Workstation");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GummoWorkstationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
