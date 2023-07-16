package net.milos.testmod1.networking.packet;

import net.milos.testmod1.networking.ModMessages;
import net.milos.testmod1.thirst.PlayerThirstProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DrinkWaterC2SPacket { //C2S - Client to (2) Server
    //private static final String MESSAGE_DRINK_WATER = "message.testmod1.drink_water";
    private static final String MESSAGE_FAIL_DRINK_WATER = "message.testmod1.fail_drink_water";
    public DrinkWaterC2SPacket() {

    }
    public DrinkWaterC2SPacket(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            //HERE WE ARE ON THE SERVER!!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if (hasWaterAroundThem(player, level, 2)) { // check if player is near water
                //notify water has been drunk
                //player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));
                //play drinking sound
                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                        0.5F, level.random.nextFloat()*0.1F+0.9F);
                //increase thirst level
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    thirst.addThirst(3);
                    //player.sendSystemMessage(Component.literal("current thirst: " + thirst.getThirst())
                    //        .withStyle(ChatFormatting.AQUA)); //output current thirst level
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                });

            } else {
                //notify there's no water around
                player.sendSystemMessage(Component.translatable(MESSAGE_FAIL_DRINK_WATER).withStyle(ChatFormatting.RED));

                //output current thirst level
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    //player.sendSystemMessage(Component.literal("current thirst: " + thirst.getThirst())
                    //       .withStyle(ChatFormatting.AQUA)); //output current thirst level
                    ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                });
            }


        });
        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.WATER)).toArray().length>0;
    }
}
