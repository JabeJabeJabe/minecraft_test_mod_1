package net.milos.testmod1.painting;

import net.milos.testmod1.TestMod1;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TestMod1.MOD_ID);

    public static final RegistryObject<PaintingVariant> GUMMO_DASKA = PAINTING_VARIANTS.register("gummo_daska",
            () -> new PaintingVariant(16, 16)); //size in pixels, width x height
    public static final RegistryObject<PaintingVariant> WANDERING_6IX9INE = PAINTING_VARIANTS.register("wandering_6ix9ine",
            () -> new PaintingVariant(16, 32)); //size in pixels, width x height
    public static final RegistryObject<PaintingVariant> COC_BARBARIANS = PAINTING_VARIANTS.register("coc_barbarians",
            () -> new PaintingVariant(32, 16)); //size in pixels, width x height

    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
