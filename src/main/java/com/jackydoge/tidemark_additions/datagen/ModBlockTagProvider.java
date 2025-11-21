package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tidemark_additions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        /*tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_STONE_ORE.get());*/

        tag(ModTags.Blocks.NEEDS_TIDESTEEL_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_TIDESTEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

    }
}
