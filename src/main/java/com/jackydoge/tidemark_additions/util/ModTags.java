package com.jackydoge.tidemark_additions.util;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_TIDESTEEL_TOOL = createTag("needs_tidesteel_tool");
        public static final TagKey<Block> INCORRECT_FOR_TIDESTEEL_TOOL = createTag("incorrect_for_tidesteel_tool");

        public static final TagKey<Block> NEEDS_ABYSSAL_RESONANCE_TOOL = createTag("needs_abyssal_resonance_tool");
        public static final TagKey<Block> INCORRECT_FOR_ABYSSAL_RESONANCE_TOOL = createTag("incorrect_for_abyssal_resonance_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, name));
        }

    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, name));
        }
    }
}
