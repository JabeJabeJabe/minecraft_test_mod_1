package net.milos.testmod1;

import com.mojang.logging.LogUtils;
import net.milos.testmod1.block.ModBlocks;
import net.milos.testmod1.block.entity.ModBlockEntities;
import net.milos.testmod1.fluid.ModFluidTypes;
import net.milos.testmod1.fluid.ModFluids;
import net.milos.testmod1.item.ModItems;
import net.milos.testmod1.networking.ModMessages;
import net.milos.testmod1.painting.ModPaintings;
import net.milos.testmod1.recipe.ModRecipes;
import net.milos.testmod1.screen.GummoWorkstationScreen;
import net.milos.testmod1.screen.ModMenuTypes;
import net.milos.testmod1.villager.ModVillagers;
import net.milos.testmod1.world.feature.ModConfiguredFeatures;
import net.milos.testmod1.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod1.MOD_ID)
public class TestMod1 {
    public static final String MOD_ID = "testmod1";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod1() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus); //ore gen 1/2
        ModPlacedFeatures.register(modEventBus); //ore gen 2/2

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
            ModVillagers.registerPOIs();
        });
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.GUMMO_WORKSTATION_MENU.get(), GummoWorkstationScreen::new);
        }
    }
}

//E desi