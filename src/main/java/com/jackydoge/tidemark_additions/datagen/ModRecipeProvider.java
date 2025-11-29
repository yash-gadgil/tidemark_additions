package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(packOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DRIFTSTEEL.get())
                .pattern("FF")
                .pattern("FF")
                .define('F', ModItems.DRIFTSTEEL_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.DRIFTSTEEL_FRAGMENT.get()), has(ModItems.DRIFTSTEEL_FRAGMENT.get()))
                .save(recipeOutput, Tidemark_additions.MOD_ID + ":driftsteel_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIDESTEEL_INGOT.get())
                .pattern("TD")
                .define('T', ModItems.TIDESCALE.get())
                .define('D', ModItems.DRIFTSTEEL.get())
                .unlockedBy("has_driftsteel_and_tidescale", hasItems(ModItems.DRIFTSTEEL.get(), ModItems.TIDESCALE.get()))
                .save(recipeOutput, Tidemark_additions.MOD_ID + ":tidesteel_ingot_from_tidescale_driftsteel");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDESTEEL_PICKAXE.get())
                .pattern("TTT")
                .pattern(" S ")
                .pattern(" S ")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDESTEEL_AXE.get())
                .pattern("TT")
                .pattern("TS")
                .pattern(" S")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDESTEEL_SHOVEL.get())
                .pattern("T")
                .pattern("S")
                .pattern("S")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDESTEEL_HOE.get())
                .pattern("TT")
                .pattern(" S")
                .pattern(" S")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDESTEEL_SWORD.get())
                .pattern("T")
                .pattern("T")
                .pattern("S")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDESTEEL_HELMET.get())
                .pattern("TTT")
                .pattern("T T")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDESTEEL_CHESTPLATE.get())
                .pattern("T T")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDESTEEL_LEGGINGS.get())
                .pattern("TTT")
                .pattern("T T")
                .pattern("T T")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDESTEEL_BOOTS.get())
                .pattern("T T")
                .pattern("T T")
                .define('T', ModItems.TIDESTEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDESTEEL_INGOT.get()), has(ModItems.TIDESTEEL_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIDEMARKED_INGOT.get())
                .pattern("TA")
                .pattern("RD")
                .define('A', ModItems.ABYSSAL_HIDE.get())
                .define('D', ModItems.DRIFTSTEEL.get())
                .define('T', ModItems.TIDESCALE.get())
                .define('R', ModItems.RESONANT_SCALE.get())
                .unlockedBy("has_driftsteel_abyssal_hide_resonant_scale_tidescale", hasItems(ModItems.DRIFTSTEEL.get(), ModItems.ABYSSAL_HIDE.get(), ModItems.TIDESCALE.get(), ModItems.RESONANT_SCALE.get()))
                .save(recipeOutput, Tidemark_additions.MOD_ID + ":tidemarked_ingot_from_abyssal_hide_tidescale_resonant_scale_driftsteel");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDEMARKED_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDEMARKED_AXE.get())
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDEMARKED_SHOVEL.get())
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TIDEMARKED_HOE.get())
                .pattern("AA")
                .pattern(" S")
                .pattern(" S")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDEMARKED_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .define('S', ItemTags.create("forge", "rods/wooden"))
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .unlockedBy(getHasName(Items.STICK), has(ItemTags.create("forge", "rods/wooden")))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDEMARKED_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDEMARKED_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDEMARKED_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIDEMARKED_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.TIDEMARKED_INGOT.get())
                .unlockedBy(getHasName(ModItems.TIDEMARKED_INGOT.get()), has(ModItems.TIDEMARKED_INGOT.get()))
                .save(recipeOutput);

    }
}
