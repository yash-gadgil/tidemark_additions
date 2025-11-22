package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.Tidehopper;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TidehopperModel extends GeoModel<Tidehopper> {


    @Override
    public ResourceLocation getModelResource(Tidehopper tidehopper) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "geo/tidehopper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Tidehopper tidehopper) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/tidehopper/tidehopper.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Tidehopper tidehopper) {
        return null;
    }
}
