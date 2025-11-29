package com.jackydoge.tidemark_additions.loot_modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddItemToChestModifier implements IGlobalLootModifier {

    @SuppressWarnings("unchecked")
    public static final MapCodec<AddItemToChestModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            LootItemCondition.CODEC.listOf().fieldOf("conditions").forGetter(m -> List.of(m.conditions)),
            ResourceLocation.CODEC.fieldOf("loot_table").forGetter(m -> m.lootTable),
            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
            com.mojang.serialization.Codec.INT.fieldOf("min_count").forGetter(m -> m.minCount),
            com.mojang.serialization.Codec.INT.fieldOf("max_count").forGetter(m -> m.maxCount),
            com.mojang.serialization.Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
    ).apply(inst, (conditions, lootTable, item, minCount, maxCount, chance) ->
            new AddItemToChestModifier(conditions.toArray(Holder[]::new), lootTable, item, minCount, maxCount, chance)));

    private final Holder<LootItemCondition>[] conditions;
    private final ResourceLocation lootTable;
    private final Item item;
    private final int minCount;
    private final int maxCount;
    private final float chance;

    public AddItemToChestModifier(Holder<LootItemCondition>[] conditions, ResourceLocation lootTable,
                                  Item item, int minCount, int maxCount, float chance) {
        this.conditions = conditions;
        this.lootTable = lootTable;
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.chance = chance;
    }

    @Override
    public @NotNull ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ResourceLocation contextLootTable = context.getQueriedLootTableId();

        if (!contextLootTable.equals(lootTable)) {
            return generatedLoot;
        }

        if (context.getRandom().nextFloat() < chance) {
            int count = minCount;
            if (maxCount > minCount) {
                count = minCount + context.getRandom().nextInt(maxCount - minCount + 1);
            }
            generatedLoot.add(new ItemStack(item, count));
        }

        return generatedLoot;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return (MapCodec<? extends IGlobalLootModifier>) ModLootModifiers.ADD_CHEST_ITEM.get();
    }
}

