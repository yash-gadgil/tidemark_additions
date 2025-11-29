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
                        output.accept(ModItems.TIDESTEEL_INGOT.get());

                        output.accept(ModItems.TIDESTEEL_SWORD.get());
                        output.accept(ModItems.TIDESTEEL_PICKAXE.get());
                        output.accept(ModItems.TIDESTEEL_SHOVEL.get());
                        output.accept(ModItems.TIDESTEEL_AXE.get());
                        output.accept(ModItems.TIDESTEEL_HOE.get());
                        output.accept(ModItems.TIDESTEEL_HELMET.get());
                        output.accept(ModItems.TIDESTEEL_CHESTPLATE.get());
                        output.accept(ModItems.TIDESTEEL_LEGGINGS.get());
                        output.accept(ModItems.TIDESTEEL_BOOTS.get());

                        output.accept(ModItems.ABYSSAL_HIDE.get());
                        output.accept(ModItems.TIDEMARKED_INGOT.get());
                        output.accept(ModItems.RESONANT_SCALE.get());

                        output.accept(ModItems.TIDEMARKED_SWORD.get());
                        output.accept(ModItems.TIDEMARKED_PICKAXE.get());
                        output.accept(ModItems.TIDEMARKED_SHOVEL.get());
                        output.accept(ModItems.TIDEMARKED_AXE.get());
                        output.accept(ModItems.TIDEMARKED_HOE.get());
                        output.accept(ModItems.TIDEMARKED_HELMET.get());
                        output.accept(ModItems.TIDEMARKED_CHESTPLATE.get());
                        output.accept(ModItems.TIDEMARKED_LEGGINGS.get());
                        output.accept(ModItems.TIDEMARKED_BOOTS.get());

                        output.accept(ModItems.TIDEFIN_SPAWN_EGG.get());
                        output.accept(ModItems.ABYSSAL_RAY_SPAWN_EGG.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
