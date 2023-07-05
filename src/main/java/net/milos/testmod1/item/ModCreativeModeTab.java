package net.milos.testmod1.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab TESTMOD1_TAB = new CreativeModeTab("testmod1tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GUMMO.get());
        }
    };
}
