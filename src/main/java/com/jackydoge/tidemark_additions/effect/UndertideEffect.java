package com.jackydoge.tidemark_additions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UndertideEffect extends MobEffect {

    private static final int STILL_DURATION_REQUIRED = 60; // 3 seconds

    private static final int HEAL_INTERVAL = 60; // 3 seconds

    private static final float HEAL_AMOUNT = 2.0f; // 1 heart

    private static final double MOVEMENT_THRESHOLD = 0.1;

    private static final Map<UUID, PlayerStillData> PLAYER_DATA = new ConcurrentHashMap<>();

    private static class PlayerStillData {
        Vec3 lastPosition;
        int ticksStill;
        int ticksSinceLastHeal;

        PlayerStillData(Vec3 pos) {
            this.lastPosition = pos;
            this.ticksStill = 0;
            this.ticksSinceLastHeal = 0;
        }
    }

    protected UndertideEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) return true;
        if (!(entity instanceof Player player)) return true;

        UUID uuid = player.getUUID();
        Vec3 currentPos = player.position();

        PlayerStillData data = PLAYER_DATA.computeIfAbsent(uuid, k -> new PlayerStillData(currentPos));

        double distanceMoved = data.lastPosition.distanceTo(currentPos);

        boolean inWater = player.isInWater() || player.isInWaterOrBubble() || player.isUnderWater();

        if (distanceMoved > MOVEMENT_THRESHOLD || !inWater) {
            data.ticksStill = 0;
            data.ticksSinceLastHeal = 0;
            data.lastPosition = currentPos;
        } else {
            data.ticksStill++;

            if (data.ticksStill >= STILL_DURATION_REQUIRED) {
                data.ticksSinceLastHeal++;

                if (data.ticksSinceLastHeal >= HEAL_INTERVAL) {
                    if (player.getHealth() < player.getMaxHealth()) {
                        player.heal(HEAL_AMOUNT);
                        data.ticksSinceLastHeal = 0;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    public static void cleanup(UUID uuid) {
        PLAYER_DATA.remove(uuid);
    }
}



