package net.milos.testmod1.item;

import net.milos.testmod1.TestMod1;
import net.milos.testmod1.block.ModBlocks;
import net.milos.testmod1.fluid.ModFluids;
import net.milos.testmod1.item.custom.SixtyNineBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod1.MOD_ID);


    public static final RegistryObject<Item> GUMMO = ITEMS.register("gummo",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB)));
    public static final RegistryObject<Item> RAW_GUMMO = ITEMS.register("raw_gummo",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB)));


    public static final RegistryObject<Item> SIXTY_NINE_BALL = ITEMS.register("sixty_nine_ball",
            () -> new SixtyNineBallItem(new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GUMMOBERRY_SEEDS = ITEMS.register("gummoberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GUMMOBERRY_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB)));
    public static final RegistryObject<Item> GUMMOBERRY = ITEMS.register("gummoberry",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(3f).build())));

    public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER,
                    new Item.Properties().tab(ModCreativeModeTab.TESTMOD1_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
