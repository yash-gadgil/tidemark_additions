package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancements()));
    }

    public static class ModAdvancements implements AdvancementGenerator {

        @Override
        public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper) {

            AdvancementHolder underTheTides = Advancement.Builder.advancement()
                    .display(
                            ModItems.TIDESCALE.get(),
                            Component.translatable("advancement.tidemark_additions.under_the_tides"),
                            Component.translatable("advancement.tidemark_additions.under_the_tides.description"),
                            ResourceLocation.withDefaultNamespace("textures/block/water_still.png"),
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_tidescale", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESCALE.get()))
                    .addCriterion("has_driftsteel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRIFTSTEEL.get()))
                    .addCriterion("has_driftsteel_fragment", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRIFTSTEEL_FRAGMENT.get()))
                    .addCriterion("has_tidesteel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESTEEL_INGOT.get()))
                    .addCriterion("has_tidemarked_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDEMARKED_INGOT.get()))
                    .addCriterion("has_abyssal_hide", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ABYSSAL_HIDE.get()))
                    .addCriterion("has_resonant_scale", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RESONANT_SCALE.get()))
                    .requirements(net.minecraft.advancements.AdvancementRequirements.Strategy.OR)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "under_the_tides"));

            AdvancementHolder resonant = Advancement.Builder.advancement()
                    .parent(underTheTides)
                    .display(
                            ModItems.RESONANT_SCALE.get(),
                            Component.translatable("advancement.tidemark_additions.resonant"),
                            Component.translatable("advancement.tidemark_additions.resonant.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_resonant_scale", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RESONANT_SCALE.get()))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "resonant"));

            AdvancementHolder tideForged = Advancement.Builder.advancement()
                    .parent(underTheTides)
                    .display(
                            ModItems.TIDESTEEL_CHESTPLATE.get(),
                            Component.translatable("advancement.tidemark_additions.tide_forged"),
                            Component.translatable("advancement.tidemark_additions.tide_forged.description"),
                            null,
                            AdvancementType.GOAL,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_tidesteel_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESTEEL_HELMET.get()))
                    .addCriterion("has_tidesteel_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESTEEL_CHESTPLATE.get()))
                    .addCriterion("has_tidesteel_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESTEEL_LEGGINGS.get()))
                    .addCriterion("has_tidesteel_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDESTEEL_BOOTS.get()))
                    .requirements(net.minecraft.advancements.AdvancementRequirements.Strategy.AND)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "tide_forged"));

            AdvancementHolder tidemarked = Advancement.Builder.advancement()
                    .parent(tideForged)
                    .display(
                            ModItems.TIDEMARKED_CHESTPLATE.get(),
                            Component.translatable("advancement.tidemark_additions.tidemarked"),
                            Component.translatable("advancement.tidemark_additions.tidemarked.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_tidemarked_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDEMARKED_HELMET.get()))
                    .addCriterion("has_tidemarked_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDEMARKED_CHESTPLATE.get()))
                    .addCriterion("has_tidemarked_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDEMARKED_LEGGINGS.get()))
                    .addCriterion("has_tidemarked_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIDEMARKED_BOOTS.get()))
                    .requirements(net.minecraft.advancements.AdvancementRequirements.Strategy.AND)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "tidemarked"));
        }
    }
}

