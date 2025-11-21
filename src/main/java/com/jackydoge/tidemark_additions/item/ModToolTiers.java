package com.jackydoge.tidemark_additions.item;

import com.jackydoge.tidemark_additions.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {

    public static final Tier TIDESTEEL = new ForgeTier(400, 6f, 2.5f, 5,
            ModTags.Blocks.NEEDS_TIDESTEEL_TOOL,
            () -> Ingredient.of(ModItems.TIDESTEEL_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_TIDESTEEL_TOOL);


}
