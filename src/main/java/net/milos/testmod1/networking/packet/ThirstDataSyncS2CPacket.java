package net.milos.testmod1.networking.packet;

import net.milos.testmod1.client.ClientThirstData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ThirstDataSyncS2CPacket { //C2S - Client to (2) Server
    private final int thirst;
    public ThirstDataSyncS2CPacket(int thirst) {
        this.thirst = thirst;
    }
    public ThirstDataSyncS2CPacket(FriendlyByteBuf buf){
        this.thirst = buf.readInt();
    }
    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(thirst);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            //HERE WE ARE ON THE CLIENT!!
            ClientThirstData.set(thirst);
        });
        return true;
    }

}
