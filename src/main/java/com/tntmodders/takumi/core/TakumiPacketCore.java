package com.tntmodders.takumi.core;

import com.tntmodders.takumi.TakumiCraftCore;
import com.tntmodders.takumi.network.MessageMSMove;
import com.tntmodders.takumi.network.MessageMSMoveHandler;
import com.tntmodders.takumi.network.MessageTHMDetonate;
import com.tntmodders.takumi.network.MessageTHMDetonateHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class TakumiPacketCore {

    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(TakumiCraftCore.MODID);


    public static void register() {
        INSTANCE.registerMessage(MessageMSMoveHandler.class, MessageMSMove.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageTHMDetonateHandler.class, MessageTHMDetonate.class, 1, Side.SERVER);
    }
}
