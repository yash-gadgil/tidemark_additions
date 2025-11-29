package com.jackydoge.tidemark_additions.loot_modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EntityDropModifier implements IGlobalLootModifier {

    @SuppressWarnings("unchecked")
    public static final MapCodec<EntityDropModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            LootItemCondition.CODEC.listOf().fieldOf("conditions").forGetter(m -> List.of(m.conditions)),
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity_type").forGetter(m -> m.entityType),
            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
            com.mojang.serialization.Codec.INT.fieldOf("min_count").forGetter(m -> m.minCount),
            com.mojang.serialization.Codec.INT.fieldOf("max_count").forGetter(m -> m.maxCount),
            com.mojang.serialization.Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
    ).apply(inst, (conditions, entityType, item, minCount, maxCount, chance) ->
            new EntityDropModifier(conditions.toArray(Holder[]::new), entityType, item, minCount, maxCount, chance)));

    private final Holder<LootItemCondition>[] conditions;
    private final EntityType<?> entityType;
    private final Item item;
    private final int minCount;
    private final int maxCount;
    private final float chance;

    public EntityDropModifier(Holder<LootItemCondition>[] conditions, EntityType<?> entityType, Item item,
                             int minCount, int maxCount, float chance) {
        this.conditions = conditions;
        this.entityType = entityType;
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.chance = chance;
    }

    @Override
    public @NotNull ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Entity thisEntity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (thisEntity == null || thisEntity.getType() != entityType) {
            return generatedLoot;
        }

        if (maxCount <= 0 || chance <= 0f) return generatedLoot;

        int dropped = 0;
        int trials = maxCount - minCount + 1;
        for (int i = 0; i < trials; i++) {
            if (context.getRandom().nextFloat() < chance) {
                dropped++;
            }
        }

        int totalDropped = minCount + dropped - 1;
        if (totalDropped > 0) {
            generatedLoot.add(new ItemStack(item, totalDropped));
        }

        return generatedLoot;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return (MapCodec<? extends IGlobalLootModifier>) ModLootModifiers.ENTITY_DROP.get();
    }
}

