package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import com.jackydoge.tidemark_additions.loot_modifier.AddItemModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModLootModifierProvider extends GlobalLootModifierProvider {

    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Tidemark_additions.MOD_ID, lookupProvider);
    }

    @Override
    protected void start(HolderLookup.@NotNull Provider provider) {

        add("warden_extra_loot", new AddItemModifier(
                new Holder[]{},
                ModItems.RESONANT_SCALE.get(),
                3,
                0.5f
        ));
    }
}