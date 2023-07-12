package net.milos.testmod1.world.feature;

import net.milos.testmod1.TestMod1;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TestMod1.MOD_ID);



    public static final RegistryObject<PlacedFeature> STONE_GUMMO_ORE_PLACED = PLACED_FEATURES.register("stone_gummo_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.STONE_GUMMO_ORE.getHolder().get(), commonOrePlacement(37, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_GUMMO_ORE_PLACED = PLACED_FEATURES.register("deepslate_gummo_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DEEPSLATE_GUMMO_ORE.getHolder().get(), commonOrePlacement(37, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> END_GUMMO_ORE_PLACED = PLACED_FEATURES.register("end_gummo_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_GUMMO_ORE.getHolder().get(), commonOrePlacement(37, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(1), VerticalAnchor.absolute(15)))));

    public static final RegistryObject<PlacedFeature> NETHER_GUMMO_ORE_PLACED = PLACED_FEATURES.register("nether_gummo_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_GUMMO_ORE.getHolder().get(), commonOrePlacement(37, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(200)))));





    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
