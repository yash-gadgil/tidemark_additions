package com.jackydoge.tidemark_additions.entity;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.Tidehopper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Tidemark_additions.MOD_ID);

    public static final RegistryObject<EntityType<Tidehopper>> TIDEHOPPER =
            ENTITY_TYPES.register("tidehopper", () -> EntityType.Builder.of(Tidehopper::new, MobCategory.AMBIENT)
                    .sized(1.0f, 1.0f)
                    .build("tidehopper"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
