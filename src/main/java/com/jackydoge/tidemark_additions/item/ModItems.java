package com.jackydoge.tidemark_additions.item;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.ModEntities;
import com.jackydoge.tidemark_additions.item.custom.ModArmorItem;
import com.jackydoge.tidemark_additions.item.custom.ModArmorMaterials;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tidemark_additions.MOD_ID);

    public static final RegistryObject<Item> TIDESCALE = ITEMS.register("tidescale",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIFTSTEEL = ITEMS.register("driftsteel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIFTSTEEL_FRAGMENT = ITEMS.register("driftsteel_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIDESTEEL_INGOT = ITEMS.register("tidesteel_ingot",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> TIDESTEEL_SWORD = ITEMS.register("tidesteel_sword",
            () -> new SwordItem(ModToolTiers.TIDESTEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TIDESTEEL, 3000, -2.4f))));//3
    public static final RegistryObject<Item> TIDESTEEL_PICKAXE = ITEMS.register("tidesteel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TIDESTEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.TIDESTEEL, 1, -2.8f))));
    public static final RegistryObject<Item> TIDESTEEL_SHOVEL = ITEMS.register("tidesteel_shovel",
            () -> new ShovelItem(ModToolTiers.TIDESTEEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.TIDESTEEL, 1.5f, -3.0f))));
    public static final RegistryObject<Item> TIDESTEEL_AXE = ITEMS.register("tidesteel_axe",
            () -> new AxeItem(ModToolTiers.TIDESTEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.TIDESTEEL, 6, -3.2f))));
    public static final RegistryObject<Item> TIDESTEEL_HOE = ITEMS.register("tidesteel_hoe",
            () -> new HoeItem(ModToolTiers.TIDESTEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.TIDESTEEL, 0, -3.0f))));

    public static final RegistryObject<Item> TIDESTEEL_HELMET = ITEMS.register("tidesteel_helmet",
            () -> new ArmorItem(ModArmorMaterials.TIDESTEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));
    public static final RegistryObject<Item> TIDESTEEL_CHESTPLATE = ITEMS.register("tidesteel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TIDESTEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));
    public static final RegistryObject<Item> TIDESTEEL_LEGGINGS = ITEMS.register("tidesteel_leggings",
            () -> new ArmorItem(ModArmorMaterials.TIDESTEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));
    public static final RegistryObject<Item> TIDESTEEL_BOOTS = ITEMS.register("tidesteel_boots",
            () -> new ArmorItem(ModArmorMaterials.TIDESTEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));

    public static final RegistryObject<Item> ABYSSAL_HIDE = ITEMS.register("abyssal_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ABYSSAL_RESONANCE_INGOT = ITEMS.register("abyssal_resonance_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RESONANT_SCALE = ITEMS.register("resonant_scale",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> ABYSSAL_RESONANCE_SWORD = ITEMS.register("abyssal_resonance_sword",
            () -> new SwordItem(ModToolTiers.ABYSSAL_RESONANCE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ABYSSAL_RESONANCE, 3000, -2.4f))));//3
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_PICKAXE = ITEMS.register("abyssal_resonance_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ABYSSAL_RESONANCE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ABYSSAL_RESONANCE, 1, -2.8f))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_SHOVEL = ITEMS.register("abyssal_resonance_shovel",
            () -> new ShovelItem(ModToolTiers.ABYSSAL_RESONANCE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ABYSSAL_RESONANCE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_AXE = ITEMS.register("abyssal_resonance_axe",
            () -> new AxeItem(ModToolTiers.ABYSSAL_RESONANCE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ABYSSAL_RESONANCE, 6, -3.2f))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_HOE = ITEMS.register("abyssal_resonance_hoe",
            () -> new HoeItem(ModToolTiers.ABYSSAL_RESONANCE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ABYSSAL_RESONANCE, 0, -3.0f))));

    public static final RegistryObject<Item> ABYSSAL_RESONANCE_HELMET = ITEMS.register("abyssal_resonance_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ABYSSAL_RESONANCE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_CHESTPLATE = ITEMS.register("abyssal_resonance_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ABYSSAL_RESONANCE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_LEGGINGS = ITEMS.register("abyssal_resonance_leggings",
            () -> new ArmorItem(ModArmorMaterials.ABYSSAL_RESONANCE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));
    public static final RegistryObject<Item> ABYSSAL_RESONANCE_BOOTS = ITEMS.register("abyssal_resonance_boots",
            () -> new ArmorItem(ModArmorMaterials.ABYSSAL_RESONANCE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));

    public static final RegistryObject<Item> TIDEHOPPER_SPAWN_EGG = ITEMS.register("tidehopper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIDEHOPPER, 0x010aba, 0x030cbe, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
