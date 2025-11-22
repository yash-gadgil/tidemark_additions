package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.Tidehopper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TidehopperRenderer extends GeoEntityRenderer<Tidehopper> {

    public TidehopperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TidehopperModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Tidehopper animatable) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/tidehopper/tidehopper.png");
    }
}
