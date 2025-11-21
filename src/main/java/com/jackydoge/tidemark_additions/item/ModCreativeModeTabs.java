package com.jackydoge.tidemark_additions.item;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tidemark_additions.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TIDEMARK_ADDITIONS = CREATIVE_MOD_TABS.register("tidemark_additions",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TIDESCALE.get()))
                    .title(Component.translatable("creativetab.tidemark_additions.tidemark_additions"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TIDESCALE.get());
                        output.accept(ModItems.DRIFTSTEEL.get());
                        output.accept(ModItems.DRIFTSTEEL_FRAGMENT.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
