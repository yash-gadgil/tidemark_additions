package com.jackydoge.tidemark_additions.loot_modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
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

public class AddItemModifier implements IGlobalLootModifier {

    @SuppressWarnings("unchecked")
    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            LootItemCondition.CODEC.listOf().fieldOf("conditions").forGetter(m -> List.of(m.conditions)),
            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
            com.mojang.serialization.Codec.INT.fieldOf("count").forGetter(m -> m.count),
            com.mojang.serialization.Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
    ).apply(inst, (conditions, item, count, chance) -> new AddItemModifier(conditions.toArray(Holder[]::new), item, count, chance)));

    private final Holder<LootItemCondition>[] conditions;
    private final Item item;
    private final int count;
    private final float chance;

    public AddItemModifier(Holder<LootItemCondition>[] conditions, Item item, int count, float chance) {
        this.conditions = conditions;
        this.item = item;
        this.count = count;
        this.chance = chance;
    }

    @Override
    public @NotNull ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        Entity thisEntity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (thisEntity == null || thisEntity.getType() != EntityType.WARDEN) {
            return generatedLoot;
        }

        if (count <= 0 || chance <= 0f) return generatedLoot;
        int dropped = 0;
        for (int i = 0; i < count; i++) {
            if (context.getRandom().nextFloat() < chance) dropped++;
        }
        if (dropped > 0) generatedLoot.add(new ItemStack(item, dropped));
        return generatedLoot;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return (MapCodec<? extends IGlobalLootModifier>) ModLootModifiers.ADD_ITEM.get();
    }
}