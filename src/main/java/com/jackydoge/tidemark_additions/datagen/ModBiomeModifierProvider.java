package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.ModEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifierProvider {

    public static final ResourceKey<BiomeModifier> ADD_TIDEFIN_SPAWN = registerKey("add_tidefin_spawn");
    public static final ResourceKey<BiomeModifier> ADD_ABYSSAL_RAY_SPAWN = registerKey("add_abyssal_ray_spawn");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TIDEFIN_SPAWN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                java.util.List.of(new MobSpawnSettings.SpawnerData(
                        ModEntities.TIDEFIN.get(),
                        4,
                        2,
                        4
                ))
        ));

        context.register(ADD_ABYSSAL_RAY_SPAWN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_DEEP_OCEAN),
                java.util.List.of(new MobSpawnSettings.SpawnerData(
                        ModEntities.ABYSSAL_RAY.get(),
                        30,
                        2,
                        5
                ))
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, name));
    }
}

