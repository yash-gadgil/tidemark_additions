package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.AbyssalRay;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AbyssalRayModel extends GeoModel<AbyssalRay> {


    @Override
    public ResourceLocation getModelResource(AbyssalRay abyssalRay) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "geo/abyssal_ray.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbyssalRay abyssalRay) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/abyssal_ray/abyssal_ray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AbyssalRay abyssalRay) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "animations/abyssal_ray.animation.json");
    }
}
