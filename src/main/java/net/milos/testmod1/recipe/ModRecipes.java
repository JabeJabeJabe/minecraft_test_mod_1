package net.milos.testmod1.recipe;

import net.milos.testmod1.TestMod1;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TestMod1.MOD_ID);


    public static final RegistryObject<RecipeSerializer<GummoWorkstationRecipe>> GUMMO_WORKSTATION_SERIALIZER =
            SERIALIZERS.register("gummo_workstation", () -> GummoWorkstationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
