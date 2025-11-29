package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.Tidefin;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TidefinModel extends GeoModel<Tidefin> {


    @Override
    public ResourceLocation getModelResource(Tidefin tidefin) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "geo/tidefin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Tidefin tidefin) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/tidefin/tidefin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Tidefin tidefin) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "animations/tidefin.animation.json");
    }
}
