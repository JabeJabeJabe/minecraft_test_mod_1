package net.milos.testmod1.event;

import net.milos.testmod1.TestMod1;
import net.milos.testmod1.client.ThirstHudOverlay;
import net.milos.testmod1.networking.ModMessages;
import net.milos.testmod1.networking.packet.DrinkWaterC2SPacket;
import net.milos.testmod1.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TestMod1.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.DRINKING_KEY.consumeClick()){
                //Minecraft.getInstance().player.sendSystemMessage(Component.literal("pressed key xdxd!"));
                //ModMessages.sendToServer(new ExampleC2SPacket());
                ModMessages.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = TestMod1.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DRINKING_KEY);
        }
        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }
    }
}
