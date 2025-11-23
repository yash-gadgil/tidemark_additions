package com.jackydoge.tidemark_additions.effect;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tidemark_additions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UndertideCleanupHandler {

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        UndertideEffect.cleanup(event.getEntity().getUUID());
    }
}

