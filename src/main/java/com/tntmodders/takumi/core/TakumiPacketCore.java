package com.tntmodders.takumi.core;

import com.tntmodders.takumi.TakumiCraftCore;
import com.tntmodders.takumi.network.*;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TakumiPacketCore {

    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(TakumiCraftCore.MODID);


    public static void register() {
        INSTANCE.registerMessage(MessageMSMoveHandler.class, MessageMSMove.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageTHMDetonateHandler.class, MessageTHMDetonate.class, 1, Side.SERVER);
        if (FMLCommonHandler.instance().getSide().isClient()) {
            registerClient();
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerClient() {
        INSTANCE.registerMessage(MessageDarkShrineHandler.class, MessageDarkShrine.class, 2, Side.CLIENT);
    }
}
