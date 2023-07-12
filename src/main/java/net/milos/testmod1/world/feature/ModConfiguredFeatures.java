package net.milos.testmod1.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.milos.testmod1.TestMod1;
import net.milos.testmod1.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TestMod1.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GUMMO_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GUMMO_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GUMMO_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_GUMMO_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_GUMMO_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_GUMMO_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_GUMMO_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> GUMMO_ORE = CONFIGURED_FEATURES.register("gummo_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_GUMMO_ORES.get(), 7))); //vein size
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_GUMMO_ORE = CONFIGURED_FEATURES.register("end_gummo_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_GUMMO_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_GUMMO_ORE = CONFIGURED_FEATURES.register("nether_gummo_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_GUMMO_ORES.get(), 9)));



    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
