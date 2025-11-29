package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.ModEntities;
import com.jackydoge.tidemark_additions.item.ModItems;
import com.jackydoge.tidemark_additions.loot_modifier.AddItemModifier;
import com.jackydoge.tidemark_additions.loot_modifier.AddItemToChestModifier;
import com.jackydoge.tidemark_additions.loot_modifier.EntityDropModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModLootModifierProvider extends GlobalLootModifierProvider {

    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Tidemark_additions.MOD_ID, lookupProvider);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void start(HolderLookup.@NotNull Provider provider) {

        add("warden_extra_loot", new AddItemModifier(
                new Holder[]{},
                ModItems.RESONANT_SCALE.get(),
                3,
                0.5f
        ));

        add("tidefin_tidescale_drop", new EntityDropModifier(
                new Holder[]{},
                ModEntities.TIDEFIN.get(),
                ModItems.TIDESCALE.get(),
                3,
                5,
                0.5f
        ));

        add("abyssal_ray_hide_drop", new EntityDropModifier(
                new Holder[]{},
                ModEntities.ABYSSAL_RAY.get(),
                ModItems.ABYSSAL_HIDE.get(),
                2,
                5,
                0.5f
        ));

        add("shipwreck_treasure_driftsteel_fragment", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure"),
                ModItems.DRIFTSTEEL_FRAGMENT.get(),
                2,
                5,
                0.6f
        ));

        add("shipwreck_map_driftsteel_fragment", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/shipwreck_map"),
                ModItems.DRIFTSTEEL_FRAGMENT.get(),
                1,
                4,
                0.5f
        ));

        add("shipwreck_supply_driftsteel_fragment", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/shipwreck_supply"),
                ModItems.DRIFTSTEEL_FRAGMENT.get(),
                1,
                3,
                0.4f
        ));

        add("ocean_ruin_cold_driftsteel_fragment", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/underwater_ruin_small"),
                ModItems.DRIFTSTEEL_FRAGMENT.get(),
                1,
                3,
                0.5f
        ));

        add("ocean_ruin_warm_driftsteel_fragment", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/underwater_ruin_big"),
                ModItems.DRIFTSTEEL_FRAGMENT.get(),
                2,
                4,
                0.6f
        ));

        add("buried_treasure_driftsteel", new AddItemToChestModifier(
                new Holder[]{},
                ResourceLocation.withDefaultNamespace("chests/buried_treasure"),
                ModItems.DRIFTSTEEL.get(),
                2,
                5,
                0.7f
        ));
    }
}