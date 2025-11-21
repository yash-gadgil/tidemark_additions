package com.jackydoge.tidemark_additions.item;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tidemark_additions.MOD_ID);

    public static final RegistryObject<Item> TIDESCALE = ITEMS.register("tidescale",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIFTSTEEL = ITEMS.register("driftsteel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIFTSTEEL_FRAGMENT = ITEMS.register("driftsteel_fragment",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
