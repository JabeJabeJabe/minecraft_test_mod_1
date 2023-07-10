package net.milos.testmod1.item;

import net.milos.testmod1.TestMod1;
import net.milos.testmod1.item.custom.SixtyNineBallItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
