package com.jackydoge.tidemark_additions.effect;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;

public class UndertideEffect extends MobEffect {

    public UndertideEffect(MobEffectCategory category, int color) {
        super(category, color);

        ForgeMod.SWIM_SPEED.getHolder().ifPresent(holder ->
                this.addAttributeModifier(
                        holder,
                        ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "undertide_swim_speed"),
                        0.3,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                )
        );
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) {
            return true;
        }

        if (entity.hasEffect(MobEffects.DARKNESS)) {
            entity.removeEffect(MobEffects.DARKNESS);
        }

        if (entity.isInWater()) {
            if (!entity.hasEffect(MobEffects.WATER_BREATHING)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.WATER_BREATHING,
                        60, // 3 seconds
                        0,
                        false,
                        false,
                        false
                ));
            }

            if (!entity.hasEffect(MobEffects.DIG_SPEED)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.DIG_SPEED,
                        60,
                        amplifier,
                        false,
                        false,
                        false
                ));
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

