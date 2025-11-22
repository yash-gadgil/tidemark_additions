package com.jackydoge.tidemark_additions.event;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.ModEntities;
import com.jackydoge.tidemark_additions.entity.custom.Tidehopper;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tidemark_additions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIDEHOPPER.get(), Tidehopper.createAttributes().build());

    }

}
