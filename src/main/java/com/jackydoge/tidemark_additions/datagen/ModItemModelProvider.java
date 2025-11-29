package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tidemark_additions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.TIDESCALE.get());
        basicItem(ModItems.DRIFTSTEEL.get());
        basicItem(ModItems.DRIFTSTEEL_FRAGMENT.get());
        basicItem(ModItems.TIDESTEEL_INGOT.get());
        basicItem(ModItems.ABYSSAL_HIDE.get());
        basicItem(ModItems.TIDEMARKED_INGOT.get());
        basicItem(ModItems.RESONANT_SCALE.get());

        handheldItem(ModItems.TIDESTEEL_SWORD);
        handheldItem(ModItems.TIDESTEEL_PICKAXE);
        handheldItem(ModItems.TIDESTEEL_SHOVEL);
        handheldItem(ModItems.TIDESTEEL_AXE);
        handheldItem(ModItems.TIDESTEEL_HOE);

        handheldItem(ModItems.TIDEMARKED_SWORD);
        handheldItem(ModItems.TIDEMARKED_PICKAXE);
        handheldItem(ModItems.TIDEMARKED_SHOVEL);
        handheldItem(ModItems.TIDEMARKED_AXE);
        handheldItem(ModItems.TIDEMARKED_HOE);

        trimmedArmorItem(ModItems.TIDESTEEL_HELMET);
        trimmedArmorItem(ModItems.TIDESTEEL_CHESTPLATE);
        trimmedArmorItem(ModItems.TIDESTEEL_LEGGINGS);
        trimmedArmorItem(ModItems.TIDESTEEL_BOOTS);

        trimmedArmorItem(ModItems.TIDEMARKED_HELMET);
        trimmedArmorItem(ModItems.TIDEMARKED_CHESTPLATE);
        trimmedArmorItem(ModItems.TIDEMARKED_LEGGINGS);
        trimmedArmorItem(ModItems.TIDEMARKED_BOOTS);

        withExistingParent(ModItems.TIDEFIN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ABYSSAL_RAY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Tidemark_additions.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
