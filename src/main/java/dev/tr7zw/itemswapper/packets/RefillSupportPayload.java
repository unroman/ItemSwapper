package dev.tr7zw.itemswapper.packets;

import dev.tr7zw.itemswapper.ItemSwapperMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

//spotless:off 
//#if MC >= 12002
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
//#else
//$$ import dev.tr7zw.itemswapper.legacy.CustomPacketPayload;
//#endif
//spotless:on

public record RefillSupportPayload(boolean enabled) implements CustomPacketPayload, CustomPacketPayloadSupport {
    //spotless:off
    //#if MC >= 12100
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(ItemSwapperMod.MODID, "enablerefill");
    //#else
    //$$    public static final ResourceLocation ID = new ResourceLocation(ItemSwapperMod.MODID, "enablerefill");
    //#endif
    //spotless:on


    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf paramFriendlyByteBuf) {
        paramFriendlyByteBuf.writeBoolean(enabled);
    }

    public RefillSupportPayload(FriendlyByteBuf buffer) {
        this(buffer.readBoolean());
    }

}
