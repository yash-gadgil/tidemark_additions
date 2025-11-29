package com.jackydoge.tidemark_additions.loot_modifier;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    @SuppressWarnings({"rawtypes"})
    public static final DeferredRegister LOOT_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Tidemark_additions.MOD_ID);

    @SuppressWarnings({"rawtypes","unchecked"})
    public static final RegistryObject ADD_ITEM =
            LOOT_MODIFIERS.register("add_item", () -> AddItemModifier.CODEC);

    @SuppressWarnings({"rawtypes","unchecked"})
    public static final RegistryObject ENTITY_DROP =
            LOOT_MODIFIERS.register("entity_drop", () -> EntityDropModifier.CODEC);

    @SuppressWarnings({"rawtypes","unchecked"})
    public static final RegistryObject ADD_CHEST_ITEM =
            LOOT_MODIFIERS.register("add_chest_item", () -> AddItemToChestModifier.CODEC);

    public static void register(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }
}
