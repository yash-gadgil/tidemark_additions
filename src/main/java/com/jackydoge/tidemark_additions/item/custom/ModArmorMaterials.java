package com.jackydoge.tidemark_additions.item.custom;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> TIDESTEEL_ARMOR_MATERIAL = register("tidesteel",
            Util.make(new EnumMap<>(ArmorItem.Type.class),
                    attribute -> {
                        attribute.put(ArmorItem.Type.BOOTS, 3);
                        attribute.put(ArmorItem.Type.LEGGINGS, 6);
                        attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                        attribute.put(ArmorItem.Type.HELMET, 3);
                        attribute.put(ArmorItem.Type.BODY, 11);
                    }), 15, 2.1f, 0.0f, ModItems.TIDESTEEL_INGOT, 38);

    public static final Holder<ArmorMaterial> TIDEMARKED_ARMOR_MATERIAL = register("tidemarked",
            Util.make(new EnumMap<>(ArmorItem.Type.class),
                    attribute -> {
                        attribute.put(ArmorItem.Type.BOOTS, 2);
                        attribute.put(ArmorItem.Type.LEGGINGS, 5);
                        attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                        attribute.put(ArmorItem.Type.HELMET, 3);
                        attribute.put(ArmorItem.Type.BODY, 10);
                    }), 21, 2.5f, 0.08f, ModItems.TIDEMARKED_INGOT, 42);

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem, int durabilityMultiplier) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());

        List<ArmorMaterial.Layer> layers = List.of(
            new ArmorMaterial.Layer(location, "", true)
        );

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
