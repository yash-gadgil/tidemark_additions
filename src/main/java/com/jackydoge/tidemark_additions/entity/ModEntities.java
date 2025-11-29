package com.jackydoge.tidemark_additions.entity;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.AbyssalRay;
import com.jackydoge.tidemark_additions.entity.custom.Tidefin;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Tidemark_additions.MOD_ID);

    public static final RegistryObject<EntityType<Tidefin>> TIDEFIN =
            ENTITY_TYPES.register("tidefin", () -> EntityType.Builder.of(Tidefin::new, MobCategory.WATER_CREATURE)
                    .sized(0.5f, 0.4f)
                    .build("tidefin"));

    public static final RegistryObject<EntityType<AbyssalRay>> ABYSSAL_RAY =
            ENTITY_TYPES.register("abyssal_ray", () -> EntityType.Builder.of(AbyssalRay::new, MobCategory.WATER_CREATURE)
                    .sized(0.5f, 0.4f)
                    .build("abyssal_ray"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
