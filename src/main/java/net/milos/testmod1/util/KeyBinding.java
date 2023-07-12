package net.milos.testmod1.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;


public class KeyBinding {
    public static final String KEY_CATEGORY_TEST = "key.category.testmod1.test";
    public static final String KEY_DRINK_WATER = "key.testmod1.drink_water";

    public static final KeyMapping DRINKING_KEY = new KeyMapping(KEY_DRINK_WATER, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_TEST);


}
