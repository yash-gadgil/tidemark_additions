package com.jackydoge.tidemark_additions.effect;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Tidemark_additions.MOD_ID);

    public static final RegistryObject<MobEffect> UNDERTIDE = EFFECTS.register("undertide",
            () -> new UndertideEffect(MobEffectCategory.BENEFICIAL, 0x8A00FF));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}